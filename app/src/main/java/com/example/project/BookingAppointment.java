package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;

public class BookingAppointment extends AppCompatActivity {
Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_appointment);
db = new Database(this);

       final  EditText Name= findViewById(R.id.Name);
        final   EditText Date = findViewById(R.id.Date);
        final  EditText time = findViewById(R.id.time);
        final  EditText patientid = findViewById(R.id.patid);
        final  EditText Doctorid = findViewById(R.id.doc);
        final   Button btn  = findViewById(R.id.bookappointment);


         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String Dates = Date.getText().toString();
                 String Time =  time.getText().toString();
                 String Doctorids = Doctorid.getText().toString();
                 String Patientisd = patientid.getText().toString();
                 String name = Name.getText().toString();
                 boolean added =  db.addAppointmentrecord(name,Dates,Time,Doctorids,Patientisd);
                 if(added)
                 {
                     Toast.makeText(BookingAppointment.this, "added", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(BookingAppointment.this, "not added", Toast.LENGTH_SHORT).show();
                 }

             }
         });

















    }
}
