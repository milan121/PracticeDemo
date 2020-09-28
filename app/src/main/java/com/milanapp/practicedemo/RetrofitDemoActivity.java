package com.milanapp.practicedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.Toast;

import com.milanapp.practicedemo.Adapter.MarvelAdapter;
import com.milanapp.practicedemo.Interface.API;
import com.milanapp.practicedemo.Model.Marvel;

import java.util.ArrayList;
import java.util.List;

public class RetrofitDemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MarvelAdapter marvelAdapter;
    private ArrayList<Marvel> marvelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_demo);

        recyclerView = findViewById(R.id.recyclerView_marvel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        Call<List<Marvel>> call = api.getmarvel();

        call.enqueue(new Callback<List<Marvel>>() {
            @Override
            public void onResponse(Call<List<Marvel>> call, Response<List<Marvel>> response) {

                marvelList = new ArrayList<>(response.body());

                marvelAdapter = new MarvelAdapter(RetrofitDemoActivity.this,marvelList);
                recyclerView.setAdapter(marvelAdapter);
                marvelAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Marvel>> call, Throwable t) {

                Toast.makeText(RetrofitDemoActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
