package com.example.ourinventorysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText emailId, password;
    Button btnsignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mFirebaseAuth =FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        tvSignIn = findViewById(R.id.txtView);
        btnsignUp = findViewById(R.id.button);
        btnsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String email=emailId.getText().toString();
                    String pwd = password.getText().toString();

                  if(email.isEmpty()){
                        emailId.setError("plz check email id");
                        emailId.requestFocus();
                    }
                else if(pwd.isEmpty()){
                    password.setError("plz enter your password");
                    password.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are Empty!",Toast.LENGTH_SHORT).show();
                }

                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"signUp Unsuccessful, please Try Again",Toast.LENGTH_SHORT);
                            }
                            else {
                                startActivity(new Intent(MainActivity.this,homeActivity.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(MainActivity.this,"Error occurred!",Toast.LENGTH_SHORT);
                }
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iu = new Intent(MainActivity.this,loginActivity.class);
                startActivity(iu);
            }
        });
    }
}