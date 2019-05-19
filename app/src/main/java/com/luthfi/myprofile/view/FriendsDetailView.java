package com.luthfi.myprofile.view;

// 15-05-2019 Luthfi Alfarisi 10116365 IF-8

import com.luthfi.myprofile.model.FriendsModel;

public interface FriendsDetailView {
    void showDetail(FriendsModel fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void deleteFriend(int position);
}
