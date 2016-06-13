package action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import entity.CpInfo;
import entity.OrderRecord;
import entity.ProductInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.configureService;
import service.orderRecordService;
import service.productService;
import utils.Constants;
import utils.SMGP.SMGPSMProxyMethod;
import utils.Tools;
import utils.requestInfoRecod;
import utils.portalEngine.PortalEngineImplement;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ridiculous on 2016/5/28.
 */
@Controller
public class serviceOrderAction {

    private HashMap<String ,requestInfoRecod> recordHashMap;
    private CpInfo cpuser;
    private ProductInfo productInfo;
    @Resource
    private configureService configureService;

    @Resource
    private productService productService;

    @Resource
    private orderRecordService orderRecordService;

    public serviceOrderAction() {
        recordHashMap = new HashMap<String, requestInfoRecod>();
    }

    @RequestMapping("serviceOrder")
    @ResponseBody
    public void serviceOrder(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("action");
        String spid = request.getParameter("spId");
        String timestamp = request.getParameter("timestamp");
        String type = request.getParameter("orderType");
        String productid = request.getParameter("productId");
        String phonenum = request.getParameter("phoneNum");
        String token = request.getParameter("accessToken");
        String orderid = request.getParameter("orderId");
        String vercode = request.getParameter("verCode");
        String ip = request.getParameter("ip");
        String port = request.getParameter("port");

        String remoteip = request.getRemoteHost();

        JSONObject jsonresult = new JSONObject();
        String resultCode = "";
        if (action != null && action.equals("subscribe")) {
            System.out.println("subscribe");
            Enumeration<String> paraNames=request.getParameterNames();
            for(Enumeration e = paraNames; e.hasMoreElements();){
                String thisName=e.nextElement().toString();
                String thisValue=request.getParameter(thisName);
                System.out.println(thisName+"--------------"+thisValue);
            }
            if (orderid == null) {
                if (timestamp != null && spid != null && productid != null && token != null) {
                    orderid = utils.Tools.genOrderId(timestamp);
                    cpuser = configureService.getUserbyId(Integer.parseInt(spid));
                    productInfo = productService.getProductByProductId(productid);
                    if (cpuser == null) {
                        resultCode = "161";
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
                            String value = utils.Encrypt.SHA1(spid + timestamp + cpuser.getSecret());
                            //token
                            if (value.equals(token)) {
                                if (type.equals("1")) {
                                    //level = 1
                                    if (cpuser.getLevel() == 1) {
                                        if (phonenum != null) {
                                            //order
                                            resultCode = Tools.subscribe(phonenum, productid);
                                            if (resultCode.equals("0")) {
                                                OrderRecord order = new OrderRecord(0, phonenum, spid, productid, remoteip,
                                                        Integer.parseInt(type), new java.sql.Date(new java.util.Date().getTime()));
                                                orderRecordService.addOrderRecord(order);
                                            }
                                        } else {
                                            resultCode = "150";
                                        }
                                    }
                                    //level = 2
                                    else {
                                        if (ip == null || port == null || ip.equals("") || port.equals("")) {
                                            ip = request.getRemoteHost();
                                            port = String.valueOf(request.getRemotePort());
                                        }
                                        phonenum = utils.Tools.checkMdn(ip, port);
                                        if (phonenum.startsWith("86")) {
                                            phonenum = phonenum.substring(2);
                                            System.out.println(phonenum);
                                        }
                                        requestInfoRecod orderRecord = new requestInfoRecod(ip, port, type, spid, productid,
                                                productInfo.getProductName(), Integer.parseInt(productInfo.getPrice()),
                                                phonenum, "", 0, System.currentTimeMillis(), action);
                                        recordHashMap.put(orderid, orderRecord);
                                        if (phonenum.equals("")) {
                                            resultCode = "159";
                                        } else
                                            resultCode = "0";
                                        JSONObject orderinfo = new JSONObject();
                                        orderinfo.put("phoneNum", phonenum);
                                        orderinfo.put("orderId", orderid);
                                        orderinfo.put("productName", productInfo.getProductName());
                                        orderinfo.put("price", productInfo.getPrice());
                                        jsonresult.put("orderinfo", orderinfo);
                                    }
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
                }else{
                    resultCode = "150";
                }
            }
            else {
                if (phonenum != null && orderid != null) {
                    requestInfoRecod orderRecord = recordHashMap.get(orderid);
                    if (System.currentTimeMillis() - orderRecord.getRequestcreatetime() > 300000) {
                        resultCode = "157";
                    }
                    else if (phonenum.equals(orderRecord.getPhonenum())) {
                        //order
                        resultCode = Tools.subscribe(phonenum, orderRecord.getProductid());
                        if (resultCode.equals("0")) {
                            OrderRecord order = new OrderRecord(0, phonenum, orderRecord.getSpid(),
                                    orderRecord.getProductid(),remoteip, Integer.parseInt(orderRecord.getType()),
                                    new java.sql.Date(new java.util.Date().getTime()));
                            orderRecordService.addOrderRecord(order);
                        }
                    }
                    else if (vercode != null){
                        if (System.currentTimeMillis() - orderRecord.getVercodecreatetime() > 120000) {
                            resultCode = "154";
                        }
                        else {
                            if (vercode.equals(orderRecord.getVercode())) {
                                //order
                                resultCode = Tools.subscribe(orderRecord.getPhonenum(), orderRecord.getProductid());
                                if (resultCode.equals("0")) {
                                    OrderRecord order = new OrderRecord(0, phonenum, orderRecord.getSpid(),
                                            orderRecord.getProductid(),remoteip, Integer.parseInt(orderRecord.getType()),
                                            new java.sql.Date(new java.util.Date().getTime()));
                                    orderRecordService.addOrderRecord(order);
                                }
                            }
                            else {
                                resultCode = "155";
                            }
                        }
                    }
                    else {
                        String verCode = utils.Tools.genVerCode();
                        SMGPSMProxyMethod proxyMethod = new SMGPSMProxyMethod();
                        if (proxyMethod.sendMsg(phonenum,verCode)) {
                            resultCode = "0";
                        }
                        else {
                            resultCode = "158";
                        }
                        orderRecord.setVercode(verCode);
                        orderRecord.setPhonenum(phonenum);
                        orderRecord.setVercodecreatetime(System.currentTimeMillis());
                        recordHashMap.put(orderid, orderRecord);
                    }
                }
                else {
                    resultCode = "150";
                }
            }
        }
        else if (action != null && action.equals("unsubscribe")) {
            System.out.println("unsubscribe");
            Enumeration<String> paraNames=request.getParameterNames();
            for(Enumeration e = paraNames; e.hasMoreElements();){
                String thisName=e.nextElement().toString();
                String thisValue=request.getParameter(thisName);
                System.out.println(thisName+"--------------"+thisValue);
            }
            if (phonenum != null && productid != null && spid != null && timestamp != null && token!= null) {
                cpuser = configureService.getUserbyId(Integer.parseInt(spid));
                String value = utils.Encrypt.SHA1(spid+timestamp+cpuser.getSecret());
                //token
                if (value.equals(token)) {
                    resultCode = Tools.unsubscribe(phonenum, productid);
                    if (resultCode.equals("0")) {
                        OrderRecord order = new OrderRecord(0, phonenum, spid, productid, remoteip, 3, new java.sql.Date(new java.util.Date().getTime()));
                        orderRecordService.addOrderRecord(order);
                    }
                }
                else {
                    resultCode = "153";
                }
            }
            else {
                resultCode = "150";
            }
        }
        else {
            resultCode = "156";
        }
        //OrderRecord orderRecord = new OrderRecord(0, phonenum, spid, productid, ip, Integer.parseInt(type), new java.sql.Date(new java.util.Date().getTime()));
        jsonresult.put("err_code", resultCode);
        jsonresult.put("err_msg", Constants.resultCodeMap.get(resultCode));
        System.out.println(jsonresult.toString());
        response.setContentType("text/json;charset=utf-8");
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
