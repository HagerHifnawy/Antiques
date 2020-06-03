package com.example.antiqques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = Emailedt.getText().toString();
                String Password = Passwordedt.getText().toString();
                if(Email.isEmpty()){
                    Emailedt.setError("Error");
                    Toast.makeText(Login.this, "Please, Enter your Email to Log in", Toast.LENGTH_SHORT).show(); }
                else if (Password.isEmpty()){
                    Passwordedt.setError("Error");
                    Toast.makeText(Login.this, "Please, Enter your password to Log in", Toast.LENGTH_SHORT).show(); }
                else {
                Intent intent = new Intent(Login.this, Home.class);
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