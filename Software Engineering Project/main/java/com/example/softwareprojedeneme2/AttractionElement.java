package com.example.softwareprojedeneme2;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class AttractionElement implements Parcelable {
    private String type;
    private String attraction_name;
    private Drawable photo_id;
    private String photo_file_name;

    public AttractionElement(String attraction_name, Drawable photo_id, String photo_file_name,String type) {
        this.attraction_name = attraction_name;
        this.photo_id = photo_id;
        this.photo_file_name = photo_file_name;
        this.type = type;
    }

    public String getAttraction_name() {
        return attraction_name;
    }

    protected AttractionElement(Parcel in) {
        attraction_name = in.readString();
        photo_file_name = in.readString();
        type = in.readString();
    }

    public static final Creator<AttractionElement> CREATOR = new Creator<AttractionElement>() {
        @Override
        public AttractionElement createFromParcel(Parcel in) {
            return new AttractionElement(in);
        }
        @Override
        public AttractionElement[] newArray(int size) {
            return new AttractionElement[size];
        }
    };

    public String getAttractionName() {
        return attraction_name;
    }
    public String getPhoto_file_name() {return photo_file_name;}
    public Drawable getPhoto_id() {
        return photo_id;
    }
    public String getType() {return type;};

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(attraction_name);
        parcel.writeString(photo_file_name);
        parcel.writeString(type);
    }
}
