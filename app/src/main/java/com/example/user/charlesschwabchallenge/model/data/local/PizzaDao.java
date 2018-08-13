package com.example.user.charlesschwabchallenge.model.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.charlesschwabchallenge.model.pizza.Pizza;

import java.util.List;

@Dao
public interface PizzaDao {

    @Insert
    void insertPizza(Pizza pizza);

    @Insert
    void insertAllPizza(List<Pizza> pizzaList);

    @Query("SELECT * FROM pizza")
    LiveData<List<Pizza>> getPizza();
}
