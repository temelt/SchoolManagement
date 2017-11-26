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

import com.temelt.schmgt.web.data.repository.GrupRepository;
import com.temelt.schmgt.web.data.repository.IkOgretmenRepository;
import com.temelt.schmgt.web.data.repository.KursRepository;
import com.temelt.schmgt.web.data.repository.SalonRepository;
import com.temelt.schmgt.web.entity.ik.Ogretmen;
import com.temelt.schmgt.web.entity.yonetim.Grup;
import com.temelt.schmgt.web.entity.yonetim.Kurs;
import com.temelt.schmgt.web.entity.yonetim.Salon;

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
	@Autowired
	private IkOgretmenRepository ogretmenRepository;
	@Autowired
	private KursRepository kursRepository;

	LazyDataModel<Grup> lazyModel;

	private List<Salon> salonList;
	private List<Kurs> kursList;

	private Grup grup;

	@PostConstruct
	private void init() {
		listele();
		grup = new Grup();
		salonList= salonRepository.findAll();
		kursList=kursRepository.findAll();
	}
	
	public List<Ogretmen> ogretmenAcomp(String query) {
		List<Ogretmen> liste = ogretmenRepository.getByAd(query);
		return liste;
	}
	
	public void yeni() {
		grup=new Grup();
	}
	
	public void sil(Long id) {
		Grup k = grupRepository.findOne(id);
		grupRepository.delete(k);
		listele();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("KAYIT",  "Kayýt Silindi" ) );
	}
	
	public void guncelle(Long id) {
		grup = grupRepository.findOne(id);
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

	public List<Salon> getSalonList() {
		return salonList;
	}

	public void setSalonList(List<Salon> salonList) {
		this.salonList = salonList;
	}

	public List<Kurs> getKursList() {
		return kursList;
	}

	public void setKursList(List<Kurs> kursList) {
		this.kursList = kursList;
	}

	public Grup getGrup() {
		return grup;
	}

	public void setGrup(Grup grup) {
		this.grup = grup;
	}

	public void setLazyModel(LazyDataModel<Grup> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	
}
