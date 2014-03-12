/**
 * GetSysGroupReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.request;

public class GetSysGroupReq  implements java.io.Serializable {
    private java.lang.String group_type;

    private java.lang.String system_id;

    public GetSysGroupReq() {
    }

    public GetSysGroupReq(
           java.lang.String group_type,
           java.lang.String system_id) {
           this.group_type = group_type;
           this.system_id = system_id;
    }


    /**
     * Gets the group_type value for this GetSysGroupReq.
     * 
     * @return group_type
     */
    public java.lang.String getGroup_type() {
        return group_type;
    }


    /**
     * Sets the group_type value for this GetSysGroupReq.
     * 
     * @param group_type
     */
    public void setGroup_type(java.lang.String group_type) {
        this.group_type = group_type;
    }


    /**
     * Gets the system_id value for this GetSysGroupReq.
     * 
     * @return system_id
     */
    public java.lang.String getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this GetSysGroupReq.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.String system_id) {
        this.system_id = system_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSysGroupReq)) return false;
        GetSysGroupReq other = (GetSysGroupReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.group_type==null && other.getGroup_type()==null) || 
             (this.group_type!=null &&
              this.group_type.equals(other.getGroup_type()))) &&
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
        if (getGroup_type() != null) {
            _hashCode += getGroup_type().hashCode();
        }
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSysGroupReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysGroupReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "group_type"));
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
