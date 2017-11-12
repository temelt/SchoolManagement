package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.entity.kullanici.Kullanici;

@Controller("kullaniciController")
@Scope("session")
public class KullaniciController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private KullaniciRepository kullaniciRepository;

	private List<Kullanici> kullaniciList;

	@PostConstruct
	private void init() {
		kullaniciList = kullaniciRepository.findAll();
	}

	public List<Kullanici> getKullaniciList() {
		return kullaniciList;
	}
	
	public void setKullaniciList(List<Kullanici> kullaniciList) {
		this.kullaniciList = kullaniciList;
	}
}
