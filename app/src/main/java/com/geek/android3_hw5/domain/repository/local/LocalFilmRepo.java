package com.geek.android3_hw5.domain.repository.local;

import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.domain.source.local.LocalFilmSource;

import java.util.List;

public class LocalFilmRepo {
    private final LocalFilmSource source;

    public LocalFilmRepo(LocalFilmSource source) {
        this.source = source;
    }

    public List<Film> getAllFilms() {
        return source.getAllFilms();
    }

    public void insert(Film film) {
        source.insert(film);
    }

    public void delete(Film film) {
        source.delete(film);
    }

    public Film getFilm(String filmId){
       return source.getFilm(filmId);
    }

}
