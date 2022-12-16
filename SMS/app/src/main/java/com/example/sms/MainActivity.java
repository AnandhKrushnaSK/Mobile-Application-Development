package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, messageToSend;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.sendButton);
        phoneNumber = findViewById(R.id.phoneNumber);
        messageToSend = findViewById(R.id.messageToSend);

        ArrayList<String> arr=new ArrayList<String>();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=phoneNumber.getText().toString();
                String msg=messageToSend.getText().toString();

                    if(arr.contains(number))
                    {
                        Toast.makeText(getApplicationContext(),"More than 1 time",Toast.LENGTH_LONG).show();
                        System.exit(1);
                    }
                    else
                    {
                        try{
                            SmsManager smsManager=SmsManager.getDefault();
                            smsManager.sendTextMessage(number,null,msg,null,null);
                            arr.add(number);
                            Toast.makeText(getApplicationContext(),"Send",Toast.LENGTH_LONG).show();
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                        }
                }
            }
        });

    }
}