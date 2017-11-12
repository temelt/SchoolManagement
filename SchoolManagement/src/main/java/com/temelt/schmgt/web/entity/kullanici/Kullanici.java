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

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "usr")
public class Kullanici extends BaseEntity{

    private Long id;
    private String kullaniciAdi;
    private String sifre;
    private Date uyelikTarihi;
    private String email;
    private String ad;
    private String soyad;
    private Rol rol;

    @Id
    @SequenceGenerator(name = "seq_usr", allocationSize = 1, sequenceName = "seq_usr")
    @GeneratedValue(generator = "seq_usr", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "usrname", length = 30, unique = true)
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    @Column(name = "pwd", length = 30)
    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Column(name = "membership_date")
    public Date getUyelikTarihi() {
        return uyelikTarihi;
    }

    public void setUyelikTarihi(Date uyelikTarihi) {
        this.uyelikTarihi = uyelikTarihi;
    }

    @Column(name = "email", length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name", length = 30)
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Column(name = "surname", length = 30)
    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Column()
    @Enumerated
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "id=" + id + ", kullaniciAdi=" + kullaniciAdi + ", sifre=" + sifre + ", uyelikTarihi=" + uyelikTarihi + ", email=" + email + ", ad=" + ad + ", soyad=" + soyad + ", rol=" + rol + '}';
    }

}
