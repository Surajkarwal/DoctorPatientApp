package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class valuechange extends AppCompatActivity {
    Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valuechange);
        d= new Database(this);
        final EditText name= findViewById(R.id.editText2);
        final EditText email= findViewById(R.id.emailcash);
        final EditText pass= findViewById(R.id.password);
        final EditText pos= findViewById(R.id.postalcode);
        Button btn= findViewById(R.id.button5);
        final TextView cresult=findViewById(R.id.changedresult);


        final SharedPreferences preferences =
                getApplicationContext().getSharedPreferences
                        ("MyPref",MODE_PRIVATE);
       final String xxid = preferences.getString("nKey","sgsd");
       final  String xxname = preferences.getString("tKey","bnmb");





        Toast.makeText(valuechange.this,"table"+xxid+xxname,Toast.LENGTH_LONG).show();
                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n= name.getText().toString();
                String p= pass.getText().toString();
                String e=email.getText().toString();
                String po=pos.getText().toString();

               boolean x= d.changevalueuser(n,p,e,po, xxid, xxname);
               if(x)
               {
                   Toast.makeText(valuechange.this,"changed",Toast.LENGTH_LONG).show();
                   Cursor q=d.viewrecord1(xxname,xxid);
                   if(q.getCount()>0)
                   {
                       StringBuilder s= new StringBuilder();
                       while(q.moveToNext())
                       {
                           s.append("XXchanged valuesXX");s.append("\n");
                          s.append( "Id :"+ q.getString(0));
                           s.append("\n");
                          s.append("Name: "+q.getString(1));
                           s.append("\n");
                          s.append("Password:"+q.getString(2));
                           s.append("\n");
                          s.append("Email:"+ q.getString(3));
                           s.append("\n");
                          s.append("Postal code:"+q.getString(4));
                           s.append("\n");

                       }
                       cresult.setText(s);
                   }

               }
               else
               {
                   Toast.makeText(valuechange.this," notchanged",Toast.LENGTH_LONG).show();

               }


            }
        });

    }
}
