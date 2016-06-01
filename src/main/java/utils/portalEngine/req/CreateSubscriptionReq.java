/**
 * CreateSubscriptionReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package utils.portalEngine.req;

public class CreateSubscriptionReq  implements java.io.Serializable {
    private java.lang.String DA;

    private int DAType;

    private java.lang.String FA;

    private int FAType;

    private java.lang.String ID;

    private int IDType;

    private java.lang.String OA;

    private int OAType;

    private java.lang.String chanelPlayerID;

    private java.lang.String eventID;

    private java.lang.String srcDeviceID;

    private int srcDeviceType;

    private java.lang.String streamingNo;

    public CreateSubscriptionReq() {
    }

    public CreateSubscriptionReq(
           java.lang.String DA,
           int DAType,
           java.lang.String FA,
           int FAType,
           java.lang.String ID,
           int IDType,
           java.lang.String OA,
           int OAType,
           java.lang.String chanelPlayerID,
           java.lang.String eventID,
           java.lang.String srcDeviceID,
           int srcDeviceType,
           java.lang.String streamingNo) {
           this.DA = DA;
           this.DAType = DAType;
           this.FA = FA;
           this.FAType = FAType;
           this.ID = ID;
           this.IDType = IDType;
           this.OA = OA;
           this.OAType = OAType;
           this.chanelPlayerID = chanelPlayerID;
           this.eventID = eventID;
           this.srcDeviceID = srcDeviceID;
           this.srcDeviceType = srcDeviceType;
           this.streamingNo = streamingNo;
    }


    /**
     * Gets the DA value for this CreateSubscriptionReq.
     * 
     * @return DA
     */
    public java.lang.String getDA() {
        return DA;
    }


    /**
     * Sets the DA value for this CreateSubscriptionReq.
     * 
     * @param DA
     */
    public void setDA(java.lang.String DA) {
        this.DA = DA;
    }


    /**
     * Gets the DAType value for this CreateSubscriptionReq.
     * 
     * @return DAType
     */
    public int getDAType() {
        return DAType;
    }


    /**
     * Sets the DAType value for this CreateSubscriptionReq.
     * 
     * @param DAType
     */
    public void setDAType(int DAType) {
        this.DAType = DAType;
    }


    /**
     * Gets the FA value for this CreateSubscriptionReq.
     * 
     * @return FA
     */
    public java.lang.String getFA() {
        return FA;
    }


    /**
     * Sets the FA value for this CreateSubscriptionReq.
     * 
     * @param FA
     */
    public void setFA(java.lang.String FA) {
        this.FA = FA;
    }


    /**
     * Gets the FAType value for this CreateSubscriptionReq.
     * 
     * @return FAType
     */
    public int getFAType() {
        return FAType;
    }


    /**
     * Sets the FAType value for this CreateSubscriptionReq.
     * 
     * @param FAType
     */
    public void setFAType(int FAType) {
        this.FAType = FAType;
    }


    /**
     * Gets the ID value for this CreateSubscriptionReq.
     * 
     * @return ID
     */
    public java.lang.String getID() {
        return ID;
    }


    /**
     * Sets the ID value for this CreateSubscriptionReq.
     * 
     * @param ID
     */
    public void setID(java.lang.String ID) {
        this.ID = ID;
    }


    /**
     * Gets the IDType value for this CreateSubscriptionReq.
     * 
     * @return IDType
     */
    public int getIDType() {
        return IDType;
    }


    /**
     * Sets the IDType value for this CreateSubscriptionReq.
     * 
     * @param IDType
     */
    public void setIDType(int IDType) {
        this.IDType = IDType;
    }


    /**
     * Gets the OA value for this CreateSubscriptionReq.
     * 
     * @return OA
     */
    public java.lang.String getOA() {
        return OA;
    }


    /**
     * Sets the OA value for this CreateSubscriptionReq.
     * 
     * @param OA
     */
    public void setOA(java.lang.String OA) {
        this.OA = OA;
    }


    /**
     * Gets the OAType value for this CreateSubscriptionReq.
     * 
     * @return OAType
     */
    public int getOAType() {
        return OAType;
    }


    /**
     * Sets the OAType value for this CreateSubscriptionReq.
     * 
     * @param OAType
     */
    public void setOAType(int OAType) {
        this.OAType = OAType;
    }


    /**
     * Gets the chanelPlayerID value for this CreateSubscriptionReq.
     * 
     * @return chanelPlayerID
     */
    public java.lang.String getChanelPlayerID() {
        return chanelPlayerID;
    }


    /**
     * Sets the chanelPlayerID value for this CreateSubscriptionReq.
     * 
     * @param chanelPlayerID
     */
    public void setChanelPlayerID(java.lang.String chanelPlayerID) {
        this.chanelPlayerID = chanelPlayerID;
    }


    /**
     * Gets the eventID value for this CreateSubscriptionReq.
     * 
     * @return eventID
     */
    public java.lang.String getEventID() {
        return eventID;
    }


    /**
     * Sets the eventID value for this CreateSubscriptionReq.
     * 
     * @param eventID
     */
    public void setEventID(java.lang.String eventID) {
        this.eventID = eventID;
    }


    /**
     * Gets the srcDeviceID value for this CreateSubscriptionReq.
     * 
     * @return srcDeviceID
     */
    public java.lang.String getSrcDeviceID() {
        return srcDeviceID;
    }


    /**
     * Sets the srcDeviceID value for this CreateSubscriptionReq.
     * 
     * @param srcDeviceID
     */
    public void setSrcDeviceID(java.lang.String srcDeviceID) {
        this.srcDeviceID = srcDeviceID;
    }


    /**
     * Gets the srcDeviceType value for this CreateSubscriptionReq.
     * 
     * @return srcDeviceType
     */
    public int getSrcDeviceType() {
        return srcDeviceType;
    }


    /**
     * Sets the srcDeviceType value for this CreateSubscriptionReq.
     * 
     * @param srcDeviceType
     */
    public void setSrcDeviceType(int srcDeviceType) {
        this.srcDeviceType = srcDeviceType;
    }


    /**
     * Gets the streamingNo value for this CreateSubscriptionReq.
     * 
     * @return streamingNo
     */
    public java.lang.String getStreamingNo() {
        return streamingNo;
    }


    /**
     * Sets the streamingNo value for this CreateSubscriptionReq.
     * 
     * @param streamingNo
     */
    public void setStreamingNo(java.lang.String streamingNo) {
        this.streamingNo = streamingNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateSubscriptionReq)) return false;
        CreateSubscriptionReq other = (CreateSubscriptionReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DA==null && other.getDA()==null) || 
             (this.DA!=null &&
              this.DA.equals(other.getDA()))) &&
            this.DAType == other.getDAType() &&
            ((this.FA==null && other.getFA()==null) || 
             (this.FA!=null &&
              this.FA.equals(other.getFA()))) &&
            this.FAType == other.getFAType() &&
            ((this.ID==null && other.getID()==null) || 
             (this.ID!=null &&
              this.ID.equals(other.getID()))) &&
            this.IDType == other.getIDType() &&
            ((this.OA==null && other.getOA()==null) || 
             (this.OA!=null &&
              this.OA.equals(other.getOA()))) &&
            this.OAType == other.getOAType() &&
            ((this.chanelPlayerID==null && other.getChanelPlayerID()==null) || 
             (this.chanelPlayerID!=null &&
              this.chanelPlayerID.equals(other.getChanelPlayerID()))) &&
            ((this.eventID==null && other.getEventID()==null) || 
             (this.eventID!=null &&
              this.eventID.equals(other.getEventID()))) &&
            ((this.srcDeviceID==null && other.getSrcDeviceID()==null) || 
             (this.srcDeviceID!=null &&
              this.srcDeviceID.equals(other.getSrcDeviceID()))) &&
            this.srcDeviceType == other.getSrcDeviceType() &&
            ((this.streamingNo==null && other.getStreamingNo()==null) || 
             (this.streamingNo!=null &&
              this.streamingNo.equals(other.getStreamingNo())));
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
        if (getDA() != null) {
            _hashCode += getDA().hashCode();
        }
        _hashCode += getDAType();
        if (getFA() != null) {
            _hashCode += getFA().hashCode();
        }
        _hashCode += getFAType();
        if (getID() != null) {
            _hashCode += getID().hashCode();
        }
        _hashCode += getIDType();
        if (getOA() != null) {
            _hashCode += getOA().hashCode();
        }
        _hashCode += getOAType();
        if (getChanelPlayerID() != null) {
            _hashCode += getChanelPlayerID().hashCode();
        }
        if (getEventID() != null) {
            _hashCode += getEventID().hashCode();
        }
        if (getSrcDeviceID() != null) {
            _hashCode += getSrcDeviceID().hashCode();
        }
        _hashCode += getSrcDeviceType();
        if (getStreamingNo() != null) {
            _hashCode += getStreamingNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateSubscriptionReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "CreateSubscriptionReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "DA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DAType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "DAType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "FA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FAType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "FAType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "IDType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "OA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OAType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "OAType"));
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
