package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OnlineHelp extends AppCompatActivity {
    Database dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_help);
        dh = new Database(this);

        final EditText PatientId = findViewById(R.id.patid);
      final EditText DoctorId = findViewById(R.id.docid);
      final  EditText PatientName = findViewById(R.id.pname);
      final EditText Doctorname = findViewById(R.id.dicin);
      final  EditText Message = findViewById(R.id.message);


      final Button Send  = findViewById(R.id.Send);
      final Button Logout = findViewById(R.id.Logout);
        final SharedPreferences preferences =
                getApplicationContext().getSharedPreferences
                        ("MyPref",MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        final CheckBox chk1 = findViewById(R.id.checkBox);
       final  TextView Bill = findViewById(R.id.Bill);

        editor.commit();


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnlineHelp.this,SelectAccount.class));
            }
        });
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String ms = Message.getText().toString();
                boolean added =  dh.addOnlineHelprecord(PatientId.getText().toString(),DoctorId.getText().toString(),PatientName.getText().toString(), Doctorname.getText().toString() , Message.getText().toString());
                if(added) {
                    Toast.makeText(OnlineHelp.this, "Query Sent", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(OnlineHelp.this, "not added", Toast.LENGTH_SHORT).show();
                }
                if(chk1.isChecked())
                {

                    Bill.setText("Bill is"+ 0+"$");
                    editor.putString("mKey",ms);
                    editor.putInt("PKey",50);

                    editor.commit();
                }
                else
                {
                    editor.putString("lKey",ms);
                    Bill.setText("Bill is"+ 30+"$");
                    editor.putInt("PKey",30);

                    editor.commit();


                }





            }
        });





    }
}
