package com.example.ourinventorysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class editable extends AppCompatActivity {
EditText txtTitle,txtDes;

Button btn;
DatabaseReference databaseReference;
ImageView img;
FirebaseDatabase firebaseDatabase;
Storage storage;
StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editable);
        Intent get =getIntent();
        String Selected = get.getStringExtra("key");
        storageReference = FirebaseStorage.getInstance().getReference("uploads").child(Selected).child("mImageUrl");


    }
        public void onClick(View v) {
            Intent get =getIntent();
            String Selected = get.getStringExtra("key");
            databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
            txtDes = findViewById(R.id.rDes);
            txtTitle = findViewById(R.id.rTitle);
            String title = txtTitle.getText().toString();
            String des = txtDes.getText().toString();

            databaseReference.child(Selected).child("mName").setValue(title);
           databaseReference.child(Selected).child("mDescription").setValue(des);

            Toast.makeText(this,"done",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,imagesActivity.class));
        }
}