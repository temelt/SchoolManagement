/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.schmgt.web.entity.ogretmen;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.temelt.schmgt.web.entity.BaseEntity;
import com.temelt.schmgt.web.entity.yonetim.Grup;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "attendance")
public class YoklamaFormu extends BaseEntity {

	private Long id;
	private String yoklamaAciklama;
	private String islenenKonu;
	private Grup grup;
	private YoklamaBilgileri yoklamaBilgileri;
	private Date yoklamaTarihi;
	private Date dersTarihi;

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
	@JoinColumn(name = "group_id")
	public Grup getGrup() {
		return grup;
	}

	public void setGrup(Grup grup) {
		this.grup = grup;
	}

	@Column(name = "inspection_description", length = 100)
	public String getYoklamaAciklama() {
		return yoklamaAciklama;
	}

	public void setYoklamaAciklama(String yoklamaAciklama) {
		this.yoklamaAciklama = yoklamaAciklama;
	}

	@Column(name = "lesson_subject", length = 100)
	public String getIslenenKonu() {
		return islenenKonu;
	}

	public void setIslenenKonu(String islenenKonu) {
		this.islenenKonu = islenenKonu;
	}

	@ManyToOne
	@JoinColumn(name = "inspection_info_id")
	public YoklamaBilgileri getYoklamaBilgileri() {
		return yoklamaBilgileri;
	}

	public void setYoklamaBilgileri(YoklamaBilgileri yoklamaBilgileri) {
		this.yoklamaBilgileri = yoklamaBilgileri;
	}

	@Column(name = "inspection_date")
	@Temporal(TemporalType.DATE)
	public Date getYoklamaTarihi() {
		return yoklamaTarihi;
	}

	public void setYoklamaTarihi(Date yoklamaTarihi) {
		this.yoklamaTarihi = yoklamaTarihi;
	}

	@Column(name = "course_date")
	@Temporal(TemporalType.DATE)
	public Date getDersTarihi() {
		return dersTarihi;
	}

	public void setDersTarihi(Date dersTarihi) {
		this.dersTarihi = dersTarihi;
	}

}
