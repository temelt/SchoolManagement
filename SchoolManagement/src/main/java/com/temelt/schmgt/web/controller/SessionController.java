package com.temelt.schmgt.web.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.entity.kullanici.Kullanici;

@Controller("sessionController")
@Scope("session")
public class SessionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7977073196177900604L;
	
	@Autowired
	KullaniciRepository kullaniciRepository;

	public Kullanici getUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return kullaniciRepository.getByKullaniciAdi(userName);
	}

}
