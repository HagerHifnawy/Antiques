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

import com.example.antiqques.pojo.CategoryActivity;
import com.example.antiqques.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText userNameEdt;
    EditText PasswordEdt;
    EditText ConfirmPasswordEdt;
    EditText PhoneEdt;
    EditText EmailEdt;
    Button SignUpBtn;
    Button SignInBtn;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //sacd
        userNameEdt = findViewById(R.id.user_name_edt);
        PasswordEdt = findViewById(R.id.passwor_edt);
        ConfirmPasswordEdt = findViewById(R.id.confirm_passwor_edt);
        PhoneEdt = findViewById(R.id.phone);
        EmailEdt = findViewById(R.id.email_edt);
        SignUpBtn = findViewById(R.id.signUp_btn);
        SignInBtn = findViewById(R.id.signIn_btn);

        firebaseAuth= FirebaseAuth.getInstance();
        // SignUp
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
                } else if (TextUtils.isEmpty(password)) {
                    PasswordEdt.setError("please enter password");
                } else if (TextUtils.isEmpty(confirmPassword)) {
                    ConfirmPasswordEdt.setError("please confirm password");
                } else if (TextUtils.isEmpty(phone)) {
                    PhoneEdt.setError("please enter phone ");
                } else if (TextUtils.isEmpty(email)) {
                    EmailEdt.setError("please enter you email");
                } else {
                    Intent intent = new Intent(SignUp.this, CategoryActivity.class);
                    startActivity(intent);

                }
                //  Send data to firebase
                signUp();
            }
        });
        //SignIn
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

    }
    private void signUp() {
        String email = EmailEdt.getText().toString();
        String password = PasswordEdt.getText().toString();
        String confirmPass = ConfirmPasswordEdt.getText().toString();
        String username = userNameEdt.getText().toString();
        String phone =PhoneEdt.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Login success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this, Login.class));
                            finish();

                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(SignUp.this, errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}