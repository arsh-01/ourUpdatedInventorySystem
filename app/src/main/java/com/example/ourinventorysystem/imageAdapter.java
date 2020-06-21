package com.example.ourinventorysystem;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ImageViewHolder> {

    private Context pcontext;
    private List<upload> puploads;

    public imageAdapter(Context context, List<upload> uploads){
        pcontext=context;
        puploads=uploads;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(pcontext).inflate(R.layout.image_item,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        upload uploadCurrent = puploads.get(position);
        holder.textViewName.setText(uploadCurrent.getmName());
        Picasso.with(pcontext).load(uploadCurrent.getmImageUrl()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return puploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(View itemView){
            super(itemView);
            textViewName=itemView.findViewById(R.id.txtViewName);
            imageView = itemView.findViewById(R.id.imageUpload);
        }
    }

}
