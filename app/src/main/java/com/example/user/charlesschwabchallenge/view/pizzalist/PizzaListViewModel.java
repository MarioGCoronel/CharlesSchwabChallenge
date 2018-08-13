package com.example.user.charlesschwabchallenge.view.pizzalist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.user.charlesschwabchallenge.manager.LocationManager;
import com.example.user.charlesschwabchallenge.manager.PermissionManager;
import com.example.user.charlesschwabchallenge.manager.PreferenceManager;
import com.example.user.charlesschwabchallenge.model.data.PizzaRepository;
import com.example.user.charlesschwabchallenge.model.data.local.LocalDataSource;
import com.example.user.charlesschwabchallenge.model.data.remote.RemoteDataSource;
import com.example.user.charlesschwabchallenge.model.pizza.Pizza;
import com.example.user.charlesschwabchallenge.utils.QueryBuilder;

import java.util.List;

import static android.content.ContentValues.TAG;

public class PizzaListViewModel extends AndroidViewModel implements
        LocationManager.Callback {

    private PizzaRepository pizzaRepository;
    private LocationManager locationManager;
    private PreferenceManager preferenceManager;

    public PizzaListViewModel(@NonNull Application application) {
        super(application);
        pizzaRepository = new PizzaRepository(new RemoteDataSource(), new LocalDataSource());
        locationManager = LocationManager.getDefault(application.getApplicationContext(), this);
        preferenceManager = PreferenceManager.getDefault(application.getApplicationContext());

    }

    public LiveData<List<Pizza>> getPizzaList() {

        loadPizzaList();
        return pizzaRepository.getPizzaList(QueryBuilder.buildWithZip(preferenceManager.getZip()));
    }

    private void loadPizzaList() {

        locationManager.getCurrentZipCode();

    }
    @Override
    public void onLocationResults(String zipCode) {
        Log.d(TAG, "onLocationResults: "+ zipCode);
        preferenceManager.setZip(zipCode);
        pizzaRepository.getPizzaList(QueryBuilder.buildWithZip(zipCode));

    }
}
