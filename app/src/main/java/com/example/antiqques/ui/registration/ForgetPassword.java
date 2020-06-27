package com.example.antiqques.ui.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.antiqques.R;

public class ForgetPassword extends AppCompatActivity {
Button confimPassword;
Button resendcodebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        confimPassword=findViewById(R.id.confirm_pass_btn);
        resendcodebtn=findViewById(R.id.receive_code_btn);
        confimPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassword.this, Resetpassword.class));
            }
        });
        resendcodebtn.setPaintFlags(resendcodebtn.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

    }
}