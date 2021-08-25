package com.example.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaCodec;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences Sp;
    private EditText eMail, password, confirmPassword;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eMail = findViewById(R.id.eMailEdittext);
        password = findViewById(R.id.passwordEdittext);
        confirmPassword = findViewById(R.id.confirmPasswordEdittext);
        signUp = findViewById(R.id.signUp);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkDataEntered();
                SAVEpref();

                Intent i = new Intent(MainActivity.this,LogIn.class);
                startActivity(i);
            }
        });

            }

 private void checkDataEntered(){

        if (eMail.getText().toString().isEmpty()){

            eMail.setError("Email Cannot be empty");
        }
     if (password.getText().toString().isEmpty()){

         password.setError("password Cannot be empty");
     }
     if (confirmPassword.getText().toString().isEmpty()){

         confirmPassword.setError("confirm password Cannot be empty");
     }
 }


public void SAVEpref(){

    String sEMail = eMail.getText().toString();
    String sConfirmPassword = confirmPassword.getText().toString();


    SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("value", sEMail);
    editor.commit();
    editor.apply();

    SharedPreferences sharedPref1 = getSharedPreferences("myKey", MODE_PRIVATE);
    SharedPreferences.Editor editor1 = sharedPref1.edit();
    editor.putString("value1", sConfirmPassword);
    editor.apply();
    editor.commit();
}

    }



