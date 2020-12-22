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

public class Login extends AppCompatActivity {
    Database dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        CheckBox chk2 = findViewById(R.id.sh3);

        Button sign=findViewById(R.id.sigin);
        Button add=findViewById(R.id.Addmember);
       final EditText uname= findViewById(R.id.username);
       final EditText pas= findViewById(R.id.pass);
        dt= new Database(this);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Cursor eid= dt.remind(uname.getText().toString());

            if(eid.getCount()>0)
            {
                for(int j=0;j<4;j++) {
                    Toast.makeText(Login.this, "Your payment is due ! Please pay your bills", Toast.LENGTH_SHORT).show();

                }// Toast.makeText(Login.this, "Your payment is due ! Please pay youer bills", Toast.LENGTH_SHORT).show();
            }
           Cursor confirm = dt.checkmember(uname.getText().toString(),pas.getText().toString());
           if(confirm.getCount()>0) {
               Toast.makeText(Login.this," log in suceesfully",Toast.LENGTH_LONG).show();
               startActivity(new Intent(Login.this, DoctorLocation.class));
           }
           else
           {
               Toast.makeText(Login.this," log not suceesfully",Toast.LENGTH_LONG).show();
           }

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this,register.class));

            }
        });
        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                {
                    pas.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    pas.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }


            }
        });
    }
}
