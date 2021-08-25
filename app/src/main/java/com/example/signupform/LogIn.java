package com.example.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    private EditText eMailLogin,passwordLogin,EMAIL,PASSWORD;


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
                checkPref();

                if (eMailLogin.equals(EMAIL) && passwordLogin.equals(PASSWORD)) {

                    Intent intent = new Intent(LogIn.this, DataForm.class);
                    startActivity(intent);

                }


            }


        });

    }

   public void checkPref(){



       SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
       String value = sharedPreferences.getString("value","");
       EMAIL.setText(value);

       SharedPreferences sharedPreferences1 = getSharedPreferences("myKey", MODE_PRIVATE);
       String value1 = sharedPreferences1.getString("value1","");
       PASSWORD.setText(value1);






   }

}

