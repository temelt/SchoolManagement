package com.temelt.schmgt.web.data.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.temelt.schmgt.web.entity.muhasebe.Gider;

@Repository
public interface GiderMuhasebeRepository extends JpaRepository<Gider, Long> {
	
	 List<Gider> getAllByOrderByIdAsc();
		
		Gider getByKonu(String konu);
		
		@Query(value="select SUM(quantity) from expense  where date >= :from and date <= :to ",nativeQuery=true)
	      BigDecimal getAllCountSumQuantity(@Param("from") Date from, @Param("to") Date to);

}
