package com.temelt.schmgt.web.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubOperations {

	@GET("/users/{username}")
	public Call<User> getUserByName(@Path("username") String username);
	
	@GET("users/{username}/repos")
	public Call<List<Repo>> getReposByUsername(@Path("username") String username);
}
