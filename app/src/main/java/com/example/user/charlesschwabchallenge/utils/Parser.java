package com.example.user.charlesschwabchallenge.utils;

import android.util.Log;

import com.example.user.charlesschwabchallenge.model.pizza.Pizza;
import com.example.user.charlesschwabchallenge.model.pizza.QueryResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Parser {

    public static Function<QueryResponse, List<Pizza>> getPizzaParser() {

        return new Function<QueryResponse, List<Pizza>>() {
            @Override
            public List<Pizza> apply(QueryResponse queryResponse) throws Exception {
                List<Pizza> pizzas = new ArrayList<>();

                pizzas.addAll(queryResponse.getQuery().getResults().getResult());

                return pizzas;


            }
        };
    }
}
