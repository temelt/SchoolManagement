package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.entity.ogrenciisleri.OgrenciGrup;

@Repository
public interface OgrenciGrupRepository extends JpaRepository<OgrenciGrup, Long>{

	List<OgrenciGrup> getByGrupId(Long grupId);
}
