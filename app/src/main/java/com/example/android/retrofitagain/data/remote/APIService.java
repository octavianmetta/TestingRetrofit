package com.example.android.retrofitagain.data.remote;

import com.example.android.retrofitagain.data.model.Hero;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Observable<List<Hero>> getHeroes();
}

