package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.SalonRepository;
import com.temelt.schmgt.web.entity.yonetim.Salon;

@Controller("salonController")
@Scope("session")
public class YonetimSalonController implements Serializable{

	
	@Autowired
	private SalonRepository salonRepository;
	
	private Salon salon;
	private List<Salon> salonList;
	
	@PostConstruct
	private void init() {
		salonList = salonRepository.findAll();
		salon=new Salon();
	}
	
	public void salonKaydet() {
		salonRepository.save(salon);
		salon=new Salon();
		salonList = salonRepository.findAll();
	}
	
	public void salonSil(Long id) {
		Salon s = salonRepository.findOne(id);
		salonRepository.delete(s);
		salonList = salonRepository.findAll();
	}
	
	public List<Salon> getSalonList() {
		return salonList;
	}
	
	public void setSalonList(List<Salon> salonList) {
		this.salonList = salonList;
	}
	
	public Salon getSalon() {
		return salon;
	}
	
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	
	
}
