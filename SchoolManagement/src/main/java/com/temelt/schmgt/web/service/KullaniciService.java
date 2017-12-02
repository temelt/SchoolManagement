package com.temelt.schmgt.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.entity.kullanici.Kullanici;

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
}
