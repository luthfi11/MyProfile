package com.luthfi.myprofile.model;

import java.util.ArrayList;

public class FriendsData {
    public static String[][] data = new String[][]{
            {"Ari Abdul Majid","10116322","IF-8","","","@ariabdulmajid"},
            {"Aria Pratomo","10116323","IF-8","","",""},
            {"Aditia Renaldi","10116359","IF-8","","",""},
            {"Muhammad Habib","10116369","IF-8","","",""},
            {"Muhammad Ilyas","10116339","IF-8","",""}
    };

    public static ArrayList<FriendsModel> getListData() {
        FriendsModel friends;
        ArrayList<FriendsModel> list = new ArrayList<>();
        for (String[] aData : data) {
            friends = new FriendsModel(aData[0], aData[1]);

            list.add(friends);
        }

        return list;
    }
}
