package com.temelt.schmgt.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.GelirMuhasebeRepository;
import com.temelt.schmgt.web.entity.muhasebe.Gelir;

@Scope(value = "request")
@Controller("gelirMuhasebeConverter")
public class GelirMuhasebeConverter implements Converter {
	
	private GelirMuhasebeRepository gelirMuhasebeRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				Gelir ent = gelirMuhasebeRepository.findOne(new Long(value));
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
		if (value != null && !value.equals("null") && value instanceof Gelir) {
			return String.valueOf(((Gelir) value).getId());
		} else {
			return null;
		}
	}

}
