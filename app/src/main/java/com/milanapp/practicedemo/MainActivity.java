package com.milanapp.practicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milanapp.practicedemo.FirebaseOTPActivities.FirebaseRegistrationActivity;

public class MainActivity extends AppCompatActivity {

    private Button tab_btn , nav_btn, recycler_btn, otp_verify_btn , retrofit_demo_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_btn = findViewById(R.id.tab_btn);
        nav_btn = findViewById(R.id.bootom_nav_btn);
        recycler_btn = findViewById(R.id.recycler_btn);
        otp_verify_btn = findViewById(R.id.otp_verify_btn);
        retrofit_demo_btn = findViewById(R.id.retrofit_Demo_btn);


        tab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TabbedActivity.class);
                startActivity(intent);
            }
        });


        nav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NavBottonActivity.class);
                startActivity(intent);
            }
        });

        recycler_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecyclerDemoActivity.class);
                startActivity(intent);
            }
        });

        otp_verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirebaseRegistrationActivity.class);
                startActivity(intent);
            }
        });

        retrofit_demo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RetrofitDemoActivity.class);
                startActivity(intent);
            }
        });
    }
}
