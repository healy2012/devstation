/**
 * GroupUser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.atomic.pojo;

public class GroupUser  implements java.io.Serializable {
    private java.lang.String email;

    private java.lang.String group_ids;

    private java.lang.String mobile;

    private java.lang.String state;

    private java.lang.String user_account;

    private java.lang.String user_id;

    private java.lang.String user_name;

    public GroupUser() {
    }

    public GroupUser(
           java.lang.String email,
           java.lang.String group_ids,
           java.lang.String mobile,
           java.lang.String state,
           java.lang.String user_account,
           java.lang.String user_id,
           java.lang.String user_name) {
           this.email = email;
           this.group_ids = group_ids;
           this.mobile = mobile;
           this.state = state;
           this.user_account = user_account;
           this.user_id = user_id;
           this.user_name = user_name;
    }


    /**
     * Gets the email value for this GroupUser.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this GroupUser.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the group_ids value for this GroupUser.
     * 
     * @return group_ids
     */
    public java.lang.String getGroup_ids() {
        return group_ids;
    }


    /**
     * Sets the group_ids value for this GroupUser.
     * 
     * @param group_ids
     */
    public void setGroup_ids(java.lang.String group_ids) {
        this.group_ids = group_ids;
    }


    /**
     * Gets the mobile value for this GroupUser.
     * 
     * @return mobile
     */
    public java.lang.String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this GroupUser.
     * 
     * @param mobile
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the state value for this GroupUser.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this GroupUser.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the user_account value for this GroupUser.
     * 
     * @return user_account
     */
    public java.lang.String getUser_account() {
        return user_account;
    }


    /**
     * Sets the user_account value for this GroupUser.
     * 
     * @param user_account
     */
    public void setUser_account(java.lang.String user_account) {
        this.user_account = user_account;
    }


    /**
     * Gets the user_id value for this GroupUser.
     * 
     * @return user_id
     */
    public java.lang.String getUser_id() {
        return user_id;
    }


    /**
     * Sets the user_id value for this GroupUser.
     * 
     * @param user_id
     */
    public void setUser_id(java.lang.String user_id) {
        this.user_id = user_id;
    }


    /**
     * Gets the user_name value for this GroupUser.
     * 
     * @return user_name
     */
    public java.lang.String getUser_name() {
        return user_name;
    }


    /**
     * Sets the user_name value for this GroupUser.
     * 
     * @param user_name
     */
    public void setUser_name(java.lang.String user_name) {
        this.user_name = user_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GroupUser)) return false;
        GroupUser other = (GroupUser) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.group_ids==null && other.getGroup_ids()==null) || 
             (this.group_ids!=null &&
              this.group_ids.equals(other.getGroup_ids()))) &&
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.user_account==null && other.getUser_account()==null) || 
             (this.user_account!=null &&
              this.user_account.equals(other.getUser_account()))) &&
            ((this.user_id==null && other.getUser_id()==null) || 
             (this.user_id!=null &&
              this.user_id.equals(other.getUser_id()))) &&
            ((this.user_name==null && other.getUser_name()==null) || 
             (this.user_name!=null &&
              this.user_name.equals(other.getUser_name())));
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getGroup_ids() != null) {
            _hashCode += getGroup_ids().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getUser_account() != null) {
            _hashCode += getUser_account().hashCode();
        }
        if (getUser_id() != null) {
            _hashCode += getUser_id().hashCode();
        }
        if (getUser_name() != null) {
            _hashCode += getUser_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GroupUser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "GroupUser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_ids");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "group_ids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_account");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "user_account"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "user_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "user_name"));
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
