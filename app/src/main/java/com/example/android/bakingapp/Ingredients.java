package com.example.android.bakingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nazaif on 17/3/18.
 */

public class Ingredients implements Parcelable {
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    private Double quantity;
    private String measure;
    private String ingredient;
    protected Ingredients(Parcel in) {
        quantity = in.readByte() == 0x00 ? null : in.readDouble();
        measure = in.readString();
        ingredient = in.readString();
    }

    public static final Creator<Ingredients> CREATOR = new Creator<Ingredients>() {
        @Override
        public Ingredients createFromParcel(Parcel in) {
            return new Ingredients(in);
        }

        @Override
        public Ingredients[] newArray(int size) {
            return new Ingredients[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (quantity == null) {
            parcel.writeByte((byte) (0x00));
        } else {
            parcel.writeByte((byte) (0x01));
            parcel.writeDouble(quantity);
        }
        parcel.writeString(measure);
        parcel.writeString(ingredient);

    }
}
