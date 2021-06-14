package com.geek.android3_hw5.framework.room;

import androidx.room.RoomDatabase;

import com.geek.android3_hw5.framework.room.model.SavedFilm;

@androidx.room.Database(entities = {SavedFilm.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract FilmDao filmDao();
}
