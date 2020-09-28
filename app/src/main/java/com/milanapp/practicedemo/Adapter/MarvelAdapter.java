package com.milanapp.practicedemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.milanapp.practicedemo.Model.Marvel;
import com.milanapp.practicedemo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MarvelAdapter extends RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder> {
    private Context context;
    private ArrayList<Marvel> marvelList = new ArrayList<>();


    public MarvelAdapter(Context context, ArrayList<Marvel> marvelList) {
        this.context = context;
        this.marvelList = marvelList;
    }

    @NonNull
    @Override
    public MarvelAdapter.MarvelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.marvel_items,parent,false);

        return new MarvelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarvelAdapter.MarvelViewHolder holder, int position) {

        final  Marvel marvel = marvelList.get(position);

        holder.realName.setText(marvel.getRealname());
        holder.name.setText(marvel.getName());
        holder.Team.setText(marvel.getTeam());

        Glide.with(context)
                .load(marvel.getImageurl())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.img_marvel);



    }

    @Override
    public int getItemCount() {
        return marvelList.size();
    }

    public class MarvelViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_marvel;
        private TextView  name, realName, Team;

        public MarvelViewHolder(@NonNull View itemView) {
            super(itemView);

            img_marvel = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name_tv);
            realName = itemView.findViewById(R.id.realname_tv);
            Team = itemView.findViewById(R.id.team_tv);
        }
    }
}
