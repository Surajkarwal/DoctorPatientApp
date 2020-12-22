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


public class DoctorLogin extends AppCompatActivity {
    Database db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
db1 = new Database(this);
            Button btn = findViewById(R.id.Login1);
       final  EditText Username = findViewById(R.id.Username);
        final EditText Password = findViewById(R.id.Passwo);

        final CheckBox chk1 = findViewById(R.id.sh222);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Cursor confirm = db1.checkDoctormember(Username.getText().toString(),Password.getText().toString());
                    if(confirm.getCount()>0) {

                   startActivity(new Intent(DoctorLogin.this,DoctorsWorking.class));
                    }
                    else
                    {
                        Toast.makeText(DoctorLogin.this," log not suceesfully"+Username.getText().toString()+Password.getText().toString(),Toast.LENGTH_LONG).show();
                    }
                }
            });
      chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean b) {
              if(b)
              {
                  Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
              }
              else
              {
                  Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
              }


          }
      });





    }
}
