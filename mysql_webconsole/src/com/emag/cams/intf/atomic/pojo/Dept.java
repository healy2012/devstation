/**
 * Dept.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class Dept  implements java.io.Serializable {
    private java.lang.String dept_id;

    private java.lang.String dept_name;

    private java.lang.String level;

    private java.lang.String parent_id;

    private java.lang.String region_id;

    public Dept() {
    }

    public Dept(
           java.lang.String dept_id,
           java.lang.String dept_name,
           java.lang.String level,
           java.lang.String parent_id,
           java.lang.String region_id) {
           this.dept_id = dept_id;
           this.dept_name = dept_name;
           this.level = level;
           this.parent_id = parent_id;
           this.region_id = region_id;
    }


    /**
     * Gets the dept_id value for this Dept.
     * 
     * @return dept_id
     */
    public java.lang.String getDept_id() {
        return dept_id;
    }


    /**
     * Sets the dept_id value for this Dept.
     * 
     * @param dept_id
     */
    public void setDept_id(java.lang.String dept_id) {
        this.dept_id = dept_id;
    }


    /**
     * Gets the dept_name value for this Dept.
     * 
     * @return dept_name
     */
    public java.lang.String getDept_name() {
        return dept_name;
    }


    /**
     * Sets the dept_name value for this Dept.
     * 
     * @param dept_name
     */
    public void setDept_name(java.lang.String dept_name) {
        this.dept_name = dept_name;
    }


    /**
     * Gets the level value for this Dept.
     * 
     * @return level
     */
    public java.lang.String getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Dept.
     * 
     * @param level
     */
    public void setLevel(java.lang.String level) {
        this.level = level;
    }


    /**
     * Gets the parent_id value for this Dept.
     * 
     * @return parent_id
     */
    public java.lang.String getParent_id() {
        return parent_id;
    }


    /**
     * Sets the parent_id value for this Dept.
     * 
     * @param parent_id
     */
    public void setParent_id(java.lang.String parent_id) {
        this.parent_id = parent_id;
    }


    /**
     * Gets the region_id value for this Dept.
     * 
     * @return region_id
     */
    public java.lang.String getRegion_id() {
        return region_id;
    }


    /**
     * Sets the region_id value for this Dept.
     * 
     * @param region_id
     */
    public void setRegion_id(java.lang.String region_id) {
        this.region_id = region_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Dept)) return false;
        Dept other = (Dept) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dept_id==null && other.getDept_id()==null) || 
             (this.dept_id!=null &&
              this.dept_id.equals(other.getDept_id()))) &&
            ((this.dept_name==null && other.getDept_name()==null) || 
             (this.dept_name!=null &&
              this.dept_name.equals(other.getDept_name()))) &&
            ((this.level==null && other.getLevel()==null) || 
             (this.level!=null &&
              this.level.equals(other.getLevel()))) &&
            ((this.parent_id==null && other.getParent_id()==null) || 
             (this.parent_id!=null &&
              this.parent_id.equals(other.getParent_id()))) &&
            ((this.region_id==null && other.getRegion_id()==null) || 
             (this.region_id!=null &&
              this.region_id.equals(other.getRegion_id())));
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
        if (getDept_id() != null) {
            _hashCode += getDept_id().hashCode();
        }
        if (getDept_name() != null) {
            _hashCode += getDept_name().hashCode();
        }
        if (getLevel() != null) {
            _hashCode += getLevel().hashCode();
        }
        if (getParent_id() != null) {
            _hashCode += getParent_id().hashCode();
        }
        if (getRegion_id() != null) {
            _hashCode += getRegion_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Dept.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Dept"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dept_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "dept_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dept_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "dept_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
