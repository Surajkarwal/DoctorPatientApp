package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCashier extends AppCompatActivity {
Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cashier);

        Button addrec = findViewById(R.id.addcas);
      final  EditText name = findViewById(R.id.nameadd);
       final EditText email = findViewById(R.id.emailadd);
       final  EditText pass = findViewById(R.id.passadd);


d = new Database(this);
addrec.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        boolean vs= d.createcashier(name.getText().toString(),email.getText().toString(),pass.getText().toString());
        if(vs)
        {
            Toast.makeText(AddCashier.this, "added", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(AddCashier.this, "Not Added", Toast.LENGTH_SHORT).show();
        }
    }
});





    }
}
