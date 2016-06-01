package utils.portalEngine;

import utils.portalEngine.req.CreateSubscriptionReq;
import utils.portalEngine.req.WithdrawSubscriptionReq;
import utils.portalEngine.rsp.CreateSubscriptionRsp;
import utils.portalEngine.rsp.WithdrawSubscriptionRsp;
/**
 * Created by Ridiculous on 2016/5/26.
 */
public class PortalEngineImplement {
    public static String subscribe(String mobile, String spid) throws Exception {
        PortalEngineServiceLocator locator = new PortalEngineServiceLocator();
        PortalEngine engine = locator.getPortalEngine();
        CreateSubscriptionReq req = new CreateSubscriptionReq();
        CreateSubscriptionRsp rsp = new CreateSubscriptionRsp();
        req.setStreamingNo(utils.Tools.genStreamNo());
        req.setSrcDeviceType(2);
        req.setSrcDeviceID(utils.Constants.DeviceID);
        req.setOA(mobile);
        req.setOAType(0);
        req.setDA(mobile);
        req.setOAType(0);
        req.setFA(mobile);
        req.setFAType(0);
        req.setIDType(0);
        req.setID(spid);
        rsp = engine.createSubscription(req);
        return String.valueOf(rsp.getResultCode());
    }
    public static String unsubscribe(String mobile,String spid) throws Exception{
        PortalEngineServiceLocator locator = new PortalEngineServiceLocator();
        PortalEngine engine = locator.getPortalEngine();
        WithdrawSubscriptionReq req = new WithdrawSubscriptionReq();
        WithdrawSubscriptionRsp rsp = new WithdrawSubscriptionRsp();
        req.setStreamingNo(utils.Tools.genStreamNo());
        req.setSrcDeviceType(2);
        req.setSrcDeviceID(utils.Constants.DeviceID);
        req.setUserIDType(0);
        req.setUserID(mobile);
        req.setIDType(0);
        req.setID(spid);
        rsp = engine.withdrawSubscription(req);
        return String.valueOf(rsp.getResultCode());
    }
}
