/**
 * GetUsersFromRoleRsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.response;

public class GetUsersFromRoleRsp  implements java.io.Serializable {
    private java.lang.String returnCode;

    private java.lang.String returnMessage;

    private com.emag.cams.intf.atomic.pojo.Userinfo[] userList;

    public GetUsersFromRoleRsp() {
    }

    public GetUsersFromRoleRsp(
           java.lang.String returnCode,
           java.lang.String returnMessage,
           com.emag.cams.intf.atomic.pojo.Userinfo[] userList) {
           this.returnCode = returnCode;
           this.returnMessage = returnMessage;
           this.userList = userList;
    }


    /**
     * Gets the returnCode value for this GetUsersFromRoleRsp.
     * 
     * @return returnCode
     */
    public java.lang.String getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this GetUsersFromRoleRsp.
     * 
     * @param returnCode
     */
    public void setReturnCode(java.lang.String returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Gets the returnMessage value for this GetUsersFromRoleRsp.
     * 
     * @return returnMessage
     */
    public java.lang.String getReturnMessage() {
        return returnMessage;
    }


    /**
     * Sets the returnMessage value for this GetUsersFromRoleRsp.
     * 
     * @param returnMessage
     */
    public void setReturnMessage(java.lang.String returnMessage) {
        this.returnMessage = returnMessage;
    }


    /**
     * Gets the userList value for this GetUsersFromRoleRsp.
     * 
     * @return userList
     */
    public com.emag.cams.intf.atomic.pojo.Userinfo[] getUserList() {
        return userList;
    }


    /**
     * Sets the userList value for this GetUsersFromRoleRsp.
     * 
     * @param userList
     */
    public void setUserList(com.emag.cams.intf.atomic.pojo.Userinfo[] userList) {
        this.userList = userList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUsersFromRoleRsp)) return false;
        GetUsersFromRoleRsp other = (GetUsersFromRoleRsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.returnCode==null && other.getReturnCode()==null) || 
             (this.returnCode!=null &&
              this.returnCode.equals(other.getReturnCode()))) &&
            ((this.returnMessage==null && other.getReturnMessage()==null) || 
             (this.returnMessage!=null &&
              this.returnMessage.equals(other.getReturnMessage()))) &&
            ((this.userList==null && other.getUserList()==null) || 
             (this.userList!=null &&
              java.util.Arrays.equals(this.userList, other.getUserList())));
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
        if (getReturnCode() != null) {
            _hashCode += getReturnCode().hashCode();
        }
        if (getReturnMessage() != null) {
            _hashCode += getReturnMessage().hashCode();
        }
        if (getUserList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUserList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUserList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUsersFromRoleRsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUsersFromRoleRsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "returnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "returnMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "userList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Userinfo"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item"));
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
