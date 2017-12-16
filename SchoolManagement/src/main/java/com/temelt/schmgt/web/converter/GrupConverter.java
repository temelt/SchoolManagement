package com.temelt.schmgt.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.GrupRepository;
import com.temelt.schmgt.web.entity.yonetim.Grup;

@Scope(value = "request")
@Controller("grupConverter")
public class GrupConverter implements Converter {

	@Autowired
	private GrupRepository grupRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				Grup	 ent = grupRepository.findOne(new Long(value));
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
		if (value != null && !value.equals("null") && value instanceof Grup) {
			return String.valueOf(((Grup) value).getId());
		} else {
			return null;
		}
	}

}
