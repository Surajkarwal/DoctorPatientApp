package com.example.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
    public String tname="";
    public String id="";
    final static String  DATABASE1_NAME="Appdatabase.db";
        final static int DATABASE_VERSION=20;
        final static  String TABLE_NAME="Patient";
        final static  String T_col1="PatientId";
        final static  String T_col2="Name";
        final static  String T_col3="Password";
        final static  String T_col4="EmailAddress";
        final static  String T_col5="Postalcode";


    final static  String TABLE2_NAME="Doctor";
    final static  String Tcol1="DoctorId";
    final static  String Tcol2="Name";
    final static  String Tcol3="Password";
    final static  String Tcol4="EmailAddress";
    final static  String Tcol5="Postalcode";

    final static  String TABLE3_NAME="OnlineHelp";
    final static  String col1="Id";
    final static  String col2="DoctorId";
    final static  String col3="PatientName";
    final static  String col4="DoctorName";
    final static  String col5="Message";

    final static  String TABLE4_NAME="Admin";
    final static  String co1="AdminId";
    final static  String co2="AdminName";
    final static  String co3="Password";
    ContentValues c= new ContentValues();

    final static  String TABLE5_NAME="Appointment";
    final static  String c1="AppoimentId";
    final static  String c2="Name";
    final static  String c3="Date";
    final static  String c4="time";
    final static  String c5="Doctorid";
    final static  String c6 ="patientid";

 final static  String Table6 ="Cashier";
 final static String t6cl1="CashierId";
 final static String t6col2="CashierName";
 final static String t6col3="EmailAddress";
 final static String t6col4="Password";

final static String Table7="payments";
final static String t7col1="pId";
final static String t7col2="DId";
final static String t7col3="payamt";
final static String t7col4="paytype";
final static String t7col5="date";
final static String t7col6="email";








    SQLiteDatabase dw= this.getWritableDatabase();
SQLiteDatabase dr= this.getReadableDatabase();


    public Database( Context context )
        {
        super(context,DATABASE1_NAME,null,DATABASE_VERSION);


    }


    //(PatientId , PatientName , password, Patient Address , PatientPostalCode , Problem)


    @Override
    public void onCreate(SQLiteDatabase db) {

    String query = "CREATE TABLE " + TABLE_NAME +
                "(" + T_col1 + " INTEGER PRIMARY KEY," +
               T_col2 + " TEXT," + T_col3 + " TEXT, " +
              T_col4 + " TEXT," +T_col5 +" TEXT)";


        String query1 = "CREATE TABLE " + TABLE2_NAME +
                "(" + Tcol1 + " INTEGER PRIMARY KEY," +
                Tcol2 + " TEXT," + Tcol3 + " TEXT, " +
                Tcol4 + " TEXT," +Tcol5 +" TEXT)";

        String query2 = "CREATE TABLE " + TABLE3_NAME +
                "(" + col1 + " INTEGER PRIMARY KEY," +
                col2 + " INTEGER ," + col3 + " TEXT, " +
                col4 + " TEXT," +col5 +" TEXT)";

        String query3 = "CREATE TABLE " + TABLE4_NAME +
                "(" + co1 + " INTEGER PRIMARY KEY," +
                co2 + " TEXT ," +co3 +" TEXT)";
        String query4 = "CREATE TABLE " + TABLE5_NAME +
                "(" + c1 + " INTEGER PRIMARY KEY," +
                c2 + " TEXT," + c3 + " TEXT, " +
                c4 + " TEXT," +c5 + " TEXT, " +c6 +" TEXT)";
        String q5= "Create table Cashier(CashierId Integer Primary Key, CashierName Text ,EmailAddress Text ,Password Text)";
       String q6="create table payments(PId Integer Primary Key,DId integer ,payamt Text, paytype Text,date Text,email text)";
        db.execSQL(query);
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(q5);
        db.execSQL(q6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL(" DROP  TABLE IF EXISTS " + TABLE_NAME);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE4_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE5_NAME);
        db.execSQL("Drop table if exists "+Table6);
        db.execSQL("Drop table if exists "+Table7);
        onCreate(db);
    }
    public boolean addDoctorrecord( int id , String n,String pass,String eadd, String pcode)
    {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
      //  onUpgrade(db);
        ContentValues cv1= new ContentValues();
        cv1.put(Tcol1,id);
        cv1.put(Tcol2,n);
        cv1.put(Tcol3,pass);
        cv1.put(Tcol4,eadd);
        cv1.put(Tcol5,pcode);

        long i=db.insert(TABLE2_NAME,null,cv1);
        if(i>0)
        {
            return true;
        }
        else

        {
            return false;
        }
    }

//
//    final static  String TABLE5_NAME="Appointment";
//    final static  String c1="AppoimentId";
//    final static  String c2="Name";
//    final static  String c3="Date";
//    final static  String c4="time";
//    final static  String c5="Doctorid";
//    final static  String c6 ="patientid";


    public boolean addAppointmentrecord(  String n,String Date,String time, String docid , String patid)
    {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        //  onUpgrade(db);
        ContentValues cv1= new ContentValues();
        //cv1.put(Tcol1,id);
        cv1.put(c2,n);
        cv1.put(c3,Date);
        cv1.put(c4,time);
        cv1.put(c5,docid);
        cv1.put(c6,patid);

        long i=db.insert(TABLE5_NAME,null,cv1);
        if(i>0)
        {
            return true;
        }
        else

        {
            return false;
        }
    }



    public boolean addOnlineHelprecord(String Patientid , String DoctorId,String DoctorName,String PatientName, String Message)
    {
        SQLiteDatabase db;
        db = this.getWritableDatabase();

        ContentValues cv= new ContentValues();
        cv.put(col1,Patientid);
        cv.put(col2,DoctorId);
        cv.put(col3,DoctorName);
        cv.put(col4,PatientName);
        cv.put(col5,Message);

        long i=db.insert(TABLE3_NAME,null,cv);
        if(i>0)
        { return true; }
        else {
            return false; }
    }

    private void onUpgrade(SQLiteDatabase db) {
    }

    public boolean addrecord(  String n,String pass,String eadd, String pcode)
    {
      SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        //cv.put(T_col1,id);
        cv.put(T_col2,n);
        cv.put(T_col3,pass);
        cv.put(T_col4,eadd);
        cv.put(T_col5,pcode);

        long i=db.insert(TABLE_NAME,null,cv);
        if(i>0)
        {
            return true;
        }
        else

        {
            return false;
        }
    }
    public boolean addadminrecord(String id,String name,String pass)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(co1,id);
        cv.put(co2,name);
        cv.put(co3,pass);

        long i=db.insert(TABLE4_NAME,null,cv);
        if(i>0)
        {
            return true;
        }
        else

        {
            return false;
        }
    }

    public Cursor view()
    {
        SQLiteDatabase db= this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(query,null);
        return c;



    }
    public Cursor checkmember(String name, String pass)
    {
      SQLiteDatabase db= this.getReadableDatabase();
      String  n=name;
      String p= pass;
      String[] c={"Name","Postalcode"};
      Cursor findEntry = db.query("Patient", c, "EmailAddress=? and Password=?", new String[] { n,p}, null, null, null);
      return findEntry;
    }
    public Cursor checkDoctormember(String name, String pass)
    {
        SQLiteDatabase db= this.getReadableDatabase();
        String  n=name;
        String p= pass;
        String[] c={"Name","Postalcode"};
        Cursor findEntry = db.query("Doctor", c, "EmailAddress=? and Password=?", new String[] { n,p}, null, null, null);
        return findEntry;
    }


    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE2_NAME + " where " + Tcol1 + " = 1" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor viewData1(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE2_NAME + " where " + Tcol1 + " = 2" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor viewData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE2_NAME + " where " + Tcol1 + " = 3" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor viewData3(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE2_NAME + " where " + Tcol1 + " = 4" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor viewData4(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE2_NAME + " where " + Tcol1 + " = 5" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor viewData5(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE2_NAME + " where " + Tcol1 + " = 5" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor Viewquery3(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE3_NAME + " where " + col2 + " = 3" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor Viewquery5(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE3_NAME + " where " + col2 + " = 5" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor Viewquery1(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE3_NAME + " where " + col2 + " = 1" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor Viewquery4(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE3_NAME + " where " + col2 + " = 4" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor Viewquery2(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE3_NAME + " where " + col2 + " = 2" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor checkadmin(String n,String p)
    {
        SQLiteDatabase dx= this.getReadableDatabase();


        String[] col={"AdminName","Password"};
        String pass= p;
       //Cursor c=dx.rawQuery(b,null);
       Cursor x= dx.query("Admin",col,"Password=?",new String[]{pass},null,null,null);
       return x;



    }
    public boolean adddocbyadmin(String n,String pass,String email,String post)
    {


        c.put(T_col2,n);
        c.put(Tcol3,pass);
        c.put(Tcol4,email);
        c.put(Tcol5,post);
        long f= dw.insert(TABLE2_NAME,null,c);
        if(f>0)
        {
            return true;
        }
        else
        {
            return false;
        }



    }
//    //public boolean findacct(String id,String st,String cond)
//        public boolean updatebyadmin(String n,String p,String e,String post){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        values.put(Tcol2,n);
//        values.put(Tcol3,p);
//        values.put(Tcol4,e);
//        values.put(Tcol5,post);
//     String id= "1";
//        int d = db.update(TABLE2_NAME,values,"EmailAddress = ?",new String[]{"sagar@gmail.com"});
//        if(d>0){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//public Cursor findacct(String email)
//{
//
//
//    Cursor w= dr.rawQuery("select * from Doctor Where EmailAddress =?",new String[]{"sagar@gmail.com"});
//
//    return w;
//
//}

public boolean find(String i,String t)
{
    String[] col={Tcol2,Tcol4};
    id=i;
    tname= t;
    String con ="DoctorId";
    if(t.equals("Doctor"))
    {
        con="DoctorId";
    }
   else if(t.equals("Patient"))
    {
        con="PatientId";
    }
    Cursor findEntry = dr.query(tname, col, con+"=?", new String[]{id}, null, null, null);
     //Cursor findEntry = db.query("sku_table", columns, "owner=?", new String[] { owner }, null, null, null);

    if(findEntry.getCount()>0)
    {
        return true;
    }
    else
    {
        return false;
    }


}
public Cursor viewrecord1(String table,String id)
{
    String cond="DoctorId";
    if(table.equals("Doctor"))
    {
        cond="DoctorId";
    }
    else if(table.equals("Patient"))
    {
        cond= "PatientId";
    }
    else
    {
       if(table.equals("Admin")) {
           cond = "AdminId";
       }
    }
    Cursor z= dr.rawQuery("Select * from " + table + " where " + cond + "=?",new String[]{id});

    return z;

}
    public boolean changevalueuser(String n,String pass,String email,String post ,String id , String table)

    {


       ContentValues c= new ContentValues();

//       if(tname.equals("Doctor"))
             String q="1";

int a =0;
           c.put(Tcol2,n);
           c.put(Tcol3,pass);
           c.put(Tcol4,email);
           c.put(Tcol5,post);
           if(table.equals("Doctor")) {
                a = dw.update(table, c, "DoctorId = ?", new String[]{id});
           }
           else
           {
                a = dw.update(table, c, "PatientId = ?", new String[]{id});
           }


////       else if(tname.equals("Patient"))
//       {
//           c.put(T_col1,id);
//           c.put(T_col2,n);
//           c.put(T_col3,pass);
//           c.put(T_col4,email);
//           c.put(T_col5,post);
//           a= dw.update("Patient",c,"PatientId=?",new String[]{id});
//
//       }
       if(a>0)
       {
           return true;

       }
       else
       {
           return false;
       }

    }

    public Cursor Viewappointments3(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE5_NAME + " where " + c6 + " = 3" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor Viewappointments5(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE5_NAME + " where " + c6 + " = 5" ;

        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor Viewappointments1(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE5_NAME + " where " + c6 + " = 1" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor Viewappointments4(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE5_NAME + " where " + c6 + " = 4" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor Viewappointments2(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT  * FROM " + TABLE5_NAME + " where " + c6 + " = 2" ;
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public boolean addcashier()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put(t6cl1,1);
        c.put(t6col2,"david");
        c.put(t6col3,"david@gmail.com");
        c.put(t6col4,"123");
        long z= db.insert("Cashier",null,c);
        if(z>0)
        {
            return true;
        }
        else
        {
            return false;
        }


    }
    public Cursor cashierlogin(String uname,String pass)
    {
        //String t= "Select * from Cashier where EmailAddress=? and Password =?";
        //String t="select * from Cashier";
        String [] col={t6col2,t6col3,t6cl1};


       Cursor i=dr.query("Cashier",col,"EmailAddress=? and Password=?",new String[]{uname,pass},null,null,null);
       //dr.query("Cashier,col")
       // Cursor i=dr.rawQuery(t,null);
        return i;



    }
public boolean addpaymentdata(int pid,int docid,String payamt,String paytype,String d,String email)
{
    ContentValues c= new ContentValues();
    c.put(t7col1,pid);
    c.put(t7col2,docid);
    c.put(t7col3,payamt);
    c.put(t7col4,paytype);
    c.put(t7col5,d);
    c.put(t7col6,email);

    long h= dw.insert(Table7,null,c);
 if(h>0)
 {
     return true;

 }
 else
 {
     return false;
 }

}
public Cursor viewpayments(String pid)
{

    Cursor t=dr.rawQuery("Select * from payments where pId=? or dId=?",new String[]{pid});
    return t;


}
public boolean addpatient(int id,String name,String pass,String email,String post)
{
    ContentValues c= new ContentValues();
    c.put(T_col1,id);
    c.put(T_col2,name);
    c.put(T_col3,pass);
    c.put(T_col4,email);
    c.put(T_col5,post);
    Long p= dw.insert("Patient",null,c);
    if(p>0)
    {
        return  true;
    }
    else
    {
        return false;
    }



}
    public Cursor viewdue(String  id)
    {
        String f= "select * from payments where payamt=?";
        Cursor e= dr.rawQuery(f,new String[]{"0"});
        return e;


    }
    public Cursor remind(String Email)
    {
       String r="Select * from payments where payamt=?  and email=?";
        //String r="select EmailAddress from Patient where PatientId in(select pId from payments where payamt=? and EmailAddress=?)";
       Cursor b= dr.rawQuery(r,new String[]{"0",Email});
      // Cursor b= dr.rawQuery(r,null);
        return b;

    }
    public boolean changecashier(String name,String email,String pas,String id) {
        ContentValues c = new ContentValues();
        c.put(t6col2, name);
        c.put(t6col3, email);
        c.put(t6col4, pas);
        int a = dw.update("Cashier", c, "CashierId=?", new String[]{id});
        if (a > 0) {
            return true;

        } else {
            return false;
        }
    }
    public  boolean createcashier(String name,String email,String pas)
    {
        ContentValues c= new ContentValues();
        c.put(t6col2,name);
        c.put(t6col3,email);
        c.put(t6col4,pas);
        long z= dw.insert("Cashier",null,c);
        if(z>0)
        {
            return true;


        }

        else {
            return false;
        }
    }


}

