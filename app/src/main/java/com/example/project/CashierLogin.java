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

public class CashierLogin extends AppCompatActivity {
Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_login);
        final EditText uname= findViewById(R.id.cuname);
        final EditText pass= findViewById(R.id.cpass);
        CheckBox chk2 = findViewById(R.id.sh4);
        Button w= findViewById(R.id.button6);
        d= new Database(this);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u= uname.getText().toString();
                String p= pass.getText().toString();

                Cursor f= d.cashierlogin(u,p);
              if(f.getCount()>0)
              {
                  Toast.makeText(CashierLogin.this, "Login cashier", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(CashierLogin.this,viewpayments.class));
              }
              else
              {
                  Toast.makeText(CashierLogin.this, "Login nottt cashier", Toast.LENGTH_SHORT).show();
              }

            }
        });
        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }


            }
        });
    }
}
