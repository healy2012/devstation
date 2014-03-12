/**
 * Resource.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class Resource  implements java.io.Serializable {
    private java.lang.String level;

    private java.lang.String parent_id;

    private java.lang.String res_auth_string;

    private java.lang.String res_id;

    private java.lang.String res_name;

    public Resource() {
    }

    public Resource(
           java.lang.String level,
           java.lang.String parent_id,
           java.lang.String res_auth_string,
           java.lang.String res_id,
           java.lang.String res_name) {
           this.level = level;
           this.parent_id = parent_id;
           this.res_auth_string = res_auth_string;
           this.res_id = res_id;
           this.res_name = res_name;
    }


    /**
     * Gets the level value for this Resource.
     * 
     * @return level
     */
    public java.lang.String getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Resource.
     * 
     * @param level
     */
    public void setLevel(java.lang.String level) {
        this.level = level;
    }


    /**
     * Gets the parent_id value for this Resource.
     * 
     * @return parent_id
     */
    public java.lang.String getParent_id() {
        return parent_id;
    }


    /**
     * Sets the parent_id value for this Resource.
     * 
     * @param parent_id
     */
    public void setParent_id(java.lang.String parent_id) {
        this.parent_id = parent_id;
    }


    /**
     * Gets the res_auth_string value for this Resource.
     * 
     * @return res_auth_string
     */
    public java.lang.String getRes_auth_string() {
        return res_auth_string;
    }


    /**
     * Sets the res_auth_string value for this Resource.
     * 
     * @param res_auth_string
     */
    public void setRes_auth_string(java.lang.String res_auth_string) {
        this.res_auth_string = res_auth_string;
    }


    /**
     * Gets the res_id value for this Resource.
     * 
     * @return res_id
     */
    public java.lang.String getRes_id() {
        return res_id;
    }


    /**
     * Sets the res_id value for this Resource.
     * 
     * @param res_id
     */
    public void setRes_id(java.lang.String res_id) {
        this.res_id = res_id;
    }


    /**
     * Gets the res_name value for this Resource.
     * 
     * @return res_name
     */
    public java.lang.String getRes_name() {
        return res_name;
    }


    /**
     * Sets the res_name value for this Resource.
     * 
     * @param res_name
     */
    public void setRes_name(java.lang.String res_name) {
        this.res_name = res_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Resource)) return false;
        Resource other = (Resource) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.level==null && other.getLevel()==null) || 
             (this.level!=null &&
              this.level.equals(other.getLevel()))) &&
            ((this.parent_id==null && other.getParent_id()==null) || 
             (this.parent_id!=null &&
              this.parent_id.equals(other.getParent_id()))) &&
            ((this.res_auth_string==null && other.getRes_auth_string()==null) || 
             (this.res_auth_string!=null &&
              this.res_auth_string.equals(other.getRes_auth_string()))) &&
            ((this.res_id==null && other.getRes_id()==null) || 
             (this.res_id!=null &&
              this.res_id.equals(other.getRes_id()))) &&
            ((this.res_name==null && other.getRes_name()==null) || 
             (this.res_name!=null &&
              this.res_name.equals(other.getRes_name())));
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
        if (getLevel() != null) {
            _hashCode += getLevel().hashCode();
        }
        if (getParent_id() != null) {
            _hashCode += getParent_id().hashCode();
        }
        if (getRes_auth_string() != null) {
            _hashCode += getRes_auth_string().hashCode();
        }
        if (getRes_id() != null) {
            _hashCode += getRes_id().hashCode();
        }
        if (getRes_name() != null) {
            _hashCode += getRes_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Resource.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Resource"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("level");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "level"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "parent_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("res_auth_string");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "res_auth_string"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("res_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "res_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("res_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "res_name"));
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
