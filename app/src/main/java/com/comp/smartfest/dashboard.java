package com.comp.smartfest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void BirthCert1(View view){
        Intent intent = new Intent(this, birthcert.class);
        startActivity(intent);
    }

    public void community1(View view){
        Intent intent = new Intent(this, comcer.class);
        startActivity(intent);
    }

    public void licence1(View view){
        Intent intent = new Intent(this, drivlic.class);
        startActivity(intent);
    }

    public void eaadhar1(View view){
        Intent intent = new Intent(this, eaadhar.class);
        startActivity(intent);
    }

    public void complain1(View view){
        Intent intent = new Intent(this, complain.class);
        startActivity(intent);
    }
}
