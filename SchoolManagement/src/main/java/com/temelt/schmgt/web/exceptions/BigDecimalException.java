package com.temelt.schmgt.web.exceptions;

public class BigDecimalException extends Exception {
	 String message=" Lütfen Gecerli Bir Deger Girin. (/, veya bilinmeyen baska degerler girmeyiniz)";
	 public BigDecimalException(String message){
	        super(message);
	    }
}
