package com.example.personalpage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button submit,date;
    EditText dobET,name;
    RadioGroup radiogrp;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date=findViewById(R.id.dateButton);
        submit=findViewById(R.id.button2);
        dobET=findViewById(R.id.dobET);
        name=findViewById(R.id.name);
        radiogrp=findViewById(R.id.radioGrp);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                int yr=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this,
                        (view1,yr1,month1,day1) -> {dobET.setText(day1+"/"+(month1+1)+"/"+yr1);},yr,month,day);
                datePickerDialog.show();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioid=radiogrp.getCheckedRadioButtonId();
                rb=findViewById(radioid);
                String str="Hello "+name.getText();
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
            }
        });
    }
}