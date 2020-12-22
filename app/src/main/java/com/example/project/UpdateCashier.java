package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCashier extends AppCompatActivity {
    Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cashier);



    Button Update = findViewById(R.id.Update);
       final  EditText name = findViewById(R.id.namecash);
        final EditText email =findViewById(R.id.emailcash);
       final  EditText pass = findViewById(R.id.passcash);
        final  EditText id = findViewById(R.id.idcash);



d = new Database(this);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                boolean x= d.changecashier(name.getText().toString(),email.getText().toString(),pass.getText().toString(),id.getText().toString());
                if(x)
                {
                    Toast.makeText(UpdateCashier.this, "Records is changed", Toast.LENGTH_SHORT).show();

                }







            }
        });
    }
}
