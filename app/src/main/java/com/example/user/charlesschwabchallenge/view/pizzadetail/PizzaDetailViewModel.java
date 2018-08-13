package com.example.user.charlesschwabchallenge.view.pizzadetail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.user.charlesschwabchallenge.model.pizza.Pizza;

public class PizzaDetailViewModel extends ViewModel {

    MutableLiveData<Pizza> pizzaData = new MutableLiveData<>();

    public LiveData<Pizza> getPizzaData() {

        return pizzaData;
    }

    public void setData(Pizza pizza) {

        pizzaData.setValue(pizza);

    }
}
