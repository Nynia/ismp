package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;

/**
 * Created by Ridiculous on 2016/5/26.
 */
public class Tools {
    public static String genStreamNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String no = "0000000000000000000000000000000000000000000"
                + sdf.format(new Date());
        return no;
    }

    public static String genVerCode() {
        int s = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
        return String.valueOf(s);
    }

    public static String genSecret(String id) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String atTime = sdf.format(new java.util.Date(System.currentTimeMillis()));
        return utils.Encrypt.MD5(atTime+id).substring(12);
    }

    public static String genOrderId() {
        int s = (int) (Math.random() * (999999 - 100000 + 1)) + 1000000;
        return getTimestamp() + String.valueOf(s);
    }
    public static String getTimestamp() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String atTime = sdf.format(new java.util.Date(System.currentTimeMillis()));
        return atTime;
    }
    public static String checkMdn(String ip, String port) {
        String username = "ismp";
        String secret = "Ismp@0527";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new java.util.Date(System.currentTimeMillis()));
        String password = utils.Encrypt.MD5(username+secret+timestamp).toUpperCase();
        String address = "202.102.120.121";
        String messageId = timestamp + timestamp.substring(8);

        String url = "http://221.228.17.38:9002/Business/AskUserOnLineInfo";
        JSONObject jsonParams = new JSONObject();
        jsonParams.put("Address", address);
        jsonParams.put("MessageID", messageId);
        jsonParams.put("Password", password);
        jsonParams.put("Username", username);
        jsonParams.put("OperType", "AskMDNByIP");
        jsonParams.put("PublicIP", ip);
        jsonParams.put("PublicPort", port);
        jsonParams.put("ReqTime", timestamp);
        JSONObject result = HttpRequest.doJsonPost(url, jsonParams);
        System.out.println(result);
        if (!result.equals("")) {
            if (result.getString("ResultCode").equals("0")) {
                JSONArray Resultinfo = JSON.parseArray(result.getString("ResultInfo"));
                JSONObject resultjson = (JSONObject) JSON.toJSON(Resultinfo.get(0));
                return resultjson.getString("Mdn");
            }
            else {
                return "";
            }
        }
        return "";
    }
    public static String checkMdnByIMSI(String imsi, String ip) throws UnsupportedEncodingException {
        String areaId = getAreaIdByIp2(ip);
        if (areaId == null)
            return "";
        //String url = "http://132.224.218.132:9250/dcninterface/imsiQuery";
        String url = "http://192.168.127.53:9250/dcninterface/imsiQuery";
        String params = String.format("imsi=%s&areaid=%s", imsi, areaId);
        String result = HttpRequest.sendGet(url, params);
        if (result != null) {
            JSONObject jsoj = JSONObject.parseObject(result);
            if (jsoj.getString("code").equals("0")) {
                jsoj = jsoj.getJSONObject("result");
                return jsoj.getString("phone_num");
            }
            else return "";
        }
        else
            return "";
    }
    public static String subscribe(String phoneNum, String productId) {
        //String url = "http://132.224.218.132:9250/dcninterface/serviceOrder";
        String url = "http://192.168.127.53:9250/dcninterface/serviceOrder";
        String params = String.format("action=subscribe&phoneNum=%s&productId=%s", phoneNum,productId);
        String result = HttpRequest.sendGet(url, params);
        if (result != null) {
            JSONObject jsoj = JSONObject.parseObject(result);
            return jsoj.get("err_code").toString();
        }
        else
            return null;
    }
    public static String unsubscribe(String phoneNum, String productId) {
        //String url = "http://132.224.218.132:9250/dcninterface/serviceOrder";
        String url = "http://192.168.127.53:9250/dcninterface/serviceOrder";
        String params = String.format("action=unsubscribe&phoneNum=%s&productId=%s", phoneNum,productId);
        String result = HttpRequest.sendGet(url, params);
        if (result != null) {
            JSONObject jsoj = JSONObject.parseObject(result);
            return jsoj.get("err_code").toString();
        }
        else
            return null;
    }
    public static String getAreaIdByIp(String ip) throws UnsupportedEncodingException {
        String url = "http://apis.juhe.cn/ip/ip2addr";
        String appKey = "eb82c3d5e4e03425cfaff5eedbd0d51b";
        String params = String.format("ip=%s&key=%s",ip,appKey);
        String result = HttpRequest.sendGet(url, params);
        result = new String(result.getBytes(),"UTF-8");
        if (result != null) {
            JSONObject jsoj = JSONObject.parseObject(result);
            String resultCode = jsoj.get("resultcode").toString();
            System.out.println("ip查询结果:" + resultCode);
            if (resultCode.equals("200")) {
                JSONObject tj = jsoj.getJSONObject("result");
                String area = tj.getString("area");
                if (Constants.areaIdMap.containsKey(area)) {
                    return Constants.areaIdMap.get(area);
                }
            }
        }
        return null;
    }
    public static String getAreaIdByIp2(String ip) throws UnsupportedEncodingException {
        String url = "http://ip.taobao.com/service/getIpInfo.php";
        String params = String.format("ip=%s&format=js",ip);
        String result = HttpRequest.sendGet(url, params);
        result = new String(result.getBytes(),"UTF-8");
        if (result != null) {
            JSONObject jsoj = JSONObject.parseObject(result);
            String resultCode = jsoj.get("code").toString();
            System.out.println("ip查询结果:" + jsoj);
            if (resultCode.equals("0")) {
                JSONObject tj = jsoj.getJSONObject("data");
                String city = tj.getString("city");
                String region = tj.getString("region");
                String area = region+city;
                if (Constants.areaIdMap.containsKey(area)) {
                    return Constants.areaIdMap.get(area);
                }
            }
        }
        return null;
    }
}
