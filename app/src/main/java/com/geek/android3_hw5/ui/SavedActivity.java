package com.geek.android3_hw5.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.geek.android3_hw5.App;
import com.geek.android3_hw5.utils.Keys;
import com.geek.android3_hw5.R;
import com.geek.android3_hw5.databinding.ActivitySavedBinding;
import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.utils.MultipurposeToast;

import java.util.List;

public class SavedActivity extends AppCompatActivity {
    private ActivitySavedBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivitySavedBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = ui.recycler;
        FilmsAdapter adapter = new FilmsAdapter(getString(R.string.Saved), getFilms(), this::onItemClick, this::onFavClick);
        recyclerView.setAdapter(adapter);
    }

    private void onItemClick(String id) {
        Intent intent = new Intent(SavedActivity.this, DescriptionActivity.class);
        intent.putExtra(Keys.getFilmKey(), id);
        intent.putExtra(Keys.getTag(),getString(R.string.saved));
        startActivity(intent);
    }

    private void onFavClick(Film film) {
        App.localRepo.delete(film);
        MultipurposeToast.show(this, getString(R.string.deleted));
    }

    private List<Film> getFilms() {
        return App.localRepo.getAllFilms();
    }
}