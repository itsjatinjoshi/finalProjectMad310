package com.example.finalprojectmad310;


import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {
    String pimg, pimg1, pname,brand,desc;
    long  price;

    public Products(String pimg, String pimg1, String pname, String brand, String desc, long price) {
        this.pimg = pimg;
        this.pimg1 = pimg1;
        this.pname = pname;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
    }

    public Products(String pimg1, String name, String pimg, String pname, long price) {
        this.pimg = pimg;
        this.pname = pname;
    }


    protected Products(Parcel in) {
        pimg =  in.readString();
        pimg1=  in.readString();
        pname = in.readString();
        brand = in.readString();
        desc =  in.readString();
        price = in.readLong();
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPimg() {
        return pimg;
    }
    public String getPimg1() {
        return pimg1;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pimg);
        dest.writeString(pimg1);
        dest.writeString(pname);
        dest.writeString(brand);
        dest.writeString(desc);
        dest.writeLong(price);
    }
}
