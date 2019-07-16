package com.example.finalprojectmad310;


import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

public class Products implements Parcelable {
    String foodId;
    String foodCountry;
    String foodName;
    String foodUnit;
    String foodQuantity;
    String imgs;

    public Products(String foodId, String foodCountry, String foodName, String foodUnit, String foodQuantity) {
        this.foodId = foodId;
        this.foodCountry = foodCountry;
        this.foodName = foodName;
        this.foodUnit = foodUnit;

        this.foodQuantity = foodQuantity;
        this.imgs = imgs;
    }

    protected Products(Parcel in) {
        foodId = in.readString();
        foodCountry = in.readString();
        foodName = in.readString();
        foodUnit = in.readString();

        foodQuantity = in.readString();
        imgs = in.readString();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodCountry() {
        return foodCountry;
    }

    public void setFoodCountry(String foodCountry) {
        this.foodCountry = foodCountry;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodUnit() {
        return foodUnit;
    }

    public void setFoodUnit(String foodUnit) {
        this.foodUnit = foodUnit;
    }



    public String getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Products(String id, String foodCountry, String foodName, String foodUnit, String foodId, JSONArray imgs) {
        this.foodName = this.foodName;
        this.imgs = this.imgs;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(foodId);
        parcel.writeString(foodCountry);
        parcel.writeString(foodName);
        parcel.writeString(foodUnit);
        parcel.writeString(foodQuantity);
        parcel.writeString(imgs);
    }
}
