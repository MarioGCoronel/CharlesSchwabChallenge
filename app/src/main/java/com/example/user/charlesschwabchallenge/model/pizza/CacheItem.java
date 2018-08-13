package com.example.user.charlesschwabchallenge.model.pizza;


import com.google.gson.annotations.SerializedName;


public class CacheItem{

	@SerializedName("method")
	private String method;

	@SerializedName("execution-start-time")
	private String executionStartTime;

	@SerializedName("execution-time")
	private String executionTime;

	@SerializedName("execution-stop-time")
	private String executionStopTime;

	@SerializedName("type")
	private String type;

	@SerializedName("content")
	private String content;

	public void setMethod(String method){
		this.method = method;
	}

	public String getMethod(){
		return method;
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

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
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
			"CacheItem{" + 
			"method = '" + method + '\'' + 
			",execution-start-time = '" + executionStartTime + '\'' + 
			",execution-time = '" + executionTime + '\'' + 
			",execution-stop-time = '" + executionStopTime + '\'' + 
			",type = '" + type + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}