package com.example.android.retrofitagain;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.retrofitagain.data.adapter.HeroesAdapter;
import com.example.android.retrofitagain.data.model.Hero;
import com.example.android.retrofitagain.data.viewModel.HeroViewModel;
import com.example.android.retrofitagain.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HeroesAdapter mAdapter;
    private ActivityMainBinding binding;
    private List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        heroList = new ArrayList<>();
        recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroViewModel viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);
        mAdapter = new HeroesAdapter(MainActivity.this, heroList);
        recyclerView.setAdapter(mAdapter);

        viewModel.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                mAdapter.updateHero(heroList);
            }

        });

    }
}
