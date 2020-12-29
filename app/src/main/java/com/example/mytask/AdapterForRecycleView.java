package com.example.mytask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForRecycleView extends RecyclerView.Adapter<AdapterForRecycleView.MyViewHolder>{


    ArrayList<ModelClass> data_store;

    public AdapterForRecycleView(ArrayList<ModelClass> data){
        data_store=data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(data_store.get(position).getTile());
        holder.editText.setText(data_store.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data_store.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TextView editText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           textView=itemView.findViewById(R.id.title);
            editText=itemView.findViewById(R.id.text);
        }
    }
}
