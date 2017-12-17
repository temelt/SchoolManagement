package com.temelt.schmgt.web.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;

@WebService(name = "KullaniciWs", serviceName = "KullaniciWs")
@Service
public class KullaniciWebService {

	@Autowired
	private KullaniciRepository kullaniciRepository;

	@WebMethod(operationName = "getByUname")
	public Kullanici getByUsername(@WebParam(name = "wsusername") String wsUsername,
			@WebParam(name = "wsPwd") String wsPwd, @WebParam(name = "username") String username) {

		if (wsUsername.equals("wsadmin") && wsPwd.equals("123")) {
			com.temelt.schmgt.web.entity.kullanici.Kullanici kullanici = kullaniciRepository.getByKullaniciAdi(username);
			Kullanici kullanici2 = new Kullanici();
			kullanici2.setAd(kullanici.getAd());
			kullanici2.setSoyad(kullanici.getSoyad());
			kullanici2.setId(kullanici.getId());
			return kullanici2;
		}

		throw new UsernameNotFoundException(" Kullanýcý Adý :" + wsUsername + " Yetkisiz WS Kullanýcý");
	}

	/**
	 * Client Generation
	 * 
	 * wsimport -keep -clientjar Kullanici.jar
	 * http://localhost:8081/KullaniciWs?wsdl
	 * 
	 * 
	 * KullaniciWs_Service bindingStub = new KullaniciWs_Service(); Kullanici
	 * kullanici = bindingStub.getKullaniciWsPort().getByUname("admin");
	 * 
	 * System.out.println(kullanici.getSifre());
	 * 
	 */

}
