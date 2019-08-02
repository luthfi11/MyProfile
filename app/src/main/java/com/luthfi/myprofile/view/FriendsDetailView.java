package com.luthfi.myprofile.view;

import com.luthfi.myprofile.data.model.Friends;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public interface FriendsDetailView {
    void showDetail(Friends fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void onFriendDeleted();
}
