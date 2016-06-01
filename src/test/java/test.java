import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import utils.portalEngine.PortalEngine;
import utils.portalEngine.PortalEngineServiceLocator;
import utils.portalEngine.req.CreateSubscriptionReq;
import utils.portalEngine.rsp.CreateSubscriptionRsp;
import utils.portalEngine.PortalEngineImplement;

public class test {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++"+PortalEngineImplement.subscribe("18118999630", "135000000000000231929"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
