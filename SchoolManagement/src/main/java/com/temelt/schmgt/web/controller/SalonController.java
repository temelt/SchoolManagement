package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.SalonRepository;
import com.temelt.schmgt.web.entity.yonetim.Salon;

@Controller("salonController")
@Scope("session")
public class SalonController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2810630239779092550L;

	@Autowired
	private SalonRepository salonRepository;

	private Salon salon;
	private LazyDataModel<Salon> lazyModel;

	@PostConstruct
	private void init() {
		listele();
		salon = new Salon();
	}

	public void yeni() {
		salon = new Salon();

	}
	
	public void salonKaydet() {
		salonRepository.save(salon);
		listele();
	}

	public void salonSil(Long id) {
		Salon s = salonRepository.findOne(id);
		salonRepository.delete(s);
		listele();
	}

	public void SalonGuncelle(Long id) {
		salon = salonRepository.findOne(id);
		listele();
	}

	private void listele() {

		lazyModel = new LazyDataModel<Salon>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8508373796609952273L;

			@Override
			public List<Salon> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				PageRequest pageRequest = new PageRequest(first / pageSize, pageSize);

				Page<Salon> liste = salonRepository.findAll(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}

		};
	}

	public Salon getSalon() {
		return salon;
	}

	public LazyDataModel<Salon> getLazyModel() {
		return lazyModel;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

}
