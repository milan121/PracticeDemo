package com.milanapp.practicedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.milanapp.practicedemo.Adapter.MyAdapter;
import com.milanapp.practicedemo.Interface.ItemClickListener;
import com.milanapp.practicedemo.Model.Items;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDemoActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView recyclerView;
    private MyAdapter  myAdapter;
    private List<Items> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        itemsList.add(new Items("Milan","Pansuriya"));
        itemsList.add(new Items("Kenil","Pansuriya"));
        itemsList.add(new Items("Kiran","Pansuriya"));
        itemsList.add(new Items("Ketan","Pansuriya"));
        itemsList.add(new Items("Parth","Pansuriya"));
        itemsList.add(new Items("Nirav","Pansuriya"));
        itemsList.add(new Items("Ashish","Pansuriya"));
        itemsList.add(new Items("Vishal","Pansuriya"));
        itemsList.add(new Items("Krupal","Pansuriya"));
        itemsList.add(new Items("Sandip","Pansuriya"));
        itemsList.add(new Items("Janak","Pansuriya"));
        itemsList.add(new Items("Mahesh","Pansuriya"));


        myAdapter = new MyAdapter(this,itemsList,this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }


    @Override
    public void ItemOnClick(int position) {
        Toast.makeText(this, "click on"+ itemsList.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ItemOnLongClick(int position) {

        itemsList.remove(position);
        myAdapter.notifyItemRemoved(position);
        myAdapter.notifyDataSetChanged();

    }
}
