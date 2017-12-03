package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.IkPersonelRepository;
import com.temelt.schmgt.web.entity.ik.Personel;


@Controller("ikPesonelController")
@Scope("session")
public class IkPersonelController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IkPersonelRepository ikPersonelRepository;  

	private List<Personel> personelList;
	private Personel personel;

	@PostConstruct
	private void init() {
		personelList = ikPersonelRepository.findAll();
		Personel personel;
	}

	public void PersonelKaydet() {
		System.out.println("Kullanýcý Kaydettik");
		ikPersonelRepository.save(personelList);
		personel= new Personel();
		personelList =ikPersonelRepository.findAll();
	}
	
	public void PersonelSil(Long id) {
		Personel k = ikPersonelRepository.findOne(id);
		ikPersonelRepository.delete(k);
		personelList = ikPersonelRepository.findAll();
	}

	public List<Personel> getPersonelList() {
		return personelList;
	}

	public void setPersonelList(List<Personel> personelList) {
		personelList=personelList;
	}

	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel=personel;
	}

}
