package com.example.mad_assign_proj;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class rcvActivity extends AppCompatActivity {
    DataItem dataItem;
    ArrayList<DataItem> list = new ArrayList<DataItem>();
    RecyclerView rcv;
    RecycleAdapter rAdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv);
        rcv = findViewById(R.id.recyclerView);
        LoadListData();
        rAdp = new RecycleAdapter(list);
        rcv.setAdapter(rAdp);
        rcv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void LoadListData(){
        for(int i = 1;i <=100;i++){
            dataItem = new DataItem("Name "+i,"030012345"+i);
            list.add(dataItem);
        }
    }
}
