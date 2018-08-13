package com.example.user.charlesschwabchallenge.model.pizza;

import com.google.gson.annotations.SerializedName;

public class Url{

	@SerializedName("execution-start-time")
	private String executionStartTime;

	@SerializedName("execution-time")
	private String executionTime;

	@SerializedName("execution-stop-time")
	private String executionStopTime;

	@SerializedName("content")
	private String content;

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
			"Url{" + 
			"execution-start-time = '" + executionStartTime + '\'' + 
			",execution-time = '" + executionTime + '\'' + 
			",execution-stop-time = '" + executionStopTime + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}