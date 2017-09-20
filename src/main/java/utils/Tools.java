package utils;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.lang.Math;
import java.util.List;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String atTime = sdf.format(new java.util.Date(System.currentTimeMillis()));
        return utils.Encrypt.MD5(atTime + id).substring(12);
    }

    public static String genOrderId() {
        int s = (int) (Math.random() * (999999 - 100000 + 1)) + 1000000;
        return getTimestamp() + String.valueOf(s);
    }

    public static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String atTime = sdf.format(new java.util.Date(System.currentTimeMillis()));
        return atTime;
    }

    public static String checkMdn(String ip, String port) {
        String username = "ismp";
        String secret = "Ismp@0527";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new java.util.Date(System.currentTimeMillis()));
        String password = utils.Encrypt.MD5(username + secret + timestamp).toUpperCase();
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
            } else {
                return "";
            }
        }
        return "";
    }

    public static String checkMdnByIMSI(String imsi, String ip) throws UnsupportedEncodingException {
        String areaId = getAreaIdByIp3(ip);
        if (areaId != null)
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
            } else return "";
        } else
            return "";
    }

    public static String subscribe(String phoneNum, String productId) {
        //String url = "http://132.224.218.132:9250/dcninterface/serviceOrder";
        String url = "http://192.168.127.53:9250/dcninterface/serviceOrder";
        String params = String.format("action=subscribe&phoneNum=%s&productId=%s", phoneNum, productId);
        String result = HttpRequest.sendGet(url, params);
        if (result != null) {
            JSONObject jsoj = JSONObject.parseObject(result);
            return jsoj.get("err_code").toString();
        } else
            return null;
    }

    public static String unsubscribe(String phoneNum, String productId) {
        //String url = "http://132.224.218.132:9250/dcninterface/serviceOrder";
        String url = "http://192.168.127.53:9250/dcninterface/serviceOrder";
        String params = String.format("action=unsubscribe&phoneNum=%s&productId=%s", phoneNum, productId);
        String result = HttpRequest.sendGet(url, params);
        if (result != null) {
            JSONObject jsoj = JSONObject.parseObject(result);
            return jsoj.get("err_code").toString();
        } else
            return null;
    }

    public static String getAreaIdByIp(String ip) throws UnsupportedEncodingException {
        String url = "http://apis.juhe.cn/ip/ip2addr";
        String appKey = "eb82c3d5e4e03425cfaff5eedbd0d51b";
        String params = String.format("ip=%s&key=%s", ip, appKey);
        String result = HttpRequest.sendGet(url, params);
        result = new String(result.getBytes(), "UTF-8");
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
            } else {
                return getAreaIdByIp3(ip);
            }
        }
        return null;
    }

    public static String getAreaIdByIp2(String ip) throws UnsupportedEncodingException {
        String url = "http://ip.taobao.com/service/getIpInfo.php";

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("ip", ip));
        qparams.add(new BasicNameValuePair("format", "js"));

        uriBuilder.setParameters(qparams);
        URI uri = null;
        try {
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        System.out.println(httpGet.getURI());
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();//设置请求和传输超时时间
        httpGet.setConfig(requestConfig);
        try {
            HttpResponse response = closeableHttpClient.execute(httpGet);
            //获取响应消息实体
            HttpEntity entity = response.getEntity();
            //响应状态
            System.out.println("status:" + response.getStatusLine());
            //判断响应实体是否为空
            if (entity != null) {
                JSONObject jsoj = JSONObject.parseObject(EntityUtils.toString(entity));
                System.out.println(jsoj);
                String resultCode = jsoj.get("code").toString();
                System.out.println("ip查询结果:" + jsoj);
                if (resultCode.equals("0")) {
                    JSONObject tj = jsoj.getJSONObject("data");
                    String city = tj.getString("city");
                    String region = tj.getString("region");
                    String area = region + city;
                    if (Constants.areaIdMap.containsKey(area)) {
                        return Constants.areaIdMap.get(area);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return getAreaIdByIp(ip);
        } finally {
            try {
                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getAreaIdByIp3(String ip) throws UnsupportedEncodingException {
        String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("ip", ip));
        qparams.add(new BasicNameValuePair("format", "json"));

        uriBuilder.setParameters(qparams);
        URI uri = null;
        try {
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        System.out.println(httpGet.getURI());
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();//设置请求和传输超时时间
        httpGet.setConfig(requestConfig);
        try {
            HttpResponse response = closeableHttpClient.execute(httpGet);
            //获取响应消息实体
            HttpEntity entity = response.getEntity();
            //响应状态
            System.out.println("status:" + response.getStatusLine());
            String entity_str = EntityUtils.toString(entity);
            System.out.println(entity_str);
            //判断响应实体是否为空
            if (entity != null) {
                JSONObject jsoj = JSONObject.parseObject(entity_str);
                System.out.println(jsoj);
                String resultCode = jsoj.getString("ret");
                System.out.println("ip查询结果:" + jsoj);
                if (resultCode.equals("1")) {
                    String province = jsoj.getString("province");
                    String city = jsoj.getString("city");
                    String area = province + "省" + city + "市";
                    System.out.println(area);
                    if (Constants.areaIdMap.containsKey(area)) {
                        return Constants.areaIdMap.get(area);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return getAreaIdByIp(ip);
        } finally {
            try {
                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        String params = String.format("ip=%s&format=json",ip);
//        String result = HttpRequest.sendGet(url,params);
//        result = new String(result.getBytes(),"UTF-8");
//        if (result != null) {
//            JSONObject jsoj = JSONObject.parseObject(result);
//            String resultCode = jsoj.get("ret").toString();
//            System.out.println("ip查询结果:" + jsoj);
//            if (resultCode.equals("1")) {
//                String province = jsoj.getString("province");
//                String city = jsoj.getString("city");
//                String area = province+"省"+city+"市";
//                System.out.println(area);
//                if (Constants.areaIdMap.containsKey(area)) {
//                    return Constants.areaIdMap.get(area);
//                }
//            }
//        }
        return null;
    }

}
