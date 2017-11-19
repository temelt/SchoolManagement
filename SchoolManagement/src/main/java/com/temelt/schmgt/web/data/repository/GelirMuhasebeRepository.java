package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.muhasebe.Gelir;

@Repository
public interface GelirMuhasebeRepository extends JpaRepository<Gelir, Long> {

   List<Gelir> getAllByOrderByIdAsc();
	
	Gelir getByKonu(String konu);
}
