package com.example.mad_assign_proj;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void PersonalInfo(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void Login(View v){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    public void BeautyBeast(View v){
        Intent intent = new Intent(this,BeautyAndBeast.class);
        startActivity(intent);
    }

    public void PlaceView(View v){
        Intent intent = new Intent(this,PlaceView.class);
        startActivity(intent);
    }
}
