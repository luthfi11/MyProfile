package com.luthfi.myprofile.presenter;

import com.luthfi.myprofile.view.FriendsView;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsPresenter {

    private FriendsView view;

    public FriendsPresenter(FriendsView view) {
        this.view = view;
    }

    public void setFriendsList() {
        view.showFriendsList();
    }
}
