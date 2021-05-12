package com.example.senyakapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {

    //Define the buttons
        Button btnCreditPay;
        Button btnCashPay;
        Button btnFind;


        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_payment);

            //Assign button with id name
            btnCreditPay = findViewById(R.id.btnCreditPayment);

            // handle the onClick event
            btnCreditPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Payment.this, credit.class));
                }
            });

            btnCashPay = findViewById(R.id.btnCash);

            btnCashPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Payment.this, cash.class));
                }
            });

            btnFind = findViewById(R.id.btnfind);

            btnFind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Payment.this, find_payment.class));
                }
            });

        }


    }

