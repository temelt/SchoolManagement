package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.GelirMuhasebeRepository;
import com.temelt.schmgt.web.entity.muhasebe.Gelir;


@Controller("gelirController")
@Scope("session")
public class GelirController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GelirMuhasebeRepository gelirRepository;

	private List<Gelir> gelirList;
	private Gelir gelir;

	@PostConstruct
	private void init() {
		gelirList = gelirRepository.findAll();
		gelir = new Gelir();
	}

	public void gelirKaydet() {
		System.out.println("Kullanýcý Kaydettik");
		gelirRepository.save(gelir);
		gelir = new Gelir();
		gelirList = gelirRepository.findAll();
	}

	public void gelirSil(Long id) {
		Gelir k = gelirRepository.findOne(id);
		gelirRepository.delete(k);
		gelirList = gelirRepository.findAll();
	}

	public void giderGuncelle(Long id, String konu, BigDecimal miktar, Date tarih) {

		Gelir g = gelirRepository.findOne(id);
		g.setKonu(konu);
		g.setTarih(tarih);
		g.setMiktar(miktar);
		gelirRepository.save(g);

	}

	public List<Gelir> getGelirList() {
		return gelirList;
	}

	public void setGelirList(List<Gelir> gelirlist) {
		this.gelirList = gelirlist;
	}

	public Gelir getGelir() {
		return gelir;
	}

	public void setGelir(Gelir gelir) {
		this.gelir = gelir;
	}

}
