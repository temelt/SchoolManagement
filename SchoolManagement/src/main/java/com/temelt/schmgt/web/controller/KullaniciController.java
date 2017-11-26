package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.entity.kullanici.Kullanici;

@Controller("kullaniciController")
@Scope("session")
public class KullaniciController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private KullaniciRepository kullaniciRepository;

	private Kullanici kullanici;
	private LazyDataModel<Kullanici> lazyModel;

	@PostConstruct
	private void init() {
		listele();
		kullanici=new Kullanici();
		System.out.println("RUN TT");
	}

	public void kullaniciKaydet() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("Kullanýcý Kaydettik");
			kullaniciRepository.save(kullanici);
			listele();
	        context.addMessage(null, new FacesMessage("KAYIT",  "Kayýt Eklendi" ) );
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA",  "Kayýt Eklenemedi" ) );
		}
        kullanici=new Kullanici();
        
	}
	
	public void yeni() {
		kullanici=new Kullanici();
	}
	
	public void kullaniciSil(Long id) {
		Kullanici k = kullaniciRepository.findOne(id);
		kullaniciRepository.delete(k);
		listele();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("KAYIT",  "Kayýt Silindi" ) );
	}
	
	private void listele() {
		
		lazyModel =new LazyDataModel<Kullanici>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8508373796609952273L;

			@Override
			public List<Kullanici> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
			
				PageRequest pageRequest =new PageRequest(first/pageSize, pageSize);
				
				Page<Kullanici> liste = kullaniciRepository.findAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}
			
		};
	}

	public void kullaniciGuncelle(Long id) {
		kullanici = kullaniciRepository.findOne(id);
	}
	
	public Kullanici getKullanici() {
		return kullanici;
	}
	
	public LazyDataModel<Kullanici> getLazyModel() {
		return lazyModel;
	}
	
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
}
