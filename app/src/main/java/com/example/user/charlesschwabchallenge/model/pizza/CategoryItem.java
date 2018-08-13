package com.example.user.charlesschwabchallenge.model.pizza;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CategoryItem implements Parcelable{

	@SerializedName("id")
	private String id;

	@SerializedName("content")
	private String content;

	protected CategoryItem(Parcel in) {
		id = in.readString();
		content = in.readString();
	}

	public static final Creator<CategoryItem> CREATOR = new Creator<CategoryItem>() {
		@Override
		public CategoryItem createFromParcel(Parcel in) {
			return new CategoryItem(in);
		}

		@Override
		public CategoryItem[] newArray(int size) {
			return new CategoryItem[size];
		}
	};

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
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
			"CategoryItem{" + 
			"id = '" + id + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(id);
		parcel.writeString(content);
	}
}