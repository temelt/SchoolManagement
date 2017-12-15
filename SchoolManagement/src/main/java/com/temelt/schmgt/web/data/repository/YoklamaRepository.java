package com.temelt.schmgt.web.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.ogretmen.Yoklama;
import com.temelt.schmgt.web.entity.yonetim.Grup;

@Repository
public interface YoklamaRepository extends JpaRepository<Yoklama, Long> {
	List<Yoklama> findAllByOrderByIdAsc();
	Yoklama getByGrupAdi(Grup adi);
	Page<Yoklama> findAllByOrderByIdAsc(Pageable pageable);
}
