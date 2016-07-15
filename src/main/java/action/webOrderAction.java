package action;

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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Ridiculous on 2016/7/14.
 */
@Controller
public class webOrderAction {
    private HashMap<String ,requestInfoRecod> recordHashMap;
    private CpInfo cpuser;
    private ProductInfo productInfo;
    @Resource
    private service.configureService configureService;

    @Resource
    private service.productService productService;

    @Resource
    private service.orderRecordService orderRecordService;

    public webOrderAction() {
        recordHashMap = new HashMap<String, requestInfoRecod>();
    }

    @RequestMapping("webOrder")
    @ResponseBody
    public void webOrder(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("action");
        String spid = request.getParameter("spId");
        String timestamp = request.getParameter("timestamp");
        String type = request.getParameter("orderType");
        String productid = request.getParameter("productId");
        String phonenum = request.getParameter("phoneNum");
        String token = request.getParameter("accessToken");
        String orderid = request.getParameter("orderId");
        String vercode = request.getParameter("verCode");

        String remoteip = request.getRemoteHost();
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
                if (timestamp != null && spid != null && productid != null && token != null && phonenum != null) {
                    orderid = utils.Tools.genOrderId(timestamp);
                    cpuser = configureService.getUserbyId(Integer.parseInt(spid));
                    productInfo = productService.getProductByProductId(productid);
                    if (cpuser == null) {
                        resultCode = "161";
                    } else if (productInfo == null) {
                        resultCode = "152";
                    } else {
                        String value = utils.Encrypt.SHA1(spid + timestamp + cpuser.getSecret());
                        //token
                        if (value.equals(token)) {
                            if (type.equals("1")) {
                                String verCode = utils.Tools.genVerCode();
                                String msg = String.format("%s为本次支付验证码。您正在订购%s，价格是%s元/月，验证码2分钟内有效，感谢使用!",
                                        verCode, productInfo.getProductName(), Integer.parseInt(productInfo.getPrice()) / 1000);
                                SMGPSMProxyMethod proxyMethod = new SMGPSMProxyMethod();
                                if (proxyMethod.sendMsg(phonenum, msg)) {
                                    resultCode = "0";
                                } else {
                                    resultCode = "158";
                                }
                                requestInfoRecod orderRecord = new requestInfoRecod("", "", type, spid, productid,
                                        productInfo.getProductName(), Integer.parseInt(productInfo.getPrice()),
                                        phonenum, verCode, System.currentTimeMillis(), System.currentTimeMillis(), action, cpuser.getName());
                                recordHashMap.put(orderid, orderRecord);
                                if (resultCode.equals("0")) {
                                    JSONObject orderinfo = new JSONObject();
                                    orderinfo.put("phoneNum", phonenum);
                                    orderinfo.put("orderId", orderid);
                                    orderinfo.put("productName", productInfo.getProductName());
                                    orderinfo.put("price", productInfo.getPrice());
                                    orderinfo.put("providerName", cpuser.getName());
                                    jsonresult.put("orderinfo", orderinfo);
                                }
                            } else {
                                resultCode = "160";
                            }
                        } else {
                            resultCode = "153";
                        }
                    }
                } else {
                    resultCode = "151";
                }
            }else {
                //orderid != null
                if (phonenum != null && vercode!= null) {
                    requestInfoRecod orderRecord = recordHashMap.get(orderid);
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

                }else {
                    resultCode = "150";
                }
            }
        }
        else if (action != null && action.equals("unsubscribe")) {
            resultCode = "160";
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
