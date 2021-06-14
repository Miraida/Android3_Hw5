package com.geek.android3_hw5.domain.repository.remote;

import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.domain.source.remote.RemoteFilmSource;
import com.geek.android3_hw5.framework.retrofit.RetrofitSource;

import java.util.List;

public class RemoteFilmRepo {
    private final RemoteFilmSource source;

    public RemoteFilmRepo(RemoteFilmSource source) {
        this.source = source;
    }

    public void getFilms(RetrofitSource.FilmCallback<List<Film>> callback) {
        source.getFilms(callback);
    }

    public void getFilm(String id, RetrofitSource.FilmCallback<Film> callback) {
        source.getFilm(id, callback);
    }
}
