package com.example.user.charlesschwabchallenge.model.pizza;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Diagnostics{

	@SerializedName("publiclyCallable")
	private String publiclyCallable;

	@SerializedName("service-time")
	private String serviceTime;

	@SerializedName("cache")
	private List<CacheItem> cache;

	@SerializedName("user-time")
	private String userTime;

	@SerializedName("query")
	private Query query;

	@SerializedName("url")
	private Url url;

	@SerializedName("javascript")
	private Javascript javascript;

	@SerializedName("build-version")
	private String buildVersion;

	public void setPubliclyCallable(String publiclyCallable){
		this.publiclyCallable = publiclyCallable;
	}

	public String getPubliclyCallable(){
		return publiclyCallable;
	}

	public void setServiceTime(String serviceTime){
		this.serviceTime = serviceTime;
	}

	public String getServiceTime(){
		return serviceTime;
	}

	public void setCache(List<CacheItem> cache){
		this.cache = cache;
	}

	public List<CacheItem> getCache(){
		return cache;
	}

	public void setUserTime(String userTime){
		this.userTime = userTime;
	}

	public String getUserTime(){
		return userTime;
	}

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	public void setUrl(Url url){
		this.url = url;
	}

	public Url getUrl(){
		return url;
	}

	public void setJavascript(Javascript javascript){
		this.javascript = javascript;
	}

	public Javascript getJavascript(){
		return javascript;
	}

	public void setBuildVersion(String buildVersion){
		this.buildVersion = buildVersion;
	}

	public String getBuildVersion(){
		return buildVersion;
	}

	@Override
 	public String toString(){
		return 
			"Diagnostics{" + 
			"publiclyCallable = '" + publiclyCallable + '\'' + 
			",service-time = '" + serviceTime + '\'' + 
			",cache = '" + cache + '\'' + 
			",user-time = '" + userTime + '\'' + 
			",query = '" + query + '\'' + 
			",url = '" + url + '\'' + 
			",javascript = '" + javascript + '\'' + 
			",build-version = '" + buildVersion + '\'' + 
			"}";
		}
}