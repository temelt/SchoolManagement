package com.temelt.schmgt.web.entity.yonetim;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.temelt.schmgt.web.entity.BaseEntity;

@Entity
@Table(name = "group_day")
public class GrupGun extends BaseEntity{

    private Long id;
    private Grup grup;
    private Gun gun;

    @Id
    @SequenceGenerator(name = "seq_group_day", allocationSize = 1, sequenceName = "seq_group_day")
    @GeneratedValue(generator = "seq_group_day", strategy = GenerationType.SEQUENCE)
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

    @ManyToOne
    @JoinColumn(name = "days_id")
    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

}
