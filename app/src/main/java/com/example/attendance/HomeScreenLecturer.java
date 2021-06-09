package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenLecturer extends AppCompatActivity {
    Button viewstud,markatt,viewatt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_lecturer);

        viewstud=(Button) findViewById(R.id.btnViewStud);
        markatt=(Button) findViewById(R.id.btnMarkAtt);
        viewatt=(Button) findViewById(R.id.btnViewAtt);


        viewstud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreenLecturer.this, ViewStudent.class);
                startActivity(i);
            }
        });
        markatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreenLecturer.this, MarkSelectClass.class);
                startActivity(i);
            }
        });
        viewatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeScreenLecturer.this, ViewAttendanceClass.class);
                startActivity(i);
            }
        });

    }
}