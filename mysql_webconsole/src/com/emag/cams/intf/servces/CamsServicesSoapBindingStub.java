/**
 * CamsServicesSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces;

public class CamsServicesSoapBindingStub extends org.apache.axis.client.Stub implements com.emag.cams.intf.servces.CamsServices {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[19];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "createUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "CreateUserReq"), com.emag.cams.intf.servces.request.CreateUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "CreateUserRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.CreateUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "createUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modifyUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "modifyUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "ModifyUserReq"), com.emag.cams.intf.servces.request.ModifyUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "ModifyUserRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.ModifyUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "modifyUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysAdministrator");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysAdministratorReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysAdministratorReq"), com.emag.cams.intf.servces.request.GetSysAdministratorReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysAdministratorRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetSysAdministratorRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysAdministratorReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserPerm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserPermReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserPermReq"), com.emag.cams.intf.servces.request.GetUserPermReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserPermRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetUserPermRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserPermReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysPerm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysPermReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysPermReq"), com.emag.cams.intf.servces.request.GetSysPermReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysPermRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetSysPermRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysPermReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserRes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserResReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserResReq"), com.emag.cams.intf.servces.request.GetUserResReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserResRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetUserResRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserResReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysRes");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysResReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysResReq"), com.emag.cams.intf.servces.request.GetSysResReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysResRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetSysResRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysResReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserMenu");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserMenuReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserMenuReq"), com.emag.cams.intf.servces.request.GetUserMenuReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserMenuRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetUserMenuRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserMenuReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysMenu");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysMenuReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysMenuReq"), com.emag.cams.intf.servces.request.GetSysMenuReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysMenuRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetSysMenuRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysMenuReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRegionDept");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRegionDeptReq"), com.emag.cams.intf.servces.request.GetRegionDeptReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRegionDeptRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetRegionDeptRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRegionDeptUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRegionDeptUserReq"), com.emag.cams.intf.servces.request.GetRegionDeptUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRegionDeptUserRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetRegionDeptUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysUserReq"), com.emag.cams.intf.servces.request.GetSysUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysUserRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetSysUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysGroupReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysGroupReq"), com.emag.cams.intf.servces.request.GetSysGroupReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysGroupRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetSysGroupRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysGroupReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGroupUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getGroupUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetGroupUserReq"), com.emag.cams.intf.servces.request.GetGroupUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetGroupUserRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetGroupUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getGroupUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserInfoReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserInfoReq"), com.emag.cams.intf.servces.request.GetUserInfoReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserInfoRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetUserInfoRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;
        
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUsersFromRole");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUsersFromRoleReq"), com.emag.cams.intf.servces.request.GetUsersFromRoleReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUsersFromRoleRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetUsersFromRoleRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUsersFromRoleReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRolesFromUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRolesFromUserReq"), com.emag.cams.intf.servces.request.GetRolesFromUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRolesFromUserRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetRolesFromUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRolesFromUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modifyRoleForUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "ModifyRoleForUserReq"), com.emag.cams.intf.servces.request.ModifyRoleForUserReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "ModifyRoleForUserRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.ModifyRoleForUserRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "modifyRoleForUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSysRoles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysRolesReq"), com.emag.cams.intf.servces.request.GetSysRolesReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysRolesRsp"));
        oper.setReturnClass(com.emag.cams.intf.servces.response.GetSysRolesRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysRolesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

    }

    public CamsServicesSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CamsServicesSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CamsServicesSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Dept");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Dept.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "DeptUser");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.DeptUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Group");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Group.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "GroupUser");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.GroupUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Menu");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Menu.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Perm");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Perm.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Region");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Region.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Resource");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Resource.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Userinfo");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Userinfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "CreateUserReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.CreateUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetGroupUserReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetGroupUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRegionDeptReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetRegionDeptReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRegionDeptUserReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetRegionDeptUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysAdministratorReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetSysAdministratorReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysGroupReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetSysGroupReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysMenuReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetSysMenuReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysPermReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetSysPermReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysResReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetSysResReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysUserReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetSysUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserInfoReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetUserInfoReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserMenuReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetUserMenuReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserPermReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetUserPermReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserResReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetUserResReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "ModifyUserReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.ModifyUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "CreateUserRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.CreateUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetGroupUserRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetGroupUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRegionDeptRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetRegionDeptRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRegionDeptUserRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetRegionDeptUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysAdministratorRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetSysAdministratorRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysGroupRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetSysGroupRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysMenuRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetSysMenuRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysPermRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetSysPermRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysResRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetSysResRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysUserRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetSysUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserInfoRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetUserInfoRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserMenuRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetUserMenuRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserPermRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetUserPermRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserResRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetUserResRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "ModifyUserRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.ModifyUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Dept");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Dept[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Dept");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_DeptUser");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.DeptUser[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "DeptUser");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Group");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Group[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Group");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_GroupUser");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.GroupUser[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "GroupUser");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Menu");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Menu[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Menu");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Perm");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Perm[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Perm");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Region");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Region[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Region");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Resource");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Resource[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Resource");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Userinfo");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Userinfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Userinfo");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());
            
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Role");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Role.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRolesFromUserReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetRolesFromUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysRolesReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetSysRolesReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUsersFromRoleReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.GetUsersFromRoleReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "ModifyRoleForUserReq");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.request.ModifyRoleForUserReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRolesFromUserRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetRolesFromUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysRolesRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetSysRolesRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUsersFromRoleRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.GetUsersFromRoleRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "ModifyRoleForUserRsp");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.servces.response.ModifyRoleForUserRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);
            
            qName = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "ArrayOf_tns4_Role");
            cachedSerQNames.add(qName);
            cls = com.emag.cams.intf.atomic.pojo.Role[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://pojo.atomic.intf.cams.emag.com", "Role");
            qName2 = new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.emag.cams.intf.servces.response.CreateUserRsp createUser(com.emag.cams.intf.servces.request.CreateUserReq createUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "createUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {createUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.CreateUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.CreateUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.CreateUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.ModifyUserRsp modifyUser(com.emag.cams.intf.servces.request.ModifyUserReq modifyUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "modifyUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {modifyUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.ModifyUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.ModifyUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.ModifyUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetSysAdministratorRsp getSysAdministrator(com.emag.cams.intf.servces.request.GetSysAdministratorReq getSysAdministratorReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSysAdministrator"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getSysAdministratorReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetSysAdministratorRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetSysAdministratorRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetSysAdministratorRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetUserPermRsp getUserPerm(com.emag.cams.intf.servces.request.GetUserPermReq getUserPermReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getUserPerm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getUserPermReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetUserPermRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetUserPermRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetUserPermRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetSysPermRsp getSysPerm(com.emag.cams.intf.servces.request.GetSysPermReq getSysPermReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSysPerm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getSysPermReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetSysPermRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetSysPermRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetSysPermRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetUserResRsp getUserRes(com.emag.cams.intf.servces.request.GetUserResReq getUserResReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getUserRes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getUserResReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetUserResRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetUserResRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetUserResRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetSysResRsp getSysRes(com.emag.cams.intf.servces.request.GetSysResReq getSysResReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSysRes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getSysResReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetSysResRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetSysResRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetSysResRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetUserMenuRsp getUserMenu(com.emag.cams.intf.servces.request.GetUserMenuReq getUserMenuReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getUserMenu"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getUserMenuReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetUserMenuRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetUserMenuRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetUserMenuRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetSysMenuRsp getSysMenu(com.emag.cams.intf.servces.request.GetSysMenuReq getSysMenuReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSysMenu"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getSysMenuReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetSysMenuRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetSysMenuRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetSysMenuRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetRegionDeptRsp getRegionDept(com.emag.cams.intf.servces.request.GetRegionDeptReq getRegionDeptReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getRegionDept"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getRegionDeptReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetRegionDeptRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetRegionDeptRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetRegionDeptRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetRegionDeptUserRsp getRegionDeptUser(com.emag.cams.intf.servces.request.GetRegionDeptUserReq getRegionDeptUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getRegionDeptUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getRegionDeptUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetRegionDeptUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetRegionDeptUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetRegionDeptUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetSysUserRsp getSysUser(com.emag.cams.intf.servces.request.GetSysUserReq getSysUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSysUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getSysUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetSysUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetSysUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetSysUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetSysGroupRsp getSysGroup(com.emag.cams.intf.servces.request.GetSysGroupReq getSysGroupReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSysGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getSysGroupReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetSysGroupRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetSysGroupRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetSysGroupRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetGroupUserRsp getGroupUser(com.emag.cams.intf.servces.request.GetGroupUserReq getGroupUserReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getGroupUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getGroupUserReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetGroupUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetGroupUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetGroupUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetUserInfoRsp getUserInfo(com.emag.cams.intf.servces.request.GetUserInfoReq getUserInfoReq) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getUserInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getUserInfoReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetUserInfoRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetUserInfoRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetUserInfoRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetUsersFromRoleRsp getUsersFromRole(com.emag.cams.intf.servces.request.GetUsersFromRoleReq in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getUsersFromRole"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetUsersFromRoleRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetUsersFromRoleRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetUsersFromRoleRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetRolesFromUserRsp getRolesFromUser(com.emag.cams.intf.servces.request.GetRolesFromUserReq in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getRolesFromUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetRolesFromUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetRolesFromUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetRolesFromUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.ModifyRoleForUserRsp modifyRoleForUser(com.emag.cams.intf.servces.request.ModifyRoleForUserReq in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "modifyRoleForUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.ModifyRoleForUserRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.ModifyRoleForUserRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.ModifyRoleForUserRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.emag.cams.intf.servces.response.GetSysRolesRsp getSysRoles(com.emag.cams.intf.servces.request.GetSysRolesReq in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getSysRoles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.emag.cams.intf.servces.response.GetSysRolesRsp) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.emag.cams.intf.servces.response.GetSysRolesRsp) org.apache.axis.utils.JavaUtils.convert(_resp, com.emag.cams.intf.servces.response.GetSysRolesRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
