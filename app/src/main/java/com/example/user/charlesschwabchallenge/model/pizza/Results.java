package com.example.user.charlesschwabchallenge.model.pizza;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Results{

	@SerializedName("Result")
	private List<Pizza> result;

	public void setResult(List<Pizza> result){
		this.result = result;
	}

	public List<Pizza> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}