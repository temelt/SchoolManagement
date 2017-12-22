package com.temelt.schmgt.web.converter;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



@Scope(value = "request")
@Controller("bigDecimalConverter")
public class BigDecimalConverter implements Converter {

	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0 && !value.equals("null")) {
			try {
				BigDecimal money = new BigDecimal(value.replaceAll(",", "."));
				return money;
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
		if (value != null && !value.equals("null") ) {
			return String.valueOf((value));
		} else {
			return null;
		}
	}
}
