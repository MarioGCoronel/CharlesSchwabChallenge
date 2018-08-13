package com.example.user.charlesschwabchallenge.model.pizza;

import com.google.gson.annotations.SerializedName;

public class Query{

	@SerializedName("diagnostics")
	private Diagnostics diagnostics;

	@SerializedName("created")
	private String created;

	@SerializedName("count")
	private int count;

	@SerializedName("lang")
	private String lang;

	@SerializedName("results")
	private Results results;

	@SerializedName("execution-start-time")
	private String executionStartTime;

	@SerializedName("execution-time")
	private String executionTime;

	@SerializedName("execution-stop-time")
	private String executionStopTime;

	@SerializedName("content")
	private String content;

	public void setDiagnostics(Diagnostics diagnostics){
		this.diagnostics = diagnostics;
	}

	public Diagnostics getDiagnostics(){
		return diagnostics;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setLang(String lang){
		this.lang = lang;
	}

	public String getLang(){
		return lang;
	}

	public void setResults(Results results){
		this.results = results;
	}

	public Results getResults(){
		return results;
	}

	public void setExecutionStartTime(String executionStartTime){
		this.executionStartTime = executionStartTime;
	}

	public String getExecutionStartTime(){
		return executionStartTime;
	}

	public void setExecutionTime(String executionTime){
		this.executionTime = executionTime;
	}

	public String getExecutionTime(){
		return executionTime;
	}

	public void setExecutionStopTime(String executionStopTime){
		this.executionStopTime = executionStopTime;
	}

	public String getExecutionStopTime(){
		return executionStopTime;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Query{" + 
			"diagnostics = '" + diagnostics + '\'' + 
			",created = '" + created + '\'' + 
			",count = '" + count + '\'' + 
			",lang = '" + lang + '\'' + 
			",results = '" + results + '\'' + 
			",execution-start-time = '" + executionStartTime + '\'' + 
			",execution-time = '" + executionTime + '\'' + 
			",execution-stop-time = '" + executionStopTime + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}