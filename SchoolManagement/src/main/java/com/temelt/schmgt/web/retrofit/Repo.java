package com.temelt.schmgt.web.retrofit;

import java.io.Serializable;

public class Repo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6280128264278933605L;
	private Long id;
	private String name;
	private String full_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

}
