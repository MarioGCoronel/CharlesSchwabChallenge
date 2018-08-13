package com.example.user.charlesschwabchallenge.model.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.user.charlesschwabchallenge.model.data.local.LocalDataSource;
import com.example.user.charlesschwabchallenge.model.data.remote.RemoteDataSource;
import com.example.user.charlesschwabchallenge.model.pizza.Pizza;

import java.util.List;
import java.util.Locale;

import static android.support.constraint.Constraints.TAG;

public class PizzaRepository {

    RemoteDataSource remoteDataSource;
    LocalDataSource localDataSource;
    MutableLiveData<List<Pizza>> data = new MutableLiveData<>();


    public PizzaRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public LiveData<List<Pizza>> getPizzaList(String query) {


        // TODO: 8/13/18 Implement local database for caching
        remoteDataSource.getPizzaList(query, new DataSourceCallback() {
            @Override
            public void onPizzaList(List<Pizza> pizzaList) {
                data.setValue(pizzaList);
            }

            @Override
            public void onPizza(Pizza pizza) {

            }

            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: " + error);

            }
        });

        return data;

    }

}
