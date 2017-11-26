/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.schmgt.web.entity.kullanici;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.temelt.schmgt.web.entity.BaseEntity;

import lombok.EqualsAndHashCode;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "usr")
@EqualsAndHashCode(callSuper=false)
public class Kullanici extends BaseEntity{
    @Id
    @SequenceGenerator(name = "seq_usr", allocationSize = 1, sequenceName = "seq_usr")
    @GeneratedValue(generator = "seq_usr", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "usrname", length = 30, unique = true)
    private String kullaniciAdi;
    
    @Column(name = "pwd", length = 30)
    private String sifre;
    
    @Column(name = "membership_date")
    private Date uyelikTarihi;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @Column(name = "name", length = 30)
    private String ad;
    
    @Column(name = "surname", length = 30)
    private String soyad;
    
    @Column()
    @Enumerated
    private Rol rol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public Date getUyelikTarihi() {
		return uyelikTarihi;
	}

	public void setUyelikTarihi(Date uyelikTarihi) {
		this.uyelikTarihi = uyelikTarihi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
    
    
}
