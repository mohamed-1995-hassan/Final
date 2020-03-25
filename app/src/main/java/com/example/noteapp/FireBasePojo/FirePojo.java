package com.example.noteapp.FireBasePojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;
@IgnoreExtraProperties
public class FirePojo implements Parcelable{

    private String id;
    private String details;

    public FirePojo() {

    }

    public FirePojo(String id, String details) {
        this.id = id;
        this.details = details;
    }



    protected FirePojo(Parcel in) {
        id = in.readString();
        details = in.readString();
    }

    public static final Creator<FirePojo> CREATOR = new Creator<FirePojo>() {
        @Override
        public FirePojo createFromParcel(Parcel in) {
            return new FirePojo(in);
        }

        @Override
        public FirePojo[] newArray(int size) {
            return new FirePojo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(details);
    }

    }


