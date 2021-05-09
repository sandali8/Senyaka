package com.example.senyakapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class find_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_payment);

        ArrayList<DataSet> dataList = (ArrayList<DataSet>) getIntent().getSerializableExtra("key");

        Button find =findViewById(R.id.btnFind);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText customerNIC=findViewById(R.id.findtoNIC);
                EditText bookedDate=findViewById(R.id.findtoDate);
                String inputCustomerNIC=customerNIC.getText().toString().toLowerCase();
                String inputBookedDate=bookedDate.getText().toString().toLowerCase();
                if (!(customerNIC.getText().toString().isEmpty() || bookedDate.getText().toString().isEmpty())){
                    ArrayList<DataSet> sentList=new ArrayList<DataSet>();
                    sentList.add(dataList.get(0));
                    for(DataSet item:dataList ){
                        if(item.NIC.toLowerCase().contains(inputCustomerNIC) && item.bookedDate.toLowerCase().contains(inputBookedDate)){
                            sentList.add(item);
                        }
                    }
                    Intent intent = new Intent(find_payment.this,allpayment.class);
                    intent.putExtra("filteredList",sentList);
                    startActivity(intent);
                }else{
                    Toast.makeText(find_payment.this, "Please fill Customer NIC and Booked Date to Find", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



}
