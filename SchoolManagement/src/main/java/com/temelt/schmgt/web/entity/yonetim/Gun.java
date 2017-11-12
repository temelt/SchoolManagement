package com.temelt.schmgt.web.entity.yonetim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.temelt.schmgt.web.entity.BaseEntity;

@Entity
@Table(name = "lessons")
public class Gun extends BaseEntity{

    private Long id;
    private int gun1;
    private int gun2;
    private int gun3;
    private int gun4;
    private int gun5;
    private int gun6;
    private int gun7;

    @Id
    @SequenceGenerator(name = "seq_lessons", allocationSize = 1, sequenceName = "seq_lessons")
    @GeneratedValue(generator = "seq_lessons", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "day1")
    public int getGun1() {
        return gun1;
    }

    public void setGun1(int gun1) {
        this.gun1 = gun1;
    }

    @Column(name = "day21")
    public int getGun2() {
        return gun2;
    }

    public void setGun2(int gun2) {
        this.gun2 = gun2;
    }

    @Column(name = "day3")
    public int getGun3() {
        return gun3;
    }

    public void setGun3(int gun3) {
        this.gun3 = gun3;
    }

    @Column(name = "day4")
    public int getGun4() {
        return gun4;
    }

    public void setGun4(int gun4) {
        this.gun4 = gun4;
    }

    @Column(name = "day5")
    public int getGun5() {
        return gun5;
    }

    public void setGun5(int gun5) {
        this.gun5 = gun5;
    }

    @Column(name = "day6")
    public int getGun6() {
        return gun6;
    }

    public void setGun6(int gun6) {
        this.gun6 = gun6;
    }

    @Column(name = "day7")
    public int getGun7() {
        return gun7;
    }

    public void setGun7(int gun7) {
        this.gun7 = gun7;
    }

}
