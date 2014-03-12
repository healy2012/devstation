/**
 * Group.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class Group  implements java.io.Serializable {
    private java.lang.String group_id;

    private java.lang.String group_name;

    private java.lang.String group_type;

    private java.lang.String level;

    private java.lang.String parent_group_id;

    public Group() {
    }

    public Group(
           java.lang.String group_id,
           java.lang.String group_name,
           java.lang.String group_type,
           java.lang.String level,
           java.lang.String parent_group_id) {
           this.group_id = group_id;
           this.group_name = group_name;
           this.group_type = group_type;
           this.level = level;
           this.parent_group_id = parent_group_id;
    }


    /**
     * Gets the group_id value for this Group.
     * 
     * @return group_id
     */
    public java.lang.String getGroup_id() {
        return group_id;
    }


    /**
     * Sets the group_id value for this Group.
     * 
     * @param group_id
     */
    public void setGroup_id(java.lang.String group_id) {
        this.group_id = group_id;
    }


    /**
     * Gets the group_name value for this Group.
     * 
     * @return group_name
     */
    public java.lang.String getGroup_name() {
        return group_name;
    }


    /**
     * Sets the group_name value for this Group.
     * 
     * @param group_name
     */
    public void setGroup_name(java.lang.String group_name) {
        this.group_name = group_name;
    }


    /**
     * Gets the group_type value for this Group.
     * 
     * @return group_type
     */
    public java.lang.String getGroup_type() {
        return group_type;
    }


    /**
     * Sets the group_type value for this Group.
     * 
     * @param group_type
     */
    public void setGroup_type(java.lang.String group_type) {
        this.group_type = group_type;
    }


    /**
     * Gets the level value for this Group.
     * 
     * @return level
     */
    public java.lang.String getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Group.
     * 
     * @param level
     */
    public void setLevel(java.lang.String level) {
        this.level = level;
    }


    /**
     * Gets the parent_group_id value for this Group.
     * 
     * @return parent_group_id
     */
    public java.lang.String getParent_group_id() {
        return parent_group_id;
    }


    /**
     * Sets the parent_group_id value for this Group.
     * 
     * @param parent_group_id
     */
    public void setParent_group_id(java.lang.String parent_group_id) {
        this.parent_group_id = parent_group_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Group)) return false;
        Group other = (Group) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.group_id==null && other.getGroup_id()==null) || 
             (this.group_id!=null &&
              this.group_id.equals(other.getGroup_id()))) &&
            ((this.group_name==null && other.getGroup_name()==null) || 
             (this.group_name!=null &&
              this.group_name.equals(other.getGroup_name()))) &&
            ((this.group_type==null && other.getGroup_type()==null) || 
             (this.group_type!=null &&
              this.group_type.equals(other.getGroup_type()))) &&
            ((this.level==null && other.getLevel()==null) || 
             (this.level!=null &&
              this.level.equals(other.getLevel()))) &&
            ((this.parent_group_id==null && other.getParent_group_id()==null) || 
             (this.parent_group_id!=null &&
              this.parent_group_id.equals(other.getParent_group_id())));
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
        if (getGroup_id() != null) {
            _hashCode += getGroup_id().hashCode();
        }
        if (getGroup_name() != null) {
            _hashCode += getGroup_name().hashCode();
        }
        if (getGroup_type() != null) {
            _hashCode += getGroup_type().hashCode();
        }
        if (getLevel() != null) {
            _hashCode += getLevel().hashCode();
        }
        if (getParent_group_id() != null) {
            _hashCode += getParent_group_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Group.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Group"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "group_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "group_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "group_type"));
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
        elemField.setFieldName("parent_group_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "parent_group_id"));
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
