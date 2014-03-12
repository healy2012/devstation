/**
 * CamsServicesSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces;

public class CamsServicesSoapBindingSkeleton implements com.emag.cams.intf.servces.CamsServices, org.apache.axis.wsdl.Skeleton {
    private com.emag.cams.intf.servces.CamsServices impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "createUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "CreateUserReq"), com.emag.cams.intf.servces.request.CreateUserReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("createUser", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "createUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "CreateUserRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "createUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createUser") == null) {
            _myOperations.put("createUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("createUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "modifyUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "ModifyUserReq"), com.emag.cams.intf.servces.request.ModifyUserReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("modifyUser", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "modifyUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "ModifyUserRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "modifyUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("modifyUser") == null) {
            _myOperations.put("modifyUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("modifyUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysAdministratorReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysAdministratorReq"), com.emag.cams.intf.servces.request.GetSysAdministratorReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getSysAdministrator", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysAdministratorReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysAdministratorRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getSysAdministrator"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getSysAdministrator") == null) {
            _myOperations.put("getSysAdministrator", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getSysAdministrator")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserPermReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserPermReq"), com.emag.cams.intf.servces.request.GetUserPermReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getUserPerm", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserPermReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserPermRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getUserPerm"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUserPerm") == null) {
            _myOperations.put("getUserPerm", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getUserPerm")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysPermReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysPermReq"), com.emag.cams.intf.servces.request.GetSysPermReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getSysPerm", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysPermReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysPermRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getSysPerm"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getSysPerm") == null) {
            _myOperations.put("getSysPerm", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getSysPerm")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserResReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserResReq"), com.emag.cams.intf.servces.request.GetUserResReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getUserRes", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserResReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserResRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getUserRes"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUserRes") == null) {
            _myOperations.put("getUserRes", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getUserRes")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysResReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysResReq"), com.emag.cams.intf.servces.request.GetSysResReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getSysRes", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysResReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysResRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getSysRes"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getSysRes") == null) {
            _myOperations.put("getSysRes", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getSysRes")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserMenuReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserMenuReq"), com.emag.cams.intf.servces.request.GetUserMenuReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getUserMenu", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserMenuReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserMenuRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getUserMenu"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUserMenu") == null) {
            _myOperations.put("getUserMenu", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getUserMenu")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysMenuReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysMenuReq"), com.emag.cams.intf.servces.request.GetSysMenuReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getSysMenu", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysMenuReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysMenuRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getSysMenu"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getSysMenu") == null) {
            _myOperations.put("getSysMenu", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getSysMenu")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRegionDeptReq"), com.emag.cams.intf.servces.request.GetRegionDeptReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getRegionDept", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRegionDeptRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getRegionDept"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRegionDept") == null) {
            _myOperations.put("getRegionDept", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getRegionDept")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRegionDeptUserReq"), com.emag.cams.intf.servces.request.GetRegionDeptUserReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getRegionDeptUser", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRegionDeptUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRegionDeptUserRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getRegionDeptUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRegionDeptUser") == null) {
            _myOperations.put("getRegionDeptUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getRegionDeptUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysUserReq"), com.emag.cams.intf.servces.request.GetSysUserReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getSysUser", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysUserRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getSysUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getSysUser") == null) {
            _myOperations.put("getSysUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getSysUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysGroupReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysGroupReq"), com.emag.cams.intf.servces.request.GetSysGroupReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getSysGroup", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysGroupReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysGroupRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getSysGroup"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getSysGroup") == null) {
            _myOperations.put("getSysGroup", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getSysGroup")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getGroupUserReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetGroupUserReq"), com.emag.cams.intf.servces.request.GetGroupUserReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getGroupUser", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getGroupUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetGroupUserRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getGroupUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getGroupUser") == null) {
            _myOperations.put("getGroupUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getGroupUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserInfoReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUserInfoReq"), com.emag.cams.intf.servces.request.GetUserInfoReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getUserInfo", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUserInfoReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUserInfoRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getUserInfo"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUserInfo") == null) {
            _myOperations.put("getUserInfo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getUserInfo")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetUsersFromRoleReq"), com.emag.cams.intf.servces.request.GetUsersFromRoleReq.class, false, false), 
         };
        _oper = new org.apache.axis.description.OperationDesc("getUsersFromRole", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getUsersFromRoleReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetUsersFromRoleRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getUsersFromRole"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getUsersFromRole") == null) {
            _myOperations.put("getUsersFromRole", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getUsersFromRole")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetRolesFromUserReq"), com.emag.cams.intf.servces.request.GetRolesFromUserReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getRolesFromUser", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getRolesFromUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetRolesFromUserRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getRolesFromUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRolesFromUser") == null) {
            _myOperations.put("getRolesFromUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getRolesFromUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "ModifyRoleForUserReq"), com.emag.cams.intf.servces.request.ModifyRoleForUserReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("modifyRoleForUser", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "modifyRoleForUserReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "ModifyRoleForUserRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "modifyRoleForUser"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("modifyRoleForUser") == null) {
            _myOperations.put("modifyRoleForUser", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("modifyRoleForUser")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "in3"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://request.servces.intf.cams.emag.com", "GetSysRolesReq"), com.emag.cams.intf.servces.request.GetSysRolesReq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getSysRoles", _params, new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "getSysRolesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://response.servces.intf.cams.emag.com", "GetSysRolesRsp"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getSysRoles"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getSysRoles") == null) {
            _myOperations.put("getSysRoles", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getSysRoles")).add(_oper);
    }

    public CamsServicesSoapBindingSkeleton() {
        this.impl = new com.emag.cams.intf.servces.CamsServicesSoapBindingImpl();
    }

    public CamsServicesSoapBindingSkeleton(com.emag.cams.intf.servces.CamsServices impl) {
        this.impl = impl;
    }
    public com.emag.cams.intf.servces.response.CreateUserRsp createUser(com.emag.cams.intf.servces.request.CreateUserReq createUserReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.CreateUserRsp ret = impl.createUser(createUserReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.ModifyUserRsp modifyUser(com.emag.cams.intf.servces.request.ModifyUserReq modifyUserReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.ModifyUserRsp ret = impl.modifyUser(modifyUserReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetSysAdministratorRsp getSysAdministrator(com.emag.cams.intf.servces.request.GetSysAdministratorReq getSysAdministratorReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetSysAdministratorRsp ret = impl.getSysAdministrator(getSysAdministratorReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetUserPermRsp getUserPerm(com.emag.cams.intf.servces.request.GetUserPermReq getUserPermReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetUserPermRsp ret = impl.getUserPerm(getUserPermReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetSysPermRsp getSysPerm(com.emag.cams.intf.servces.request.GetSysPermReq getSysPermReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetSysPermRsp ret = impl.getSysPerm(getSysPermReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetUserResRsp getUserRes(com.emag.cams.intf.servces.request.GetUserResReq getUserResReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetUserResRsp ret = impl.getUserRes(getUserResReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetSysResRsp getSysRes(com.emag.cams.intf.servces.request.GetSysResReq getSysResReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetSysResRsp ret = impl.getSysRes(getSysResReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetUserMenuRsp getUserMenu(com.emag.cams.intf.servces.request.GetUserMenuReq getUserMenuReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetUserMenuRsp ret = impl.getUserMenu(getUserMenuReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetSysMenuRsp getSysMenu(com.emag.cams.intf.servces.request.GetSysMenuReq getSysMenuReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetSysMenuRsp ret = impl.getSysMenu(getSysMenuReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetRegionDeptRsp getRegionDept(com.emag.cams.intf.servces.request.GetRegionDeptReq getRegionDeptReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetRegionDeptRsp ret = impl.getRegionDept(getRegionDeptReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetRegionDeptUserRsp getRegionDeptUser(com.emag.cams.intf.servces.request.GetRegionDeptUserReq getRegionDeptUserReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetRegionDeptUserRsp ret = impl.getRegionDeptUser(getRegionDeptUserReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetSysUserRsp getSysUser(com.emag.cams.intf.servces.request.GetSysUserReq getSysUserReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetSysUserRsp ret = impl.getSysUser(getSysUserReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetSysGroupRsp getSysGroup(com.emag.cams.intf.servces.request.GetSysGroupReq getSysGroupReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetSysGroupRsp ret = impl.getSysGroup(getSysGroupReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetGroupUserRsp getGroupUser(com.emag.cams.intf.servces.request.GetGroupUserReq getGroupUserReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetGroupUserRsp ret = impl.getGroupUser(getGroupUserReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetUserInfoRsp getUserInfo(com.emag.cams.intf.servces.request.GetUserInfoReq getUserInfoReq) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetUserInfoRsp ret = impl.getUserInfo(getUserInfoReq);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetUsersFromRoleRsp getUsersFromRole(com.emag.cams.intf.servces.request.GetUsersFromRoleReq in0) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetUsersFromRoleRsp ret = impl.getUsersFromRole(in0);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetRolesFromUserRsp getRolesFromUser(com.emag.cams.intf.servces.request.GetRolesFromUserReq in0) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetRolesFromUserRsp ret = impl.getRolesFromUser(in0);
        return ret;
    }

    public com.emag.cams.intf.servces.response.ModifyRoleForUserRsp modifyRoleForUser(com.emag.cams.intf.servces.request.ModifyRoleForUserReq in0) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.ModifyRoleForUserRsp ret = impl.modifyRoleForUser(in0);
        return ret;
    }

    public com.emag.cams.intf.servces.response.GetSysRolesRsp getSysRoles(com.emag.cams.intf.servces.request.GetSysRolesReq in0) throws java.rmi.RemoteException
    {
        com.emag.cams.intf.servces.response.GetSysRolesRsp ret = impl.getSysRoles(in0);
        return ret;
    }

}
