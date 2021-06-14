package com.geek.android3_hw5.domain.source.local;
import com.geek.android3_hw5.domain.model.Film;

import java.util.List;

public interface LocalFilmSource {
    List<Film> getAllFilms();

    void insert(Film film);

    void delete(Film film);

    Film getFilm(String filmId);
}
