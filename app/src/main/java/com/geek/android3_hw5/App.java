package com.geek.android3_hw5;

import android.app.Application;

import androidx.room.Room;

import com.geek.android3_hw5.domain.repository.local.LocalFilmRepo;
import com.geek.android3_hw5.domain.repository.remote.RemoteFilmRepo;
import com.geek.android3_hw5.framework.retrofit.RetrofitSource;
import com.geek.android3_hw5.framework.room.Database;
import com.geek.android3_hw5.framework.room.RoomSource;

public class App extends Application {
    public static Database database;
    public static LocalFilmRepo localRepo;
    public static RemoteFilmRepo remoteRepo;

    @Override
    public void onCreate() {
        super.onCreate();
        createDatabase();
        setRepo();
    }

    private void setRepo() {
        remoteRepo = new RemoteFilmRepo(new RetrofitSource());
        localRepo = new LocalFilmRepo(new RoomSource());
    }

    private void createDatabase() {
        database = Room.databaseBuilder(this
                , Database.class
                , "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
