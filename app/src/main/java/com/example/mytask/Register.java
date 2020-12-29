package com.example.mytask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText username;
    private EditText useremail;
    private EditText userpassword;
    private EditText userrepassword;
    private AppCompatCheckBox termAndCondition;
    private Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        useremail = (EditText) findViewById(R.id.useremail);
        userpassword = (EditText) findViewById(R.id.userpassword);
        userrepassword = (EditText) findViewById(R.id.userrepassword);
        termAndCondition = (AppCompatCheckBox) findViewById(R.id.term_and_condition);
        signup = (Button) findViewById(R.id.signup);



        
        
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString().trim();
                String email = useremail.getText().toString().trim();
                String pass = userpassword.getText().toString().trim();
                String repass = userrepassword.getText().toString().trim();

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new Register(), new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(getApplicationContext(),"Account created sucessfully",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new Register(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}

       
       