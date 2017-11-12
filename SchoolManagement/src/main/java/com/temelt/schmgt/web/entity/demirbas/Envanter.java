/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.schmgt.web.entity.demirbas;

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

import com.temelt.schmgt.web.entity.muhasebe.Gider;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "inventory")
public class Envanter {

    private Long id;
    private String tanim;
    private String aciklama;
    private Boolean garanti;
    private Date garantiBaslamaTarihi;
    private Date garantiBitisTarihi;
    private Gider gider;

    @Id
    @SequenceGenerator(name = "seq_inventory", allocationSize = 1, sequenceName = "seq_inventory")
    @GeneratedValue(generator = "seq_inventory", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "caption", length = 100)
    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    @Column(name = "description", length = 400)
    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Column(name = "warranty")
    public Boolean getGaranti() {
        return garanti;
    }

    public void setGaranti(Boolean garanti) {
        this.garanti = garanti;
    }

    @Column(name = "warranty_start_date")
    public Date getGarantiBaslamaTarihi() {
        return garantiBaslamaTarihi;
    }

    public void setGarantiBaslamaTarihi(Date garantiBaslamaTarihi) {
        this.garantiBaslamaTarihi = garantiBaslamaTarihi;
    }

    @Column(name = "warranty_end_date")
    public Date getGarantiBitisTarihi() {
        return garantiBitisTarihi;
    }

    public void setGarantiBitisTarihi(Date garantiBitisTarihi) {
        this.garantiBitisTarihi = garantiBitisTarihi;
    }

    @ManyToOne
    @JoinColumn(name = "exspense_id")
    public Gider getGider() {
        return gider;
    }

    public void setGider(Gider gider) {
        this.gider = gider;
    }

    @Override
    public String toString() {
        return  "tanimi = "+tanim+ " id = "+id;
    }
    

}
