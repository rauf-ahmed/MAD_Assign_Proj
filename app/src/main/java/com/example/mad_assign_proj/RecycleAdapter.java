package com.example.mad_assign_proj;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.DataViewHolder>{

    ArrayList<com.example.mad_assign_proj.DataItem> dataItems;

    public RecycleAdapter(ArrayList<com.example.mad_assign_proj.DataItem> dt){
        dataItems = dt;
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View dv = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
        return new DataViewHolder(dv);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.txtName.setText(dataItems.get(position).getName());
        holder.txtMobile.setText(dataItems.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtMobile;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtMobile = itemView.findViewById(R.id.txtMobile);
        }
    }
}
