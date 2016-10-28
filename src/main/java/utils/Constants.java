package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ridiculous on 2016/5/26.
 */
public class Constants {
    public final static String DeviceID = "021155";
    public final static Map<String, String> resultCodeMap = new HashMap<String, String>();
    public final static Map<String, String> areaIdMap = new HashMap<String, String>();
    static {
        areaIdMap.put("江苏省南京市", "3");
        areaIdMap.put("江苏省镇江市", "4");
        areaIdMap.put("江苏省无锡市", "15");
        areaIdMap.put("江苏省苏州市", "20");
        areaIdMap.put("江苏省南通市", "26");
        areaIdMap.put("江苏省扬州市", "33");
        areaIdMap.put("江苏省盐城市", "39");
        areaIdMap.put("江苏省徐州市", "48");
        areaIdMap.put("江苏省淮安市", "60");
        areaIdMap.put("江苏省连云港市", "63");
        areaIdMap.put("江苏省常州市", "69");
        areaIdMap.put("江苏省泰州市", "79");
        areaIdMap.put("江苏省宿迁市", "84");

        resultCodeMap.put("0", "success");
        resultCodeMap.put("103", "用户号码非法");
        resultCodeMap.put("108", "用户信息不存在");
        resultCodeMap.put("115", "用户已注销");
        resultCodeMap.put("116", "产品ID非法");
        resultCodeMap.put("118", "订购方用户号码非法");
        resultCodeMap.put("125", "用户状态不正常");
        resultCodeMap.put("126", "用户余额不足");
        resultCodeMap.put("127", "业务状态不正常");
        resultCodeMap.put("128", "产品状态不正常");
        resultCodeMap.put("130", "订购关系不存在");
        resultCodeMap.put("131", "订购关系已存在");
        resultCodeMap.put("132", "订购关系不正常");
        resultCodeMap.put("136", "黑名单用户");
        resultCodeMap.put("150", "参数非法");
        resultCodeMap.put("151", "IP非法");
        resultCodeMap.put("152", "产品不存在");
        resultCodeMap.put("153", "token错误");
        resultCodeMap.put("154", "验证码超时");
        resultCodeMap.put("155", "验证码错误");
        resultCodeMap.put("156", "URL错误");
        resultCodeMap.put("157", "请求超时");
        resultCodeMap.put("158", "验证码发送失败");
        resultCodeMap.put("159", "获取号码失败");
        resultCodeMap.put("160", "暂未开通功能");
        resultCodeMap.put("161", "CP不存在");
        resultCodeMap.put("162", "计费代码不存在");
        resultCodeMap.put("999", "其他");
    }
}

