package com.temelt.schmgt.web.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.ogretmen.YoklamaDetay;

@Repository
@Transactional
public interface YoklamaDetayRepository extends JpaRepository<YoklamaDetay, Long>{
	List<YoklamaDetay> findAllByOrderByIdAsc();
	Page<YoklamaDetay> findAllByOrderByIdAsc(Pageable pageable);

}
