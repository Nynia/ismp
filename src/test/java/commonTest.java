import utils.Tools;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ridiculous on 2016/5/26.
 */
public class commonTest {
    public static void main(String[] args){
        Map<String, String[]> productid_ip_list = new HashMap<String, String[]>();
        String[] ip_list = productid_ip_list.get("111");
        for (int i = 0; ip_list != null && i < ip_list.length; i++) {
            if (ip_list[i].equals("localhost")) {
                break;
            }
        }
    }
}
