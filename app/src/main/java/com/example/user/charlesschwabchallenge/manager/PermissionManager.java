package com.example.user.charlesschwabchallenge.manager;

import android.Manifest;
import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

public class PermissionManager {

    private static PermissionManager instance = null;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_LOCATION = 10;
    private Context context;
    private Callback callback;
    private String currentPermission;


    public static PermissionManager getDefault(Context context) {

        if (instance == null) {
            instance = new PermissionManager(context);
        }
        return instance;

    }

    private PermissionManager(Context context) {
        this.context = context;
        this.callback = (Callback) context;
        setPermission(Manifest.permission.ACCESS_FINE_LOCATION);

    }

    public void setPermission(String permission) {
        this.currentPermission = permission;
    }

    public void checkPermission() {


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(context,
                currentPermission)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                    currentPermission)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission


                ActivityCompat.requestPermissions((Activity) context,
                        new String[]{currentPermission},
                        MY_PERMISSIONS_REQUEST_ACCESS_LOCATION);


                // MY_PERMISSIONS_REQUEST_ACCESS_LOCATION is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted

            callback.onPermissionResults(MY_PERMISSIONS_REQUEST_ACCESS_LOCATION, true);


        }

    }

    public void checkResults(int requestCode,
                             String permissions[], int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    callback.onPermissionResults(requestCode, true);


                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    callback.onPermissionResults(requestCode, false);
                }
                return;
            }


            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    public interface Callback {

        void onPermissionResults(int requestCode, boolean isGranted);

    }
}
