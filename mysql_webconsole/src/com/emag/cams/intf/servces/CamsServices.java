/**
 * CamsServices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces;

public interface CamsServices extends java.rmi.Remote {
    public com.emag.cams.intf.servces.response.CreateUserRsp createUser(com.emag.cams.intf.servces.request.CreateUserReq createUserReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.ModifyUserRsp modifyUser(com.emag.cams.intf.servces.request.ModifyUserReq modifyUserReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetSysAdministratorRsp getSysAdministrator(com.emag.cams.intf.servces.request.GetSysAdministratorReq getSysAdministratorReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetUserPermRsp getUserPerm(com.emag.cams.intf.servces.request.GetUserPermReq getUserPermReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetSysPermRsp getSysPerm(com.emag.cams.intf.servces.request.GetSysPermReq getSysPermReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetUserResRsp getUserRes(com.emag.cams.intf.servces.request.GetUserResReq getUserResReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetSysResRsp getSysRes(com.emag.cams.intf.servces.request.GetSysResReq getSysResReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetUserMenuRsp getUserMenu(com.emag.cams.intf.servces.request.GetUserMenuReq getUserMenuReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetSysMenuRsp getSysMenu(com.emag.cams.intf.servces.request.GetSysMenuReq getSysMenuReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetRegionDeptRsp getRegionDept(com.emag.cams.intf.servces.request.GetRegionDeptReq getRegionDeptReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetRegionDeptUserRsp getRegionDeptUser(com.emag.cams.intf.servces.request.GetRegionDeptUserReq getRegionDeptUserReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetSysUserRsp getSysUser(com.emag.cams.intf.servces.request.GetSysUserReq getSysUserReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetSysGroupRsp getSysGroup(com.emag.cams.intf.servces.request.GetSysGroupReq getSysGroupReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetGroupUserRsp getGroupUser(com.emag.cams.intf.servces.request.GetGroupUserReq getGroupUserReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetUserInfoRsp getUserInfo(com.emag.cams.intf.servces.request.GetUserInfoReq getUserInfoReq) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetUsersFromRoleRsp getUsersFromRole(com.emag.cams.intf.servces.request.GetUsersFromRoleReq in0) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetRolesFromUserRsp getRolesFromUser(com.emag.cams.intf.servces.request.GetRolesFromUserReq in0) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.ModifyRoleForUserRsp modifyRoleForUser(com.emag.cams.intf.servces.request.ModifyRoleForUserReq in0) throws java.rmi.RemoteException;
    public com.emag.cams.intf.servces.response.GetSysRolesRsp getSysRoles(com.emag.cams.intf.servces.request.GetSysRolesReq in0) throws java.rmi.RemoteException;
}
