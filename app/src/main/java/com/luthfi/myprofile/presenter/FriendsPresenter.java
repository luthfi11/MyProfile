package com.luthfi.myprofile.presenter;

import com.luthfi.myprofile.model.FriendsModel;
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

    public void add(FriendsModel fr) {
        view.addFriend(fr);
    }

    public void update(int pos, FriendsModel fr) {
        view.updateFriend(pos, fr);
    }

    public void delete(int pos) {
        view.deleteFriend(pos);
    }
}
