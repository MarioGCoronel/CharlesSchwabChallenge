package com.example.user.charlesschwabchallenge.manager;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;


public class LocationManager {

    @SuppressLint("StaticFieldLeak")
    private static LocationManager instance = null;
    private Context context;
    private Callback callback;
    private FusedLocationProviderClient client;
    private Geocoder geocoder;


    private LocationManager() {

    }

    public static LocationManager getDefault(Context context, ViewModel viewModel) {

        if (instance == null) {
            instance = new LocationManager(context, viewModel);
        }

        return instance;
    }


    private LocationManager(Context context, ViewModel viewModel) {
        this.context = context;
        this.callback = (Callback) viewModel;
        client = LocationServices.getFusedLocationProviderClient(context);
        geocoder = new Geocoder(context);

    }


    @SuppressLint("MissingPermission")
    public void getCurrentZipCode() {

        client.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        try {
                            callback.onLocationResults(getZip(location));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callback.onLocationResults(null);
                    }
                });

    }

    public String getZip(Location location) throws IOException {

        List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        return addressList.get(0).getPostalCode();

    }

    public interface Callback {
        void onLocationResults(String zipCode);

    }
}
