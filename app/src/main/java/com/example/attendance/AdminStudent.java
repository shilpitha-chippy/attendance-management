package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminStudent extends AppCompatActivity {

    Button add,update,viewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student);

        add=(Button) findViewById(R.id.btnSAdd);
        update=(Button) findViewById(R.id.btnSUpdate);
        viewStudent=(Button) findViewById(R.id.btnSView);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminStudent.this, AddStudent.class);
                startActivity(i);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminStudent.this, UpdateStudentClass.class);
                startActivity(i);
            }
        });
        viewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminStudent.this, ViewStudent.class);
                startActivity(i);
            }
        });

    }
}