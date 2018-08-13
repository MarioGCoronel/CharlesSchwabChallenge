package com.example.user.charlesschwabchallenge.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private Context context;
    private String defaultZip = "95050";
    private SharedPreferences sharedPreferences;


    private static PreferenceManager instance = null;

    private PreferenceManager() {
    }

    private PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("default_shared_prep", Context.MODE_PRIVATE);
    }

    public static PreferenceManager getDefault(Context context) {
        if (instance == null) {
            instance = new PreferenceManager(context);
        }
        return instance;
    }

    public void setZip(String zip) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("zip", zip);
        editor.apply();
    }

    public String getZip() {

        String currentZip = sharedPreferences.getString("zip", defaultZip);
        return currentZip;

    }


}
