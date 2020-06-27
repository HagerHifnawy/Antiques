package com.example.antiqques.pojo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antiqques.R;
import com.example.antiqques.ui.intro.IntroScreenItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public static class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.IntroViewHolder> {
        private List<IntroScreenItem> introscreenitems;

        public IntroAdapter(List<IntroScreenItem> introscreenitems) {
            this.introscreenitems = introscreenitems;
        }

        @NonNull
        @Override
        public IntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new IntroViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.layout_intro_screen, parent, false
                    )
            );
        }

        @Override
        public void onBindViewHolder(@NonNull IntroViewHolder holder, int position) {
            holder.setIntroData(introscreenitems.get(position));
        }

        @Override
        public int getItemCount() {
            return introscreenitems.size();
        }

        class IntroViewHolder extends RecyclerView.ViewHolder {
            private TextView title;
            private TextView description;
            private ImageView imageintro;

            public IntroViewHolder(@NonNull View itemView) {
                super(itemView);
                imageintro = itemView.findViewById(R.id.intro1_img);
                title = itemView.findViewById(R.id.intro1_title_tv);
                description = itemView.findViewById(R.id.intro1_desc_tv);


            }

            void setIntroData(IntroScreenItem intro_screen_item) {
                imageintro.setImageResource(intro_screen_item.getScreenImg());
                title.setText(intro_screen_item.getTitle());
                description.setText(intro_screen_item.getDescription());
            }
        }

    }
}