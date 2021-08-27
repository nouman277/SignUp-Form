package com.example.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaCodec;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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


            }
        });

            }

    boolean isEmail(EditText eMail) {
        CharSequence email = eMail.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText password) {
        CharSequence str = password.getText().toString();
        return TextUtils.isEmpty(str);
    }

 private void checkDataEntered(){



     if (isEmpty(password)) {
         password.setError("PASSWORD CANNOT BE EMPTY");
     }

     if (isEmpty(confirmPassword)) {
         confirmPassword.setError("CONFIRM password CAN NOT BE EMPTY");
     }

     if (isEmail(eMail) == false) {
         eMail.setError("Enter valid email!");


     }
     if (password.getText().toString().length()<6){
         password.setError("PASSWORD MUST BE SIX CHARACTER OR MORE ");
     }


     else {
         Intent i = new Intent(MainActivity.this,LogIn.class);
         startActivity(i);
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



