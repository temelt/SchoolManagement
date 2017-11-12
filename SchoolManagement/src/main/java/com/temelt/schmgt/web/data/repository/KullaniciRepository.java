package com.temelt.schmgt.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.kullanici.Kullanici;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long>{

}
