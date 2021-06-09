package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    EditText username,password;
    Button login;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTextUname);
        password = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.btnLogin);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.SELECT, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (text.equals("Admin")) {
                    if (username.getText().toString().equals("admin") &&
                            password.getText().toString().equals("Admin@")) {
                        Intent i = new Intent(MainActivity.this, HomeScreenAdmin.class);
                        Toast.makeText(getApplicationContext(), "Logged in Successfully as Admin", Toast.LENGTH_LONG).show();
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Username/password is incorrect", Toast.LENGTH_LONG).show();
                    }
                } else {
                    if (username.getText().toString().equals("lecturer") &&
                            password.getText().toString().equals("Lecturer@")) {
                        Intent i = new Intent(MainActivity.this, HomeScreenLecturer.class);
                        Toast.makeText(getApplicationContext(), "Logged in Successfully as Lecturer", Toast.LENGTH_LONG).show();
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Username/password is incorrect", Toast.LENGTH_LONG).show();
                    }
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