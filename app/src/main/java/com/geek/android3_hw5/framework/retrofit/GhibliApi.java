package com.geek.android3_hw5.framework.retrofit;

import com.geek.android3_hw5.framework.retrofit.model.LoadedFilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {
    @GET("films")
    Call<List<LoadedFilm>> getFilms();

    @GET("films/{id}")
    Call<LoadedFilm> getFilm(@Path("id") String id);
}
