package com.example.senyakapro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addvehical extends AppCompatActivity {

    Button viewbtn;
    EditText V_ID,B_name,Passangers,trans,D_price;
    Button Btn1;
    DatabaseReference reff;
    Insert insert;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addvehical);

        V_ID=findViewById(R.id.vId);
        B_name=findViewById(R.id.bname);
        Passangers=findViewById(R.id.passen);
        trans=findViewById(R.id.trans);
        D_price=findViewById(R.id.dprice);
        Btn1=findViewById(R.id.btn1);


        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
//Please enter the transmissions

        awesomeValidation.addValidation(this,R.id.vId,
                RegexTemplate.NOT_EMPTY,R.string.vehi);
        awesomeValidation.addValidation(this,R.id.bname,
                RegexTemplate.NOT_EMPTY,R.string.name);
        awesomeValidation.addValidation(this,R.id.passen,
                RegexTemplate.NOT_EMPTY,R.string.pass);
        awesomeValidation.addValidation(this,R.id.trans,
                RegexTemplate.NOT_EMPTY,R.string.tran);
        awesomeValidation.addValidation(this,R.id.dprice,
                RegexTemplate.NOT_EMPTY,R.string.bna);



        insert=new Insert();
        reff= FirebaseDatabase.getInstance().getReference("Bokking");

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

// validation

                if(awesomeValidation.validate() ){

                    Toast.makeText(getApplicationContext(), "Form validation success", Toast.LENGTH_LONG).show();


                }else{

                    Toast.makeText(getApplicationContext(), "Form validation Unsuccessful", Toast.LENGTH_LONG).show();
                }








                Insert insert= new Insert(V_ID.getText().toString(),B_name.getText().toString(),Passangers.getText().toString(),trans.getText().toString(),D_price.getText().toString());

                reff.child(V_ID.getText().toString()).setValue(insert).addOnCompleteListener(Addvehical.this, new OnCompleteListener<Void>()
                { @Override public void onComplete(@NonNull Task<Void> task)
                { if(task.isSuccessful())
                { Toast.makeText(Addvehical.this, "successful", Toast.LENGTH_SHORT).show(); }

                else { Toast.makeText(Addvehical.this, "Unsuccessful ", Toast.LENGTH_SHORT).show();

                } } });
            }
        });
        viewbtn = findViewById(R.id.viewbtn1);

        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Addvehical.this,vehicalHandling.class));
            }
        });


    }
}