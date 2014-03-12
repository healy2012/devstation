/**
 * Menu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class Menu  implements java.io.Serializable {
    private java.lang.String level;

    private java.lang.String menu_auth_string;

    private java.lang.String menu_item_id;

    private java.lang.String menu_item_name;

    private java.lang.String menu_type;

    private java.lang.String parent_item_id;

    public Menu() {
    }

    public Menu(
           java.lang.String level,
           java.lang.String menu_auth_string,
           java.lang.String menu_item_id,
           java.lang.String menu_item_name,
           java.lang.String menu_type,
           java.lang.String parent_item_id) {
           this.level = level;
           this.menu_auth_string = menu_auth_string;
           this.menu_item_id = menu_item_id;
           this.menu_item_name = menu_item_name;
           this.menu_type = menu_type;
           this.parent_item_id = parent_item_id;
    }


    /**
     * Gets the level value for this Menu.
     * 
     * @return level
     */
    public java.lang.String getLevel() {
        return level;
    }


    /**
     * Sets the level value for this Menu.
     * 
     * @param level
     */
    public void setLevel(java.lang.String level) {
        this.level = level;
    }


    /**
     * Gets the menu_auth_string value for this Menu.
     * 
     * @return menu_auth_string
     */
    public java.lang.String getMenu_auth_string() {
        return menu_auth_string;
    }


    /**
     * Sets the menu_auth_string value for this Menu.
     * 
     * @param menu_auth_string
     */
    public void setMenu_auth_string(java.lang.String menu_auth_string) {
        this.menu_auth_string = menu_auth_string;
    }


    /**
     * Gets the menu_item_id value for this Menu.
     * 
     * @return menu_item_id
     */
    public java.lang.String getMenu_item_id() {
        return menu_item_id;
    }


    /**
     * Sets the menu_item_id value for this Menu.
     * 
     * @param menu_item_id
     */
    public void setMenu_item_id(java.lang.String menu_item_id) {
        this.menu_item_id = menu_item_id;
    }


    /**
     * Gets the menu_item_name value for this Menu.
     * 
     * @return menu_item_name
     */
    public java.lang.String getMenu_item_name() {
        return menu_item_name;
    }


    /**
     * Sets the menu_item_name value for this Menu.
     * 
     * @param menu_item_name
     */
    public void setMenu_item_name(java.lang.String menu_item_name) {
        this.menu_item_name = menu_item_name;
    }


    /**
     * Gets the menu_type value for this Menu.
     * 
     * @return menu_type
     */
    public java.lang.String getMenu_type() {
        return menu_type;
    }


    /**
     * Sets the menu_type value for this Menu.
     * 
     * @param menu_type
     */
    public void setMenu_type(java.lang.String menu_type) {
        this.menu_type = menu_type;
    }


    /**
     * Gets the parent_item_id value for this Menu.
     * 
     * @return parent_item_id
     */
    public java.lang.String getParent_item_id() {
        return parent_item_id;
    }


    /**
     * Sets the parent_item_id value for this Menu.
     * 
     * @param parent_item_id
     */
    public void setParent_item_id(java.lang.String parent_item_id) {
        this.parent_item_id = parent_item_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Menu)) return false;
        Menu other = (Menu) obj;
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
            ((this.menu_auth_string==null && other.getMenu_auth_string()==null) || 
             (this.menu_auth_string!=null &&
              this.menu_auth_string.equals(other.getMenu_auth_string()))) &&
            ((this.menu_item_id==null && other.getMenu_item_id()==null) || 
             (this.menu_item_id!=null &&
              this.menu_item_id.equals(other.getMenu_item_id()))) &&
            ((this.menu_item_name==null && other.getMenu_item_name()==null) || 
             (this.menu_item_name!=null &&
              this.menu_item_name.equals(other.getMenu_item_name()))) &&
            ((this.menu_type==null && other.getMenu_type()==null) || 
             (this.menu_type!=null &&
              this.menu_type.equals(other.getMenu_type()))) &&
            ((this.parent_item_id==null && other.getParent_item_id()==null) || 
             (this.parent_item_id!=null &&
              this.parent_item_id.equals(other.getParent_item_id())));
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
        if (getMenu_auth_string() != null) {
            _hashCode += getMenu_auth_string().hashCode();
        }
        if (getMenu_item_id() != null) {
            _hashCode += getMenu_item_id().hashCode();
        }
        if (getMenu_item_name() != null) {
            _hashCode += getMenu_item_name().hashCode();
        }
        if (getMenu_type() != null) {
            _hashCode += getMenu_type().hashCode();
        }
        if (getParent_item_id() != null) {
            _hashCode += getParent_item_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Menu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Menu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("level");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "level"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("menu_auth_string");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "menu_auth_string"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("menu_item_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "menu_item_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("menu_item_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "menu_item_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("menu_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "menu_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent_item_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "parent_item_id"));
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
