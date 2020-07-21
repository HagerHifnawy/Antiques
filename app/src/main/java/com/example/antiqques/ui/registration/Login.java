package com.example.antiqques.ui.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.antiqques.R;

import com.example.antiqques.ui.homepage.HomeBottomNavigation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText Emailedt;
    private EditText Passwordedt;
    private Button LoginBtn;
    private Button ForgetpassBtn;
    private Button RegisteraccountBtn;
    private Button forgetphone;
    private FirebaseAuth auth= FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Emailedt = findViewById(R.id.editTextTextEmailAddress);
        Passwordedt = findViewById(R.id.editTextTextPassword);
        LoginBtn = findViewById(R.id.Login_btn);
        ForgetpassBtn = findViewById(R.id.forget_pass_btn);
        RegisteraccountBtn = findViewById(R.id.register_account_btn);
        RegisteraccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,SignUp.class));
            }
        });
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });
        ForgetpassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });
    }
    public void openDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");

    }
    private void signin(){
        String Email = Emailedt.getText().toString();
        String password = Passwordedt.getText().toString();
        auth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Login.this, "Log in Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, HomeBottomNavigation.class));
                    finish();
                } else {
                    String messageerror = task.getException().getMessage();
                    Toast.makeText(Login.this, messageerror, Toast.LENGTH_SHORT).show(); } }
        });
    }
}