package com.example.android.retrofitagain.data.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.retrofitagain.data.model.Hero;
import com.example.android.retrofitagain.data.remote.APIService;
import com.example.android.retrofitagain.data.remote.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HeroViewModel extends ViewModel {
    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Hero>> heroList;

    //we will call this method to get the data
    public LiveData<List<Hero>> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<Hero>>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadHeroes() {

        Retrofit retrofit = RetrofitClient.getClient(APIService.BASE_URL);
        APIService heroApi = retrofit.create(APIService.class);
        Observable<List<Hero>> heroObservable = heroApi.getHeroes();

        heroObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Hero>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Hero> heroResponse) {
                        heroList.setValue(heroResponse);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
