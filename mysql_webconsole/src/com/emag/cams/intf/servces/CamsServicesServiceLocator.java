/**
 * CamsServicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.emag.cams.intf.servces;

public class CamsServicesServiceLocator extends org.apache.axis.client.Service implements com.emag.cams.intf.servces.CamsServicesService {

    public CamsServicesServiceLocator() {
    }


    public CamsServicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CamsServicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CamsServices
    private java.lang.String CamsServices_address = "http://localhost:8080/services/CamsServices";

    public java.lang.String getCamsServicesAddress() {
        return CamsServices_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CamsServicesWSDDServiceName = "CamsServices";

    public java.lang.String getCamsServicesWSDDServiceName() {
        return CamsServicesWSDDServiceName;
    }

    public void setCamsServicesWSDDServiceName(java.lang.String name) {
        CamsServicesWSDDServiceName = name;
    }

    public com.emag.cams.intf.servces.CamsServices getCamsServices() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CamsServices_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCamsServices(endpoint);
    }

    public com.emag.cams.intf.servces.CamsServices getCamsServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.emag.cams.intf.servces.CamsServicesSoapBindingStub _stub = new com.emag.cams.intf.servces.CamsServicesSoapBindingStub(portAddress, this);
            _stub.setPortName(getCamsServicesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCamsServicesEndpointAddress(java.lang.String address) {
        CamsServices_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.emag.cams.intf.servces.CamsServices.class.isAssignableFrom(serviceEndpointInterface)) {
                com.emag.cams.intf.servces.CamsServicesSoapBindingStub _stub = new com.emag.cams.intf.servces.CamsServicesSoapBindingStub(new java.net.URL(CamsServices_address), this);
                _stub.setPortName(getCamsServicesWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CamsServices".equals(inputPortName)) {
            return getCamsServices();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "CamsServicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servces.intf.cams.emag.com", "CamsServices"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CamsServices".equals(portName)) {
            setCamsServicesEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
