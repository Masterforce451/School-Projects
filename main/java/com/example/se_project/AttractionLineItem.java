package com.example.se_project;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class AttractionLineItem implements Parcelable {
    private String attraction_name;
    private Drawable photo_id;
    private String photo_file_name;

    public AttractionLineItem(String attraction_name, Drawable photo_id, String photo_file_name) {
        this.attraction_name = attraction_name;
        this.photo_id = photo_id;
        this.photo_file_name = photo_file_name;
    }

    public String getAttraction_name() {
        return attraction_name;
    }

    protected AttractionLineItem(Parcel in) {
        attraction_name = in.readString();
        photo_file_name = in.readString();
    }

    public static final Creator<AttractionLineItem> CREATOR = new Creator<AttractionLineItem>() {
        @Override
        public AttractionLineItem createFromParcel(Parcel in) {
            return new AttractionLineItem(in);
        }

        @Override
        public AttractionLineItem[] newArray(int size) {
            return new AttractionLineItem[size];
        }
    };

    public String getAttractionName() {
        return attraction_name;
    }
    public String getPhoto_file_name() {return photo_file_name;}
    public Drawable getPhoto_id() {
        return photo_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(attraction_name);
        parcel.writeString(photo_file_name);
    }
}
