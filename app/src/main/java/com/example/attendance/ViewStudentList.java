package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewStudentList extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_list);

        recyclerView = findViewById(R.id.recyclerViewStud);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        String classs = "class" + str;
        Toast.makeText(this, classs, Toast.LENGTH_SHORT).show();
        List<AppModelClass> appModelClasses = databaseHelper.getStudentList(classs);

        if (appModelClasses.size() > 0){
            AppAdapterClass appadapterclass = new AppAdapterClass(appModelClasses,ViewStudentList.this);
            recyclerView.setAdapter(appadapterclass);
        }else {
            Toast.makeText(this, "There are no students stored", Toast.LENGTH_SHORT).show();
        }
    }
}