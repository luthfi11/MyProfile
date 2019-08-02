package com.luthfi.myprofile.presenter;

import android.content.Context;

import com.luthfi.myprofile.data.model.Friends;
import com.luthfi.myprofile.data.repo.FriendsRepository;
import com.luthfi.myprofile.view.FriendsDetailView;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsDetailPresenter {

    private FriendsDetailView view;
    private FriendsRepository repo;

    public FriendsDetailPresenter(Context context, FriendsDetailView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void getFriendsDetail(Friends fr) {
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

    public void removeFriend(Friends friend) {
        repo.deleteFriend(friend);
        view.onFriendDeleted();
    }
}
