package com.geek.android3_hw5.framework.room;

import com.geek.android3_hw5.App;
import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.domain.source.local.LocalFilmSource;
import com.geek.android3_hw5.framework.room.model.SavedFilm;

import java.util.ArrayList;
import java.util.List;

public class RoomSource implements LocalFilmSource {
    @Override
    public List<Film> getAllFilms() {
        if (App.database.filmDao().getAllFilms() != null)
            return mapToFilmList(App.database.filmDao().getAllFilms());
        return new ArrayList<>();
    }

    @Override
    public void insert(Film film) {
        App.database.filmDao().insert(new SavedFilm(film));
    }

    @Override
    public void delete(Film film) {
        App.database.filmDao().delete(film.getFilmId());
    }

    @Override
    public Film getFilm(String filmId) {
        SavedFilm savedFilm = App.database.filmDao().getFilm(filmId);
        return savedFilm.getFilm();
    }

    private List<Film> mapToFilmList(List<SavedFilm> savedFilms) {
        List<Film> films = new ArrayList<>();
        for (SavedFilm film : savedFilms) {
            films.add(film.getFilm());
        }
        return films;
    }
}
