package com.altinkaynak.data;

public class DataServiceSoapProxy implements com.altinkaynak.data.DataServiceSoap {
  private String _endpoint = null;
  private com.altinkaynak.data.DataServiceSoap dataServiceSoap = null;
  
  public DataServiceSoapProxy() {
    _initDataServiceSoapProxy();
  }
  
  public DataServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDataServiceSoapProxy();
  }
  
  private void _initDataServiceSoapProxy() {
    try {
      dataServiceSoap = (new com.altinkaynak.data.DataServiceLocator()).getDataServiceSoap();
      if (dataServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dataServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dataServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dataServiceSoap != null)
      ((javax.xml.rpc.Stub)dataServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.altinkaynak.data.DataServiceSoap getDataServiceSoap() {
    if (dataServiceSoap == null)
      _initDataServiceSoapProxy();
    return dataServiceSoap;
  }
  
  public java.lang.String getCurrency() throws java.rmi.RemoteException{
    if (dataServiceSoap == null)
      _initDataServiceSoapProxy();
    return dataServiceSoap.getCurrency();
  }
  
  public java.lang.String getGold() throws java.rmi.RemoteException{
    if (dataServiceSoap == null)
      _initDataServiceSoapProxy();
    return dataServiceSoap.getGold();
  }
  
  public java.lang.String getMain() throws java.rmi.RemoteException{
    if (dataServiceSoap == null)
      _initDataServiceSoapProxy();
    return dataServiceSoap.getMain();
  }
  
  public java.lang.String getParity() throws java.rmi.RemoteException{
    if (dataServiceSoap == null)
      _initDataServiceSoapProxy();
    return dataServiceSoap.getParity();
  }
  
  
}