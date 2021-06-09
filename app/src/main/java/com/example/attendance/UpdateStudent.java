package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class UpdateStudent extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        recyclerView = findViewById(R.id.recyclerViewUpdateS);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        String classs = "class" + str;
        Toast.makeText(this, classs, Toast.LENGTH_SHORT).show();
        List<AppModelClass> appModelClasses = databaseHelper.getStudentList(classs);

        if (appModelClasses.size() > 0){
            SuAdapterClass suadapterclass = new SuAdapterClass(appModelClasses,UpdateStudent.this,classs);
            recyclerView.setAdapter(suadapterclass);
            //AppAdapterClass appadapterclass = new AppAdapterClass(appModelClasses,UpdateStudent.this);
            //recyclerView.setAdapter(appadapterclass);
        }else {
            Toast.makeText(this, "There are no students  in the database", Toast.LENGTH_SHORT).show();
        }

    }
}