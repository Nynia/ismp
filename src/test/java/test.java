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
		System.out.println(utils.Tools.genVerCode());
	}

}
