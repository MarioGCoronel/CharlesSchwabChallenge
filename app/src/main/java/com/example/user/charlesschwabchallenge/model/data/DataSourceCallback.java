package com.example.user.charlesschwabchallenge.model.data;

import com.example.user.charlesschwabchallenge.model.pizza.Pizza;

import java.util.List;

public interface DataSourceCallback {

    public void onPizzaList(List<Pizza> pizzaList);

    public void onPizza(Pizza pizza);

    public void onFailure(String error);

}
