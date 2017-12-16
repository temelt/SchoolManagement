/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.schmgt.web.entity.ogretmen;

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
import com.temelt.schmgt.web.entity.ogrenciisleri.Ogrenci;

/**
 *
 * @author vektorel
 */
@Entity	
@Table(name = "attendance_detail")
public class YoklamaDetay extends BaseEntity {

	private Long id;
	private Yoklama yoklama;
	private Ogrenci ogrenci;
	private Boolean geldi;
	

	@Id
	@SequenceGenerator(name = "seq_attendance", allocationSize = 1, sequenceName = "seq_attendance")
	@GeneratedValue(generator = "seq_attendance", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "attendence_id")
	public Yoklama getYoklama() {
		return yoklama;
	}

	public void setYoklama(Yoklama yoklama) {
		this.yoklama = yoklama;
	}
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}
	
	@Column(name="here")
	public Boolean getGeldi() {
		return geldi;
	}
	
	public void setGeldi(Boolean geldi) {
		this.geldi = geldi;
	}
}
