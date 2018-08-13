package com.example.user.charlesschwabchallenge.model.pizza;

import android.arch.persistence.room.Entity;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


@Entity
public class Pizza implements Parcelable {

	@SerializedName("MapUrl")
	private String mapUrl;

	@SerializedName("Address")
	private String address;

	@SerializedName("Categories")
	private Categories categories;

	@SerializedName("ClickUrl")
	private String clickUrl;

	@SerializedName("Rating")
	private Rating rating;

	@SerializedName("Title")
	private String title;

	@SerializedName("BusinessClickUrl")
	private String businessClickUrl;

	@SerializedName("Latitude")
	private String latitude;

	@SerializedName("City")
	private String city;

	@SerializedName("Longitude")
	private String longitude;

	@SerializedName("Url")
	private String url;

	@SerializedName("xmlns")
	private String xmlns;

	@SerializedName("State")
	private String state;

	@SerializedName("Phone")
	private String phone;

	@SerializedName("id")
	private String id;

	@SerializedName("Distance")
	private String distance;

	@SerializedName("BusinessUrl")
	private String businessUrl;

	protected Pizza(Parcel in) {
		mapUrl = in.readString();
		address = in.readString();
		clickUrl = in.readString();
		title = in.readString();
		businessClickUrl = in.readString();
		latitude = in.readString();
		city = in.readString();
		longitude = in.readString();
		url = in.readString();
		xmlns = in.readString();
		state = in.readString();
		phone = in.readString();
		id = in.readString();
		distance = in.readString();
		businessUrl = in.readString();
	}

	public static final Creator<Pizza> CREATOR = new Creator<Pizza>() {
		@Override
		public Pizza createFromParcel(Parcel in) {
			return new Pizza(in);
		}

		@Override
		public Pizza[] newArray(int size) {
			return new Pizza[size];
		}
	};

	public void setMapUrl(String mapUrl){
		this.mapUrl = mapUrl;
	}

	public String getMapUrl(){
		return mapUrl;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCategories(Categories categories){
		this.categories = categories;
	}

	public Categories getCategories(){
		return categories;
	}

	public void setClickUrl(String clickUrl){
		this.clickUrl = clickUrl;
	}

	public String getClickUrl(){
		return clickUrl;
	}

	public void setRating(Rating rating){
		this.rating = rating;
	}

	public Rating getRating(){
		return rating;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBusinessClickUrl(String businessClickUrl){
		this.businessClickUrl = businessClickUrl;
	}

	public String getBusinessClickUrl(){
		return businessClickUrl;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setXmlns(String xmlns){
		this.xmlns = xmlns;
	}

	public String getXmlns(){
		return xmlns;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDistance(String distance){
		this.distance = distance;
	}

	public String getDistance(){
		return distance;
	}

	public void setBusinessUrl(String businessUrl){
		this.businessUrl = businessUrl;
	}

	public String getBusinessUrl(){
		return businessUrl;
	}

	@Override
 	public String toString(){
		return 
			"Pizza{" + 
			"mapUrl = '" + mapUrl + '\'' + 
			",address = '" + address + '\'' + 
			",categories = '" + categories + '\'' + 
			",clickUrl = '" + clickUrl + '\'' + 
			",rating = '" + rating + '\'' + 
			",title = '" + title + '\'' + 
			",businessClickUrl = '" + businessClickUrl + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",city = '" + city + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",url = '" + url + '\'' + 
			",xmlns = '" + xmlns + '\'' + 
			",state = '" + state + '\'' + 
			",phone = '" + phone + '\'' + 
			",id = '" + id + '\'' + 
			",distance = '" + distance + '\'' + 
			",businessUrl = '" + businessUrl + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(mapUrl);
		parcel.writeString(address);
		parcel.writeString(clickUrl);
		parcel.writeString(title);
		parcel.writeString(businessClickUrl);
		parcel.writeString(latitude);
		parcel.writeString(city);
		parcel.writeString(longitude);
		parcel.writeString(url);
		parcel.writeString(xmlns);
		parcel.writeString(state);
		parcel.writeString(phone);
		parcel.writeString(id);
		parcel.writeString(distance);
		parcel.writeString(businessUrl);
	}
}