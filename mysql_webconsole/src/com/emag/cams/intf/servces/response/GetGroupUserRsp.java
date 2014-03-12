/**
 * GetGroupUserRsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.response;

public class GetGroupUserRsp  implements java.io.Serializable {
    private com.emag.cams.intf.atomic.pojo.Group[] groupList;

    private com.emag.cams.intf.atomic.pojo.GroupUser[] groupUserList;

    private java.lang.String returnCode;

    private java.lang.String returnMessage;

    public GetGroupUserRsp() {
    }

    public GetGroupUserRsp(
           com.emag.cams.intf.atomic.pojo.Group[] groupList,
           com.emag.cams.intf.atomic.pojo.GroupUser[] groupUserList,
           java.lang.String returnCode,
           java.lang.String returnMessage) {
           this.groupList = groupList;
           this.groupUserList = groupUserList;
           this.returnCode = returnCode;
           this.returnMessage = returnMessage;
    }


    /**
     * Gets the groupList value for this GetGroupUserRsp.
     * 
     * @return groupList
     */
    public com.emag.cams.intf.atomic.pojo.Group[] getGroupList() {
        return groupList;
    }


    /**
     * Sets the groupList value for this GetGroupUserRsp.
     * 
     * @param groupList
     */
    public void setGroupList(com.emag.cams.intf.atomic.pojo.Group[] groupList) {
        this.groupList = groupList;
    }


    /**
     * Gets the groupUserList value for this GetGroupUserRsp.
     * 
     * @return groupUserList
     */
    public com.emag.cams.intf.atomic.pojo.GroupUser[] getGroupUserList() {
        return groupUserList;
    }


    /**
     * Sets the groupUserList value for this GetGroupUserRsp.
     * 
     * @param groupUserList
     */
    public void setGroupUserList(com.emag.cams.intf.atomic.pojo.GroupUser[] groupUserList) {
        this.groupUserList = groupUserList;
    }


    /**
     * Gets the returnCode value for this GetGroupUserRsp.
     * 
     * @return returnCode
     */
    public java.lang.String getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this GetGroupUserRsp.
     * 
     * @param returnCode
     */
    public void setReturnCode(java.lang.String returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Gets the returnMessage value for this GetGroupUserRsp.
     * 
     * @return returnMessage
     */
    public java.lang.String getReturnMessage() {
        return returnMessage;
    }


    /**
     * Sets the returnMessage value for this GetGroupUserRsp.
     * 
     * @param returnMessage
     */
    public void setReturnMessage(java.lang.String returnMessage) {
        this.returnMessage = returnMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetGroupUserRsp)) return false;
        GetGroupUserRsp other = (GetGroupUserRsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.groupList==null && other.getGroupList()==null) || 
             (this.groupList!=null &&
              java.util.Arrays.equals(this.groupList, other.getGroupList()))) &&
            ((this.groupUserList==null && other.getGroupUserList()==null) || 
             (this.groupUserList!=null &&
              java.util.Arrays.equals(this.groupUserList, other.getGroupUserList()))) &&
            ((this.returnCode==null && other.getReturnCode()==null) || 
             (this.returnCode!=null &&
              this.returnCode.equals(other.getReturnCode()))) &&
            ((this.returnMessage==null && other.getReturnMessage()==null) || 
             (this.returnMessage!=null &&
              this.returnMessage.equals(other.getReturnMessage())));
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
        if (getGroupList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroupList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroupList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGroupUserList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroupUserList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroupUserList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReturnCode() != null) {
            _hashCode += getReturnCode().hashCode();
        }
        if (getReturnMessage() != null) {
            _hashCode += getReturnMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetGroupUserRsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetGroupUserRsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "groupList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Group"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupUserList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "groupUserList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "GroupUser"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
