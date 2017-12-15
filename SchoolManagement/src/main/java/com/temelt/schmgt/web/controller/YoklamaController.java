package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.temelt.schmgt.web.data.repository.YoklamaRepository;
import com.temelt.schmgt.web.entity.ogretmen.Yoklama;
import com.temelt.schmgt.web.entity.ogretmen.YoklamaDetay;

@Controller("yoklamaController ")
@Repository("session")
public class YoklamaController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private YoklamaRepository yoklamaRepository;
	
	private List<Yoklama> yoklamaList;
	
	private Yoklama yoklama;
	
	private LazyDataModel<Yoklama> lazyModel;
	
	public void listele() {
		lazyModel = new LazyDataModel<Yoklama>() {
			@Override
			public List<Yoklama> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first/pageSize, pageSize);
				Page<Yoklama> liste = yoklamaRepository.findAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int)liste.getTotalElements());
				return liste.getContent();
			}
		};
		yoklamaList = yoklamaRepository.findAllByOrderByIdAsc();
	}
	
	@PostConstruct
	private void init() {
		yoklamaList = yoklamaRepository.findAllByOrderByIdAsc();
		yoklama = new Yoklama();
	}
	
	public List<Yoklama> getYoklamaList() {
		return yoklamaList;
	}
	
	public void setYoklamaList(List<Yoklama> yoklamaList) {
		this.yoklamaList = yoklamaList;
	}
	
	public Yoklama getYoklama() {
		return yoklama;
	}
	
	public void setYoklama(Yoklama yoklama) {
		this.yoklama = yoklama;
	}
	
	public LazyDataModel<Yoklama> getLazyModel() {
		return lazyModel;
	}

}
