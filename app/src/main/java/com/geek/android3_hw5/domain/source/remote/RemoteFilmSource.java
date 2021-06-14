package com.geek.android3_hw5.domain.source.remote;

import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.framework.retrofit.RetrofitSource;

import java.util.List;

public interface RemoteFilmSource {
    void getFilms(RetrofitSource.FilmCallback<List<Film>> callback);

    void getFilm(String id, RetrofitSource.FilmCallback<Film> callback);
}
