package com.example.antiqques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro3 extends AppCompatActivity {
    Button NextIntro3;
    Button SkipIntro3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);
        NextIntro3=findViewById(R.id.nextintro2_btn);
        SkipIntro3=findViewById(R.id.skipintro2_btn);
        NextIntro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro3.this,Home.class);
                startActivity(intent);
            }
        });
        SkipIntro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intro3.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
