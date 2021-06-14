package com.geek.android3_hw5.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.android3_hw5.App;
import com.geek.android3_hw5.utils.Keys;
import com.geek.android3_hw5.R;
import com.geek.android3_hw5.databinding.ActivityMainBinding;
import com.geek.android3_hw5.domain.model.Film;
import com.geek.android3_hw5.utils.MultipurposeToast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ConnectivityManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (checkNetwork()) getFilms();
        setOnClicks();
    }

    private void setOnClicks() {
        binding.savedBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SavedActivity.class);
            startActivity(intent);
        });
    }

    private boolean checkNetwork() {
        return (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected());
    }

    private void getFilms() {
        App.remoteRepo.getFilms(this::initViews);
    }

    private void initViews(List<Film> list) {
        binding.mainProgressbar.setVisibility(View.GONE);
        RecyclerView recyclerView = binding.recycler;
        FilmsAdapter adapter = new FilmsAdapter(getString(R.string.Loaded), list, (FilmsAdapter.Listener<String>) this::onItemClick, this::onFavClick);
        recyclerView.setAdapter(adapter);
    }

    private void onFavClick(Film model) {
        App.localRepo.insert(model);
        MultipurposeToast.show(this,getString(R.string.saved));
    }

    private void onItemClick(String id) {
        Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
        intent.putExtra(Keys.getFilmKey(), id);
        intent.putExtra(Keys.getTag(),getString(R.string.Loaded));
        startActivity(intent);
    }
}