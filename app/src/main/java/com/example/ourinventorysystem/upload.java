package com.example.ourinventorysystem;

import com.google.firebase.database.Exclude;

public class upload {
    private String mName;
    private String mImageUrl;
    private String mKey;
    private String mDescription;

    public upload() {
    }
    public upload(String name,String Description,String imageUrl){
        if (name.trim().equals("")){
            name="No Name";
        }
        if(Description.trim().equals("")){
            Description="No Description";
        }
        mName=name;
        mDescription=Description;
        mImageUrl=imageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }

    @Exclude
    public String getKey(){
        return mKey;
    }
    @Exclude
    public void setKey(String key){
        mKey=key;
    }
}
