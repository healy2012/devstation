/**
 * GetRegionDeptRsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces.response;

public class GetRegionDeptRsp  implements java.io.Serializable {
    private com.emag.cams.intf.atomic.pojo.Dept[] deptList;

    private com.emag.cams.intf.atomic.pojo.Region[] regionList;

    private java.lang.String returnCode;

    private java.lang.String returnMessage;

    public GetRegionDeptRsp() {
    }

    public GetRegionDeptRsp(
           com.emag.cams.intf.atomic.pojo.Dept[] deptList,
           com.emag.cams.intf.atomic.pojo.Region[] regionList,
           java.lang.String returnCode,
           java.lang.String returnMessage) {
           this.deptList = deptList;
           this.regionList = regionList;
           this.returnCode = returnCode;
           this.returnMessage = returnMessage;
    }


    /**
     * Gets the deptList value for this GetRegionDeptRsp.
     * 
     * @return deptList
     */
    public com.emag.cams.intf.atomic.pojo.Dept[] getDeptList() {
        return deptList;
    }


    /**
     * Sets the deptList value for this GetRegionDeptRsp.
     * 
     * @param deptList
     */
    public void setDeptList(com.emag.cams.intf.atomic.pojo.Dept[] deptList) {
        this.deptList = deptList;
    }


    /**
     * Gets the regionList value for this GetRegionDeptRsp.
     * 
     * @return regionList
     */
    public com.emag.cams.intf.atomic.pojo.Region[] getRegionList() {
        return regionList;
    }


    /**
     * Sets the regionList value for this GetRegionDeptRsp.
     * 
     * @param regionList
     */
    public void setRegionList(com.emag.cams.intf.atomic.pojo.Region[] regionList) {
        this.regionList = regionList;
    }


    /**
     * Gets the returnCode value for this GetRegionDeptRsp.
     * 
     * @return returnCode
     */
    public java.lang.String getReturnCode() {
        return returnCode;
    }


    /**
     * Sets the returnCode value for this GetRegionDeptRsp.
     * 
     * @param returnCode
     */
    public void setReturnCode(java.lang.String returnCode) {
        this.returnCode = returnCode;
    }


    /**
     * Gets the returnMessage value for this GetRegionDeptRsp.
     * 
     * @return returnMessage
     */
    public java.lang.String getReturnMessage() {
        return returnMessage;
    }


    /**
     * Sets the returnMessage value for this GetRegionDeptRsp.
     * 
     * @param returnMessage
     */
    public void setReturnMessage(java.lang.String returnMessage) {
        this.returnMessage = returnMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRegionDeptRsp)) return false;
        GetRegionDeptRsp other = (GetRegionDeptRsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deptList==null && other.getDeptList()==null) || 
             (this.deptList!=null &&
              java.util.Arrays.equals(this.deptList, other.getDeptList()))) &&
            ((this.regionList==null && other.getRegionList()==null) || 
             (this.regionList!=null &&
              java.util.Arrays.equals(this.regionList, other.getRegionList()))) &&
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
        if (getDeptList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeptList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeptList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRegionList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegionList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegionList(), i);
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
        new org.apache.axis.description.TypeDesc(GetRegionDeptRsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRegionDeptRsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deptList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "deptList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Dept"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regionList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "regionList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Region"));
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
