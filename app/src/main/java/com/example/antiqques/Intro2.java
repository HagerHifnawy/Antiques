package com.example.antiqques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro2 extends AppCompatActivity {
Button NextIntro2;
Button SkipIntro2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
        NextIntro2=findViewById(R.id.nextintro2_btn);
        SkipIntro2=findViewById(R.id.skipintro2_btn);
        NextIntro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro2.this,Intro3.class);
                startActivity(intent);
            }
        });
        SkipIntro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro2.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
