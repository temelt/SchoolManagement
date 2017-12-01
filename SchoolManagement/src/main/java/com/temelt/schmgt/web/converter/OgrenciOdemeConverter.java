package com.temelt.schmgt.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.temelt.schmgt.web.data.repository.OgrenciOdemeRepository;
import com.temelt.schmgt.web.entity.ogrenciisleri.OgrenciOdeme;


@Scope(value = "request")
@Controller("ogrenciOdemeConverter")
public class OgrenciOdemeConverter implements Converter {
	
	@Autowired
	private OgrenciOdemeRepository ogrenciOdemeRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				OgrenciOdeme ent = ogrenciOdemeRepository.findOne(new Long(value));
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
		if (value != null && !value.equals("null") && value instanceof OgrenciOdeme) {
			return String.valueOf(((OgrenciOdeme) value).getId());
		} else {
			return null;
		}
	}

}
