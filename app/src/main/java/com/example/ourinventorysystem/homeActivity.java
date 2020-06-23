package com.example.ourinventorysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

public class homeActivity extends AppCompatActivity {
    Button btnLogout;
    Button admbtn;
    int h=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        admbtn=findViewById(R.id.admbtn);
        btnLogout = findViewById(R.id.button2);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(homeActivity.this, MainActivity.class);
                startActivity(intToMain);
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user.getUid().equals("QJoabhm8dZUrjq00fRU2K7BXvcN2")){
            admbtn.setVisibility(View.VISIBLE);
        }
        else {
            admbtn.setVisibility(View.INVISIBLE);
        }
    }



    public void onClick(View v) {
        Intent i = new Intent(this, addProduct.class);
        startActivity(i);
    }

    public void onClick1(View v) {
        Intent ii = new Intent(this, imagesActivity.class);
        startActivity(ii);
    }
    public void onClick2(View v) {
        Intent iii = new Intent(this, imagesActivity.class);
        startActivity(iii);
    }
}