package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.KisiRepository;
import com.temelt.schmgt.web.entity.Kisi;

@Controller("kisiController")
@Scope("session")
public class KisiController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private KisiRepository kisiRepository;

	private List<Kisi> kisiList;

	@PostConstruct
	private void init() {
		kisiList = kisiRepository.findAll();
	}

	public List<Kisi> getKisiList() {
		return kisiList;
	}

	public void setKisiList(List<Kisi> kisiList) {
		this.kisiList = kisiList;
	}
}
