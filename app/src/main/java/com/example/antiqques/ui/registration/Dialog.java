package com.example.antiqques.ui.registration;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.antiqques.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
private Button forgetphone;
private Button forgetemail;
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);
        builder.setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        forgetphone = view.findViewById(R.id.phone_forget);
        forgetemail = view.findViewById(R.id.email_forget);
        forgetphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dialog.this.getContext(), ForgetPassword.class));
            }
        });
     forgetemail.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             startActivity( new Intent(Dialog.this.getContext(), ForgetPassword.class));
         }
     });
        return builder.create();
    }

}
