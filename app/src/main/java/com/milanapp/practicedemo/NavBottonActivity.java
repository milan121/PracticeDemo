package com.milanapp.practicedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.milanapp.practicedemo.Fragments.CameraFragment;
import com.milanapp.practicedemo.Fragments.ContactFragment;
import com.milanapp.practicedemo.Fragments.MapFragment;

public class NavBottonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_botton);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(itemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ContactFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()){

                case R.id.nav_contact:
                    fragment = new ContactFragment();
                    break;

                case R.id.nav_camera:
                    fragment = new CameraFragment();
                    break;

                case R.id.nav_map:
                    fragment = new MapFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
    };
}
