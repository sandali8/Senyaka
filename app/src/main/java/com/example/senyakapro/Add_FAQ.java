package com.example.senyakapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_FAQ extends AppCompatActivity {
    TextView t1,t2;
    Button btn,btnS;
    FAQ_help faq_help;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faq);

        t1=findViewById(R.id.E1);
        t2=findViewById(R.id.E2);
        btn=findViewById(R.id.btn1);

        reff= FirebaseDatabase.getInstance().getReference().child("FAQ");

        faq_help=new FAQ_help();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FAQ_help faq_help = new FAQ_help(t1.getText().toString(),t2.getText().toString());



                reff.push().setValue(faq_help);
                Toast.makeText(Add_FAQ.this,"Deta insert sucess",Toast.LENGTH_SHORT).show();

            }
        });

        btnS = findViewById(R.id.butshow);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Add_FAQ.this,FAQ_Activity.class));
            }
        });


    }


}