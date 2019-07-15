package com.example.finalprojectmad310;


import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {

    String pimg, pimg1, pname,brand,desc, price;

    protected Products(Parcel in) {
        pimg = in.readString();
        pimg1 = in.readString();
        pname = in.readString();
        brand = in.readString();
        desc = in.readString();
        price = in.readString();
    }
    public Products(String pimg, String pimg1, String pname, String brand, String desc, String price) {
        this.pimg = pimg;
        this.pimg1 = pimg1;
        this.pname = pname;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
    }

    public Products(String pname) {
        this.pname = pname;
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
    public Products(String pimg1, String name, String pimg, String pname, long price) {
        this.pimg = pimg;
        this.pname = pname;
    }


    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getPimg1() {
        return pimg1;
    }

    public void setPimg1(String pimg1) {
        this.pimg1 = pimg1;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pimg);
        parcel.writeString(pimg1);
        parcel.writeString(pname);
        parcel.writeString(brand);
        parcel.writeString(desc);
        parcel.writeString(price);
    }


}
