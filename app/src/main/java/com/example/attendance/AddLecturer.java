package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;


public class AddLecturer extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");
EditText uname,pass;
Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lecturer);

        uname = findViewById(R.id.editTextUserNameL);
        pass = findViewById(R.id.editTextPassL);
        add = findViewById(R.id.btnAdd);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unamel = uname.getText().toString();
                String passl = pass.getText().toString();

                if (unamel.length() <=0 || passl.length() <=0){
                    Toast.makeText(AddLecturer.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {

                    if(!PASSWORD_PATTERN.matcher(passl).matches())
                    {
                        Toast.makeText(AddLecturer.this, "Please provide a strong password", Toast.LENGTH_SHORT).show();
                    }else{
                        DatabaseHelper databaseHelper = new DatabaseHelper(AddLecturer.this); //object creation
                        AppModelClass appModelClass = new AppModelClass(unamel,passl);
                        databaseHelper.addLecturer(appModelClass);
                        Toast.makeText(AddLecturer.this, "Added Lecturer Successful", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(getIntent());}
                }
            }
        });
    }
}