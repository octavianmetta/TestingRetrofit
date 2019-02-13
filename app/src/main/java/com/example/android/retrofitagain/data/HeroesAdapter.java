package com.example.android.retrofitagain.data;

import android.content.Context;
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

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Hero> heroList;

    public HeroesAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);

        Glide.with(mCtx)
                .load(hero.getImageurl())
                .into(holder.heroImage);

        holder.heroName.setText(hero.getName());
        holder.heroRealName.setText(hero.getRealname());
        holder.heroBio.setText(hero.getBio());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView heroImage;
        TextView heroName;
        TextView heroRealName;
        TextView heroBio;

        public HeroViewHolder(View itemView) {
            super(itemView);

            heroImage = itemView.findViewById(R.id.iv_Hero);
            heroName = itemView.findViewById(R.id.tv_Name);
            heroRealName = itemView.findViewById(R.id.tv_RealName);
            heroBio = itemView.findViewById(R.id.tv_Bio);
        }
    }
}