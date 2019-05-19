package com.luthfi.myprofile.view;

import android.widget.EditText;

import com.luthfi.myprofile.model.FriendsModel;

// 16-05-2019 Luthfi Alfarisi 10116365 IF-8

public interface AddEditFriendsView {
    void showData();
    void addData(FriendsModel friends);
    void updateData(int pos, FriendsModel fr);
    void showError(EditText et);
}
