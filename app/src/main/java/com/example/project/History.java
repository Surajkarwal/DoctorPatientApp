package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        TextView Hist = findViewById(R.id.hist);

        final SharedPreferences preferences =
                getApplicationContext().getSharedPreferences
                        ("MyPref",MODE_PRIVATE);
        String  Nmae = preferences.getString("NDKey","suraj");
        String message = preferences.getString("mKey","Body Problem");
        int Bill = preferences.getInt("PKey",50);
        String solution = preferences.getString("skey","eat aspirin");
        Hist.setText(" Name of Doctor is = " +Nmae + " \n" +"\n"+ " Your MESSAGE to doctor is = " + message + "\n"+"\n" + "Bill is = " + Bill+"\n" +"\n"+" Solution Posted by doctor is **" +solution+"**" );



    }
}
