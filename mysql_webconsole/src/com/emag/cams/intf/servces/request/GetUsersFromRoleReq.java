/**
 * GetUsersFromRoleReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.request;

public class GetUsersFromRoleReq  implements java.io.Serializable {
    private java.lang.String role_flag;

    private java.lang.String system_id;

    public GetUsersFromRoleReq() {
    }

    public GetUsersFromRoleReq(
           java.lang.String role_flag,
           java.lang.String system_id) {
           this.role_flag = role_flag;
           this.system_id = system_id;
    }


    /**
     * Gets the role_flag value for this GetUsersFromRoleReq.
     * 
     * @return role_flag
     */
    public java.lang.String getRole_flag() {
        return role_flag;
    }


    /**
     * Sets the role_flag value for this GetUsersFromRoleReq.
     * 
     * @param role_flag
     */
    public void setRole_flag(java.lang.String role_flag) {
        this.role_flag = role_flag;
    }


    /**
     * Gets the system_id value for this GetUsersFromRoleReq.
     * 
     * @return system_id
     */
    public java.lang.String getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this GetUsersFromRoleReq.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.String system_id) {
        this.system_id = system_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUsersFromRoleReq)) return false;
        GetUsersFromRoleReq other = (GetUsersFromRoleReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.role_flag==null && other.getRole_flag()==null) || 
             (this.role_flag!=null &&
              this.role_flag.equals(other.getRole_flag()))) &&
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
        if (getRole_flag() != null) {
            _hashCode += getRole_flag().hashCode();
        }
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUsersFromRoleReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUsersFromRoleReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_flag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "role_flag"));
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
