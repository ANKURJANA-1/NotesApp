package com.example.mytask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;

public class AdapterForTasks extends RecyclerView.Adapter<AdapterForTasks.MyViewHolder> {

    ArrayList<ModelClassForTasks> tasks_data=new ArrayList<>();

    public AdapterForTasks(ArrayList<ModelClassForTasks> tasks_data) {
        this.tasks_data = tasks_data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.task_added,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(tasks_data.get(position).getTasks());
    }

    @Override
    public int getItemCount() {
        return tasks_data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        MaterialCheckBox checkBox;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox=itemView.findViewById(R.id.checkbox);
            textView=itemView.findViewById(R.id.task_detiles);

        }
    }
}
