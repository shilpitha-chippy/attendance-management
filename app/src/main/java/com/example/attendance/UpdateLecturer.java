package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class UpdateLecturer extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_lecturer);

        recyclerView = findViewById(R.id.recyclerViewUpdate);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<AppModelClass> appModelClasses = databaseHelper.getLecturerList();

        if (appModelClasses.size() > 0){
            LuAdapterClass luadapterclass = new LuAdapterClass(appModelClasses,UpdateLecturer.this);
            recyclerView.setAdapter(luadapterclass);
        }else {
            Toast.makeText(this, "There are no lecturers in the database", Toast.LENGTH_SHORT).show();
        }
    }
}