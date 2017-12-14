package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.IkOgretmenRepository;
import com.temelt.schmgt.web.entity.ik.Ogretmen;

@Controller("ikOgretmenController")
@Scope("session")
public class IkOgretmenController  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Autowired
	private IkOgretmenRepository ikogretmenRepository;

	private List<Ogretmen> ogretmenList;
	private Ogretmen ogretmen;

	@PostConstruct
	private void init() {
		ogretmenList = ikogretmenRepository.findAll();
		ogretmen=new Ogretmen();
	}

	public void OgretmenKaydet() {
		System.out.println("Öðretmeni Kaydettik");
		ikogretmenRepository.save(ogretmen);
		ogretmen=new Ogretmen();
		ogretmenList = ikogretmenRepository.findAll();
	}
	
	public void OgretmenSil(Long id) {
		Ogretmen o = ikogretmenRepository.findOne(id);
		ikogretmenRepository.delete(o);
		ogretmenList = ikogretmenRepository.findAll();
	}

	public List<Ogretmen> getOgretmenList() {
		return ogretmenList;
	}

	public void setOgretmenList(List<Ogretmen> ogretmenList) {
		ogretmenList = ogretmenList;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}


}
