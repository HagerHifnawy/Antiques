package com.example.antiqques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    EditText userNameEdt;
    EditText PasswordEdt;
    EditText ConfirmPasswordEdt;
    EditText PhoneEdt;
    EditText EmailEdt;
    Button SignUpBtn;
    Button SignInBtn;

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
        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameEdt.getText().toString();
                String password = PasswordEdt.getText().toString();
                String confirmPassword = ConfirmPasswordEdt.getText().toString();
                String phone = PhoneEdt.getText().toString();
                String email = EmailEdt.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    userNameEdt.setError("please enter Username");
                }else if (TextUtils.isEmpty(password)){
                    PasswordEdt.setError("please enter password");
                }else if (TextUtils.isEmpty(confirmPassword)){
                    ConfirmPasswordEdt.setError("please confirm password");
                }else if (TextUtils.isEmpty(phone)){
                    PhoneEdt.setError("please enter phone ");
                }else if (TextUtils.isEmpty(email)){
                    EmailEdt.setError("please enter you email");
                }else {
                    Intent intent=new Intent(SignUp.this,CategoryActivity.class);
                    startActivity(intent);
                }
            }
        });
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });
    }
}