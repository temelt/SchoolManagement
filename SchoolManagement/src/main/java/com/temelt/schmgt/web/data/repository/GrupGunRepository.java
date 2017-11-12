package com.temelt.schmgt.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.yonetim.GrupGun;

@Repository
public interface GrupGunRepository extends JpaRepository<GrupGun, Long>{

}
