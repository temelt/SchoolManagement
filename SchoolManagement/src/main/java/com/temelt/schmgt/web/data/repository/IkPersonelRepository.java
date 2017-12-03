package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.temelt.schmgt.web.entity.ik.Personel;
@Repository

public interface IkPersonelRepository extends JpaRepository<Personel , Long>  {
	@Query(value="select * from teacher where name ilike %?1% or surname ilike %?1%",nativeQuery=true)
	List<Personel> getByAd(String query);
}
