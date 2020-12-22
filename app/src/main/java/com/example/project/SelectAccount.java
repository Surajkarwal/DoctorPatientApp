package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectAccount extends AppCompatActivity {
Database db1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account);

db1= new Database(this);
        int[]  id = {1,2,3,4,5};
        String[] name = {"Dr.suraj","Dr.sagar","Dr.Anmol","Dr.Akash","Dr.gaurav"};
        String[] pass = {"suraj","sagar","anmol","akash","gaurav"};
        String[] email = {"skarwal@gmail.com","sagar@gmail.com","aj@gmail.com","av@gmail.com","gk@gmail.com"};
        String[] postal = {"v3v vxz","v3v zxv","v3v 123" , " v3z xcv" , "v3v z3c","vc3 v34"};
        boolean added = true;
        db1 = new Database(this);
        for(int i = 0 ; i <id.length ; i++ ) {

            added =  db1.addDoctorrecord(id[i], name[i], pass[i], email[i], postal[i]);
        }
        if (added) {
            Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "not", Toast.LENGTH_SHORT).show();
        }
        int[]  pid = {1,2,3,4,5};
        int[] did={1,2,3,4,5};


        String[] payment = {" $ 80 ","0","$ 67" , " $ 20" , "0","$ 44.69"};
        String [] paytype={"Visa","Cash","Credit","Mastercard","cash"};
        String [] date={" 29-02-2019","02-01-2020","20-01-2019","23-04-11","11-11-2020"};
        String [] em={"dave@gmail.com","monty@gmail.com","anmol@gmail.com","saurav@gmail.com","gk@gmail.com"};
        boolean ad = true;
        db1 = new Database(this);
        for(int i = 0 ; i <id.length ; i++ ) {

            ad =  db1.addpaymentdata(id[i], did[i], payment[i], paytype[i],date[i],em[i]);
        }
        if (ad) {
            Toast.makeText(this, "added payments", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "not", Toast.LENGTH_SHORT).show();
        }
String idc = "1";
        String namec = "Garry";
        String passwordc = "garry";

       boolean added1 =  db1.addadminrecord(idc,namec,passwordc);
       if(added1)
    {
            Toast.makeText(this, "Admin added added", Toast.LENGTH_SHORT).show();
        }
       else
       {
           Toast.makeText(this, "Admin not added", Toast.LENGTH_SHORT).show();
       }

      boolean c=db1.addcashier();
       if(c)
       {
           Toast.makeText(SelectAccount.this, "cashier added ", Toast.LENGTH_SHORT).show();
       }
       else
       {
           Toast.makeText(SelectAccount.this, "cashier added ", Toast.LENGTH_SHORT).show();

       }
        int[]  id1 = {1,2,3,4,5};
        String[] pname = {"dave","monty","Anmol","Akash","saurav"};
        String[] pas = {"123","456","678","910","111"};
        String[] e= {"dave@gmail.com","monty@gmail.com","anmol@gmail.com","saurav@gmail.com","gk@gmail.com"};
        String[] post = {"v3v vxz","v3v zxv","v3v 123" , " v3z xcv" , "v3v z3c","vc3 v34"};
        boolean add = true;
        db1 = new Database(this);
        for(int i = 0 ; i <id.length ; i++ ) {

            added =  db1.addpatient(id1[i], pname[i], pas[i], e[i], post[i]);
        }
        if (added) {
            Toast.makeText(this, "added Patient", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "not added patient", Toast.LENGTH_SHORT).show();
        }


        Button Patient = findViewById(R.id.PatientAccount);
        Button Doctor = findViewById(R.id.DoctorAccount);
        Button Cashier  = findViewById(R.id.CashierAccount);
        Button admin = findViewById(R.id.AdminAccount);


        Patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectAccount.this,Login.class));

            }
        });

        Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectAccount.this,DoctorLogin.class));
            }

        });

        Cashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(SelectAccount.this,Adminlogin.class));
            }
        });
        Cashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectAccount.this,CashierLogin.class));
            }
        });



    }
}
