package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_location);
       final  EditText ps = findViewById(R.id.a);




        Button btn1 = findViewById(R.id.find);




            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String postalCode = ps.getText().toString();


                    if(postalCode.equals(""))
                    {
                        Toast.makeText(DoctorLocation.this, "Please enter the postal code first"+postalCode, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                       
                        startActivity(new Intent(DoctorLocation.this,DoctorList.class));
                    }


                }
            });










    }
}
