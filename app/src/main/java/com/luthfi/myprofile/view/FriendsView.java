package com.luthfi.myprofile.view;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

import com.luthfi.myprofile.model.FriendsModel;

public interface FriendsView {
    void showFriendsList();
    void addFriend(FriendsModel fr);
    void updateFriend(int pos, FriendsModel fr);
    void deleteFriend(int pos);
}
