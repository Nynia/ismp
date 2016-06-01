/**
 * PortalEngine.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package utils.portalEngine;

public interface PortalEngine extends java.rmi.Remote {
    public utils.portalEngine.rsp.CreateSubscriptionRsp createSubscription(utils.portalEngine.req.CreateSubscriptionReq createSubscriptionReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.WithdrawSubscriptionRsp withdrawSubscription(utils.portalEngine.req.WithdrawSubscriptionReq withdrawSubscriptionReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.GetSubscriptionRsp getSubscription(utils.portalEngine.req.GetSubscriptionReq getSubscriptionReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.ResponseInfo withdrawAllSubscription(utils.portalEngine.req.WithdrawAllSubscriptionReq withdrawAllSubscriptionReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.ResponseInfo modifyPassword(utils.portalEngine.req.ModifyPasswordReq modifyPasswordReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.ResponseInfo resetPassword(utils.portalEngine.req.ResetPasswordReq resetPasswordReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.ReadUserRsp readUser(utils.portalEngine.req.ReadUserReq readUserReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.ResponseInfo modifyUser(utils.portalEngine.req.ModifyUserReq modifyUserReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.AuthenticateUserRsp authenticateUser(utils.portalEngine.req.AuthenticateUserReq authenticateUserReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.AuthorizeUserRsp authorizeUser(utils.portalEngine.req.AuthorizeUserReq authorizeUserReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.QuerySubscriptionHistoryRsp querySubscriptionHistory(utils.portalEngine.req.QuerySubscriptionHistoryReq querySubscriptionHistoryReq) throws java.rmi.RemoteException;
    public utils.portalEngine.rsp.ResponseInfo useService(utils.portalEngine.req.UseServiceReq useServiceReq) throws java.rmi.RemoteException;
}
