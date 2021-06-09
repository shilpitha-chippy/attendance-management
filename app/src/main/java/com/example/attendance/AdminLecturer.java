package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminLecturer extends AppCompatActivity {
    Button add,update,viewLecturer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lecturer);
        add=(Button) findViewById(R.id.btnAddLecturer);
        update=(Button) findViewById(R.id.btnUpdateLecturer);
        viewLecturer=(Button) findViewById(R.id.btnViewLecturer);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminLecturer.this, AddLecturer.class);
                startActivity(i);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminLecturer.this, UpdateLecturer.class);
                startActivity(i);
            }
        });
        viewLecturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminLecturer.this, ViewLecturer.class);
                startActivity(i);
            }
        });
    }
}