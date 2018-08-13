package com.example.user.charlesschwabchallenge.model.pizza;

import com.google.gson.annotations.SerializedName;

public class Rating{

	@SerializedName("TotalRatings")
	private String totalRatings;

	@SerializedName("AverageRating")
	private String averageRating;

	@SerializedName("TotalReviews")
	private String totalReviews;

	@SerializedName("LastReviewIntro")
	private Object lastReviewIntro;

	@SerializedName("LastReviewDate")
	private Object lastReviewDate;

	public void setTotalRatings(String totalRatings){
		this.totalRatings = totalRatings;
	}

	public String getTotalRatings(){
		return totalRatings;
	}

	public void setAverageRating(String averageRating){
		this.averageRating = averageRating;
	}

	public String getAverageRating(){
		return averageRating;
	}

	public void setTotalReviews(String totalReviews){
		this.totalReviews = totalReviews;
	}

	public String getTotalReviews(){
		return totalReviews;
	}

	public void setLastReviewIntro(Object lastReviewIntro){
		this.lastReviewIntro = lastReviewIntro;
	}

	public Object getLastReviewIntro(){
		return lastReviewIntro;
	}

	public void setLastReviewDate(Object lastReviewDate){
		this.lastReviewDate = lastReviewDate;
	}

	public Object getLastReviewDate(){
		return lastReviewDate;
	}

	@Override
 	public String toString(){
		return 
			"Rating{" + 
			"totalRatings = '" + totalRatings + '\'' + 
			",averageRating = '" + averageRating + '\'' + 
			",totalReviews = '" + totalReviews + '\'' + 
			",lastReviewIntro = '" + lastReviewIntro + '\'' + 
			",lastReviewDate = '" + lastReviewDate + '\'' + 
			"}";
		}
}