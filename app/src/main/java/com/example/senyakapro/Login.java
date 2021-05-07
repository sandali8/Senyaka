package com.example.senyakapro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.basgeekball.awesomevalidation.AwesomeValidation;

public class Login extends AppCompatActivity {
    Button homebtn;
       private EditText Name;
       private EditText Password;
       private TextView Info;
       private Button Login;
       private int counter =3;
       //AwesomeValidation awesomeValidation;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //go to home button
        homebtn = findViewById(R.id.btngohome);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });
        //awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
       //Please enter the transmissions
        Name =(EditText)findViewById(R.id.etName);
        Password =(EditText)findViewById(R.id.etPassword);
        Info =(TextView) findViewById(R.id.tvInfo);
        Login=(Button) findViewById(R.id.btnlo11);

        Info.setText("No of attempt remaining");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });


    }
    //void to not return anything
     private void validate(String userName, String userPassword){

        if (  (userName.equals("admin")) && (userPassword.equals("12345"))){


            //Intent intent =  new Intent(Login.this,Addvehical.class);
             Intent intent =new Intent(Login.this,AdminPannal.class);
            startActivity(intent);
        }else {

            counter--;
            Info.setText("No of attempt remaining : " +String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }


        }


     }





}