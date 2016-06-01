package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * Created by Ridiculous on 2016/5/27.
 */
@Controller
public class askMDNAction {
    @RequestMapping("askMDNByIp")
    @ResponseBody
    public String askMDNByIp (HttpServletRequest request){
        String publicip = request.getRemoteAddr();
        String publicport = String.valueOf(request.getRemotePort());
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
        jsonParams.put("PublicIP", publicip);
        jsonParams.put("PublicPort", publicport);
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
}
