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
		String ipstr = "202.102.120.121;127.0.0.1;192.168.0.1";
		String[] ip_list = ipstr.split(";");
		int flag = 0;
		for (int i=0; i<ip_list.length; i++) {
			System.out.println(ip_list[i]);
		}
	}

}
