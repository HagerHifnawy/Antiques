package com.example.antiqques.ui.intro;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.antiqques.R;
import com.example.antiqques.ui.registration.Login;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;


public class Intro extends AppCompatActivity {
    private MaterialButton NextIntro1;

    private IntroAdapter introAdapter;
    private LinearLayout layoutintroindicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        layoutintroindicators = findViewById(R.id.layoutintroIndicatores);
        NextIntro1 = findViewById(R.id.btn_Nextintro);

        SetUpOnIntroItems();
        final ViewPager2 introViewbpager = findViewById(R.id.introViewPager);
        introViewbpager.setAdapter(introAdapter);
        setupintroIndicators();
        setCurrentInroIndicator(0);
        introViewbpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentInroIndicator(position);
            }
        });
        NextIntro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (introViewbpager.getCurrentItem() + 1 < introAdapter.getItemCount()) {
                    introViewbpager.setCurrentItem(introViewbpager.getCurrentItem() + 1);

                } else {
                    startActivity(new Intent( getApplicationContext(), Login.class));
                    finish();
                }
            }
        });
    }

    private void SetUpOnIntroItems() {

        List<IntroScreenItem> introScreenItems = new ArrayList<>();
        //gift
        IntroScreenItem itemGift = new IntroScreenItem();
        itemGift.setTitle("Get Your gift easier");
        itemGift.setDescription("just select your gift and buy with one click ;)");
        itemGift.setScreenImg(R.drawable.firstintro);
        //online
        IntroScreenItem itemonlineshop = new IntroScreenItem();
        itemonlineshop.setTitle("Online Shopping");
        itemonlineshop.setDescription("It is not an ordinary shopping ,but it is handmade of all kinds.(crochet, drawing,craving, embroidery and lap,,etc…)");
        itemonlineshop.setScreenImg(R.drawable.secondintro);
        //trade
        IntroScreenItem itemTrade = new IntroScreenItem();
        itemTrade.setTitle("Trade online");
        itemTrade.setDescription("Anyone can share what he did with his hands in the app and sell it in an easy way  while ensuring safety");
        itemTrade.setScreenImg(R.drawable.thirdintro);
//showadaptor
        introScreenItems.add(itemonlineshop);
        introScreenItems.add(itemGift);
        introScreenItems.add(itemTrade);
        introAdapter = new IntroAdapter(introScreenItems);

    }

    private void setupintroIndicators() {
        ImageView[] indicators = new ImageView[introAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.intro_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutintroindicators.addView(indicators[i]);

        }

    }

    private void setCurrentInroIndicator(int index) {
        int childCount = layoutintroindicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutintroindicators.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                getApplicationContext(),
                                R.drawable.intro_active)
                );
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getApplicationContext(),
                        R.drawable.intro_inactive
                ));
            }

        }
        if (index== introAdapter.getItemCount()-1){
            NextIntro1.setText("Finish");
        }else {
            NextIntro1.setText("Next");
        }
    }
}