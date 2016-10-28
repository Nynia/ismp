package utils.SMGP;

import java.awt.peer.SystemTrayPeer;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.huawei.smproxy.comm.smgp.message.*;
import com.huawei.smproxy.util.Args;
import com.huawei.smproxy.util.Cfg;

/**
 * SMGP
 */

public class SMGPSMProxyMethod {
    public static MySMGPSMProxy mySMProxy;
    public static int test;

    static {
        try {
            String configPath = SMGPSMProxyMethod.class.getResource("/config.xml").getPath();
            System.out.println(configPath);
            Args cfgArgs = new Cfg(configPath.substring(1)).getArgs("SMGPConnect");
            //Linux
            //Args cfgArgs = new Cfg(configPath).getArgs("SMGPConnect");
            mySMProxy = new MySMGPSMProxy(cfgArgs);
            test = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SMGPSMProxyMethod() {
    }

    public Boolean sendMsg(String phoneNum, String msgContent) {
        String[] rcvMobile = new String[1];
        rcvMobile[0] = phoneNum;
        // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        // String atTime = sdf.format(new
        // java.util.Date(System.currentTimeMillis()));
        // System.out.println(atTime);
        SMGPSubmitMessage msg = new SMGPSubmitMessage(6, 1, 1, "goodnews13", "01", "999", "", 8, "", "",
                "106596106", "", rcvMobile, msgContent, "0123");
        SMGPSubmitRespMessage respMsg = null;
        try {
            respMsg = (SMGPSubmitRespMessage) mySMProxy.send(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (respMsg != null) {
            return true;
            //System.out.println("Get SubmitResp Message Success! The status = " + respMsg.getStatus());
        } else {
            return false;
            //System.out.println("Get SubmitResp Message Fail!");
        }
        //mySMProxy.close();
    }
}
