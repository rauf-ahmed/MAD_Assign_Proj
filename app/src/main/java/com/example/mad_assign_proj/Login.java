package com.example.mad_assign_proj;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText password;
    EditText email;
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.txtemail);
        password = findViewById(R.id.txtpassword);
    }

    public void onClickSignIn(View v){
        String passText = password.getText().toString();
        String emailText = email.getText().toString();
        boolean isError= false;

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

        if(passText != null && passText.equalsIgnoreCase("")){
            password.setError("Please enter Valid Password");
            isError = true;
        }else if(passText.length() < 5 || passText.length() > 8){
            password.setError("Password lenght should be between 5-8 characters");
            isError = true;
        }

        if(!isError){
            if(db.validateUser(emailText,passText)==1){
                Intent intent = new Intent(this, BeautyAndBeast.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"Email or Password is Invalid",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onClickSignUp(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickTerms(View v){
        Intent intent = new Intent(this, FrgActivity.class);
        startActivity(intent);
    }
}
