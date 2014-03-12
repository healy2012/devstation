/**
 * Region.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class Region  implements java.io.Serializable {
    private java.lang.String level;

    private java.lang.String parent_id;

    private java.lang.String region_id;

    private java.lang.String region_name;

    public Region() {
    }

    public Region(
           java.lang.String level,
           java.lang.String parent_id,
           java.lang.String region_id,
           java.lang.String region_name) {
           this.level = level;
           this.parent_id = parent_id;
           this.region_id = region_id;
           this.region_name = region_name;
    }


    /**
     * Gets the level value for this Region.
     * 
     * @return level
     */
    public java.lang.String getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Region.
     * 
     * @param level
     */
    public void setLevel(java.lang.String level) {
        this.level = level;
    }


    /**
     * Gets the parent_id value for this Region.
     * 
     * @return parent_id
     */
    public java.lang.String getParent_id() {
        return parent_id;
    }


    /**
     * Sets the parent_id value for this Region.
     * 
     * @param parent_id
     */
    public void setParent_id(java.lang.String parent_id) {
        this.parent_id = parent_id;
    }


    /**
     * Gets the region_id value for this Region.
     * 
     * @return region_id
     */
    public java.lang.String getRegion_id() {
        return region_id;
    }


    /**
     * Sets the region_id value for this Region.
     * 
     * @param region_id
     */
    public void setRegion_id(java.lang.String region_id) {
        this.region_id = region_id;
    }


    /**
     * Gets the region_name value for this Region.
     * 
     * @return region_name
     */
    public java.lang.String getRegion_name() {
        return region_name;
    }


    /**
     * Sets the region_name value for this Region.
     * 
     * @param region_name
     */
    public void setRegion_name(java.lang.String region_name) {
        this.region_name = region_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Region)) return false;
        Region other = (Region) obj;
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
            ((this.region_id==null && other.getRegion_id()==null) || 
             (this.region_id!=null &&
              this.region_id.equals(other.getRegion_id()))) &&
            ((this.region_name==null && other.getRegion_name()==null) || 
             (this.region_name!=null &&
              this.region_name.equals(other.getRegion_name())));
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
        if (getRegion_id() != null) {
            _hashCode += getRegion_id().hashCode();
        }
        if (getRegion_name() != null) {
            _hashCode += getRegion_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Region.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Region"));
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
        elemField.setFieldName("region_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "region_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("region_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "region_name"));
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
