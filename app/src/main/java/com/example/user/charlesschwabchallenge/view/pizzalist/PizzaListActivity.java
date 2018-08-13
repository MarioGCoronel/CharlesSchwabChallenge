package com.example.user.charlesschwabchallenge.view.pizzalist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.user.charlesschwabchallenge.R;
import com.example.user.charlesschwabchallenge.manager.PermissionManager;
import com.example.user.charlesschwabchallenge.model.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaListActivity extends AppCompatActivity implements PermissionManager.Callback{

    private PizzaListViewModel viewModel;
    private static final String TAG = PizzaListActivity.class.getSimpleName();
    PermissionManager permissionManager;
    private PizzaListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);

        initViews();
        viewModel = ViewModelProviders.of(this).get(PizzaListViewModel.class);
        permissionManager = PermissionManager.getDefault(this);

    }

    private void initViews() {
        RecyclerView rvPizzaList = findViewById(R.id.rvPizzaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new PizzaListAdapter(new ArrayList<Pizza>());
        rvPizzaList.setLayoutManager(layoutManager);
        rvPizzaList.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        permissionManager.checkPermission();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionManager.checkResults(requestCode, permissions, grantResults);

    }

    @Override
    public void onPermissionResults(int requestCode, boolean isGranted) {

        viewModel.getPizzaList().observe(this, new Observer<List<Pizza>>() {
            @Override
            public void onChanged(@Nullable List<Pizza> pizzas) {
                adapter.updatePizzaList(pizzas);

            }
        });
    }
}
