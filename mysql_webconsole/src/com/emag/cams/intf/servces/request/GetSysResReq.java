/**
 * GetSysResReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.request;

public class GetSysResReq  implements java.io.Serializable {
    private java.lang.String res_auth_string;

    private java.lang.String system_id;

    public GetSysResReq() {
    }

    public GetSysResReq(
           java.lang.String res_auth_string,
           java.lang.String system_id) {
           this.res_auth_string = res_auth_string;
           this.system_id = system_id;
    }


    /**
     * Gets the res_auth_string value for this GetSysResReq.
     * 
     * @return res_auth_string
     */
    public java.lang.String getRes_auth_string() {
        return res_auth_string;
    }


    /**
     * Sets the res_auth_string value for this GetSysResReq.
     * 
     * @param res_auth_string
     */
    public void setRes_auth_string(java.lang.String res_auth_string) {
        this.res_auth_string = res_auth_string;
    }


    /**
     * Gets the system_id value for this GetSysResReq.
     * 
     * @return system_id
     */
    public java.lang.String getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this GetSysResReq.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.String system_id) {
        this.system_id = system_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSysResReq)) return false;
        GetSysResReq other = (GetSysResReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.res_auth_string==null && other.getRes_auth_string()==null) || 
             (this.res_auth_string!=null &&
              this.res_auth_string.equals(other.getRes_auth_string()))) &&
            ((this.system_id==null && other.getSystem_id()==null) || 
             (this.system_id!=null &&
              this.system_id.equals(other.getSystem_id())));
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
        if (getRes_auth_string() != null) {
            _hashCode += getRes_auth_string().hashCode();
        }
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSysResReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysResReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("res_auth_string");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "res_auth_string"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("system_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "system_id"));
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
