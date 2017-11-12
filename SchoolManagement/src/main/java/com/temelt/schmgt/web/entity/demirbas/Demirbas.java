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

import com.temelt.schmgt.web.entity.ik.Ogretmen;
import com.temelt.schmgt.web.entity.ik.Personel;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "fixture")
public class Demirbas {

    private Long id;
    private String aciklama;
    private Date tarih;
    private Envanter envanter;
    private Personel personel;
    private Ogretmen ogretmen;

    @Id
    @SequenceGenerator(name = "seq_fixture", allocationSize = 1, sequenceName = "seq_fixture")
    @GeneratedValue(generator = "seq_fixture", strategy = GenerationType.SEQUENCE)
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

    @Column(name = "date")
    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    public Envanter getEnvanter() {
        return envanter;
    }

    public void setEnvanter(Envanter envanter) {
        this.envanter = envanter;
    }

    @ManyToOne
    @JoinColumn(name = "emplooye_id")
    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Ogretmen getOgretmen() {
        return ogretmen;
    }

    public void setOgretmen(Ogretmen ogretmen) {
        this.ogretmen = ogretmen;
    }

}
