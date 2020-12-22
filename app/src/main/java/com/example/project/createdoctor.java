package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createdoctor extends AppCompatActivity {
Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdoctor);
        final EditText e1= findViewById(R.id.docname);
        final EditText e2= findViewById(R.id.docpass);
        final EditText e3= findViewById(R.id.docemail);
        final EditText e4= findViewById(R.id.docpost);
        Button x= findViewById(R.id.button3);
        d= new Database(this);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            boolean a=    d.adddocbyadmin(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString());
                 if(a)
                 {
                     Toast.makeText(createdoctor.this,"added",Toast.LENGTH_LONG).show();
                 }
            }
        });
    }
}
