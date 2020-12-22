package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Appointments extends AppCompatActivity {
Database dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
dh = new Database(this);
       final EditText id = findViewById(R.id.ids);
       final TextView Q = findViewById(R.id.all);

Button btn1 = findViewById(R.id.seea);


btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(id.getText().toString().equals("3") ) {
            Cursor c = dh.Viewappointments3();
            while (c.moveToNext()) {
                Q.setText("Appointment ="+"\n" +" Date is"  + c.getString(2) + " \n" +c.getString(3) +"\n" +c.getString(4));

            }
        }
        if(id.getText().toString().equals("1") ) {
            Cursor c = dh.Viewappointments1();
            while (c.moveToNext()) {
                Q.setText("Appointment " + c.getString(2) + c.getString(3) + c.getString(4));

            }
        }
        if(id.getText().toString().equals("2") ) {
            Cursor c = dh.Viewappointments2();
            while (c.moveToNext()) {
                Q.setText("Appointment " + c.getString(2) + c.getString(3) + c.getString(4));
            }
        }
        if(id.getText().toString().equals("4") ) {
            Cursor c = dh.Viewappointments4();
            while (c.moveToNext()) {
                Q.setText("Appointment " + c.getString(2) + c.getString(3) + c.getString(4));
            }
        }
        if(id.getText().toString().equals("5") ) {
            Cursor c = dh.Viewappointments5();
            while (c.moveToNext()) {
                Q.setText("Appointment " + c.getString(2) + c.getString(3) + c.getString(4));
            }
        }



    }
});







    }
}
