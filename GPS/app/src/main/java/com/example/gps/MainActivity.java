package com.example.gps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    FusedLocationProviderClient mfusedLocationClient;

    EditText latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitude=findViewById(R.id.editTextTextPersonName);
        longitude=findViewById(R.id.editTextTextPersonName2);

        mfusedLocationClient= LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation()
    {
        mfusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location=task.getResult();

                latitude.setText(""+location.getLatitude());
                longitude.setText(""+location.getLongitude());
            }
        });
    }
}