package com.luthfi.myprofile.presenter;

import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.view.AddFriendsView;

// 16-05-2019 Luthfi Alfarisi 10116365 IF-8

public class AddFriendsPresenter {

    private AddFriendsView view;

    public AddFriendsPresenter(AddFriendsView view) {
        this.view = view;
    }

    public void addFriends(FriendsModel friends) {
        view.saveData(friends);
    }
}
