package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.retrofit.GithubConfig;
import com.temelt.schmgt.web.retrofit.Repo;
import com.temelt.schmgt.web.retrofit.User;

@Controller("retroController")
@Scope("session")
public class RetroController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7124760317602165620L;

	@Autowired
	private GithubConfig githubConfig;
	private String username;
	private User user;
	private List<Repo> repos;

	@PostConstruct
	private void init() {
	}

	public void kullaniciGetir() {
		try {
			user = githubConfig.getUser(username);
			repos = githubConfig.getRepo(username);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public List<Repo> getRepos() {
		return repos;
	}
}
