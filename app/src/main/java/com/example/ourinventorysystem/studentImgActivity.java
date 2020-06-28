package com.example.ourinventorysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class studentImgActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private studentImgAdapter Adapter;

    private ProgressBar LoadingBar;
    private DatabaseReference databaseReference;

    private List<upload> puploads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_img);

        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LoadingBar =findViewById(R.id.loadBar);
        LoadingBar.setVisibility(View.VISIBLE);


        puploads = new ArrayList<>();
        Adapter = new studentImgAdapter(studentImgActivity.this,puploads);
        recyclerView.setAdapter(Adapter);


        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                puploads.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    upload picUpload = postSnapshot.getValue(upload.class);
                    puploads.add(picUpload);
                }

                Adapter.notifyDataSetChanged();


                LoadingBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(studentImgActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                LoadingBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}