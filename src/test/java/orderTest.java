import java.text.SimpleDateFormat;

/**
 * Created by Ridiculous on 2016/5/28.
 */
public class orderTest {


    public static void main(String[] args) {
        String id = "1912";
        String productid = "135000000000000231929";
        String phonenum = "18118999630";
        int  ordertype = 1;
        String orderid;
        String timestamp = utils.Tools.getTimestamp();
        String url = "http://127.0.0.1:8080/serviceOrder?action=subscribe";
        String secret = "23cce45dff52da379dbd";

        String token = utils.Encrypt.SHA1(id+timestamp+secret);
        String params = String.format("id=%s&productId=%s&phoneNum=%s&orderType=%d&timestamp=%s&accessToken=%s",
                id,productid,phonenum,ordertype,timestamp,token);
        String resutlt = utils.HttpRequest.sendPost(url, params);
        System.out.println(resutlt);
    }

}
