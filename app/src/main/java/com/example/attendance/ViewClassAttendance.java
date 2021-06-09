package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ViewClassAttendance extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView TStudents;
    TextView PStudents;
    TextView AStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class_attendance);

        recyclerView = findViewById(R.id.recyclerViewVA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        TStudents = findViewById(R.id.txtTStudents);
        PStudents = findViewById(R.id.txtPStudents);
        AStudents = findViewById(R.id.txtAStudents);


        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        String str = intent.getStringExtra("message_key");
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        // AttDatabaseHelper attdatabaseHelper = new AttDatabaseHelper(this);
        String classs = "class" + str;
        Toast.makeText(this, classs, Toast.LENGTH_SHORT).show();

        List<AppModelClass> appModelClasses = databaseHelper.getAttendance(date,classs);

        if (appModelClasses.size() > 0){
            VaAdapterClass vaadapterclass = new VaAdapterClass(appModelClasses,ViewClassAttendance.this,date,classs);
            //AttAdapterClass attadapterclass1 = new AttAdapterClass(MarkAttendance.this,date,classs);
            final AppModelClass appModelClass = appModelClasses.get(appModelClasses.size()-1);
            TStudents.setText("Total : "+Integer.toString(appModelClass.getT()));
            PStudents.setText("Present : "+Integer.toString(appModelClass.getP()));
            AStudents.setText("Absent : "+Integer.toString(appModelClass.getA()));
            recyclerView.setAdapter(vaadapterclass);
        }else {
            Toast.makeText(this, "There are no students stored", Toast.LENGTH_SHORT).show();
        }

    }
}