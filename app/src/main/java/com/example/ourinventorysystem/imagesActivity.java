package com.example.ourinventorysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class imagesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private imageAdapter Adapter;

    private DatabaseReference databaseReference;
    private List<upload> puploads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        puploads = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    upload picupload = postSnapshot.getValue(upload.class);
                    puploads.add(picupload);
                }


                Adapter = new imageAdapter(imagesActivity.this,puploads);
                recyclerView.setAdapter(Adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(imagesActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}