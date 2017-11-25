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

import com.temelt.schmgt.web.data.repository.GrupRepository;
import com.temelt.schmgt.web.data.repository.SalonRepository;
import com.temelt.schmgt.web.entity.yonetim.Grup;
import com.temelt.schmgt.web.entity.yonetim.Salon;

import lombok.Getter;
import lombok.Setter;

@Controller("grupController")
@Scope("session")
public class GrupController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3320021334729261157L;

	@Autowired
	private GrupRepository grupRepository;
	@Autowired
	private SalonRepository salonRepository;

	
	LazyDataModel<Grup> lazyModel;
	
	@Getter
	private List<Salon> salonList;

	@Getter
	@Setter
	private Grup grup;

	@PostConstruct
	private void init() {
		listele();
		grup = new Grup();
		salonList= salonRepository.findAll();
	}

	public void listele() {
		lazyModel = new LazyDataModel<Grup>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 7014764454954767183L;

			@Override
			public List<Grup> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first / pageSize, pageSize);
				Page<Grup> liste = grupRepository.findAll(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}
		};
	}

	public void kaydet() {
		if (grup != null) {
			grupRepository.save(grup);
		}
		listele();
	}
	
	public LazyDataModel<Grup> getLazyModel() {
		return lazyModel;
	}
}
