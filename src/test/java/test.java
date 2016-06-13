import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import entity.CpInfo;
import entity.ProductInfo;
import service.configureService;
import service.productService;
import utils.portalEngine.PortalEngine;
import utils.portalEngine.PortalEngineServiceLocator;
import utils.portalEngine.req.CreateSubscriptionReq;
import utils.portalEngine.rsp.CreateSubscriptionRsp;
import utils.portalEngine.PortalEngineImplement;

public class test {
	private static CpInfo cpuser;
	private static ProductInfo productInfo;
	@Resource
	private static configureService configureService;

	@Resource
	private static productService productService;
	public static void main(String[] args)  {
		String spid = "11104927";
		String stamp = "20160613110248";
		String secret = "a9a883cfe29e237d927c";
		System.out.println(utils.Encrypt.SHA1(spid+stamp+secret));
	}

}
