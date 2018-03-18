package com.example.android.bakingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nazaif on 17/3/18.
 */

public class Steps implements Parcelable {
    protected Steps(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        shortDescription = in.readString();
        description = in.readString();
        videoURL = in.readString();
        thumbnailURL = in.readString();
    }


    private Integer id;
    private String shortDescription;
    private String description;
    private String videoURL;
    private String thumbnailURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public static final Creator<Steps> CREATOR = new Creator<Steps>() {
        @Override
        public Steps createFromParcel(Parcel in) {
            return new Steps(in);
        }

        @Override
        public Steps[] newArray(int size) {
            return new Steps[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) (0x00));
        } else {
            parcel.writeByte((byte) (0x01));
            parcel.writeInt(id);
        }
        parcel.writeString(shortDescription);
        parcel.writeString(description);
        parcel.writeString(videoURL);
        parcel.writeString(thumbnailURL);
    }
}
