package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.IkOgretmenRepository;
import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.entity.ik.Ogretmen;
import com.temelt.schmgt.web.entity.kullanici.Kullanici;
@Controller("ikogretmenController")
@Scope("session")
public class IkOgretmenController  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Autowired
	private IkOgretmenRepository ikogretmenRepository;

	private List<Ogretmen> OgretmenList;
	private Ogretmen ogretmen;

	@PostConstruct
	private void init() {
		OgretmenList = ikogretmenRepository.findAll();
		ogretmen=new Ogretmen();
	}

	public void OgretmenKaydet() {
		System.out.println("Kullanýcý Kaydettik");
		ikogretmenRepository.save(ogretmen);
		ogretmen=new Ogretmen();
		OgretmenList = ikogretmenRepository.findAll();
	}
	
	public void OgretmenSil(Long id) {
		Ogretmen k = ikogretmenRepository.findOne(id);
		ikogretmenRepository.delete(k);
		OgretmenList = ikogretmenRepository.findAll();
	}

	public List<Ogretmen> getOgretmenList() {
		return OgretmenList;
	}

	public void setOgretmenList(List<Ogretmen> ogretmenList) {
		OgretmenList = ogretmenList;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}


}
