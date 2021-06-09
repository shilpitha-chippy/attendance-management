package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.sql.Date;
import java.util.List;

public class MarkAttendance extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);

        recyclerView = findViewById(R.id.recyclerViewAtt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        String str = intent.getStringExtra("message_key");


        DatabaseHelper databaseHelper = new DatabaseHelper(this);
       // AttDatabaseHelper attdatabaseHelper = new AttDatabaseHelper(this);
        String classs = "class" + str;
        Toast.makeText(this, "successfull", Toast.LENGTH_SHORT).show();
        /*List<AppModelClass> appModelClasses = databaseHelper.getStudentList(classs);

        if (appModelClasses.size() > 0){
            AppAdapterClass appadapterclass = new AppAdapterClass(appModelClasses,MarkAttendance.this);
            recyclerView.setAdapter(appadapterclass);
        }else {
            Toast.makeText(this, "There are no students stored", Toast.LENGTH_SHORT).show();
        }*/
       List<AppModelClass> appModelClasses = databaseHelper.getStudentList(classs);

        if (appModelClasses.size() > 0){
            AttAdapterClass attadapterclass = new AttAdapterClass(appModelClasses,MarkAttendance.this,date,classs);
            //AttAdapterClass attadapterclass1 = new AttAdapterClass(MarkAttendance.this,date,classs);
            recyclerView.setAdapter(attadapterclass);
        }else {
            Toast.makeText(this, "There are no students stored", Toast.LENGTH_SHORT).show();
        }


    }
}