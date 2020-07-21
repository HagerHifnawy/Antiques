package com.example.antiqques.ui.homepage;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.antiqques.R;
import com.example.antiqques.pojo.CartActivity;
import com.example.antiqques.ui.category.SculptureActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class HomeBottomNavigation extends AppCompatActivity {
    private NavigationView navigationView;
    private NavController navController;
    private BottomNavigationView bottomNavigationView;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_bottom_navigation);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                startActivity(new Intent(HomeBottomNavigation.this, CartActivity.class));
            }
        });
        bottomNavigationView =  findViewById(R.id.bottomNavigationView);
       bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_framelayout, homeFragment);
        fragmentTransaction.commit();}

      private   BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
           new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFargment = null;
                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                selectedFargment = new HomeFragment();
                                break;
                            case R.id.nav_profile:
                                selectedFargment = new ProfileFragment();
                                break;
                            case R.id.nav_fav:
                                selectedFargment = new FavoriteFragment();
                                break;
                            case R.id.nav_settings:
                                selectedFargment = new SettingFragment();
                                break;
                            case R.id.nav_categorie:
                                selectedFargment = new Categories();
                                break;

                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.container_framelayout, selectedFargment).commit();
                        return true;
                    }
                };

    }
