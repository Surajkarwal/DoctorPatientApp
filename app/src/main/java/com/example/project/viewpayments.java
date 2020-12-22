package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class viewpayments extends AppCompatActivity {
Database d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpayments);
        Button u=findViewById(R.id.button7);
        d= new Database(this);
       // final EditText pid= findViewById(R.id.editText5);
        final EditText pid= findViewById(R.id.editText3);
        Button due= findViewById(R.id.button8);
       final TextView tv= findViewById(R.id.viewpayments);

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor y= d.viewpayments(pid.getText().toString());
                if(y.getCount()>0)
                {
                    Toast.makeText(viewpayments.this, "payments found!", Toast.LENGTH_SHORT).show();
                    StringBuilder d= new StringBuilder();
                    while(y.moveToNext())
                    {
                        d.append(" Patient id: "+ y.getString(0));    d.append("\n");
                        d.append(" doctor id: "+y.getString(1));
                        d.append("\n");
                        d.append(" payment amount"+y.getString(2));    d.append("\n");
                        d.append(" payment type "+ y.getString(3));
                        d.append("Date :"+y.getString(4));
                        d.append("\n");
                        d.append(" **email address *** "+y.getString(5));
                        d.append("\n");

                    }

                    tv.setText(d);
                }
                else
                {
                    Toast.makeText(viewpayments.this, "not found !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        due.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor y=d.viewdue(pid.getText().toString());
                if(y.getCount()>0)
                {
                    tv.setText("");
                    Toast.makeText(viewpayments.this, "found  due payments!", Toast.LENGTH_SHORT).show();
                    StringBuilder d= new StringBuilder();
                    while(y.moveToNext())
                    {
                        d.append("**************// next due payment//****");
                        d.append(" Patient id: "+ y.getString(0));    d.append("\n");
                        d.append(" doctor id: "+y.getString(1));
                        d.append("\n");
                        d.append(" payment amount"+y.getString(2));    d.append("\n");
                        d.append(" payment type "+ y.getString(3));
                        d.append("Date :"+y.getString(4));
                        d.append(" **email address *** "+y.getString(5));
                        
                        d.append("\n");
                       // d.append("Email Patient :"+y.getString(5));
                        d.append("\n");

                    }

                    tv.setText(d);
                }
            }
        });
        Button remind= findViewById(R.id.report);
        final EditText e=findViewById(R.id.emailcash);
        remind.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Cursor b=d.remind(e.getText().toString());

                if(b.getCount()>0)
                {
                    Toast.makeText(viewpayments.this, "All Patient are reminded !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(viewpayments.this, "Some Problem !", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
