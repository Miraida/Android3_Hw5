package com.geek.android3_hw5.framework.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.framework.room.model.SavedFilm;

import java.util.List;

@Dao
public interface FilmDao {
    @Query("select * from films")
    List<SavedFilm> getAllFilms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SavedFilm film);

    @Query("delete from films where filmId = :filmId")
    void delete(String filmId);

    @Query("select * from films where filmId = :filmId")
    SavedFilm getFilm(String filmId);
}
