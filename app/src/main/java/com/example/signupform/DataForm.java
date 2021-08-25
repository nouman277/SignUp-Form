package com.example.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DataForm extends AppCompatActivity {

    private EditText name,address,cnic,mobileNumber;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_form);

        name = findViewById(R.id.nameEditText);
        address = findViewById(R.id.addressEditText);
        cnic = findViewById(R.id.cnicEditText);
        mobileNumber = findViewById(R.id.mobileNumberEditText);

        final Spinner gender = (Spinner)findViewById(R.id.sGender);

        done=findViewById(R.id.btnDone);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(DataForm.this);

                builder.setMessage("You Enter This Data");

                // Set Alert Title
                builder.setTitle("DATA ENTERED");
                builder.setCancelable(false);

                builder.setPositiveButton(
                        "GO TO LOGIN",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                Intent intent = new Intent(DataForm.this,LogIn.class);
                                startActivity(intent);
                            }
                        });

                builder
                        .setNegativeButton(
                                "GO TO SIGNUP",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {
                                        Intent intent = new Intent(DataForm.this,MainActivity.class);
                                        startActivity(intent);

                                    }
                                });

                AlertDialog alertDialog = builder.create();


                alertDialog.show();



            }
        });



    }
}