package com.temelt.schmgt.web.entity.yonetim;

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
import com.temelt.schmgt.web.entity.ik.Ogretmen;

@Entity
@Table(name = "groups")
public class Grup extends BaseEntity{

    private Long id;
    private String adi;
    private Kurs kurs;
    private Ogretmen ogretmen;
    private int ogrenciSayisi;
    private Salon salon;
    private Date baslamaTarihi;
    private Date bitisTarihi;

    @Id
    @SequenceGenerator(name = "seq_group", allocationSize = 1, sequenceName = "seq_group")
    @GeneratedValue(generator = "seq_group", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Ogretmen getOgretmen() {
		return ogretmen;
	}
    
    public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

    @Column(name = "student_count")
    public int getOgrenciSayisi() {
        return ogrenciSayisi;
    }

    public void setOgrenciSayisi(int ogrenciSayisi) {
        this.ogrenciSayisi = ogrenciSayisi;
    }

    @ManyToOne
    @JoinColumn(name = "room_id")
    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    @Column(name = "start_date")
    public Date getBaslamaTarihi() {
        return baslamaTarihi;
    }

    public void setBaslamaTarihi(Date baslamaTarihi) {
        this.baslamaTarihi = baslamaTarihi;
    }

    @Column(name = "end_date")
    public Date getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(Date bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    @Override
    public String toString() {
        return "Grup{" + "id=" + id + ", adi=" + adi + ", kurs=" + kurs + ", Ogretmen=" + ogretmen + ", ogrenciSayisi=" + ogrenciSayisi + ", salon=" + salon + ", baslamaTarihi=" + baslamaTarihi + ", bitisTarihi=" + bitisTarihi + '}';
    }  
    
    
}
