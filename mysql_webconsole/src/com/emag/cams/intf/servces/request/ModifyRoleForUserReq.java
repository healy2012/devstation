/**
 * ModifyRoleForUserReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.request;

public class ModifyRoleForUserReq  implements java.io.Serializable {
    private java.lang.String opt_flag;

    private java.lang.String role_flag;

    private java.lang.String system_id;

    private java.lang.String user_account;

    public ModifyRoleForUserReq() {
    }

    public ModifyRoleForUserReq(
           java.lang.String opt_flag,
           java.lang.String role_flag,
           java.lang.String system_id,
           java.lang.String user_account) {
           this.opt_flag = opt_flag;
           this.role_flag = role_flag;
           this.system_id = system_id;
           this.user_account = user_account;
    }


    /**
     * Gets the opt_flag value for this ModifyRoleForUserReq.
     * 
     * @return opt_flag
     */
    public java.lang.String getOpt_flag() {
        return opt_flag;
    }


    /**
     * Sets the opt_flag value for this ModifyRoleForUserReq.
     * 
     * @param opt_flag
     */
    public void setOpt_flag(java.lang.String opt_flag) {
        this.opt_flag = opt_flag;
    }


    /**
     * Gets the role_flag value for this ModifyRoleForUserReq.
     * 
     * @return role_flag
     */
    public java.lang.String getRole_flag() {
        return role_flag;
    }


    /**
     * Sets the role_flag value for this ModifyRoleForUserReq.
     * 
     * @param role_flag
     */
    public void setRole_flag(java.lang.String role_flag) {
        this.role_flag = role_flag;
    }


    /**
     * Gets the system_id value for this ModifyRoleForUserReq.
     * 
     * @return system_id
     */
    public java.lang.String getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this ModifyRoleForUserReq.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.String system_id) {
        this.system_id = system_id;
    }


    /**
     * Gets the user_account value for this ModifyRoleForUserReq.
     * 
     * @return user_account
     */
    public java.lang.String getUser_account() {
        return user_account;
    }


    /**
     * Sets the user_account value for this ModifyRoleForUserReq.
     * 
     * @param user_account
     */
    public void setUser_account(java.lang.String user_account) {
        this.user_account = user_account;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModifyRoleForUserReq)) return false;
        ModifyRoleForUserReq other = (ModifyRoleForUserReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.opt_flag==null && other.getOpt_flag()==null) || 
             (this.opt_flag!=null &&
              this.opt_flag.equals(other.getOpt_flag()))) &&
            ((this.role_flag==null && other.getRole_flag()==null) || 
             (this.role_flag!=null &&
              this.role_flag.equals(other.getRole_flag()))) &&
            ((this.system_id==null && other.getSystem_id()==null) || 
             (this.system_id!=null &&
              this.system_id.equals(other.getSystem_id()))) &&
            ((this.user_account==null && other.getUser_account()==null) || 
             (this.user_account!=null &&
              this.user_account.equals(other.getUser_account())));
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
        if (getOpt_flag() != null) {
            _hashCode += getOpt_flag().hashCode();
        }
        if (getRole_flag() != null) {
            _hashCode += getRole_flag().hashCode();
        }
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        if (getUser_account() != null) {
            _hashCode += getUser_account().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModifyRoleForUserReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "ModifyRoleForUserReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opt_flag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "opt_flag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_account");
        elemField.setXmlName(new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "user_account"));
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
