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

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "usr")
@Data
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
}
