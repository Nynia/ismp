package action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import entity.ChargePoint;
import entity.CpInfo;
import entity.OrderRecord;
import entity.ProductInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.chargeService;
import service.configureService;
import service.orderRecordService;
import service.productService;
import utils.Constants;
import utils.SMGP.SMGPSMProxyMethod;
import utils.Tools;
import utils.requestInfoRecod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ridiculous on 2016/5/28.
 */
@Controller
public class serviceOrderAction {

    private HashMap<String, requestInfoRecod> recordHashMap;
    private CpInfo cpuser;
    private ProductInfo productInfo;
    private ChargePoint chargePoint;
    @Resource
    private configureService configureService;

    @Resource
    private productService productService;

    @Resource
    private orderRecordService orderRecordService;

    @Resource
    private chargeService chargeService;

    public serviceOrderAction() {
        recordHashMap = new HashMap<String, requestInfoRecod>();
    }

    @RequestMapping("serviceOrder")
    @ResponseBody
    public void serviceOrder(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //JSONObject jsonresult = new JSONObject();
        String os_encoding = System.getProperty("file.encoding");
        System.out.println(os_encoding);

        String action = request.getParameter("action");
        String spid = request.getParameter("spId");
        String timestamp = request.getParameter("timestamp");
        String type = request.getParameter("orderType");
        String chargeid = request.getParameter("chargeId");
        String phonenum = request.getParameter("phoneNum");
        String token = request.getParameter("accessToken");
        String orderid = request.getParameter("orderId");
        String vercode = request.getParameter("verCode");
        String imsi = request.getParameter("imsi");
        String ip = request.getParameter("ip");

        String remoteip = request.getRemoteHost();

        System.out.println(remoteip);

        JSONObject jsonresult = new JSONObject();
        String resultCode = "";

        if (action != null && action.equals("subscribe")) {
            System.out.println("subscribe");
            Enumeration<String> paraNames = request.getParameterNames();
            for (Enumeration e = paraNames; e.hasMoreElements(); ) {
                String thisName = e.nextElement().toString();
                String thisValue = request.getParameter(thisName);
                System.out.println(thisName + "--------------" + thisValue);
            }
            if (orderid == null) {
                if (timestamp == null || spid == null || chargeid == null || token == null || type == null) {
                    ret(response, "150", jsonresult);
                }
                orderid = utils.Tools.genOrderId();

                cpuser = configureService.getUserbyId(Integer.parseInt(spid));
                if (cpuser == null)
                    ret(response, "161", jsonresult);

                chargePoint = chargeService.getChargePointById(Integer.parseInt(chargeid));
                if (chargePoint != null)
                    productInfo = productService.getProductByProductId(chargePoint.getPid());
                else
                    ret(response, "162", jsonresult);

                if (productInfo == null)
                    ret(response, "152", jsonresult);

                int level = cpuser.getLevel();
                if (level == 0)
                    ret(response, "163", jsonresult);

                //ip鉴权
                String ipstr = cpuser.getIp();
                String[] ip_list = ipstr.split(";");
                int flag = 0;
                for (String item : ip_list) {
                    if (remoteip.equals(item)) {
                        flag = 1;
                        break;
                    }
                }
                // ip no restrict
                if (ipstr.equals("0.0.0.0")) {
                    flag = 1;
                }
                if (flag == 0)
                    ret(response, "151", jsonresult);

                //token鉴权
                String value = utils.Encrypt.SHA1(chargeid + timestamp + chargePoint.getSecret());
                if (!value.equals(token))
                    ret(response, "153", jsonresult);

                //点播包月区分
                if (type.equals("1")) {
                    if (phonenum != null) {
                        if (level == 1 || level == 3) {
                            //order
                            String productid = productInfo.getProductId();
                            resultCode = Tools.subscribe(phonenum, productid);
                            if (resultCode.equals("0")) {
                                OrderRecord order = new OrderRecord(0, phonenum, spid, chargeid, remoteip,
                                        Integer.parseInt(type), new java.sql.Date(new java.util.Date().getTime()));
                                orderRecordService.addOrderRecord(order);
                            }
                            ret(response, resultCode, jsonresult);
                        } else {
                            ret(response, "150", jsonresult);
                        }
                    } else {
                        if (level == 1)
                            ret(response, "150", jsonresult);

                        phonenum = utils.Tools.checkMdnByIMSI(imsi, ip);
                        if (phonenum.startsWith("86")) {
                            phonenum = phonenum.substring(2);
                            System.out.println(phonenum);
                        }
                        requestInfoRecod orderRecord = new requestInfoRecod(remoteip, type, spid, chargeid,
                                productInfo.getProductName(), Integer.parseInt(productInfo.getPrice()),
                                phonenum, "", 0, System.currentTimeMillis(), action, cpuser.getName());

                        if (phonenum.equals("")) {
                            resultCode = "159";
                        } else {
                            String verCode = utils.Tools.genVerCode();
                            String msg = String.format("%s为本次支付验证码。您正在订购%s，价格是%s元/月，验证码2分钟内有效，感谢使用!",
                                    verCode, orderRecord.getProductname(), orderRecord.getPrice() / 100);
                            SMGPSMProxyMethod proxyMethod = new SMGPSMProxyMethod();
                            if (proxyMethod.sendMsg(phonenum, msg)) {
                                resultCode = "101";
                            } else {
                                resultCode = "158";
                            }
                            orderRecord.setVercode(verCode);
                            orderRecord.setPhonenum(phonenum);
                            orderRecord.setVercodecreatetime(System.currentTimeMillis());
                            orderRecord.addReqSeq();
                            //recordHashMap.put(orderid, orderRecord);
                        }
                        recordHashMap.put(orderid, orderRecord);
                        JSONObject orderinfo = new JSONObject();
                        orderinfo.put("phoneNum", phonenum);
                        orderinfo.put("orderId", orderid);
                        orderinfo.put("productName", productInfo.getProductName());
                        orderinfo.put("price", productInfo.getPrice());
                        orderinfo.put("providerName", cpuser.getName());
                        jsonresult.put("orderinfo", orderinfo);

                        ret(response, resultCode, jsonresult);
                    }
                } else if (type.equals("2")) {
                    //点播
                    ret(response, "160", jsonresult);

                } else {
                    ret(response, "150", jsonresult);

                }

            } else {
                if (phonenum == null)
                    ret(response, "150", jsonresult);
                requestInfoRecod orderRecord = recordHashMap.get(orderid);
                if (orderRecord == null) {
                    ret(response,"164", jsonresult);
                }
                System.out.println(orderRecord.getRequestcreatetime());
                System.out.println(System.currentTimeMillis());
                if (System.currentTimeMillis() - orderRecord.getRequestcreatetime() > 300000) {
                    ret(response, "157", jsonresult);
                }
                //第二次请求
                if (vercode == null) {
                    String verCode = utils.Tools.genVerCode();
                    String msg = String.format("%s为本次支付验证码。您正在订购%s，价格是%s元/月，验证码2分钟内有效，感谢使用!",
                            verCode, orderRecord.getProductname(), orderRecord.getPrice() / 100);
                    SMGPSMProxyMethod proxyMethod = new SMGPSMProxyMethod();
                    if (proxyMethod.sendMsg(phonenum, msg)) {
                        resultCode = "101";
                    } else {
                        resultCode = "158";
                    }
                    orderRecord.setVercode(verCode);
                    orderRecord.setPhonenum(phonenum);
                    orderRecord.setVercodecreatetime(System.currentTimeMillis());
                    orderRecord.addReqSeq();
                    recordHashMap.put(orderid, orderRecord);

                    ret(response, resultCode, jsonresult);

                } else {
                    //第三次请求
                    //验证码超时
                    if (System.currentTimeMillis() - orderRecord.getVercodecreatetime() > 120000) {
                        ret(response, "154", jsonresult);
                    }
                    //验证码错误
                    if (!vercode.equals(orderRecord.getVercode()))
                        ret(response, "155", jsonresult);
                    //order
                    chargePoint = chargeService.getChargePointById(Integer.parseInt(orderRecord.getChargeid()));
                    if (chargePoint == null)
                        ret(response, "162", jsonresult);

                    resultCode = Tools.subscribe(orderRecord.getPhonenum(), chargePoint.getPid());
                    if (resultCode.equals("0")) {
                        //recordHashMap.remove(orderid);
                        OrderRecord order = new OrderRecord(0, phonenum, orderRecord.getSpid(),
                                orderRecord.getChargeid(), remoteip, Integer.parseInt(orderRecord.getType()),
                                new java.sql.Date(new java.util.Date().getTime()));
                        orderRecordService.addOrderRecord(order);
                    }
                    ret(response, resultCode, jsonresult);

                }
            }
        } else if (action != null && action.equals("unsubscribe")) {
            System.out.println("unsubscribe");
            Enumeration<String> paraNames = request.getParameterNames();
            for (Enumeration e = paraNames; e.hasMoreElements(); ) {
                String thisName = e.nextElement().toString();
                String thisValue = request.getParameter(thisName);
                System.out.println(thisName + "--------------" + thisValue);
            }
            if (phonenum != null && chargeid != null && spid != null && timestamp != null && token != null) {
                cpuser = configureService.getUserbyId(Integer.parseInt(spid));
                chargePoint = chargeService.getChargePointById(Integer.parseInt(chargeid));
                String value = utils.Encrypt.SHA1(chargeid + timestamp + chargePoint.getSecret());
                //token
                if (value.equals(token)) {
                    resultCode = Tools.unsubscribe(phonenum, chargePoint.getPid());
                    if (resultCode.equals("0")) {
                        OrderRecord order = new OrderRecord(0, phonenum, spid, chargeid, remoteip, 3, new java.sql.Date(new java.util.Date().getTime()));
                        orderRecordService.addOrderRecord(order);
                    }
                } else {
                    resultCode = "153";
                }
            } else {
                resultCode = "150";
            }
            ret(response, resultCode, jsonresult);

        } else {
            ret(response, "156", jsonresult);

        }
        //OrderRecord orderRecord = new OrderRecord(0, phonenum, spid, productid, ip, Integer.parseInt(type), new java.sql.Date(new java.util.Date().getTime()));
//        jsonresult.put("errcode", resultCode);
//        String err_msg = Constants.resultCodeMap.get(resultCode);
//        //err_msg = new String(err_msg.getBytes("GBK"));
//        jsonresult.put("errmsg", err_msg);
//        System.out.println(jsonresult.toString());
//        response.setContentType("application/json;charset=utf-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        OutputStream out = null;
//        try {
//            out = response.getOutputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            out.write(jsonresult.toString().getBytes("UTF-8"));
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void ret(HttpServletResponse response, String resultCode, JSONObject jsonresult) {
        jsonresult.put("errcode", resultCode);
        String err_msg = Constants.resultCodeMap.get(resultCode);
        //err_msg = new String(err_msg.getBytes("GBK"));
        jsonresult.put("errmsg", err_msg);
        System.out.println(jsonresult.toString());
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.write(jsonresult.toString().getBytes("UTF-8"));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
