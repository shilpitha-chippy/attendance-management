package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenAdmin extends AppCompatActivity {
Button lecturer,student,viewAttendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_admin);
        lecturer=(Button) findViewById(R.id.btnLecturer);
        student=(Button) findViewById(R.id.btnStudent);
        viewAttendance=(Button) findViewById(R.id.btnViewAttendance);

        lecturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreenAdmin.this, AdminLecturer.class);
                startActivity(i);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreenAdmin.this, AdminStudent.class);
                startActivity(i);
            }
        });
        viewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreenAdmin.this, ViewAttendanceClass.class);
                startActivity(i);
            }
        });
    }
}