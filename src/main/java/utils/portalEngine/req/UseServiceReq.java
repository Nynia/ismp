/**
 * UseServiceReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package utils.portalEngine.req;

public class UseServiceReq  implements java.io.Serializable {
    private java.lang.String productID;

    private int hasFeatureStr;

    private java.lang.String featureStr;

    private java.lang.String srcDeviceID;

    private int srcDeviceType;

    private java.lang.String streamingNo;

    private java.lang.String userID;

    private int userIDType;

    private java.lang.String chanelPlayerID;

    private java.lang.String eventID;

    public UseServiceReq() {
    }

    public UseServiceReq(
           java.lang.String productID,
           int hasFeatureStr,
           java.lang.String featureStr,
           java.lang.String srcDeviceID,
           int srcDeviceType,
           java.lang.String streamingNo,
           java.lang.String userID,
           int userIDType,
           java.lang.String chanelPlayerID,
           java.lang.String eventID) {
           this.productID = productID;
           this.hasFeatureStr = hasFeatureStr;
           this.featureStr = featureStr;
           this.srcDeviceID = srcDeviceID;
           this.srcDeviceType = srcDeviceType;
           this.streamingNo = streamingNo;
           this.userID = userID;
           this.userIDType = userIDType;
           this.chanelPlayerID = chanelPlayerID;
           this.eventID = eventID;
    }


    /**
     * Gets the productID value for this UseServiceReq.
     * 
     * @return productID
     */
    public java.lang.String getProductID() {
        return productID;
    }


    /**
     * Sets the productID value for this UseServiceReq.
     * 
     * @param productID
     */
    public void setProductID(java.lang.String productID) {
        this.productID = productID;
    }


    /**
     * Gets the hasFeatureStr value for this UseServiceReq.
     * 
     * @return hasFeatureStr
     */
    public int getHasFeatureStr() {
        return hasFeatureStr;
    }


    /**
     * Sets the hasFeatureStr value for this UseServiceReq.
     * 
     * @param hasFeatureStr
     */
    public void setHasFeatureStr(int hasFeatureStr) {
        this.hasFeatureStr = hasFeatureStr;
    }


    /**
     * Gets the featureStr value for this UseServiceReq.
     * 
     * @return featureStr
     */
    public java.lang.String getFeatureStr() {
        return featureStr;
    }


    /**
     * Sets the featureStr value for this UseServiceReq.
     * 
     * @param featureStr
     */
    public void setFeatureStr(java.lang.String featureStr) {
        this.featureStr = featureStr;
    }


    /**
     * Gets the srcDeviceID value for this UseServiceReq.
     * 
     * @return srcDeviceID
     */
    public java.lang.String getSrcDeviceID() {
        return srcDeviceID;
    }


    /**
     * Sets the srcDeviceID value for this UseServiceReq.
     * 
     * @param srcDeviceID
     */
    public void setSrcDeviceID(java.lang.String srcDeviceID) {
        this.srcDeviceID = srcDeviceID;
    }


    /**
     * Gets the srcDeviceType value for this UseServiceReq.
     * 
     * @return srcDeviceType
     */
    public int getSrcDeviceType() {
        return srcDeviceType;
    }


    /**
     * Sets the srcDeviceType value for this UseServiceReq.
     * 
     * @param srcDeviceType
     */
    public void setSrcDeviceType(int srcDeviceType) {
        this.srcDeviceType = srcDeviceType;
    }


    /**
     * Gets the streamingNo value for this UseServiceReq.
     * 
     * @return streamingNo
     */
    public java.lang.String getStreamingNo() {
        return streamingNo;
    }


    /**
     * Sets the streamingNo value for this UseServiceReq.
     * 
     * @param streamingNo
     */
    public void setStreamingNo(java.lang.String streamingNo) {
        this.streamingNo = streamingNo;
    }


    /**
     * Gets the userID value for this UseServiceReq.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this UseServiceReq.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }


    /**
     * Gets the userIDType value for this UseServiceReq.
     * 
     * @return userIDType
     */
    public int getUserIDType() {
        return userIDType;
    }


    /**
     * Sets the userIDType value for this UseServiceReq.
     * 
     * @param userIDType
     */
    public void setUserIDType(int userIDType) {
        this.userIDType = userIDType;
    }


    /**
     * Gets the chanelPlayerID value for this UseServiceReq.
     * 
     * @return chanelPlayerID
     */
    public java.lang.String getChanelPlayerID() {
        return chanelPlayerID;
    }


    /**
     * Sets the chanelPlayerID value for this UseServiceReq.
     * 
     * @param chanelPlayerID
     */
    public void setChanelPlayerID(java.lang.String chanelPlayerID) {
        this.chanelPlayerID = chanelPlayerID;
    }


    /**
     * Gets the eventID value for this UseServiceReq.
     * 
     * @return eventID
     */
    public java.lang.String getEventID() {
        return eventID;
    }


    /**
     * Sets the eventID value for this UseServiceReq.
     * 
     * @param eventID
     */
    public void setEventID(java.lang.String eventID) {
        this.eventID = eventID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UseServiceReq)) return false;
        UseServiceReq other = (UseServiceReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.productID==null && other.getProductID()==null) || 
             (this.productID!=null &&
              this.productID.equals(other.getProductID()))) &&
            this.hasFeatureStr == other.getHasFeatureStr() &&
            ((this.featureStr==null && other.getFeatureStr()==null) || 
             (this.featureStr!=null &&
              this.featureStr.equals(other.getFeatureStr()))) &&
            ((this.srcDeviceID==null && other.getSrcDeviceID()==null) || 
             (this.srcDeviceID!=null &&
              this.srcDeviceID.equals(other.getSrcDeviceID()))) &&
            this.srcDeviceType == other.getSrcDeviceType() &&
            ((this.streamingNo==null && other.getStreamingNo()==null) || 
             (this.streamingNo!=null &&
              this.streamingNo.equals(other.getStreamingNo()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID()))) &&
            this.userIDType == other.getUserIDType() &&
            ((this.chanelPlayerID==null && other.getChanelPlayerID()==null) || 
             (this.chanelPlayerID!=null &&
              this.chanelPlayerID.equals(other.getChanelPlayerID()))) &&
            ((this.eventID==null && other.getEventID()==null) || 
             (this.eventID!=null &&
              this.eventID.equals(other.getEventID())));
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
        if (getProductID() != null) {
            _hashCode += getProductID().hashCode();
        }
        _hashCode += getHasFeatureStr();
        if (getFeatureStr() != null) {
            _hashCode += getFeatureStr().hashCode();
        }
        if (getSrcDeviceID() != null) {
            _hashCode += getSrcDeviceID().hashCode();
        }
        _hashCode += getSrcDeviceType();
        if (getStreamingNo() != null) {
            _hashCode += getStreamingNo().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        _hashCode += getUserIDType();
        if (getChanelPlayerID() != null) {
            _hashCode += getChanelPlayerID().hashCode();
        }
        if (getEventID() != null) {
            _hashCode += getEventID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UseServiceReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "UseServiceReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "productID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasFeatureStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "hasFeatureStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("featureStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "featureStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("srcDeviceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "srcDeviceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("srcDeviceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "srcDeviceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("streamingNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "streamingNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "userID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userIDType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "userIDType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chanelPlayerID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "chanelPlayerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "eventID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
