package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Adminlogin extends AppCompatActivity {
Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
      final   EditText e1= findViewById(R.id.adminname);
       final EditText e2= findViewById(R.id.editText4);
        Button s= findViewById(R.id.adminlogin);
        CheckBox chk2 = findViewById(R.id.sh1);
        d= new Database(this);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname=e1.getText().toString();
                String pass= e2.getText().toString();
                if(uname.length()==0 )
                {
                    e1.requestFocus();
                    e1.setError("User name can t be empty!");
                }
                else if(pass.length()==0)
                {
                    e2.requestFocus();
                    e2.setError("Password can t be empty!");
                }

                else
                {

                    Cursor c= d.checkadmin(e1.getText().toString(),e2.getText().toString());
                    if(c.getCount()>0)
                    {
                        startActivity(new Intent(Adminlogin.this,createuser.class));

                    }
                    else
                    {
                        Toast.makeText(Adminlogin.this,"Please enter a valid cardentials i.e password or id",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                {
                    e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }


            }
        });
    }
}
