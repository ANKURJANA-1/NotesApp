package com.example.mytask;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SearchView;
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


public class Notes extends Fragment {

    private SearchView notesSearch;
    private RecyclerView notesRecycleview;
    private ExtendedFloatingActionButton notesAdd;
    private AdapterForRecycleView myadapter;
    private ModelClass modelClass;
    private ImageView imageView,imageView1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_notes, container, false);


        notesSearch = view.findViewById(R.id.notes_search);
        notesRecycleview = view.findViewById(R.id.notes_recycleview);
        notesAdd = view.findViewById(R.id.notes_add);


        ///data added to recycler adapter/later this data add using server database
        //add your database connection here
        ArrayList<ModelClass> data=new ArrayList<>();
        data.add(new ModelClass("Notes","notes"));
        data.add(new ModelClass("notes","text"));

        // set recycler adapter
        myadapter=new AdapterForRecycleView(data);
        notesRecycleview.setAdapter(myadapter);
        notesRecycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        notesRecycleview.setHasFixedSize(true);


        // for add new data to database using model class
        notesAdd.setOnClickListener(new View.OnClickListener() {
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