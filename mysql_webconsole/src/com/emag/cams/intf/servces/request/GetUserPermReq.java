/**
 * GetUserPermReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.request;

public class GetUserPermReq  implements java.io.Serializable {
    private java.lang.String perm_type;

    private java.lang.String system_id;

    private java.lang.String user_account;

    public GetUserPermReq() {
    }

    public GetUserPermReq(
           java.lang.String perm_type,
           java.lang.String system_id,
           java.lang.String user_account) {
           this.perm_type = perm_type;
           this.system_id = system_id;
           this.user_account = user_account;
    }


    /**
     * Gets the perm_type value for this GetUserPermReq.
     * 
     * @return perm_type
     */
    public java.lang.String getPerm_type() {
        return perm_type;
    }


    /**
     * Sets the perm_type value for this GetUserPermReq.
     * 
     * @param perm_type
     */
    public void setPerm_type(java.lang.String perm_type) {
        this.perm_type = perm_type;
    }


    /**
     * Gets the system_id value for this GetUserPermReq.
     * 
     * @return system_id
     */
    public java.lang.String getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this GetUserPermReq.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.String system_id) {
        this.system_id = system_id;
    }


    /**
     * Gets the user_account value for this GetUserPermReq.
     * 
     * @return user_account
     */
    public java.lang.String getUser_account() {
        return user_account;
    }


    /**
     * Sets the user_account value for this GetUserPermReq.
     * 
     * @param user_account
     */
    public void setUser_account(java.lang.String user_account) {
        this.user_account = user_account;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUserPermReq)) return false;
        GetUserPermReq other = (GetUserPermReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.perm_type==null && other.getPerm_type()==null) || 
             (this.perm_type!=null &&
              this.perm_type.equals(other.getPerm_type()))) &&
            ((this.system_id==null && other.getSystem_id()==null) || 
             (this.system_id!=null &&
              this.system_id.equals(other.getSystem_id()))) &&
            ((this.user_account==null && other.getUser_account()==null) || 
             (this.user_account!=null &&
              this.user_account.equals(other.getUser_account())));
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
        if (getPerm_type() != null) {
            _hashCode += getPerm_type().hashCode();
        }
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        if (getUser_account() != null) {
            _hashCode += getUser_account().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUserPermReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserPermReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perm_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "perm_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("system_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "system_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_account");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "user_account"));
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
