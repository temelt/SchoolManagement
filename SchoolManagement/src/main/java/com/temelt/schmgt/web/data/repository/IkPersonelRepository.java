package com.temelt.schmgt.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.temelt.schmgt.web.entity.ik.Personel;
@Repository

public interface IkPersonelRepository extends JpaRepository<Personel , Long>  {

}
