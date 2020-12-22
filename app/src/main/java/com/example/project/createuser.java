package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class createuser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser);
        Button cpatient= findViewById(R.id.userpatient);
        Button cdoctor= findViewById(R.id.userdoctor);
        Button update=findViewById(R.id.button4);

        final Button ChangeCashier = findViewById(R.id.ChangeCashier);

        final Button  CreateCashier = findViewById(R.id.AddCashier);

        ChangeCashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createuser.this,UpdateCashier.class));
            }
        });
        CreateCashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createuser.this,AddCashier.class));
            }
        });




        cpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createuser.this,register.class));
            }
        });
        cdoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createuser.this,createdoctor.class)
                );
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createuser.this,changeact.class));
            }
        });

    }
}
