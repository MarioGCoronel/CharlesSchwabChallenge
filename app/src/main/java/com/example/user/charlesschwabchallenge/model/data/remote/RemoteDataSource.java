package com.example.user.charlesschwabchallenge.model.data.remote;

import android.util.Log;

import com.example.user.charlesschwabchallenge.model.data.DataSourceCallback;
import com.example.user.charlesschwabchallenge.model.pizza.Pizza;
import com.example.user.charlesschwabchallenge.model.pizza.QueryResponse;
import com.example.user.charlesschwabchallenge.utils.Parser;

import java.util.List;

import static android.support.constraint.Constraints.TAG;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private static final String BASE_URL = "https://query.yahooapis.com/";
    private static final String Q_FORMAT = "json";
    private static final String Q_DIAGNOSTICS = "true";


    private Retrofit createClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }


    private Observable<QueryResponse> getRawObservable(String query) {

        return createClient().create(RemoteService.class).getPizzaList(query, Q_FORMAT, Q_DIAGNOSTICS);
    }

    public void getPizzaList(String query, final DataSourceCallback callback) {

        getRawObservable(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(Parser.getPizzaParser())
                .subscribe(new Observer<List<Pizza>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Pizza> pizzas) {

                        Log.d(TAG, "onNext: " + pizzas.size());
                        callback.onPizzaList(pizzas);

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

}
