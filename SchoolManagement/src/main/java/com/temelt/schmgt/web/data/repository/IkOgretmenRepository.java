package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.ik.Ogretmen;
@Repository

public interface IkOgretmenRepository extends JpaRepository<Ogretmen , Long> {

	@Query(value="select * from teacher where name ilike %?1% or surname ilike %?1%",nativeQuery=true)
	List<Ogretmen> getByAd(String query);

}
