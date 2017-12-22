/**
 * DataServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.altinkaynak.data;

public class DataServiceLocator extends org.apache.axis.client.Service implements com.altinkaynak.data.DataService {

    public DataServiceLocator() {
    }


    public DataServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DataServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DataServiceSoap
    private java.lang.String DataServiceSoap_address = "http://data.altinkaynak.com/DataService.asmx";

    public java.lang.String getDataServiceSoapAddress() {
        return DataServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DataServiceSoapWSDDServiceName = "DataServiceSoap";

    public java.lang.String getDataServiceSoapWSDDServiceName() {
        return DataServiceSoapWSDDServiceName;
    }

    public void setDataServiceSoapWSDDServiceName(java.lang.String name) {
        DataServiceSoapWSDDServiceName = name;
    }

    public com.altinkaynak.data.DataServiceSoap getDataServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DataServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDataServiceSoap(endpoint);
    }

    public com.altinkaynak.data.DataServiceSoap getDataServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.altinkaynak.data.DataServiceSoapStub _stub = new com.altinkaynak.data.DataServiceSoapStub(portAddress, this);
            _stub.setPortName(getDataServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDataServiceSoapEndpointAddress(java.lang.String address) {
        DataServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.altinkaynak.data.DataServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.altinkaynak.data.DataServiceSoapStub _stub = new com.altinkaynak.data.DataServiceSoapStub(new java.net.URL(DataServiceSoap_address), this);
                _stub.setPortName(getDataServiceSoapWSDDServiceName());
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
        if ("DataServiceSoap".equals(inputPortName)) {
            return getDataServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://data.altinkaynak.com/", "DataService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://data.altinkaynak.com/", "DataServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DataServiceSoap".equals(portName)) {
            setDataServiceSoapEndpointAddress(address);
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
