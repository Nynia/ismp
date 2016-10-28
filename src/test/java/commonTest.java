import utils.Tools;

import java.io.UnsupportedEncodingException;

/**
 * Created by Ridiculous on 2016/5/26.
 */
public class commonTest {
    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        String os_encoding = System.getProperty("file.encoding");
        System.out.println(os_encoding);
        String s = "中国";
        System.out.println(new String(s.getBytes("GBK")));
    }
}
