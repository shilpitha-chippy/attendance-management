package com.example.attendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MarkSelectClass extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public static final String TAG ="MarkSelectClass";
    Spinner spinner;
    Button submit;
    String text;
    CalendarView simpleCalendarView;
    String selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_select_class);
        simpleCalendarView = (CalendarView) findViewById(R.id.calendarView); // get the reference of CalendarView
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        selectedDate = sdf.format(new Date(simpleCalendarView.getDate()));
        //long selectedDate = simpleCalendarView.getDate();
        submit = findViewById(R.id.btnSubmitC);
        spinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CLASS, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = dayOfMonth +"/"+ month +"/"+ year;

            }
        });

        Toast.makeText( this, selectedDate , Toast.LENGTH_SHORT).show();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(MarkSelectClass.this, MarkAttendance.class);
i.putExtra("date",selectedDate);
                i.putExtra("message_key",text);
                startActivity(i);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}