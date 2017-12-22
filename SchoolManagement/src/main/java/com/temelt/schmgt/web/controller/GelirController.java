package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.GelirMuhasebeRepository;
import com.temelt.schmgt.web.data.repository.OgrenciOdemeRepository;
import com.temelt.schmgt.web.data.repository.OgrenciRepository;
import com.temelt.schmgt.web.entity.ik.Ogretmen;
import com.temelt.schmgt.web.entity.muhasebe.Gelir;
import com.temelt.schmgt.web.entity.ogrenciisleri.Ogrenci;
import com.temelt.schmgt.web.entity.ogrenciisleri.OgrenciOdeme;
import com.temelt.schmgt.web.exceptions.BigDecimalException;
import com.temelt.schmgt.web.exceptions.GelirMuhasebeException;
import com.temelt.schmgt.web.ws.DovizWs;



@Controller("gelirController")
@Scope("session")
public class GelirController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GelirMuhasebeRepository gelirRepository;
	@Autowired
	private OgrenciOdemeRepository ogrenciOdemeRepository;
	@Autowired
	private OgrenciRepository ogrenciRepository;

	private Gelir gelir;
	private LazyDataModel<Gelir> lazyModel;
	private List<OgrenciOdeme> listeOgrenciOdeme;
	private List<Ogrenci> listeOgrenci;
	private String doviz;



	@PostConstruct
	private void init() {
		listele();
		gelir = new Gelir();
		listeOgrenciOdeme=ogrenciOdemeRepository.findAll();
		listeOgrenci=ogrenciRepository.findAll();
          System.out.println("init edildi gelir controller");
	}
	
	private void listele(){
		lazyModel=new LazyDataModel<Gelir>() {
		
			/**
			 * 
			 */
			private static final long serialVersionUID = 912536297379318078L;

			@Override
			public List<Gelir> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
			
				PageRequest pageRequest =new PageRequest(first/pageSize, pageSize);
				
				Page<Gelir> liste = gelirRepository.findAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				listeOgrenciOdeme=ogrenciOdemeRepository.findAll();
				listeOgrenci=ogrenciRepository.findAll();
				return liste.getContent();
			}
		};
	}
	


	public void gelirKaydet()  {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(!gelir.getKonu().isEmpty()&&gelir.getMiktar() instanceof BigDecimal){
				System.out.println("Gelir Kaydettik");
			gelirRepository.save(gelir);
			listele();
	        context.addMessage(null, new FacesMessage("KAYIT",  "Kayýt Eklendi" ) );
			}
			else{
				throw new GelirMuhasebeException(null);			
			}
			
		} catch (GelirMuhasebeException e){
		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA",  "Kayýt Eklenemedi" ) );
		}
        gelir=new Gelir();
        

	}

	public void gelirSil(Long id)  {
		Gelir k = gelirRepository.findOne(id);
		gelirRepository.delete(k);
		listele();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("KAYIT",  "Kayýt Silindi" ) );
		System.out.println("kayýt sýldýk");
		
	}

	
	public void yenileGelir(){
		gelir =new Gelir();
		System.out.println("geliride yeniledik");
	}

	public void gelirGuncelle(Long id) {
		gelir = gelirRepository.findOne(id);

	}
	
	public void dovizAl() throws MalformedURLException, RemoteException, ServiceException, SOAPException{
//		String d="";
	//    doviz=new DovizWs().getDoviz(d);
	//   System.out.println("---------------"+" Dovuz = "+doviz);
	}
	
	public String getDoviz() {
		return doviz;
	}
	
	public LazyDataModel<Gelir> getLazyModel() {
		return lazyModel;
	}

	public Gelir getGelir() {
		return gelir;
	}

	public void setGelir(Gelir gelir) {
		this.gelir = gelir;
	}
	
	public List<OgrenciOdeme> getListeOgrenciOdeme() {
		return listeOgrenciOdeme;
	}

	public void setListeOgrenciOdeme(List<OgrenciOdeme> listeOgrenciOdeme) {
		this.listeOgrenciOdeme = listeOgrenciOdeme;
	}

	public List<Ogrenci> getListeOgrenci() {
		return listeOgrenci;
	}

	public void setListeOgrenci(List<Ogrenci> listeOgrenci) {
		this.listeOgrenci = listeOgrenci;
	}

}
