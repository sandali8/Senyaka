package com.example.senyakapro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPannal extends AppCompatActivity {

     Button button1;
     Button button4;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pannal);

        button1 = findViewById(R.id.addVehi2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPannal.this,Addvehical.class));
            }
        });

        button4 = findViewById(R.id.btn1goho);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPannal.this,MainActivity.class));
            }
        });

        button5 = findViewById(R.id.addfaq);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPannal.this,Add_FAQ.class));
            }
        });

    }


    }
