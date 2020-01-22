package com.example.mad_assign_proj;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText gender;
    EditText country;
    EditText email;
    EditText password;
    CheckBox chkAgreement;
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        gender = findViewById(R.id.txtGender);
        country = findViewById(R.id.txtCountry);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        chkAgreement = findViewById(R.id.chkAgreement);
    }

    public void onClickNext(View v){

            String fname = firstName.getText().toString();
            String lname = lastName.getText().toString();
            String genderText = gender.getText().toString();
            String countryText = country.getText().toString();
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();

            boolean isError= false;

            if(fname != null && fname.equalsIgnoreCase("")){
                firstName.setError("Please enter Valid First Name");
                isError = true;
            }

            if(lname != null && lname.equalsIgnoreCase("")){
                lastName.setError("Please enter Valid Last Name");
                isError = true;
            }

            if(genderText != null && genderText.equalsIgnoreCase("")){
                gender.setError("Please enter Valid Gender");
                isError = true;
            }

            if(countryText != null && countryText.equalsIgnoreCase("")){
                country.setError("Please enter Valid Country");
                isError = true;
            }

            if(emailText != null && emailText.equalsIgnoreCase("")){
                email.setError("Please enter Valid email");
                isError = true;
            }else if(!emailText.contains("@")){
                email.setError("Please enter Valid email, @ is missing");
                isError = true;
            }else if(!emailText.contains(".com")){
                email.setError("Please enter Valid email, .com is missing");
                isError = true;
            }

            if(passwordText != null && passwordText.equalsIgnoreCase("")){
                password.setError("Please enter Valid Password");
                isError = true;
            }else if(passwordText.length() < 5 || passwordText.length() > 8){
                password.setError("Password lenght should be between 5-8 characters");
                isError = true;
            }

            if(!chkAgreement.isChecked()){
                chkAgreement.setTextColor(Color.RED);
                isError = true;
            }

            if(!isError){
                db.addUser(new User(emailText,passwordText));

                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            }

    }
}
