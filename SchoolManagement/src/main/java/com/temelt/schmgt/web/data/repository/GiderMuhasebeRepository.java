package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.temelt.schmgt.web.entity.muhasebe.Gider;

@Repository
public interface GiderMuhasebeRepository extends JpaRepository<Gider, Long> {
	
	 List<Gider> getAllByOrderByIdAsc();
		
		Gider getByKonu(String konu);

}
