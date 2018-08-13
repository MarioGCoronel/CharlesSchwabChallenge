package com.example.user.charlesschwabchallenge.model.pizza;

import com.google.gson.annotations.SerializedName;

public class Javascript{

	@SerializedName("execution-start-time")
	private String executionStartTime;

	@SerializedName("execution-time")
	private String executionTime;

	@SerializedName("execution-stop-time")
	private String executionStopTime;

	@SerializedName("table-name")
	private String tableName;

	@SerializedName("instructions-used")
	private String instructionsUsed;

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

	public void setTableName(String tableName){
		this.tableName = tableName;
	}

	public String getTableName(){
		return tableName;
	}

	public void setInstructionsUsed(String instructionsUsed){
		this.instructionsUsed = instructionsUsed;
	}

	public String getInstructionsUsed(){
		return instructionsUsed;
	}

	@Override
 	public String toString(){
		return 
			"Javascript{" + 
			"execution-start-time = '" + executionStartTime + '\'' + 
			",execution-time = '" + executionTime + '\'' + 
			",execution-stop-time = '" + executionStopTime + '\'' + 
			",table-name = '" + tableName + '\'' + 
			",instructions-used = '" + instructionsUsed + '\'' + 
			"}";
		}
}