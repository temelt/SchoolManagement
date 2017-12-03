package com.temelt.schmgt.web.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.entity.kullanici.Kullanici;
import com.temelt.schmgt.web.entity.kullanici.Rol;

@Service
public class KullaniciService {

	@Autowired
	private KullaniciRepository kullaniciRepository;

	
	public Kullanici save(Kullanici kullanici) {
		if(kullanici.getId()==null){
			Md5PasswordEncoder md5PasswordEncoder =new Md5PasswordEncoder();
			String md5Sifre = md5PasswordEncoder.encodePassword(kullanici.getSifre(), null);
			kullanici.setSifre(md5Sifre);		
		}
		return kullaniciRepository.save(kullanici);
	}
	
	@PostConstruct
	private void init() {
		long userCount = kullaniciRepository.count();
		if(userCount<1){
			Kullanici kullanici =new Kullanici();
			kullanici.setAd("Taner");
			kullanici.setSoyad("TEMEL");
			kullanici.setKullaniciAdi("admin");
			kullanici.setKayitDurumu(Boolean.TRUE);
			kullanici.setRol(Rol.ADMIN);
			kullanici.setUyelikTarihi(new Date());
			kullanici.setSifre("1");
			kullanici.setEmail("taner@schmgt.com");
			save(kullanici);
		}
	}
}
