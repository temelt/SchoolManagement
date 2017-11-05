package com.temelt.schmgt.web.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	private String ekleyen;
	private String guncelleyen;
	private Date eklemeTarihi;
	private Date guncellemeTarihi;
	private Boolean kayitDurumu;

	@Column(name = "created_by", length = 20)
	public String getEkleyen() {
		return ekleyen;
	}

	public void setEkleyen(String ekleyen) {
		this.ekleyen = ekleyen;
	}

	@Column(name = "updated_by", length = 20)
	public String getGuncelleyen() {
		return guncelleyen;
	}

	public void setGuncelleyen(String guncelleyen) {
		this.guncelleyen = guncelleyen;
	}

	@Column(name = "created_at")
	public Date getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(Date eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

	@Column(name = "updated_at")
	public Date getGuncellemeTarihi() {
		return guncellemeTarihi;
	}

	public void setGuncellemeTarihi(Date guncellemeTarihi) {
		this.guncellemeTarihi = guncellemeTarihi;
	}

	@Column(name = "record_state")
	public Boolean getKayitDurumu() {
		return kayitDurumu;
	}

	public void setKayitDurumu(Boolean kayitDurumu) {
		this.kayitDurumu = kayitDurumu;
	}

}
