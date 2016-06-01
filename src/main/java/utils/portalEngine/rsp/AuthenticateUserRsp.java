/**
 * AuthenticateUserRsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package utils.portalEngine.rsp;

public class AuthenticateUserRsp  implements java.io.Serializable {
    private java.lang.String corpID;

    private int corpTag;

    private int resultCode;

    private java.lang.String SPID;

    private java.lang.String streamingNo;

    private int testUserTag;

    private int registered;

    private int whiteListServiceNum;

    private java.lang.String[] serviceIDList;

    public AuthenticateUserRsp() {
    }

    public AuthenticateUserRsp(
           java.lang.String corpID,
           int corpTag,
           int resultCode,
           java.lang.String SPID,
           java.lang.String streamingNo,
           int testUserTag,
           int registered,
           int whiteListServiceNum,
           java.lang.String[] serviceIDList) {
           this.corpID = corpID;
           this.corpTag = corpTag;
           this.resultCode = resultCode;
           this.SPID = SPID;
           this.streamingNo = streamingNo;
           this.testUserTag = testUserTag;
           this.registered = registered;
           this.whiteListServiceNum = whiteListServiceNum;
           this.serviceIDList = serviceIDList;
    }


    /**
     * Gets the corpID value for this AuthenticateUserRsp.
     * 
     * @return corpID
     */
    public java.lang.String getCorpID() {
        return corpID;
    }


    /**
     * Sets the corpID value for this AuthenticateUserRsp.
     * 
     * @param corpID
     */
    public void setCorpID(java.lang.String corpID) {
        this.corpID = corpID;
    }


    /**
     * Gets the corpTag value for this AuthenticateUserRsp.
     * 
     * @return corpTag
     */
    public int getCorpTag() {
        return corpTag;
    }


    /**
     * Sets the corpTag value for this AuthenticateUserRsp.
     * 
     * @param corpTag
     */
    public void setCorpTag(int corpTag) {
        this.corpTag = corpTag;
    }


    /**
     * Gets the resultCode value for this AuthenticateUserRsp.
     * 
     * @return resultCode
     */
    public int getResultCode() {
        return resultCode;
    }


    /**
     * Sets the resultCode value for this AuthenticateUserRsp.
     * 
     * @param resultCode
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }


    /**
     * Gets the SPID value for this AuthenticateUserRsp.
     * 
     * @return SPID
     */
    public java.lang.String getSPID() {
        return SPID;
    }


    /**
     * Sets the SPID value for this AuthenticateUserRsp.
     * 
     * @param SPID
     */
    public void setSPID(java.lang.String SPID) {
        this.SPID = SPID;
    }


    /**
     * Gets the streamingNo value for this AuthenticateUserRsp.
     * 
     * @return streamingNo
     */
    public java.lang.String getStreamingNo() {
        return streamingNo;
    }


    /**
     * Sets the streamingNo value for this AuthenticateUserRsp.
     * 
     * @param streamingNo
     */
    public void setStreamingNo(java.lang.String streamingNo) {
        this.streamingNo = streamingNo;
    }


    /**
     * Gets the testUserTag value for this AuthenticateUserRsp.
     * 
     * @return testUserTag
     */
    public int getTestUserTag() {
        return testUserTag;
    }


    /**
     * Sets the testUserTag value for this AuthenticateUserRsp.
     * 
     * @param testUserTag
     */
    public void setTestUserTag(int testUserTag) {
        this.testUserTag = testUserTag;
    }


    /**
     * Gets the registered value for this AuthenticateUserRsp.
     * 
     * @return registered
     */
    public int getRegistered() {
        return registered;
    }


    /**
     * Sets the registered value for this AuthenticateUserRsp.
     * 
     * @param registered
     */
    public void setRegistered(int registered) {
        this.registered = registered;
    }


    /**
     * Gets the whiteListServiceNum value for this AuthenticateUserRsp.
     * 
     * @return whiteListServiceNum
     */
    public int getWhiteListServiceNum() {
        return whiteListServiceNum;
    }


    /**
     * Sets the whiteListServiceNum value for this AuthenticateUserRsp.
     * 
     * @param whiteListServiceNum
     */
    public void setWhiteListServiceNum(int whiteListServiceNum) {
        this.whiteListServiceNum = whiteListServiceNum;
    }


    /**
     * Gets the serviceIDList value for this AuthenticateUserRsp.
     * 
     * @return serviceIDList
     */
    public java.lang.String[] getServiceIDList() {
        return serviceIDList;
    }


    /**
     * Sets the serviceIDList value for this AuthenticateUserRsp.
     * 
     * @param serviceIDList
     */
    public void setServiceIDList(java.lang.String[] serviceIDList) {
        this.serviceIDList = serviceIDList;
    }

    public java.lang.String getServiceIDList(int i) {
        return this.serviceIDList[i];
    }

    public void setServiceIDList(int i, java.lang.String _value) {
        this.serviceIDList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AuthenticateUserRsp)) return false;
        AuthenticateUserRsp other = (AuthenticateUserRsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.corpID==null && other.getCorpID()==null) || 
             (this.corpID!=null &&
              this.corpID.equals(other.getCorpID()))) &&
            this.corpTag == other.getCorpTag() &&
            this.resultCode == other.getResultCode() &&
            ((this.SPID==null && other.getSPID()==null) || 
             (this.SPID!=null &&
              this.SPID.equals(other.getSPID()))) &&
            ((this.streamingNo==null && other.getStreamingNo()==null) || 
             (this.streamingNo!=null &&
              this.streamingNo.equals(other.getStreamingNo()))) &&
            this.testUserTag == other.getTestUserTag() &&
            this.registered == other.getRegistered() &&
            this.whiteListServiceNum == other.getWhiteListServiceNum() &&
            ((this.serviceIDList==null && other.getServiceIDList()==null) || 
             (this.serviceIDList!=null &&
              java.util.Arrays.equals(this.serviceIDList, other.getServiceIDList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCorpID() != null) {
            _hashCode += getCorpID().hashCode();
        }
        _hashCode += getCorpTag();
        _hashCode += getResultCode();
        if (getSPID() != null) {
            _hashCode += getSPID().hashCode();
        }
        if (getStreamingNo() != null) {
            _hashCode += getStreamingNo().hashCode();
        }
        _hashCode += getTestUserTag();
        _hashCode += getRegistered();
        _hashCode += getWhiteListServiceNum();
        if (getServiceIDList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceIDList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceIDList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AuthenticateUserRsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "AuthenticateUserRsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "corpID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpTag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "corpTag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "resultCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SPID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "SPID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("streamingNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "streamingNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testUserTag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "testUserTag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registered");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "registered"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whiteListServiceNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "whiteListServiceNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceIDList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "serviceIDList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
