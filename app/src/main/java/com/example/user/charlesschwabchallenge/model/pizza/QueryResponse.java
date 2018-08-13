package com.example.user.charlesschwabchallenge.model.pizza;

import com.google.gson.annotations.SerializedName;

public class QueryResponse{

	@SerializedName("query")
	private Query query;

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	@Override
 	public String toString(){
		return 
			"QueryResponse{" + 
			"query = '" + query + '\'' + 
			"}";
		}
}