package com.luthfi.myprofile.presenter;

import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.view.FriendsDetailView;

// 15-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsDetailPresenter {

    private FriendsDetailView view;

    public FriendsDetailPresenter(FriendsDetailView view) {
        this.view = view;
    }

    public void getFriendsDetail(FriendsModel fr) {
        view.showDetail(fr);
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void removeFriend(int position) {
        view.deleteFriend(position);
    }
}
