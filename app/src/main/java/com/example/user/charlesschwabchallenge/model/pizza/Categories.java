package com.example.user.charlesschwabchallenge.model.pizza;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Categories implements Parcelable{

	@SerializedName("Category")
	private List<CategoryItem> category;

	protected Categories(Parcel in) {
	}

	public static final Creator<Categories> CREATOR = new Creator<Categories>() {
		@Override
		public Categories createFromParcel(Parcel in) {
			return new Categories(in);
		}

		@Override
		public Categories[] newArray(int size) {
			return new Categories[size];
		}
	};

	public void setCategory(List<CategoryItem> category){
		this.category = category;
	}

	public List<CategoryItem> getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"Categories{" + 
			"category = '" + category + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
	}
}