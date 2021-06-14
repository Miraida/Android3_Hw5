package com.geek.android3_hw5.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.geek.android3_hw5.App;
import com.geek.android3_hw5.R;
import com.geek.android3_hw5.utils.Keys;
import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.databinding.ActivityDescriptionBinding;

public class DescriptionActivity extends AppCompatActivity {
    private ActivityDescriptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkIntent();
    }

    private void checkIntent() {
        if (getIntent() != null) {
            if (getIntent().getStringExtra(Keys.getTag()).equals(getString(R.string.Loaded)))
                getFilmAndSet(getIntent().getStringExtra(Keys.getFilmKey()));
            else
                loadFilmAndSet(getIntent().getStringExtra(Keys.getFilmKey()));
        }
    }

    private void loadFilmAndSet(String id) {
        App.remoteRepo.getFilm(id, this::setData);
    }

    private void getFilmAndSet(String id) {
        setData(App.localRepo.getFilm(id));
    }

    private void setData(Film film) {
        binding.progressbar.setVisibility(View.GONE);
        binding.title.setText(film.getTitle());
        binding.originalTitle.setText(film.getOriginalTitle());
        binding.producer.setText(film.getProducer());
        binding.releaseDate.setText(film.getReleaseDate());
        binding.description.setText(film.getDescription());
    }

}