package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.GrupRepository;
import com.temelt.schmgt.web.data.repository.OgrenciGrupRepository;
import com.temelt.schmgt.web.data.repository.YoklamaRepository;
import com.temelt.schmgt.web.entity.ogrenciisleri.OgrenciGrup;
import com.temelt.schmgt.web.entity.ogretmen.Yoklama;
import com.temelt.schmgt.web.entity.ogretmen.YoklamaDetay;
import com.temelt.schmgt.web.entity.yonetim.Grup;

@Controller("yoklamaController")
@Scope("session")
public class YoklamaController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private YoklamaRepository yoklamaRepository;
	
	@Autowired
	private GrupRepository grupRepository;
	
	@Autowired
	private OgrenciGrupRepository ogrenciGrupRepository; 

	private List<Grup> grups;
	private Yoklama yoklama;
	private YoklamaDetay yoklamaDetay;
	private List<OgrenciGrup> ogrenciGrups;
	private List<Long> gelenOgrenciler;

	@PostConstruct
	private void init() {
		grups = grupRepository.findAll();
		yoklama = new Yoklama();
		yoklamaDetay= new YoklamaDetay();
	}	
	
	public void yoklamaAl() {
		System.out.println("yoklamaPanelGorunsun çaðrýldý");
		ogrenciGrups = ogrenciGrupRepository.getByGrupId(yoklama.getGrup().getId());
	}

	public List<Grup> getGrups() {
		return grups;
	}

	public Yoklama getYoklama() {
		return yoklama;
	}

	public void setYoklama(Yoklama yoklama) {
		this.yoklama = yoklama;
	}

	public YoklamaDetay getYoklamaDetay() {
		return yoklamaDetay;
	}
	
	public void setYoklamaDetay(YoklamaDetay yoklamaDetay) {
		this.yoklamaDetay = yoklamaDetay;
	}
	
	public List<OgrenciGrup> getOgrenciGrups() {
		return ogrenciGrups;
	}
	
	public List<Long> getGelenOgrenciler() {
		return gelenOgrenciler;
	}
	
	public void setGelenOgrenciler(List<Long> gelenOgrenciler) {
		this.gelenOgrenciler = gelenOgrenciler;
	}
}
