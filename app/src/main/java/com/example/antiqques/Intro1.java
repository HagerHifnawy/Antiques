package com.example.antiqques;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class Intro1 extends AppCompatActivity {
    Button NextIntro1;
    Button SkipIntro1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);
        NextIntro1=findViewById(R.id.nextintro1_btn);
        SkipIntro1=findViewById(R.id.skipintro1_btn);
        NextIntro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro1.this,Intro2.class);
                startActivity(intent);
            }
        });
        SkipIntro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro1.this, Login.class);
                startActivity(intent);
            }
        });


    }
}
