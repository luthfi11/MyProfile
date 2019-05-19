package com.luthfi.myprofile.presenter;

import android.widget.EditText;

import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.view.AddEditFriendsView;

// 16-05-2019 Luthfi Alfarisi 10116365 IF-8

public class AddEditFriendsPresenter {

    private AddEditFriendsView view;

    public AddEditFriendsPresenter(AddEditFriendsView view) {
        this.view = view;
    }

    public void isEdit(int type) {
        if (type == 1) {
            view.showData();
        }
    }

    public void addFriend(FriendsModel friend) {
        view.addData(friend);
    }

    public void updateFriend(int pos, FriendsModel fr) {
        view.updateData(pos, fr);
    }

    public void setError(EditText et) {
        view.showError(et);
    }
}
