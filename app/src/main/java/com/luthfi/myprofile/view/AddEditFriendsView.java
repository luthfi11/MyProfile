package com.luthfi.myprofile.view;

import android.widget.EditText;

import com.luthfi.myprofile.data.model.Friends;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public interface AddEditFriendsView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(Friends friend);
    void showError(EditText et);
    void showFailed(String msg);
}
