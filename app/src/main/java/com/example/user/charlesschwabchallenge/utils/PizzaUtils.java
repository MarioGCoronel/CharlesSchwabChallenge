package com.example.user.charlesschwabchallenge.utils;

import com.example.user.charlesschwabchallenge.model.pizza.CategoryItem;
import com.example.user.charlesschwabchallenge.model.pizza.Pizza;
import com.google.android.gms.maps.model.LatLng;

public class PizzaUtils {

    public static String formattedAddress(Pizza pizza) {
        String address = pizza.getAddress();
        String city = pizza.getCity();
        String state = pizza.getState();
        return address + "," + city + "," + state;
    }

    public static String formattedDistance(Pizza pizza) {
        return pizza.getDistance() + "m away";
    }

    public static LatLng getLatLng(Pizza pizza) {
        double latitute = Double.parseDouble(pizza.getLatitude());
        double longtitude = Double.parseDouble(pizza.getLongitude());

        LatLng latLng = new LatLng(latitute, longtitude);
        return latLng;
    }

    public static String formattedCategories(Pizza pizza) {
        StringBuilder stringBuilder = new StringBuilder();

        if (pizza.getCategories() != null) {
            for (CategoryItem categoryItem : pizza.getCategories().getCategory()) {
                stringBuilder.append(categoryItem.getContent());
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();

    }

}
