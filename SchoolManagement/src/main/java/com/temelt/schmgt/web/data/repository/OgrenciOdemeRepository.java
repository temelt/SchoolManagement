package com.temelt.schmgt.web.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.temelt.schmgt.web.entity.ogrenciisleri.OgrenciOdeme;

public interface OgrenciOdemeRepository extends JpaRepository<OgrenciOdeme, Long> {


}
