package com.example.senyakapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class allpayment extends AppCompatActivity {

    DatabaseReference reference1;
    DatabaseReference reference2;

    ListView list;
    ArrayList<DataSet> paymentData=new ArrayList<DataSet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allpayment);

        Intent intent=getIntent();
        ArrayList<DataSet> recervedList = (ArrayList<DataSet>) getIntent().getSerializableExtra("filteredList");
        Button find =findViewById(R.id.find);



        list=findViewById(R.id.list);

        if (recervedList!=null){


            CustomListAdapter customListAdapter =new CustomListAdapter(allpayment.this,recervedList);
            list.setAdapter(customListAdapter);
            find.setText("Show All Payment");


        }else{
            setInitalRow();
            getPaymentData();

        }


        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (find.getText()=="Show All Payment"){
                    setInitalRow();
                    getPaymentData();
                    find.setText("Find A Payment");
                }else{
                    Intent intent = new Intent(allpayment.this,find_payment.class);

                    ArrayList<DataSet> e;
                    e=paymentData;
                    intent.putExtra("key",e);
                    startActivity(intent);

                }

            }
        });

    }

    public void setInitalRow(){
        if(paymentData.size()==0) {
            DataSet t = new DataSet();
            t.paymentType = "PaymentType";
            t.total = "Total";
            t.NIC = "NIC";
            t.bookedDate = "Booked Date";
            t.vehicleID = "Vehicleid";
            paymentData.add(t);
            CustomListAdapter customListAdapter = new CustomListAdapter(allpayment.this, paymentData);
            list.setAdapter(customListAdapter);
        }
    }



    public void getPaymentData(){


        reference1= FirebaseDatabase.getInstance().getReference().child("CashPayment");
        reference2= FirebaseDatabase.getInstance().getReference().child("CreditPayment");
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot postSnapshot : snapshot.getChildren()){
                    DataSet temp=new DataSet();
                    temp.vehicleID=(postSnapshot.getKey()==null?"-":postSnapshot.getKey());
                    temp.NIC=(!postSnapshot.child("customerNIC").exists()?"-":postSnapshot.child("customerNIC").getValue().toString());
                    temp.bookedDate=(!postSnapshot.child("bookedDate").exists()?"-":postSnapshot.child("bookedDate").getValue().toString());
                    temp.total=(!postSnapshot.child("totalAmount").exists()?"-":postSnapshot.child("totalAmount").getValue().toString());
                    temp.paymentType="Cash";



                    paymentData.add(temp);


                }
                CustomListAdapter customListAdapter =new CustomListAdapter(allpayment.this,paymentData);
                list.setAdapter(customListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot postSnapshot : snapshot.getChildren()){

                    DataSet temp=new DataSet();
                    temp.vehicleID=(postSnapshot.getKey()==null?"-":postSnapshot.getKey());
                    temp.NIC=(!postSnapshot.child("customerNIC").exists()?"-":postSnapshot.child("customerNIC").getValue().toString());
                    temp.bookedDate=(!postSnapshot.child("bookedDate").exists()?"-":postSnapshot.child("bookedDate").getValue().toString());
                    temp.total=(!postSnapshot.child("totalAmount").exists()?"-":postSnapshot.child("totalAmount").getValue().toString());
                    temp.paymentType="Card";

                    paymentData.add(temp);



                }
                CustomListAdapter customListAdapter =new CustomListAdapter(allpayment.this,paymentData);
                list.setAdapter(customListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
