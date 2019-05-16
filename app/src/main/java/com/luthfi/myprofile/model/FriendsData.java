package com.luthfi.myprofile.model;

import java.util.ArrayList;

// 15-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsData {
    public static String[][] data = new String[][]{
            {"Ari Abdul Majid","10116322","IF-8","083827474755","ariabdul@gmail.com","@ariabdulmajid"},
            {"Aria Pratomo","10116323","IF-8","08577683265","aripratom@gmail.com","@aripratom"},
            {"Chandra Septian","10116333","IF-8","085334567834","chandraseptian@gmail.com","@cseptian_"},
            {"Aditia Renaldi","10116359","IF-8","081313667895","aditiarenaldi@gmail.com","@aditiarenaldii_"},
            {"Muhammad Habib","10116369","IF-8","081233463456","mhabibnf@gmail.com","@mhabibnf"},
            {"Muhammad Ilyas","10116339","IF-8","087867747120","milyas@gmail.com","@milyas"}
    };

    public static ArrayList<FriendsModel> getListData() {
        FriendsModel friends;
        ArrayList<FriendsModel> list = new ArrayList<>();
        for (String[] aData : data) {
            friends = new FriendsModel(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5]);

            list.add(friends);
        }

        return list;
    }
}
