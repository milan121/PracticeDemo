package com.milanapp.practicedemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milanapp.practicedemo.Interface.ItemClickListener;
import com.milanapp.practicedemo.Model.Items;
import com.milanapp.practicedemo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context  context;
    private List<Items> itemsList = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public MyAdapter(Context context, List<Items> itemsList, ItemClickListener itemClickListener) {
        this.context = context;
        this.itemsList = itemsList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_items,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(itemsList.get(position).getName());
        holder.tv_surname.setText(itemsList.get(position).getSurName());

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name , tv_surname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_surname = itemView.findViewById(R.id.tv_surname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.ItemOnClick(getAdapterPosition());


                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemClickListener.ItemOnLongClick(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
