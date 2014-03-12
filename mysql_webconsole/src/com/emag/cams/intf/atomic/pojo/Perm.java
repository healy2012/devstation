/**
 * Perm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class Perm  implements java.io.Serializable {
    private java.lang.String auth_url;

    private java.lang.String obj_id;

    private java.lang.String operation_id;

    private java.lang.String perm_desc;

    private java.lang.String perm_id;

    private java.lang.String perm_type;

    public Perm() {
    }

    public Perm(
           java.lang.String auth_url,
           java.lang.String obj_id,
           java.lang.String operation_id,
           java.lang.String perm_desc,
           java.lang.String perm_id,
           java.lang.String perm_type) {
           this.auth_url = auth_url;
           this.obj_id = obj_id;
           this.operation_id = operation_id;
           this.perm_desc = perm_desc;
           this.perm_id = perm_id;
           this.perm_type = perm_type;
    }


    /**
     * Gets the auth_url value for this Perm.
     * 
     * @return auth_url
     */
    public java.lang.String getAuth_url() {
        return auth_url;
    }


    /**
     * Sets the auth_url value for this Perm.
     * 
     * @param auth_url
     */
    public void setAuth_url(java.lang.String auth_url) {
        this.auth_url = auth_url;
    }


    /**
     * Gets the obj_id value for this Perm.
     * 
     * @return obj_id
     */
    public java.lang.String getObj_id() {
        return obj_id;
    }


    /**
     * Sets the obj_id value for this Perm.
     * 
     * @param obj_id
     */
    public void setObj_id(java.lang.String obj_id) {
        this.obj_id = obj_id;
    }


    /**
     * Gets the operation_id value for this Perm.
     * 
     * @return operation_id
     */
    public java.lang.String getOperation_id() {
        return operation_id;
    }


    /**
     * Sets the operation_id value for this Perm.
     * 
     * @param operation_id
     */
    public void setOperation_id(java.lang.String operation_id) {
        this.operation_id = operation_id;
    }


    /**
     * Gets the perm_desc value for this Perm.
     * 
     * @return perm_desc
     */
    public java.lang.String getPerm_desc() {
        return perm_desc;
    }


    /**
     * Sets the perm_desc value for this Perm.
     * 
     * @param perm_desc
     */
    public void setPerm_desc(java.lang.String perm_desc) {
        this.perm_desc = perm_desc;
    }


    /**
     * Gets the perm_id value for this Perm.
     * 
     * @return perm_id
     */
    public java.lang.String getPerm_id() {
        return perm_id;
    }


    /**
     * Sets the perm_id value for this Perm.
     * 
     * @param perm_id
     */
    public void setPerm_id(java.lang.String perm_id) {
        this.perm_id = perm_id;
    }


    /**
     * Gets the perm_type value for this Perm.
     * 
     * @return perm_type
     */
    public java.lang.String getPerm_type() {
        return perm_type;
    }


    /**
     * Sets the perm_type value for this Perm.
     * 
     * @param perm_type
     */
    public void setPerm_type(java.lang.String perm_type) {
        this.perm_type = perm_type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Perm)) return false;
        Perm other = (Perm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.auth_url==null && other.getAuth_url()==null) || 
             (this.auth_url!=null &&
              this.auth_url.equals(other.getAuth_url()))) &&
            ((this.obj_id==null && other.getObj_id()==null) || 
             (this.obj_id!=null &&
              this.obj_id.equals(other.getObj_id()))) &&
            ((this.operation_id==null && other.getOperation_id()==null) || 
             (this.operation_id!=null &&
              this.operation_id.equals(other.getOperation_id()))) &&
            ((this.perm_desc==null && other.getPerm_desc()==null) || 
             (this.perm_desc!=null &&
              this.perm_desc.equals(other.getPerm_desc()))) &&
            ((this.perm_id==null && other.getPerm_id()==null) || 
             (this.perm_id!=null &&
              this.perm_id.equals(other.getPerm_id()))) &&
            ((this.perm_type==null && other.getPerm_type()==null) || 
             (this.perm_type!=null &&
              this.perm_type.equals(other.getPerm_type())));
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
        if (getAuth_url() != null) {
            _hashCode += getAuth_url().hashCode();
        }
        if (getObj_id() != null) {
            _hashCode += getObj_id().hashCode();
        }
        if (getOperation_id() != null) {
            _hashCode += getOperation_id().hashCode();
        }
        if (getPerm_desc() != null) {
            _hashCode += getPerm_desc().hashCode();
        }
        if (getPerm_id() != null) {
            _hashCode += getPerm_id().hashCode();
        }
        if (getPerm_type() != null) {
            _hashCode += getPerm_type().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Perm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Perm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "auth_url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obj_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "obj_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "operation_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perm_desc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "perm_desc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perm_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "perm_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perm_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "perm_type"));
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
