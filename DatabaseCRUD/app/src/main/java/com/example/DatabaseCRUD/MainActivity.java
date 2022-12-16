package com.example.DatabaseCRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name,number;
    Button insert,delete,display,update;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        insert=findViewById(R.id.insert);
        delete=findViewById(R.id.delete);
        display=findViewById(R.id.display);
        update=findViewById(R.id.update);
        info=findViewById(R.id.info);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String num1=number.getText().toString();

                DBHandler dbHandler=new DBHandler(getApplicationContext());
                dbHandler.addEntry(name1,num1);

                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                name.setText("");
                number.setText("");
                info.setText("");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                DBHandler dbHandler=new DBHandler(getApplicationContext());
                dbHandler.delete(name1);
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                name.setText("");
                number.setText("");
                info.setText("");
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler=new DBHandler(getApplicationContext());
                String info1=dbHandler.getInfo();
                info.setMovementMethod(new ScrollingMovementMethod());
                info.setText(info1);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String num1=number.getText().toString();

                DBHandler dbHandler=new DBHandler(getApplicationContext());
                dbHandler.update(name1,num1);

                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                name.setText("");
                number.setText("");
                info.setText("");
            }
        });
    }
}