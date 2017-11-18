package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.entity.muhasebe.Gelir;
import com.temelt.schmgt.web.entity.muhasebe.Gider;

import com.temelt.schmgt.web.data.repository.GiderMuhasebeRepository;

@Controller("giderController")
@Scope("session")
public class GiderController implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GiderMuhasebeRepository giderRepository;
	
	private List<Gider> giderList;
	private Gider gider;
	
	

	@PostConstruct
	private void init() {		
		giderList=giderRepository.getAllByOrderByIdAsc();
		gider = new Gider();
	}
	
	public void giderKaydet(){
		System.out.println("Gider Kaydettik");
		giderRepository.save(gider);
		gider =new Gider();
		giderList=giderRepository.getAllByOrderByIdAsc();

	}
	
	public void giderSil(Long id){
		Gider g=giderRepository.findOne(id);
		giderRepository.delete(g);
		giderList=giderRepository.getAllByOrderByIdAsc();

	}
	
	public void giderGuncelle(Long id) {
		gider = giderRepository.findOne(id);
		

	}
	
	public List<Gider> getGiderList() {
		return giderList;
	}

	public void setGiderList(List<Gider> giderList) {
		this.giderList = giderList;
	}

	public Gider getGider() {
		return gider;
	}

	public void setGider(Gider gider) {
		this.gider = gider;
	}
	
	
	

}
