package com.example.antiqques.ui.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.antiqques.R;
import com.example.antiqques.ui.registration.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText userNameEdt;
    private EditText PasswordEdt;
    private EditText ConfirmPasswordEdt;
    private EditText PhoneEdt;
    private EditText EmailEdt;
    private Button SignUpBtn;
    private Button SignInBtn;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userNameEdt = findViewById(R.id.user_name_edt);
        PasswordEdt = findViewById(R.id.passwor_edt);
        ConfirmPasswordEdt = findViewById(R.id.confirm_passwor_edt);
        PhoneEdt = findViewById(R.id.phone);
        EmailEdt = findViewById(R.id.email_edt);
        SignUpBtn = findViewById(R.id.signUp_btn);
        SignInBtn = findViewById(R.id.signIn_btn);
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });
        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }
    private void signUp() {
        String Email = EmailEdt.getText().toString();
        String password = PasswordEdt.getText().toString();
        auth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Account Created", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            String messageerror = task.getException().getMessage();
                            Toast.makeText(SignUp.this, messageerror, Toast.LENGTH_SHORT).show(); } }
                });
    }
}