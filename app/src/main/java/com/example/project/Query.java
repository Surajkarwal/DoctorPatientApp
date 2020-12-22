package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Query extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        TextView result = findViewById(R.id.details);
        Intent intent = getIntent();
        if(intent!=null){
            String output = intent.getStringExtra("data");
            result.setText(output);
        }

        final Button OnlineHelp = findViewById(R.id.online);
        OnlineHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Query.this,OnlineHelp.class));
            }
        });

        final Button DoctorAppointment  = findViewById(R.id.Appointment);
        DoctorAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Query.this,BookingAppointment.class));



            }
        });






        final Button DoctorsAvailability = findViewById(R.id.Availability);

        DoctorsAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Query.this,DoctorAvailability.class));


            }
        });
        Button LoggingOut = findViewById(R.id.LogingOut);
        LoggingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Query.this,SelectAccount.class));
            }
        });
        final Button History = findViewById(R.id.History);
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Query.this,History.class));
            }
        });




    }
}
