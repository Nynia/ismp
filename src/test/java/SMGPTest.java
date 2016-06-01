import utils.SMGP.SMGPSMProxyMethod;

/**
 * Created by Ridiculous on 2016/5/26.
 */
public class SMGPTest {

    public static void main(String[] args) {
        SMGPSMProxyMethod proxyMethod = new SMGPSMProxyMethod();
        proxyMethod.sendMsg("18118999630","test1 from sk");

        SMGPSMProxyMethod proxyMethod2 = new SMGPSMProxyMethod();
        proxyMethod2.sendMsg("18118999630","test2 from sk");

    }
}
