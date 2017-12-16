package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.ik.Ogretmen;
@Repository

public interface IkOgretmenRepository extends JpaRepository<Ogretmen , Long> {

	List<Ogretmen>getAllByOrderByIdAsc();
	List<Ogretmen> getByAd(String ad);

}
