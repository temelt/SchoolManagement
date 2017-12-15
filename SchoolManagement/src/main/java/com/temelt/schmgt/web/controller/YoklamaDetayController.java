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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.data.repository.KullaniciRepository;
import com.temelt.schmgt.web.data.repository.YoklamaDetayRepository;
import com.temelt.schmgt.web.entity.ogretmen.YoklamaDetay;

@Controller("yoklamaDetayController")
@Repository("session")
public class YoklamaDetayController implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private YoklamaDetayRepository yoklamaDetayRepository;

	private List<YoklamaDetay> yoklamaDetayList;
	
	private YoklamaDetay yoklamaDetay; 
	
	private LazyDataModel<YoklamaDetay> lazyModel;
	
	@PostConstruct
	private void init() {
		yoklamaDetayList= yoklamaDetayRepository.findAllByOrderByIdAsc();
		yoklamaDetay = new YoklamaDetay();
	}
	
	public void yoklamayýKaydet() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			yoklamaDetayRepository.save(yoklamaDetay);
			yoklamaDetay = new YoklamaDetay();
			yoklamaDetayList = yoklamaDetayRepository.findAllByOrderByIdAsc();
			listele();
			context.addMessage(null, new FacesMessage("YOKLAMA", "Yoklama Alýndý"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR ,"HATA", "Yoklama Alýnamadý"));
		}
		yoklamaDetay = new YoklamaDetay();
	}
	/*Yoklama alma iþleminde bu methoda ihtiyaç yok ama yinede burada dursun*/
	private void yoklamaSil(Long id) {
		YoklamaDetay yoklamaDetay = yoklamaDetayRepository.findOne(id);
		yoklamaDetayRepository.delete(yoklamaDetay);
		listele();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("YOKLAMA", "Yoklama Silindi"));
	}
	
	public void listele() {
		lazyModel = new LazyDataModel<YoklamaDetay>() {
			@Override
			public List<YoklamaDetay> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first/pageSize, pageSize);
				Page<YoklamaDetay> liste = yoklamaDetayRepository.findAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int)liste.getTotalElements());
				return liste.getContent();
			}
		};
	}
	
	public List<YoklamaDetay> getYoklamaDetayList() {
		return yoklamaDetayList;
	}
	
	public void setYoklamaDetayList(List<YoklamaDetay> yoklamaDetayList) {
		this.yoklamaDetayList = yoklamaDetayList;
	}
	
	public YoklamaDetay getYoklamaDetay() {
		return yoklamaDetay;
	}
	
	public void setYoklamaDetay(YoklamaDetay yoklamaDetay) {
		this.yoklamaDetay = yoklamaDetay;
	}
	
	public LazyDataModel<YoklamaDetay> getLazyModel() {
		return lazyModel;
	}
}
