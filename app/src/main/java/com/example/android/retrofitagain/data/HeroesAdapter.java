package com.example.android.retrofitagain.data;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.retrofitagain.R;
import com.example.android.retrofitagain.data.model.Hero;
import com.example.android.retrofitagain.databinding.RecyclerviewLayoutBinding;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Hero> heroList;
    private LayoutInflater layoutInflater;

    public class HeroViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerviewLayoutBinding binding;

        ImageView heroImage;
        TextView heroName;
        TextView heroRealName;
        TextView heroBio;

        public HeroViewHolder(final RecyclerviewLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;

            //heroImage = itemView.findViewById(R.id.iv_Hero);
            //heroName = itemView.findViewById(R.id.tv_Name);
            //heroRealName = itemView.findViewById(R.id.tv_RealName);
            //heroBio = itemView.findViewById(R.id.tv_Bio);
        }
    }

    public HeroesAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = layoutInflater.from(parent.getContext());
        }
        View view = LayoutInflater.from(mCtx)
                .inflate(R.layout.recyclerview_layout, parent, false);
        RecyclerviewLayoutBinding binding = DataBindingUtil
                .inflate(layoutInflater, R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        holder.binding.setHero(heroList.get(position));

        //Hero hero = heroList.get(position);
        //
        //Glide.with(mCtx)
        //.load(hero.getImageurl())
        //.into(holder.heroImage);
        //
        //holder.heroName.setText(hero.getName());
        //holder.heroRealName.setText(hero.getRealname());
        //holder.heroBio.setText(hero.getBio());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }


}