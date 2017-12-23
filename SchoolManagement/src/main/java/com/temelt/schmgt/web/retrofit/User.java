package com.temelt.schmgt.web.retrofit;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7904447581669545376L;
	
	private String login;
	private Long id;
	private String avatar_url;
	private String url;
	private String html_url;
	private String followers_url;
	private String following_url;
	private String gists_url;
	private String type;
	private Boolean site_admin;
	private String name;
	private String company;
	private String blog;
	private String location;
	private String email;
	private Boolean hireable;
	private String bio;
	private Integer public_repos;
	private Integer public_gists;
	private Integer followers;
	private Integer following;
	private Date created_at;
	private Date updated_at;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getFollowers_url() {
		return followers_url;
	}

	public void setFollowers_url(String followers_url) {
		this.followers_url = followers_url;
	}

	public String getFollowing_url() {
		return following_url;
	}

	public void setFollowing_url(String following_url) {
		this.following_url = following_url;
	}

	public String getGists_url() {
		return gists_url;
	}

	public void setGists_url(String gists_url) {
		this.gists_url = gists_url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getSite_admin() {
		return site_admin;
	}

	public void setSite_admin(Boolean site_admin) {
		this.site_admin = site_admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getHireable() {
		return hireable;
	}

	public void setHireable(Boolean hireable) {
		this.hireable = hireable;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Integer getPublic_repos() {
		return public_repos;
	}

	public void setPublic_repos(Integer public_repos) {
		this.public_repos = public_repos;
	}

	public Integer getPublic_gists() {
		return public_gists;
	}

	public void setPublic_gists(Integer public_gists) {
		this.public_gists = public_gists;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	public Integer getFollowing() {
		return following;
	}

	public void setFollowing(Integer following) {
		this.following = following;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", id=" + id + ", avatar_url=" + avatar_url + ", url=" + url + ", html_url="
				+ html_url + ", followers_url=" + followers_url + ", following_url=" + following_url + ", gists_url="
				+ gists_url + ", type=" + type + ", site_admin=" + site_admin + ", name=" + name + ", company="
				+ company + ", blog=" + blog + ", location=" + location + ", email=" + email + ", hireable=" + hireable
				+ ", bio=" + bio + ", public_repos=" + public_repos + ", public_gists=" + public_gists + ", followers="
				+ followers + ", following=" + following + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}

	
}
