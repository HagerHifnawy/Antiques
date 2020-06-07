package com.example.antiqques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Emailedt;
    EditText Passwordedt;
    Button LoginBtn;
    Button ForgetpassBtn;
    Button RegisteraccountBtn;
    Button forgetphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        Emailedt = findViewById(R.id.editTextTextEmailAddress);
        Passwordedt = findViewById(R.id.editTextTextPassword);
        LoginBtn = findViewById(R.id.Login_btn);
        ForgetpassBtn = findViewById(R.id.forget_pass_btn);
        RegisteraccountBtn = findViewById(R.id.register_account_btn);
        ForgetpassBtn.setPaintFlags(ForgetpassBtn.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        RegisteraccountBtn.setPaintFlags(RegisteraccountBtn.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dwascx evwdsc
                String Email = Emailedt.getText().toString();
                String Password = Passwordedt.getText().toString();
                if(Email.isEmpty()){
                    Emailedt.setError("Please, Enter your Email to Log in");
                     }
                else if (Password.isEmpty()){
                    Passwordedt.setError("Please, Enter your Password to Log in");
                     }
                else {
                Intent intent = new Intent(Login.this, CategoryActivity.class);
                startActivity(intent);
            }}
        });
        ForgetpassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });
        RegisteraccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);            }
        });

    }
    public void openDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");

    }
}