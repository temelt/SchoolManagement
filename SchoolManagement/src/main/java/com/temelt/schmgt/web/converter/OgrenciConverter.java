package com.temelt.schmgt.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.temelt.schmgt.web.data.repository.OgrenciRepository;
import com.temelt.schmgt.web.entity.ogrenciisleri.Ogrenci;


@Scope(value = "request")
@Controller("ogrenciConverter")
public class OgrenciConverter implements Converter {

	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				Ogrenci ent = ogrenciRepository.findOne(new Long(value));
				return ent;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("null") && value instanceof Ogrenci) {
			return String.valueOf(((Ogrenci) value).getId());
		} else {
			return null;
		}
	}

}
