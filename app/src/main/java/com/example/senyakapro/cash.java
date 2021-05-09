package com.example.senyakapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cash extends AppCompatActivity {



    FirebaseDatabase rootNode;
    DatabaseReference reference;

    Button btn2;
    Cash_Payment cp;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);

        EditText VehicleID = findViewById(R.id.txtID);
        EditText customerNIC = findViewById(R.id.txtNIC);
        EditText bookedDate = findViewById(R.id.txtdate);
        EditText totalAmount = findViewById(R.id.txtamount);

        btn2 = findViewById(R.id.btnconfirm);
        cp = new Cash_Payment();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value_vehicleID = VehicleID.getText().toString();
                String value_customerNIC = customerNIC.getText().toString();
                String value_bookedDate = bookedDate.getText().toString();
                String value_totalAmount = totalAmount.getText().toString();

                if (!(value_vehicleID.isEmpty() && value_totalAmount.isEmpty() && value_bookedDate.isEmpty() && value_customerNIC.isEmpty())) {
                    reff = FirebaseDatabase.getInstance().getReference("CashPayment/" + value_vehicleID);

                    Cash_Payment cp = new Cash_Payment();
                    cp.setVehicleID(value_vehicleID);
                    cp.setCustomerNIC(value_customerNIC);
                    cp.setBookedDate(value_bookedDate);
                    cp.setTotalAmount(value_totalAmount);

                    reff.setValue(cp).addOnCompleteListener(cash.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(cash.this, "successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(cash.this, "Unsuccessful", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }


            }
        });
    }


}