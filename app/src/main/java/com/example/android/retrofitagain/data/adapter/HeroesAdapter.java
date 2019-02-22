package com.example.android.retrofitagain.data.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.retrofitagain.R;
import com.example.android.retrofitagain.data.model.Hero;
import com.example.android.retrofitagain.databinding.RecyclerviewLayoutBinding;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    private Context mCtx;
    private List<Hero> heroList;
    private LayoutInflater layoutInflater;

    public HeroesAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }


    public class HeroViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerviewLayoutBinding binding;

        public HeroViewHolder(final RecyclerviewLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        public void bind (Hero hero){
            binding.setHero(hero);
            binding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = layoutInflater.from(parent.getContext());
        }
        RecyclerviewLayoutBinding binding = DataBindingUtil
                .inflate(layoutInflater, R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);
        holder.bind(hero);
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public void updateHero(List<Hero> heroList){
        this.heroList = heroList;
        notifyDataSetChanged();
    }


}