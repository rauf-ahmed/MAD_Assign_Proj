package com.example.mad_assign_proj;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlaceView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_view);
    }

    public void onClickContacts(View v){
        Intent intent = new Intent(this, rcvActivity.class);
        startActivity(intent);
    }
}
