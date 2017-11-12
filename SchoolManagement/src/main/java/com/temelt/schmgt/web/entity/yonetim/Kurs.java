package com.temelt.schmgt.web.entity.yonetim;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.temelt.schmgt.web.entity.BaseEntity;

@Entity
@Table(name = "course")
public class Kurs extends BaseEntity{

    Grup grup = new Grup();
    private Long id;
    private String adi;
    private Date baslamaTarihi = grup.getBaslamaTarihi();
    private BigDecimal fiyat; 

    @Id
    @SequenceGenerator(name = "seq_course", allocationSize = 1, sequenceName = "seq_course")
    @GeneratedValue(generator = "seq_course", strategy = GenerationType.SEQUENCE)
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

    @Column(name = "start_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getbaslamaTarihi() {
        return baslamaTarihi;
    }

    public void setbaslamaTarihi(Date baslamaTarihi) {
        this.baslamaTarihi = baslamaTarihi;
    }

    @Column(name = "price", precision = 14, scale = 2)
    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

}
