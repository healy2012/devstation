/**
 * Role.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class Role  implements java.io.Serializable {
    private java.lang.String role_desc;

    private java.lang.String role_flag;

    private java.lang.String role_id;

    private java.lang.String role_name;

    public Role() {
    }

    public Role(
           java.lang.String role_desc,
           java.lang.String role_flag,
           java.lang.String role_id,
           java.lang.String role_name) {
           this.role_desc = role_desc;
           this.role_flag = role_flag;
           this.role_id = role_id;
           this.role_name = role_name;
    }


    /**
     * Gets the role_desc value for this Role.
     * 
     * @return role_desc
     */
    public java.lang.String getRole_desc() {
        return role_desc;
    }


    /**
     * Sets the role_desc value for this Role.
     * 
     * @param role_desc
     */
    public void setRole_desc(java.lang.String role_desc) {
        this.role_desc = role_desc;
    }


    /**
     * Gets the role_flag value for this Role.
     * 
     * @return role_flag
     */
    public java.lang.String getRole_flag() {
        return role_flag;
    }


    /**
     * Sets the role_flag value for this Role.
     * 
     * @param role_flag
     */
    public void setRole_flag(java.lang.String role_flag) {
        this.role_flag = role_flag;
    }


    /**
     * Gets the role_id value for this Role.
     * 
     * @return role_id
     */
    public java.lang.String getRole_id() {
        return role_id;
    }


    /**
     * Sets the role_id value for this Role.
     * 
     * @param role_id
     */
    public void setRole_id(java.lang.String role_id) {
        this.role_id = role_id;
    }


    /**
     * Gets the role_name value for this Role.
     * 
     * @return role_name
     */
    public java.lang.String getRole_name() {
        return role_name;
    }


    /**
     * Sets the role_name value for this Role.
     * 
     * @param role_name
     */
    public void setRole_name(java.lang.String role_name) {
        this.role_name = role_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Role)) return false;
        Role other = (Role) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.role_desc==null && other.getRole_desc()==null) || 
             (this.role_desc!=null &&
              this.role_desc.equals(other.getRole_desc()))) &&
            ((this.role_flag==null && other.getRole_flag()==null) || 
             (this.role_flag!=null &&
              this.role_flag.equals(other.getRole_flag()))) &&
            ((this.role_id==null && other.getRole_id()==null) || 
             (this.role_id!=null &&
              this.role_id.equals(other.getRole_id()))) &&
            ((this.role_name==null && other.getRole_name()==null) || 
             (this.role_name!=null &&
              this.role_name.equals(other.getRole_name())));
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
        if (getRole_desc() != null) {
            _hashCode += getRole_desc().hashCode();
        }
        if (getRole_flag() != null) {
            _hashCode += getRole_flag().hashCode();
        }
        if (getRole_id() != null) {
            _hashCode += getRole_id().hashCode();
        }
        if (getRole_name() != null) {
            _hashCode += getRole_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Role.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Role"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_desc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "role_desc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_flag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "role_flag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "role_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "role_name"));
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
