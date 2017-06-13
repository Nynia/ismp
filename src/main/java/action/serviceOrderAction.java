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
                if (timestamp != null && spid != null && chargeid != null && token != null) {
                    orderid = utils.Tools.genOrderId();
                    cpuser = configureService.getUserbyId(Integer.parseInt(spid));
                    chargePoint = chargeService.getChargePointById(Integer.parseInt(chargeid));
                    if (chargePoint != null)
                        productInfo = productService.getProductByProductId(chargePoint.getPid());
                    if (cpuser == null) {
                        resultCode = "161";
                    } else if (chargePoint == null) {
                        resultCode = "162";
                    } else if (productInfo == null) {
                        resultCode = "152";
                    } else {
                        String ipstr = cpuser.getIp();
                        String[] ip_list = ipstr.split(";");
                        int flag = 0;
                        for (int i = 0; i < ip_list.length; i++) {
                            if (remoteip.equals(ip_list[i])) {
                                flag = 1;
                                break;
                            }
                        }
                        // ip no restrict
                        if (ipstr.equals("0.0.0.0")) {
                            flag = 1;
                        }
                        if (flag == 1) {
                            String value = utils.Encrypt.SHA1(chargeid + timestamp + chargePoint.getSecret());
                            //token
                            if (value.equals(token)) {
                                if (type.equals("1")) {
                                    int level = cpuser.getLevel();
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
                                        }
                                        else {
                                            resultCode = "150";
                                        }
                                    }
                                    else {
                                        if (level == 1) {
                                            resultCode = "150";
                                        }
                                        else {
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
                                                    resultCode = "0";
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
                                        }
                                    }
//                                    //level = 1
//                                    if (cpuser.getLevel() == 1) {
//                                        if (phonenum != null) {
//                                            //order
//                                            String productid = productInfo.getProductId();
//                                            resultCode = Tools.subscribe(phonenum, productid);
//                                            if (resultCode.equals("0")) {
//                                                OrderRecord order = new OrderRecord(0, phonenum, spid, chargeid, remoteip,
//                                                        Integer.parseInt(type), new java.sql.Date(new java.util.Date().getTime()));
//                                                orderRecordService.addOrderRecord(order);
//                                            }
//                                        } else {
//                                            resultCode = "150";
//                                        }
//                                    }
//                                    //level = 2
//                                    else if (cpuser.getLevel() == 2) {
//                                        phonenum = utils.Tools.checkMdnByIMSI(imsi, ip);
//                                        if (phonenum.startsWith("86")) {
//                                            phonenum = phonenum.substring(2);
//                                            System.out.println(phonenum);
//                                        }
//                                        requestInfoRecod orderRecord = new requestInfoRecod(remoteip, type, spid, chargeid,
//                                                productInfo.getProductName(), Integer.parseInt(productInfo.getPrice()),
//                                                phonenum, "", 0, System.currentTimeMillis(), action, cpuser.getName());
//
//                                        if (phonenum.equals("")) {
//                                            resultCode = "159";
//                                        } else {
//                                            String verCode = utils.Tools.genVerCode();
//                                            String msg = String.format("%s为本次支付验证码。您正在订购%s，价格是%s元/月，验证码2分钟内有效，感谢使用!",
//                                                    verCode, orderRecord.getProductname(), orderRecord.getPrice() / 100);
//                                            SMGPSMProxyMethod proxyMethod = new SMGPSMProxyMethod();
//                                            if (proxyMethod.sendMsg(phonenum, msg)) {
//                                                resultCode = "0";
//                                            } else {
//                                                resultCode = "158";
//                                            }
//                                            orderRecord.setVercode(verCode);
//                                            orderRecord.setPhonenum(phonenum);
//                                            orderRecord.setVercodecreatetime(System.currentTimeMillis());
//                                            orderRecord.addReqSeq();
//                                            //recordHashMap.put(orderid, orderRecord);
//                                        }
//                                        recordHashMap.put(orderid, orderRecord);
//                                        JSONObject orderinfo = new JSONObject();
//                                        orderinfo.put("phoneNum", phonenum);
//                                        orderinfo.put("orderId", orderid);
//                                        orderinfo.put("productName", productInfo.getProductName());
//                                        orderinfo.put("price", productInfo.getPrice());
//                                        orderinfo.put("providerName", cpuser.getName());
//                                        jsonresult.put("orderinfo", orderinfo);
//                                    }
//                                    // level= 3
//                                    else {
//
//                                    }
                                } else if (type.equals("2")) {
                                    //点播
                                    resultCode = "160";
                                }
                            } else {
                                resultCode = "153";
                            }
                        } else {
                            resultCode = "151";
                        }
                    }
                } else {
                    resultCode = "150";
                }
            } else {
                if (phonenum != null) {
                    requestInfoRecod orderRecord = recordHashMap.get(orderid);
                    System.out.println(orderRecord.getRequestcreatetime());
                    System.out.println(System.currentTimeMillis());
                    if (System.currentTimeMillis() - orderRecord.getRequestcreatetime() > 300000) {
                        resultCode = "157";
                    } else if (vercode == null) {
                        /*
                        if (phonenum.equals(orderRecord.getPhonenum()) && orderRecord.getVercode().equals("")) {
                            //order
                            resultCode = Tools.subscribe(phonenum, chargePoint.getPid());
                            if (resultCode.equals("0")) {
                                //recordHashMap.remove(orderid);
                                OrderRecord order = new OrderRecord(0, phonenum, orderRecord.getSpid(),
                                        orderRecord.getChargeid(),remoteip, Integer.parseInt(orderRecord.getType()),
                                        new java.sql.Date(new java.util.Date().getTime()));
                                orderRecordService.addOrderRecord(order);
                            }
                        }
                        */
                        String verCode = utils.Tools.genVerCode();
                        String msg = String.format("%s为本次支付验证码。您正在订购%s，价格是%s元/月，验证码2分钟内有效，感谢使用!",
                                verCode, orderRecord.getProductname(), orderRecord.getPrice() / 100);
                        SMGPSMProxyMethod proxyMethod = new SMGPSMProxyMethod();
                        if (proxyMethod.sendMsg(phonenum, msg)) {
                            resultCode = "0";
                        } else {
                            resultCode = "158";
                        }
                        orderRecord.setVercode(verCode);
                        orderRecord.setPhonenum(phonenum);
                        orderRecord.setVercodecreatetime(System.currentTimeMillis());
                        orderRecord.addReqSeq();
                        recordHashMap.put(orderid, orderRecord);
                    } else {
                        if (System.currentTimeMillis() - orderRecord.getVercodecreatetime() > 120000) {
                            resultCode = "154";
                        } else {
                            if (vercode.equals(orderRecord.getVercode())) {
                                //order
                                chargePoint = chargeService.getChargePointById(Integer.parseInt(orderRecord.getChargeid()));
                                if (chargePoint != null) {
                                    resultCode = Tools.subscribe(orderRecord.getPhonenum(), chargePoint.getPid());
                                    if (resultCode.equals("0")) {
                                        //recordHashMap.remove(orderid);
                                        OrderRecord order = new OrderRecord(0, phonenum, orderRecord.getSpid(),
                                                orderRecord.getChargeid(), remoteip, Integer.parseInt(orderRecord.getType()),
                                                new java.sql.Date(new java.util.Date().getTime()));
                                        orderRecordService.addOrderRecord(order);
                                    }
                                }
                                else {
                                    resultCode = "162";
                                }

                            } else {
                                resultCode = "155";
                            }
                        }
                    }
                } else {
                    resultCode = "150";
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
        } else {
            resultCode = "156";
        }
        //OrderRecord orderRecord = new OrderRecord(0, phonenum, spid, productid, ip, Integer.parseInt(type), new java.sql.Date(new java.util.Date().getTime()));
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
