package com.temelt.schmgt.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.temelt.schmgt.web.entity.ik.Ogretmen;
@Repository

public interface IkOgretmenRepository extends JpaRepository<Ogretmen , Long> {

}
