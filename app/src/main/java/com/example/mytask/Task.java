package com.example.mytask;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;


public class Task extends Fragment {

    RecyclerView recyclerView;
    ExtendedFloatingActionButton floatingActionButton;
    private ImageView imageView,imageView1;

    AdapterForTasks adapterForTasks;
    ArrayList<ModelClassForTasks> modeldata;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_task, container, false);


        recyclerView=view.findViewById(R.id.tasks_recycleview);
        floatingActionButton=view.findViewById(R.id.tasks_add);


        modeldata=new ArrayList<>();
        /////////////////////////////////////////////////////////////////////////////////////add your database connection here
        modeldata.add(new ModelClassForTasks("hello",true));
        modeldata.add(new ModelClassForTasks("hello",true));
        modeldata.add(new ModelClassForTasks("hello",true));
        modeldata.add(new ModelClassForTasks("hello",true));
        modeldata.add(new ModelClassForTasks("hello",true));
        modeldata.add(new ModelClassForTasks("hello",true));
        modeldata.add(new ModelClassForTasks("hello",true));
      ////////////////////////////////////////////////////////////////////////////////////////
        adapterForTasks=new AdapterForTasks(modeldata);
        recyclerView.setAdapter(adapterForTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);





        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater1=getLayoutInflater();
                View view=inflater1.inflate(R.layout.new_data_entry_layout,null,false);

                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setView(view);
                builder.setCancelable(false);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

                imageView=view.findViewById(R.id.backpress);
                imageView1=view.findViewById(R.id.add_submit);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"Notes saved",Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });


            }
        });



        return view;
    }
}