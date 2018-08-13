package com.example.user.charlesschwabchallenge.view.pizzadetail;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.charlesschwabchallenge.R;
import com.example.user.charlesschwabchallenge.manager.PermissionManager;
import com.example.user.charlesschwabchallenge.model.pizza.Pizza;
import com.example.user.charlesschwabchallenge.utils.PizzaUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PizzaDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private PizzaDetailViewModel viewModel;
    private TextView tvName;
    private TextView tvDistance;
    private TextView tvAddress;
    private TextView tvPhone;
    private TextView tvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        bindViews();
        viewModel = ViewModelProviders.of(this).get(PizzaDetailViewModel.class);
        updatePizza(getIntent());
        setupMap();

    }

    private void updateViews(Pizza pizza) {
        tvName.setText(pizza.getTitle());
        tvPhone.setText(pizza.getPhone());
        tvDistance.setText(PizzaUtils.formattedDistance(pizza));
        tvAddress.setText(PizzaUtils.formattedAddress(pizza));
        tvCategories.setText(PizzaUtils.formattedCategories(pizza));

//        updates maps
        mMap.addMarker(new MarkerOptions().position(PizzaUtils.getLatLng(pizza)).title(pizza.getTitle()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PizzaUtils.getLatLng(pizza)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(PizzaUtils.getLatLng(pizza), 16.0f));


    }

    private void bindViews() {
        tvName = findViewById(R.id.tvName);
        tvDistance = findViewById(R.id.tvDistance);
        tvAddress = findViewById(R.id.tvAddress);
        tvPhone = findViewById(R.id.tvPhone);
        tvCategories = findViewById(R.id.tvCategories);

        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tvPhone.getText().toString()));
                startActivity(intent);
            }
        });

    }

    private void updatePizza(Intent intent) {
        viewModel.setData((Pizza) intent.getParcelableExtra("pizza"));
    }

    private void setupMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        viewModel.getPizzaData().observe(this, new Observer<Pizza>() {
            @Override
            public void onChanged(@Nullable Pizza pizza) {
                if (pizza != null) {
                    updateViews(pizza);
                }
            }
        });
    }

}
