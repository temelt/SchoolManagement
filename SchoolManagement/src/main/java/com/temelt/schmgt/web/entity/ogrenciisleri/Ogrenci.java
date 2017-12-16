/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.schmgt.web.entity.ogrenciisleri;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.temelt.schmgt.web.entity.BaseEntity;
import com.temelt.schmgt.web.entity.CinsiyetEnum;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "student")
public class Ogrenci extends BaseEntity {

	private Long id;
	private String ad;
	private String soyad;
	private String adres;
	private String tel;
	private String mail;
	private Date kayitTarihi;
	private CinsiyetEnum cinsiyet;

	@Id
	@SequenceGenerator(name = "seq_student", allocationSize = 1, sequenceName = "seq_student")
	@GeneratedValue(generator = "seq_student", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Column(name = "surname", length = 50)
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Column(name = "address", length = 500)
	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Column(name = "phone", length = 13)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "email", length = 100)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "reg_date")
	public Date getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

	@Column(name = "gender")
	@Enumerated
	public CinsiyetEnum getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(CinsiyetEnum cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	@Transient	
	public String getAdSoyad() {
		return ad + " " + soyad;
	}

	@Override
	public String toString() {
		return "adi = " + ad + " soyadı = " + soyad + " id = " + id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ogrenci) {
			if (((Ogrenci) obj).getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}

}
