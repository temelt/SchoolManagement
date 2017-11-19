package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.kullanici.Kullanici;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long>{
	
	List<Kullanici> getAllByOrderByIdAsc();
	
	Kullanici getByKullaniciAdi(String kullaniciAdi);
	
	Page<Kullanici> findAllByOrderByIdAsc(Pageable pageable);
	
}
