package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewLecturer extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lecturer);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<AppModelClass> appModelClasses = databaseHelper.getLecturerList();

        if (appModelClasses.size() > 0){
            AppAdapterClass appadapterclass = new AppAdapterClass(appModelClasses,ViewLecturer.this);
            recyclerView.setAdapter(appadapterclass);
        }else {
            Toast.makeText(this, "There are no lecturers stored", Toast.LENGTH_SHORT).show();
        }
    }
}