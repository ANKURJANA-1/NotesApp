package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    finish();
                }catch (Exception e)
                {

                }
            }
        });
        thread.start();
    }
}