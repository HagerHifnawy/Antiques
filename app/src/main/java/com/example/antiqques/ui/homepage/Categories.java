package com.example.antiqques.ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antiqques.R;
import com.example.antiqques.ui.category.ArtActivity;
import com.example.antiqques.ui.category.SculptureActivity;
import com.example.antiqques.ui.category.CrochetActivity;
import com.example.antiqques.ui.category.SewingActivity;
import com.example.antiqques.ui.category.EmbroideryActivity;
import com.example.antiqques.ui.category.EarthenwareActivity;
import com.example.antiqques.ui.category.AccessoriesActivity;
import com.example.antiqques.ui.category.BagsActivity;
import com.example.antiqques.ui.category.PulloversActivity;
import com.example.antiqques.ui.category.ScarfActivity;
import com.example.antiqques.ui.category.BridesActivity;
import com.example.antiqques.ui.category.DressesActivity;
import com.example.antiqques.ui.category.BabyActivity;
import com.example.antiqques.ui.category.WeddingPlannerActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Categories extends Fragment {
    TextView art, sculipture, crochet, sewing, embroidery, earthenware, accessories, bags, pullovers, scarf, brides, dresses, baby, wedding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_category_main, container, false);

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        art = view.findViewById(R.id.btn_Art);
        sculipture = view.findViewById(R.id.btn_sculipture);
        crochet = view.findViewById(R.id.btn_crochet);
        sewing = view.findViewById(R.id.btn_sewing);
        embroidery = view.findViewById(R.id.btn_embroidery);
        earthenware = view.findViewById(R.id.btn_earthenware);
        accessories = view.findViewById(R.id.btn_accessories);
        bags = view.findViewById(R.id.btn_bags);
        pullovers = view.findViewById(R.id.btn_pullovers);
        scarf = view.findViewById(R.id.btn_scarf);
        brides = view.findViewById(R.id.btn_brides);
        dresses = view.findViewById(R.id.btn_dresses);
        baby = view.findViewById(R.id.btn_baby);
        wedding = view.findViewById(R.id.btn_wedding);
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ArtActivity.class));
            }
        });
        sculipture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),SculptureActivity.class));
            }
        });

        crochet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),CrochetActivity.class));
            }
        });
        sewing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),SewingActivity.class));
            }
        });
        embroidery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),EmbroideryActivity.class));
            }
        });
        earthenware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),EarthenwareActivity.class));
            }
        });
        accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),AccessoriesActivity.class));
            }
        });
        bags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),BagsActivity.class));
            }
        });
        pullovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),PulloversActivity.class));
            }
        });
        scarf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ScarfActivity.class));
            }
        });
        brides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),BridesActivity.class));
            }
        });
        dresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),DressesActivity.class));
            }
        });
        baby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),BabyActivity.class));
            }
        });
        wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),WeddingPlannerActivity.class));
            }
        });

    }

    }

