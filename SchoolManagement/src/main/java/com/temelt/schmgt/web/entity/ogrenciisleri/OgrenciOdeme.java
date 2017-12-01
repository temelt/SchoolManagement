/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.schmgt.web.entity.ogrenciisleri;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.temelt.schmgt.web.entity.BaseEntity;
import com.temelt.schmgt.web.entity.yonetim.Kurs;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "student_payment")
public class OgrenciOdeme extends BaseEntity{

    private Long id;
    private String aciklama;
    private BigDecimal odemeMiktari;
    private Ogrenci ogrenci;
    private Date odemeTarihi;

    @Id
    @SequenceGenerator(name = "seq_student_payment", allocationSize = 1, sequenceName = "seq_student_payment")
    @GeneratedValue(generator = "seq_student_payment", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "description", length = 400)
    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Column(name = "quantity", scale = 2, precision = 14)
    public BigDecimal getOdemeMiktari() {
        return odemeMiktari;
    }

    public void setOdemeMiktari(BigDecimal odemeMiktari) {
        this.odemeMiktari = odemeMiktari;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    @Column(name = "quantity_date")
    public Date getOdemeTarihi() {
        return odemeTarihi;
    }

    public void setOdemeTarihi(Date odemeTarihi) {
        this.odemeTarihi = odemeTarihi;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof OgrenciOdeme){
    		if(((OgrenciOdeme)obj).getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }
 
    

}
