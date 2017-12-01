package com.temelt.schmgt.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temelt.schmgt.web.entity.ogrenciisleri.Ogrenci;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

}
