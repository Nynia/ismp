import utils.Tools;

/**
 * Created by Ridiculous on 2016/5/26.
 */
public class commonTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<20; i++){
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
        }

    }
}
