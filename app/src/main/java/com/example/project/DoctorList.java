package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorList extends AppCompatActivity {


Database dbh;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        dbh = new Database(this);
    Cursor c = dbh.viewData();
    String[] doctors =new  String[6];
    for( c.moveToFirst() ; !c.isAfterLast() ; c.moveToNext()){
            doctors[0]=  c.getString(1);

        }

c.close();

    Cursor c1 = dbh.viewData1();

    for( c1.moveToFirst() ; !c1.isAfterLast() ; c1.moveToNext()){
        doctors[1]=  c1.getString(1);

    }

    c1.close();


    Cursor c2 = dbh.viewData2();

    for( c2.moveToFirst() ; !c2.isAfterLast() ; c2.moveToNext()){
        doctors[2]=  c2.getString(1);
        ;
    }

    c2.close();
    Cursor c3 = dbh.viewData3();

    for( c3.moveToFirst() ; !c3.isAfterLast() ; c3.moveToNext()){
        doctors[3]=  c3.getString(1);
        ;
    }

    c3.close();

    Cursor c4= dbh.viewData4();

    for( c4.moveToFirst() ; !c4.isAfterLast() ; c4.moveToNext()){
        doctors[4]=  c4.getString(1);
        ;
    }

    c4.close();

    Cursor c5= dbh.viewData5();

    for( c5.moveToFirst() ; !c5.isAfterLast() ; c5.moveToNext()){
        doctors[5]=  c5.getString(1);
        ;
    }

    c5.close();

    int[] images = {R.drawable.img1 , R.drawable.img2 , R.drawable.img3 , R.drawable.img4 ,R.drawable.img5};
    dbh = new Database(this);


    List<HashMap<String, String>> aList = new ArrayList
            <HashMap<String, String>>();

    for (int i = 0; i < 5; i++) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("txt", doctors[i]);
        hm.put("images", Integer.toString(images[i]));
        aList.add(hm);
    }

    String[] from = {"images", "txt"};
    int[] to = {R.id.image, R.id.travel};

    SimpleAdapter adapter = new SimpleAdapter(getBaseContext(),
            aList, R.layout.listview, from, to);

    ListView listView = findViewById(R.id.list);
    listView.setAdapter(adapter);
    final SharedPreferences preferences =
            getApplicationContext().getSharedPreferences
                    ("MyPref",MODE_PRIVATE);
  final   SharedPreferences.Editor editor = preferences.edit();

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent,
                                View view, int position, long id) {
            switch (position) {

                case 0:
                    Intent i = new Intent(DoctorList.this,Query.class);
                    i.putExtra("data","Name: Dr.Suraj :: Qualification: MBBS(BioMechanics) :: Experiance: 6 years" );
                    startActivity(i);

                    editor.putString("NDKey","Dr.Suraj");

                    editor.commit();

                    break;
                case 1:
                    Intent ii = new Intent(DoctorList.this,Query.class);
                    ii.putExtra("data","Name: Dr.Sagar :: Qualification: MBBS(PTU,AIIMS,Harward Medical School) :: Experiance: 3 years" );
                    startActivity(ii);

                    editor.putString("NDKey","Dr.Sagar");

                    editor.commit();


                    break;
                case 2:
                    Intent iii = new Intent(DoctorList.this,Query.class);
                    iii.putExtra("data","Name: Dr.Anmol :: Qualification: Dentistry(Winnipeg) :: Experiance: 3 years" );
                    startActivity(iii);

                    editor.putString("NDKey","Dr.Anmol");

                    editor.commit();


                    break;
                case 3:
                    Intent iiii = new Intent(DoctorList.this,Query.class);
                    iiii.putExtra("data","Name: Dr.Akash :: Qualification: MD :: Experiance: 3 years" );
                    startActivity(iiii);

                    editor.putString("NDKey","Dr.Akash");

                    editor.commit();


                    break;
                case 4:
                    Intent iiiii = new Intent(DoctorList.this,Query.class);
                    iiiii.putExtra("data","Name: Dr.Gaurav :: Qualification: MBBS(aims,india) :: Experiance: 3 years" );
                    startActivity(iiiii);

                    editor.putString("NDKey","Dr.Suraj");

                    editor.commit();


                    break;
            }
        }


    });

    }}
