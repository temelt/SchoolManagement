package com.temelt.schmgt.web.data.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.temelt.schmgt.web.entity.muhasebe.Gelir;

@Repository
public interface GelirMuhasebeRepository extends JpaRepository<Gelir, Long> {

   List<Gelir> getAllByOrderByIdAsc();
	
	Gelir getByKonu(String konu);
	
	Page<Gelir> findAllByOrderByIdAsc(Pageable pageable);
	
	
	
	  @Query(value="select * from income  where date >= :from and date <= :to ",nativeQuery=true)
	  List<Gelir> getAllByDateBetween(@Param("from") Date from, @Param("to") Date to);
		
//		@Modifying
//	    @Transactional
//	    @Query(value="select d from income  where date >= :from and date <= :to ",nativeQuery=true)
//	    List<Gelir> getAllByDateBetween(@Param("from") Date from, @Param("to") Date to);
	//	@Modifying
	//    @Transactional  
	//    @Query(value="select SUM(quantity) from income  where date >= :from and date <= :to ",nativeQuery=true)
	//      int get12(@Param("from") Date from, @Param("to") Date to);
	  @Query(value="select SUM(quantity) from income  where date >= :from and date <= :to ",nativeQuery=true)
		      BigDecimal getAllCountSumQuantity(@Param("from") Date from, @Param("to") Date to);
	  
	
}
