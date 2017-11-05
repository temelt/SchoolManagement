package com.temelt.schmgt.web.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.temelt.schmgt.web.entity.Kisi;

@Repository
@Transactional
public interface KisiRepository extends JpaRepository<Kisi, Long> {

}
