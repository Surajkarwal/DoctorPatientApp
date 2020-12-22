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
import android.widget.Toast;

public class changeact extends AppCompatActivity {
  Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeact);
        EditText  st= findViewById(R.id.tablename);
        EditText id= findViewById(R.id.idforupdate);
        final TextView result= findViewById(R.id.show);
        Button c= findViewById(R.id.change);
        Button v= findViewById(R.id.button2);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText e= findViewById(R.id.tablename);
                final EditText f= findViewById(R.id.idforupdate);
                Button c= findViewById(R.id.change);
                final String no = f.getText().toString();
                final String tname=e.getText().toString();
                final SharedPreferences preferences =
                        getApplicationContext().getSharedPreferences
                                ("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nKey",no);
                editor.putString("tKey",tname);
                editor.commit();
                Cursor a= d.viewrecord1(tname,no);
                if(a.getCount()>0)
                {
                    StringBuilder s= new StringBuilder();
                    while(a.moveToNext())
                    {
                        s.append("Id :" + a.getString(0));
                        s.append("\n");
                        s.append(" Name :" +a.getString(1));
                        s.append("\n");
                        s.append("Postal code:" + a.getString(2));
                        s.append("\n");
                        s.append(" Email: " + a.getString(3));
                        s.append("\n");


                    }
                    result.setText(s);
                }

            }
        });
        d= new Database(this);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   final EditText e= findViewById(R.id.tablename);
                   final EditText f= findViewById(R.id.idforupdate);

                   Button c= findViewById(R.id.change);
                final String no = f.getText().toString();
                final String tname=e.getText().toString();
                final SharedPreferences preferences =
                        getApplicationContext().getSharedPreferences
                                ("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nKey",no);
                editor.putString("tKey",tname);
                editor.commit();
                String uname=e.getText().toString();
                String pass= f.getText().toString();
                if(uname.length()==0 )
                {
                    e.requestFocus();
                    e.setError("Table [status ] name can t be empty!");
                }
                else if(pass.length()==0)
                {
                    f.requestFocus();
                    f.setError("Id name can t be empty!");
                }
                else {

                    Cursor a = d.viewrecord1(tname, no);
                    if (a.getCount() > 0) {
                        StringBuilder s = new StringBuilder();
                        while (a.moveToNext()) {
                            s.append("Id :" + a.getString(0));
                            s.append("\n");
                            s.append(" Name :" + a.getString(1));
                            s.append("\n");
                            s.append("Email:" + a.getString(2));
                            s.append("\n");
                            s.append(" Postal code: " + a.getString(3));
                            s.append("\n");


                        }
                        result.setText(s);
                        boolean x = d.find(no, tname);
                        if (x) {
                            Toast.makeText(changeact.this, "found", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(changeact.this, valuechange.class));


                        } else {
                            Toast.makeText(changeact.this, "not found", Toast.LENGTH_LONG).show();
                        }
                    }





                }
            }
        });

    }
}
