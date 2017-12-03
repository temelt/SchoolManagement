package com.temelt.schmgt.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.entity.kullanici.Kullanici;
	
@SuppressWarnings("deprecation")
@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private KullaniciRepository kullaniciRepository;
	
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kullanici kullanici = kullaniciRepository.getByKullaniciAdi(username);
		List<GrantedAuthority> authorities =new ArrayList<>();
		GrantedAuthorityImpl authority=new GrantedAuthorityImpl("USER");
		GrantedAuthorityImpl authority2=new GrantedAuthorityImpl(kullanici.getRol().name());
		authorities.add(authority);
		authorities.add(authority2);
		User user =new User(kullanici.getKullaniciAdi(), kullanici.getSifre(),true,true,true,true,authorities );
		return user;
	}

}
