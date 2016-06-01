/**
 * PortalEngineSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package utils.portalEngine;

public class PortalEngineSoapBindingStub extends org.apache.axis.client.Stub implements utils.portalEngine.PortalEngine {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[12];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createSubscription");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "createSubscriptionReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "CreateSubscriptionReq"), utils.portalEngine.req.CreateSubscriptionReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "CreateSubscriptionRsp"));
        oper.setReturnClass(utils.portalEngine.rsp.CreateSubscriptionRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "createSubscriptionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("withdrawSubscription");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "withdrawSubscriptionReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "WithdrawSubscriptionReq"), utils.portalEngine.req.WithdrawSubscriptionReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "WithdrawSubscriptionRsp"));
        oper.setReturnClass(utils.portalEngine.rsp.WithdrawSubscriptionRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "withdrawSubscriptionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSubscription");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "getSubscriptionReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "GetSubscriptionReq"), utils.portalEngine.req.GetSubscriptionReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "GetSubscriptionRsp"));
        oper.setReturnClass(utils.portalEngine.rsp.GetSubscriptionRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "getSubscriptionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("withdrawAllSubscription");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "withdrawAllSubscriptionReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "WithdrawAllSubscriptionReq"), utils.portalEngine.req.WithdrawAllSubscriptionReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ResponseInfo"));
        oper.setReturnClass(utils.portalEngine.rsp.ResponseInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "withdrawAllSubscriptionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modifyPassword");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "modifyPasswordReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ModifyPasswordReq"), utils.portalEngine.req.ModifyPasswordReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ResponseInfo"));
        oper.setReturnClass(utils.portalEngine.rsp.ResponseInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "modifyPasswordReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("resetPassword");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "resetPasswordReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ResetPasswordReq"), utils.portalEngine.req.ResetPasswordReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ResponseInfo"));
        oper.setReturnClass(utils.portalEngine.rsp.ResponseInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "resetPasswordReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("readUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "readUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ReadUserReq"), utils.portalEngine.req.ReadUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ReadUserRsp"));
        oper.setReturnClass(utils.portalEngine.rsp.ReadUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "readUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modifyUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "modifyUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ModifyUserReq"), utils.portalEngine.req.ModifyUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ResponseInfo"));
        oper.setReturnClass(utils.portalEngine.rsp.ResponseInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "modifyUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("authenticateUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "authenticateUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "AuthenticateUserReq"), utils.portalEngine.req.AuthenticateUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "AuthenticateUserRsp"));
        oper.setReturnClass(utils.portalEngine.rsp.AuthenticateUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "authenticateUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("authorizeUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "authorizeUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "AuthorizeUserReq"), utils.portalEngine.req.AuthorizeUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "AuthorizeUserRsp"));
        oper.setReturnClass(utils.portalEngine.rsp.AuthorizeUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "authorizeUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySubscriptionHistory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "querySubscriptionHistoryReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "QuerySubscriptionHistoryReq"), utils.portalEngine.req.QuerySubscriptionHistoryReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "QuerySubscriptionHistoryRsp"));
        oper.setReturnClass(utils.portalEngine.rsp.QuerySubscriptionHistoryRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "querySubscriptionHistoryReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("useService");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "useServiceReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "UseServiceReq"), utils.portalEngine.req.UseServiceReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ResponseInfo"));
        oper.setReturnClass(utils.portalEngine.rsp.ResponseInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "useServiceReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

    }

    public PortalEngineSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PortalEngineSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PortalEngineSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "ArrayOf_tns2_SubHistoryInfo");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.SubHistoryInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "SubHistoryInfo");
            qName2 = new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "ArrayOf_tns2_SubInfo");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.SubInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "SubInfo");
            qName2 = new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "AuthenticateUserReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.AuthenticateUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "AuthorizeUserReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.AuthorizeUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "CreateSubscriptionReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.CreateSubscriptionReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "GetSubscriptionReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.GetSubscriptionReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ModifyPasswordReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.ModifyPasswordReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ModifyUserReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.ModifyUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "QuerySubscriptionHistoryReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.QuerySubscriptionHistoryReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ReadUserReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.ReadUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ResetPasswordReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.ResetPasswordReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "UseServiceReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.UseServiceReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "WithdrawAllSubscriptionReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.WithdrawAllSubscriptionReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "WithdrawSubscriptionReq");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.req.WithdrawSubscriptionReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "AuthenticateUserRsp");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.AuthenticateUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "AuthorizeUserRsp");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.AuthorizeUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "CreateSubscriptionRsp");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.CreateSubscriptionRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "GetSubscriptionRsp");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.GetSubscriptionRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "QuerySubscriptionHistoryRsp");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.QuerySubscriptionHistoryRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ReadUserRsp");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.ReadUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "ResponseInfo");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.ResponseInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "SubHistoryInfo");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.SubHistoryInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "SubInfo");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.SubInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "WithdrawSubscriptionRsp");
            cachedSerQNames.add(qName);
            cls = utils.portalEngine.rsp.WithdrawSubscriptionRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public utils.portalEngine.rsp.CreateSubscriptionRsp createSubscription(utils.portalEngine.req.CreateSubscriptionReq createSubscriptionReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "createSubscription"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {createSubscriptionReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.CreateSubscriptionRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.CreateSubscriptionRsp) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.CreateSubscriptionRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.WithdrawSubscriptionRsp withdrawSubscription(utils.portalEngine.req.WithdrawSubscriptionReq withdrawSubscriptionReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "withdrawSubscription"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {withdrawSubscriptionReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.WithdrawSubscriptionRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.WithdrawSubscriptionRsp) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.WithdrawSubscriptionRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.GetSubscriptionRsp getSubscription(utils.portalEngine.req.GetSubscriptionReq getSubscriptionReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSubscription"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getSubscriptionReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.GetSubscriptionRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.GetSubscriptionRsp) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.GetSubscriptionRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.ResponseInfo withdrawAllSubscription(utils.portalEngine.req.WithdrawAllSubscriptionReq withdrawAllSubscriptionReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "withdrawAllSubscription"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {withdrawAllSubscriptionReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.ResponseInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.ResponseInfo) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.ResponseInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.ResponseInfo modifyPassword(utils.portalEngine.req.ModifyPasswordReq modifyPasswordReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "modifyPassword"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {modifyPasswordReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.ResponseInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.ResponseInfo) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.ResponseInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.ResponseInfo resetPassword(utils.portalEngine.req.ResetPasswordReq resetPasswordReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "resetPassword"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {resetPasswordReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.ResponseInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.ResponseInfo) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.ResponseInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.ReadUserRsp readUser(utils.portalEngine.req.ReadUserReq readUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "readUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {readUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.ReadUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.ReadUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.ReadUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.ResponseInfo modifyUser(utils.portalEngine.req.ModifyUserReq modifyUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "modifyUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {modifyUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.ResponseInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.ResponseInfo) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.ResponseInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.AuthenticateUserRsp authenticateUser(utils.portalEngine.req.AuthenticateUserReq authenticateUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "authenticateUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {authenticateUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.AuthenticateUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.AuthenticateUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.AuthenticateUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.AuthorizeUserRsp authorizeUser(utils.portalEngine.req.AuthorizeUserReq authorizeUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "authorizeUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {authorizeUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.AuthorizeUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.AuthorizeUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.AuthorizeUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.QuerySubscriptionHistoryRsp querySubscriptionHistory(utils.portalEngine.req.QuerySubscriptionHistoryReq querySubscriptionHistoryReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "querySubscriptionHistory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {querySubscriptionHistoryReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.QuerySubscriptionHistoryRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.QuerySubscriptionHistoryRsp) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.QuerySubscriptionHistoryRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public utils.portalEngine.rsp.ResponseInfo useService(utils.portalEngine.req.UseServiceReq useServiceReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "useService"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {useServiceReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (utils.portalEngine.rsp.ResponseInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (utils.portalEngine.rsp.ResponseInfo) org.apache.axis.utils.JavaUtils.convert(_resp, utils.portalEngine.rsp.ResponseInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
