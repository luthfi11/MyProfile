package com.luthfi.myprofile.model;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

import android.os.Parcel;
import android.os.Parcelable;

public class FriendsModel implements Parcelable {

    private String name, nim, class_, phone, email, ig;

    public FriendsModel(String name, String nim, String class_, String phone, String email, String ig) {
        this.name = name;
        this.nim = nim;
        this.class_ = class_;
        this.phone = phone;
        this.email = email;
        this.ig = ig;
    }

    protected FriendsModel(Parcel in) {
        name = in.readString();
        nim = in.readString();
        class_ = in.readString();
        phone = in.readString();
        email = in.readString();
        ig = in.readString();
    }

    public static final Creator<FriendsModel> CREATOR = new Creator<FriendsModel>() {
        @Override
        public FriendsModel createFromParcel(Parcel in) {
            return new FriendsModel(in);
        }

        @Override
        public FriendsModel[] newArray(int size) {
            return new FriendsModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getClass_() {
        return class_;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getIg() {
        return ig;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.nim);
        dest.writeString(this.class_);
        dest.writeString(this.phone);
        dest.writeString(this.email);
        dest.writeString(this.ig);
    }
}
