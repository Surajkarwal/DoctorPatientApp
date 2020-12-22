package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Database dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText name= findViewById(R.id.name);
        final EditText pas= findViewById(R.id.password);
        final EditText email= findViewById(R.id.eadd);
        final  EditText postal= findViewById(R.id.pcode);
        Button s= findViewById(R.id.addtodb);

        Button v= findViewById(R.id.view);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = dh.view();
                StringBuilder s = new StringBuilder();
                if(c.getCount()>0){
                    while(c.moveToNext()){
                        s.append("Id" + c.getString(0));
                        s.append(" Name "+ c.getString(1));
                        s.append(" Password "+ c.getString(2));
                        s.append(" Email" + c.getString(3));
                        s.append(" postal code" + c.getString(4));

                        s.append("\n");
                    }
                   
                }
                else{
                    Toast.makeText(register.this,
                            "Nothing to display", Toast.LENGTH_LONG).show();
                }

            }
        });
        dh = new Database(this);
        s.setOnClickListener(new View.OnClickListener() {
            boolean added;
            @Override
            public void onClick(View v) {//(  String n,String pass,String eadd, String pcode)
                            if(name.getText().toString().equals("")||pas.getText().toString().equals("")||email.getText().toString().equals("")||postal.getText().toString().equals(""))
               {
                   Toast.makeText(register.this, "One Of Your Fields May be empty", Toast.LENGTH_SHORT).show();
               }
           else
                {
                    added=dh.addrecord(name.getText().toString(),pas.getText().toString(),email.getText().toString(),postal.getText().toString());



                    if(added) {

                    Toast.makeText(register.this, "added", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(register.this,Login.class));
                }
                else
                {
                    Toast.makeText(register.this, "Not added", Toast.LENGTH_SHORT).show();
                }
                }


            }


        });

    }
}
