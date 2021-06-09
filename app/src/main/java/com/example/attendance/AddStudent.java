package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText Rno,Name;
Button add;
Spinner spinner;
String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        Rno = findViewById(R.id.editTextRNo);
        Name = findViewById(R.id.editTextName);
        add = findViewById(R.id.btnSadd);
        spinner = findViewById(R.id.spinnerstud);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CLASS, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rno = Rno.getText().toString();
                String name = Name.getText().toString();
                String classs = text.toString();

                if (rno.length() <=0 || name.length() <=0){
                    Toast.makeText(AddStudent.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelper databaseHelper = new DatabaseHelper(AddStudent.this);
                    AppModelClass appModelClass = new AppModelClass(rno,name,classs);
                    databaseHelper.addStudent(appModelClass, classs);
                    Toast.makeText(AddStudent.this, "Added Student Successful", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
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