package utils.portalEngine;

public class PortalEngineProxy implements utils.portalEngine.PortalEngine {
  private String _endpoint = null;
  private utils.portalEngine.PortalEngine portalEngine = null;
  
  public PortalEngineProxy() {
    _initPortalEngineProxy();
  }
  
  public PortalEngineProxy(String endpoint) {
    _endpoint = endpoint;
    _initPortalEngineProxy();
  }
  
  private void _initPortalEngineProxy() {
    try {
      portalEngine = (new utils.portalEngine.PortalEngineServiceLocator()).getPortalEngine();
      if (portalEngine != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)portalEngine)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)portalEngine)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (portalEngine != null)
      ((javax.xml.rpc.Stub)portalEngine)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public utils.portalEngine.PortalEngine getPortalEngine() {
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine;
  }
  
  public utils.portalEngine.rsp.CreateSubscriptionRsp createSubscription(utils.portalEngine.req.CreateSubscriptionReq createSubscriptionReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.createSubscription(createSubscriptionReq);
  }
  
  public utils.portalEngine.rsp.WithdrawSubscriptionRsp withdrawSubscription(utils.portalEngine.req.WithdrawSubscriptionReq withdrawSubscriptionReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.withdrawSubscription(withdrawSubscriptionReq);
  }
  
  public utils.portalEngine.rsp.GetSubscriptionRsp getSubscription(utils.portalEngine.req.GetSubscriptionReq getSubscriptionReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.getSubscription(getSubscriptionReq);
  }
  
  public utils.portalEngine.rsp.ResponseInfo withdrawAllSubscription(utils.portalEngine.req.WithdrawAllSubscriptionReq withdrawAllSubscriptionReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.withdrawAllSubscription(withdrawAllSubscriptionReq);
  }
  
  public utils.portalEngine.rsp.ResponseInfo modifyPassword(utils.portalEngine.req.ModifyPasswordReq modifyPasswordReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.modifyPassword(modifyPasswordReq);
  }
  
  public utils.portalEngine.rsp.ResponseInfo resetPassword(utils.portalEngine.req.ResetPasswordReq resetPasswordReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.resetPassword(resetPasswordReq);
  }
  
  public utils.portalEngine.rsp.ReadUserRsp readUser(utils.portalEngine.req.ReadUserReq readUserReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.readUser(readUserReq);
  }
  
  public utils.portalEngine.rsp.ResponseInfo modifyUser(utils.portalEngine.req.ModifyUserReq modifyUserReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.modifyUser(modifyUserReq);
  }
  
  public utils.portalEngine.rsp.AuthenticateUserRsp authenticateUser(utils.portalEngine.req.AuthenticateUserReq authenticateUserReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.authenticateUser(authenticateUserReq);
  }
  
  public utils.portalEngine.rsp.AuthorizeUserRsp authorizeUser(utils.portalEngine.req.AuthorizeUserReq authorizeUserReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.authorizeUser(authorizeUserReq);
  }
  
  public utils.portalEngine.rsp.QuerySubscriptionHistoryRsp querySubscriptionHistory(utils.portalEngine.req.QuerySubscriptionHistoryReq querySubscriptionHistoryReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.querySubscriptionHistory(querySubscriptionHistoryReq);
  }
  
  public utils.portalEngine.rsp.ResponseInfo useService(utils.portalEngine.req.UseServiceReq useServiceReq) throws java.rmi.RemoteException{
    if (portalEngine == null)
      _initPortalEngineProxy();
    return portalEngine.useService(useServiceReq);
  }
  
  
}