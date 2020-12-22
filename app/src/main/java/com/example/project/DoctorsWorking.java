package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DoctorsWorking extends AppCompatActivity {
Database dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_working);
      final  TextView Q = findViewById(R.id.Query);
       final  EditText id = findViewById(R.id.id);
        Button See = findViewById(R.id.see);
        Button Log = findViewById(R.id.LogOut);
        dh  = new Database(this);
final EditText solution  = findViewById(R.id.solution);
Button appoint = findViewById(R.id.appoint);
appoint.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(DoctorsWorking.this,Appointments.class));
    }
});




Button Post =findViewById(R.id.post);
Post.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String sol = solution.getText().toString();
        final SharedPreferences preferences =
                getApplicationContext().getSharedPreferences
                        ("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("skey",sol);
        editor.commit();

    }
});



        See.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(id.getText().toString().equals("3") ) {
            Cursor c = dh.Viewquery3();
            while (c.moveToNext()) {
                Q.setText("Message is :" + c.getString(4));
            }
        }
        if(id.getText().toString().equals("1") ) {
            Cursor c = dh.Viewquery1();
            while (c.moveToNext()) {
                Q.setText("Message is :" + c.getString(4));
            }
        }
        if(id.getText().toString().equals("2") ) {
            Cursor c = dh.Viewquery2();
            while (c.moveToNext()) {
                Q.setText("Message is :" + c.getString(4));
            }
        }
        if(id.getText().toString().equals("4") ) {
            Cursor c = dh.Viewquery4();
            while (c.moveToNext()) {
                Q.setText("Message is :" + c.getString(4));
            }
        }
        if(id.getText().toString().equals("5") ) {
            Cursor c = dh.Viewquery5();
            while (c.moveToNext()) {
                Q.setText("Message is :" + c.getString(4));
            }
        }


    }
});

        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorsWorking.this,MainActivity.class));
            }
        });







    }
}
