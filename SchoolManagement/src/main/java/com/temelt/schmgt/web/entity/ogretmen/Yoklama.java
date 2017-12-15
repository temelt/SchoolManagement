/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temelt.schmgt.web.entity.ogretmen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.temelt.schmgt.web.entity.BaseEntity;
import com.temelt.schmgt.web.entity.yonetim.Grup;

/**
 *
 * @author vektorel
 */
@Entity
@Table(name = "sch_attendance")
public class Yoklama extends BaseEntity {

    private Long id;
    private Grup grup;	

    @Id
    @SequenceGenerator(name = "seq_student_attendance", allocationSize = 1, sequenceName = "seq_student_attendance")
    @GeneratedValue(generator = "seq_student_attendance", strategy = GenerationType.SEQUENCE)
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
}
