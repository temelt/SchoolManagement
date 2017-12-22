package com.temelt.schmgt.web.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.altinkaynak.data.DataServiceLocator;
import com.altinkaynak.data.DataServiceSoap;
import com.altinkaynak.data.DataServiceSoapStub;

     



@Controller("dovizWs")
@Scope("request")
public class DovizWs {
    
	private String dolar="Dolar";
	private String euro="Euro";
	private String dolarAlis;
	private String euroAlis;
	
	public String getDolarAlis() {
		return dolarAlis;
	}
	public String getEuroAlis() {
		return euroAlis;
	}
	public String getDolar() {
		return dolar;
	}
	public String getEuro() {
		return euro;
	}
	
	@PostConstruct
	public void init() {
		try {
			getDoviz();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getDoviz() throws MalformedURLException, ServiceException, SOAPException, RemoteException {
		DataServiceLocator wsLocator = new DataServiceLocator();
		DataServiceSoap ws = wsLocator.getDataServiceSoap(new URL("http://data.altinkaynak.com/DataService.asmx?WSDL"));


		SOAPHeaderElement authentication = new org.apache.axis.message.SOAPHeaderElement("http://data.altinkaynak.com/", "AuthHeader");
		SOAPHeaderElement user = new org.apache.axis.message.SOAPHeaderElement("http://data.altinkaynak.com/","Username", "AltinkaynakWebServis");
		SOAPHeaderElement password = new org.apache.axis.message.SOAPHeaderElement("http://data.altinkaynak.com/","Password", "AltinkaynakWebServis");
		authentication.addChildElement(user);
		authentication.addChildElement(password);
		((DataServiceSoapStub)ws).setHeader((org.apache.axis.message.SOAPHeaderElement) authentication);

         
           String a=ws.getCurrency();
           dolarAlis= a.substring(206,212); 
           euroAlis= a.substring(368,374);
          System.out.println(a);
          System.out.println("dolar alis = "+dolarAlis);
          System.out.println("Euro alis = " +euroAlis);
		
		
		// TODO Auto-generated method stub

	}
	
	
	
	
}
