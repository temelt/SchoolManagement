/**
 * DataService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.altinkaynak.data;

public interface DataService extends javax.xml.rpc.Service {
    public java.lang.String getDataServiceSoapAddress();

    public com.altinkaynak.data.DataServiceSoap getDataServiceSoap() throws javax.xml.rpc.ServiceException;

    public com.altinkaynak.data.DataServiceSoap getDataServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
