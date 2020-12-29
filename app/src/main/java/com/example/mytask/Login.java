package com.example.mytask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {


    private EditText enteremail;
    private EditText enterpassword;
    private TextView forgotpassword;
    private Button signinbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        enteremail = (EditText) findViewById(R.id.enteremail);
        enterpassword = (EditText) findViewById(R.id.enterpassword);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        signinbutton = (Button) findViewById(R.id.signinbutton);




        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=enteremail.getText().toString().trim();
                String pass=enterpassword.getText().toString().trim();

                FirebaseAuth.getInstance().signInWithEmailAndPassword(mail,pass)
                        .addOnCompleteListener(new Login(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login sucessfull", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), Homepage.class));
                                }
                                else
                                    Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });





    }

    public void signup(View view) {
        startActivity(new Intent(getApplicationContext(),Register.class));
    }
}