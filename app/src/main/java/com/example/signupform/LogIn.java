package com.example.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    private EditText eMailLogin,passwordLogin;


    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);



        eMailLogin=findViewById(R.id.eMailEdittextLogin);
        passwordLogin=findViewById(R.id.passwordEdittextLogin);


        login=findViewById(R.id.loginEditText);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final String email = eMailLogin.getText().toString();
                final String password =passwordLogin.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                final String Email = sharedPreferences.getString("value","");


                SharedPreferences sharedPreferences1 = getSharedPreferences("myKey", MODE_PRIVATE);
                String Password1 = sharedPreferences1.getString("value1","");


                if (email.equals(Email) && password.equals(Password1)) {

                    Intent intent = new Intent(LogIn.this, DataForm.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LogIn.this, " EMAIL or PASSWORD", Toast.LENGTH_SHORT).show();

                }


            }


        });

    }

   public void checkPref(){











   }

}

