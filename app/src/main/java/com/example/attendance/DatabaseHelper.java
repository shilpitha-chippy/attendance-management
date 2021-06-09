package com.example.attendance;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper  {

    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "attendance";
    //Database Table name
    private static final String TABLE_NAME = "lecturer";
    //Table columns
    public static final String ID = "id";
    public static final String UNAME = "uname";
    public static final String PASS = "pass";
    private SQLiteDatabase sqLiteDatabase;
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + UNAME + " TEXT NOT NULL,"+PASS+" TEXT NOT NULL);";





    private static final String TABLE_NAMEA = "mattendance";

    //Table columns
    public static final String DATE = "date";
    public static final String CLASS = "class";
    public static final String RNO = "rno";
    public static final String NAME = "name";
    public static final String STATUS = "status";


    private static final String CREATE_TABLEA = "create table " + TABLE_NAMEA +"("+DATE+" LONG, "+CLASS.trim()+" TEXT, "+RNO+" TEXT, "+NAME+" TEXT, "+STATUS+" TEXT);";


    private SQLiteDatabase sqLiteDatabaseA;




    //Constructor
    public DatabaseHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE1);
        db.execSQL(CREATE_TABLE2);
        db.execSQL(CREATE_TABLE3);
        db.execSQL(CREATE_TABLE4);
        db.execSQL(CREATE_TABLE5);
        db.execSQL(CREATE_TABLE6);
        db.execSQL(CREATE_TABLE7);
        db.execSQL(CREATE_TABLE8);
        db.execSQL(CREATE_TABLE9);
        db.execSQL(CREATE_TABLE10);
        db.execSQL(CREATE_TABLEA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME4);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME5);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME6);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME7);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME8);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME9);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME10);
        onCreate(db);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAMEA);
        onCreate(db);

    }
    public void addLecturer(AppModelClass AppModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.UNAME, AppModelClass.getUname());
        contentValues.put(DatabaseHelper.PASS, AppModelClass.getPass());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null,contentValues);
    }

    public List<AppModelClass> getLecturerList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<AppModelClass> storeLecturer = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String uname = cursor.getString(1);
                String pass = cursor.getString(2);
                storeLecturer.add(new AppModelClass(id,uname,pass));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeLecturer;
    }

    public void updateLecturer(AppModelClass appModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.UNAME,appModelClass.getUname());
        contentValues.put(DatabaseHelper.PASS,appModelClass.getPass());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(appModelClass.getId())});
    }

    public void deleteLecturer(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }



    private static final String TABLE_NAME1 = "class1";
    //Table columns
    public static final String RNO1 = "rno";
    public static final String NAME1 = "name";

    private SQLiteDatabase sqLiteDatabase1;
    private static final String CREATE_TABLE1 = "create table " + TABLE_NAME1 +"("+RNO1+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME1 + " TEXT NOT NULL);";

    private static final String TABLE_NAME2 = "class2";
    //Table columns
    public static final String RNO2 = "rno";
    public static final String NAME2 = "name";

    private SQLiteDatabase sqLiteDatabase2;
    private static final String CREATE_TABLE2 = "create table " + TABLE_NAME2 +"("+RNO2+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME2 + " TEXT NOT NULL);";


    private static final String TABLE_NAME3 = "class3";
    //Table columns
    public static final String RNO3 = "rno";
    public static final String NAME3 = "name";

    private SQLiteDatabase sqLiteDatabase3;
    private static final String CREATE_TABLE3 = "create table " + TABLE_NAME3 +"("+RNO3+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME3 + " TEXT NOT NULL);";


    private static final String TABLE_NAME4 = "class4";
    //Table columns
    public static final String RNO4 = "rno";
    public static final String NAME4 = "name";

    private SQLiteDatabase sqLiteDatabase4;
    private static final String CREATE_TABLE4 = "create table " + TABLE_NAME4 +"("+RNO4+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME4 + " TEXT NOT NULL);";


    private static final String TABLE_NAME5 = "class5";
    //Table columns
    public static final String RNO5 = "rno";
    public static final String NAME5 = "name";

    private SQLiteDatabase sqLiteDatabase5;
    private static final String CREATE_TABLE5 = "create table " + TABLE_NAME5 +"("+RNO5+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME5 + " TEXT NOT NULL);";


    private static final String TABLE_NAME6 = "class6";
    //Table columns
    public static final String RNO6 = "rno";
    public static final String NAME6 = "name";

    private SQLiteDatabase sqLiteDatabase6;
    private static final String CREATE_TABLE6 = "create table " + TABLE_NAME6 +"("+RNO6+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME6 + " TEXT NOT NULL);";


    private static final String TABLE_NAME7 = "class7";
    //Table columns
    public static final String RNO7 = "rno";
    public static final String NAME7 = "name";

    private SQLiteDatabase sqLiteDatabase7;
    private static final String CREATE_TABLE7 = "create table " + TABLE_NAME7 +"("+RNO7+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME7 + " TEXT NOT NULL);";

    private static final String TABLE_NAME8 = "class8";
    //Table columns
    public static final String RNO8 = "rno";
    public static final String NAME8 = "name";

    private SQLiteDatabase sqLiteDatabase8;
    private static final String CREATE_TABLE8 = "create table " + TABLE_NAME8 +"("+RNO8+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME8 + " TEXT NOT NULL);";

    private static final String TABLE_NAME9 = "class9";
    //Table columns
    public static final String RNO9 = "rno";
    public static final String NAME9 = "name";

    private SQLiteDatabase sqLiteDatabase9;
    private static final String CREATE_TABLE9 = "create table " + TABLE_NAME9 +"("+RNO9+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME9 + " TEXT NOT NULL);";


    private static final String TABLE_NAME10 = "class10";
    //Table columns
    public static final String RNO10 = "rno";
    public static final String NAME10 = "name";

    private SQLiteDatabase sqLiteDatabase10;
    private static final String CREATE_TABLE10 = "create table " + TABLE_NAME10 +"("+RNO10+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME10 + " TEXT NOT NULL);";

    public static String UPNAME="";
    public static String UPROLL="";
    public void addStudent(AppModelClass AppModelClass, String classs){
        ContentValues contentValues = new ContentValues();

        switch(classs) {
            case "1":
                contentValues.put(DatabaseHelper.RNO1, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME1, AppModelClass.getName());
                sqLiteDatabase1 = this.getWritableDatabase();
                sqLiteDatabase1.insert(DatabaseHelper.TABLE_NAME1, null, contentValues);
                break;
            case "2":
                contentValues.put(DatabaseHelper.RNO2, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME2, AppModelClass.getName());
                sqLiteDatabase2 = this.getWritableDatabase();
                sqLiteDatabase2.insert(DatabaseHelper.TABLE_NAME2, null, contentValues);
                break;
            case "3":
                contentValues.put(DatabaseHelper.RNO3, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME3, AppModelClass.getName());
                sqLiteDatabase3 = this.getWritableDatabase();
                sqLiteDatabase3.insert(DatabaseHelper.TABLE_NAME3, null, contentValues);
                break;
            case "4":
                contentValues.put(DatabaseHelper.RNO4, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME4, AppModelClass.getName());
                sqLiteDatabase4 = this.getWritableDatabase();
                sqLiteDatabase4.insert(DatabaseHelper.TABLE_NAME4, null, contentValues);
                break;
            case "5":
                contentValues.put(DatabaseHelper.RNO5, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME5, AppModelClass.getName());
                sqLiteDatabase5 = this.getWritableDatabase();
                sqLiteDatabase5.insert(DatabaseHelper.TABLE_NAME5, null, contentValues);
                break;
            case "6":
                contentValues.put(DatabaseHelper.RNO6, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME6, AppModelClass.getName());
                sqLiteDatabase6 = this.getWritableDatabase();
                sqLiteDatabase6.insert(DatabaseHelper.TABLE_NAME6, null, contentValues);
                break;
            case "7":
                contentValues.put(DatabaseHelper.RNO7, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME7, AppModelClass.getName());
                sqLiteDatabase7 = this.getWritableDatabase();
                sqLiteDatabase7.insert(DatabaseHelper.TABLE_NAME7, null, contentValues);
                break;
            case "8":
                contentValues.put(DatabaseHelper.RNO8, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME8, AppModelClass.getName());
                sqLiteDatabase8 = this.getWritableDatabase();
                sqLiteDatabase8.insert(DatabaseHelper.TABLE_NAME8, null, contentValues);
                break;
            case "9":
                contentValues.put(DatabaseHelper.RNO9, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME9, AppModelClass.getName());
                sqLiteDatabase9 = this.getWritableDatabase();
                sqLiteDatabase9.insert(DatabaseHelper.TABLE_NAME9, null, contentValues);
                break;
            case "10":
                contentValues.put(DatabaseHelper.RNO10, AppModelClass.getRno());
                contentValues.put(DatabaseHelper.NAME10, AppModelClass.getName());
                sqLiteDatabase10 = this.getWritableDatabase();
                sqLiteDatabase10.insert(DatabaseHelper.TABLE_NAME10, null, contentValues);
                break;

        }
    }

    public List<AppModelClass> getStudentList( String classs){


        String sql = "select * from " + classs ;
        sqLiteDatabase = this.getReadableDatabase();
        List<AppModelClass> storeStudent = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int rno = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);

                storeStudent.add(new AppModelClass(rno,name,""));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeStudent;
    }

    public List<AttModelClass> getStudentListA( String classs){


        String sql = "select * from " + classs ;
        sqLiteDatabase = this.getReadableDatabase();
        List<AttModelClass> storeStudent = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int rno = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);

                storeStudent.add(new AttModelClass(rno,name));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeStudent;
    }


    public void updateStudent(AppModelClass appModelClass, String classs){
        String c = classs.substring(5);
        //String UPNAME = "name";
        // UPROLL = "RNO" + c;
        String rno="rno";
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.NAME1,appModelClass.getPass());
        // contentValues.put(DatabaseHelper.UPROLL,appModelClass.getPass());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(classs,contentValues, rno + "=?" , new String[]
                {appModelClass.getUname()});
    }
    public void deleteStudent(int id, String classs){
        String rno="rno";
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(classs,  rno + " = ? ", new String[]
                {String.valueOf(id)});
    }
    public void addAttendance(AttModelClass AttModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.DATE, AttModelClass.getDate());
        contentValues.put(DatabaseHelper.CLASS, AttModelClass.getClasss());
        contentValues.put(DatabaseHelper.RNO, AttModelClass.getRollno());
        contentValues.put(DatabaseHelper.NAME, AttModelClass.getName());
        contentValues.put(DatabaseHelper.STATUS, AttModelClass.getStatus());
        sqLiteDatabaseA = this.getWritableDatabase();
        sqLiteDatabaseA.insertOrThrow(DatabaseHelper.TABLE_NAMEA, null,contentValues);
    }

    public List<AppModelClass> getAttendance( String date, String cl){
        int t=0,p=0,a=0;
        List<AppModelClass> storeStudent = new ArrayList<>();
        String sql = "select * from " + TABLE_NAMEA + " where class = '"+ cl.trim()+"' and date ='"+date+"'";
        //String sql = "select * from " + TABLE_NAMEA  ;
        sqLiteDatabaseA = this.getReadableDatabase();
        //Cursor cursor = sqLiteDatabaseA.rawQuery("select * from mattendance where class = 'class1'" ,null);
        Cursor cursor = sqLiteDatabaseA.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                t++;
                int rno = Integer.parseInt(cursor.getString(2));
                String name = cursor.getString(3);
                String status = cursor.getString(4).trim();
                if(status.trim().toString().equals("PRESENT"))
                {
                    p++;
                }else
                {
                    a++;
                }
                storeStudent.add(new AppModelClass(rno,name,status,t,p,a));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeStudent;
    }
    public List<AppModelClass> getlecturer(String lecturer){

        List<AppModelClass> storeStudent = new ArrayList<>();
        String sql = "select * from " + TABLE_NAME + " where uname = '"+ lecturer.trim()+"'";

        sqLiteDatabaseA = this.getReadableDatabase();
        //Cursor cursor = sqLiteDatabaseA.rawQuery("select * from mattendance where class = 'class1'" ,null);
        Cursor cursor = sqLiteDatabaseA.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {

                String pass = cursor.getString(2);


                storeStudent.add(new AppModelClass(pass,""));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeStudent;
    }
}
