package com.example.ourinventorysystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class addProduct extends AppCompatActivity {
private static final int pickImgRqst=1;
private Button btnChooseImg;
private Button btnUpload;
private TextView TxtViewShowUploads;
private EditText EditTxtname;
private ImageView imageView;
private ProgressBar progressBar;
private Uri Imguri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        btnChooseImg = findViewById(R.id.chooseBtn);
        btnUpload = findViewById(R.id.btnUpload);
        TxtViewShowUploads =findViewById(R.id.txtView);
        EditTxtname = findViewById(R.id.filename);
        imageView=findViewById(R.id.img);
        progressBar = findViewById(R.id.bar);

        btnChooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

    }
    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,pickImgRqst);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == pickImgRqst && resultCode == RESULT_OK && data != null && data.getData() != null){
            Imguri =data.getData();
            Picasso.with(this).load(Imguri).into(imageView);
        }
    }
}