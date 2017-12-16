package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.GrupRepository;
import com.temelt.schmgt.web.data.repository.OgrenciGrupRepository;
import com.temelt.schmgt.web.data.repository.YoklamaDetayRepository;
import com.temelt.schmgt.web.data.repository.YoklamaRepository;
import com.temelt.schmgt.web.entity.ogrenciisleri.Ogrenci;
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
	@Autowired
	private YoklamaDetayRepository yoklamaDetayRepository;

	private List<Grup> grups;
	private Yoklama yoklama;
	private List<OgrenciGrup> ogrenciGrups;
	private List<String> gelenOgrenciler;

	@PostConstruct
	private void init() {
		grups = grupRepository.findAll();
		yoklama = new Yoklama();
	}	
	
	public void yoklamaGetir() {
		System.out.println("yoklamaPanelGorunsun çaðrýldý");
		ogrenciGrups = ogrenciGrupRepository.getByGrupId(yoklama.getGrup().getId());
	}
	
	public void yoklamaKaydet() {
		yoklama = yoklamaRepository.save(yoklama);
		for (int i = 0; i < gelenOgrenciler.size(); i++) {
			YoklamaDetay detay =new YoklamaDetay();
			detay.setYoklama(yoklama);
			Ogrenci ogrenci =new Ogrenci();
			ogrenci.setId(Long.parseLong(gelenOgrenciler.get(i)));
			detay.setOgrenci(ogrenci);
			detay.setGeldi(Boolean.TRUE);
			yoklamaDetayRepository.save(detay);
		}
		
		ogrenciGrups = null;
		yoklama=new Yoklama();
		grups = grupRepository.findAll();
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
	
	public List<OgrenciGrup> getOgrenciGrups() {
		return ogrenciGrups;
	}
	
	public List<String> getGelenOgrenciler() {
		return gelenOgrenciler;
	}
	
	public void setGelenOgrenciler(List<String> gelenOgrenciler) {
		this.gelenOgrenciler = gelenOgrenciler;
	}
}
