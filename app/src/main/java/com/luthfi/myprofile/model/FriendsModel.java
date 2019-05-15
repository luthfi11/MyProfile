package com.luthfi.myprofile.model;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsModel {

    private String name, nim, class_, phone, email, ig;

    public FriendsModel(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

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
}
