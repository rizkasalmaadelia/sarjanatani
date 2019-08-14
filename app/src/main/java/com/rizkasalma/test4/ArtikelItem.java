package com.rizkasalma.test4;

import android.os.Parcel;
import android.os.Parcelable;

public class ArtikelItem implements Parcelable {
    private int imageArtikel;
    private String title;
    private String description;


    public int getImageArtikel() {
        return imageArtikel;
    }

    public void setImageArtikel(int imageArtikel) {
        this.imageArtikel = imageArtikel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private ArtikelItem(Parcel in) {
        this.imageArtikel = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
    }
    ArtikelItem(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imageArtikel);
        dest.writeString(this.title);
        dest.writeString(this.description);
    }

    public static final Creator<ArtikelItem> CREATOR = new Creator<ArtikelItem>() {
        @Override
        public ArtikelItem createFromParcel(Parcel in) {
            return new ArtikelItem(in);
        }

        @Override
        public ArtikelItem[] newArray(int size) {
            return new ArtikelItem[size];
        }
    };
}
