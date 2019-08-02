package com.luthfi.myprofile.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.luthfi.myprofile.data.model.Friends;
import com.luthfi.myprofile.data.repo.FriendsRepository;
import com.luthfi.myprofile.view.FriendsView;

import java.util.List;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsPresenter {

    private FriendsRepository repo;
    private FriendsView view;
    private LiveData<List<Friends>> allFriends;

    public FriendsPresenter(Context context, FriendsView view) {
        this.view = view;
        repo = new FriendsRepository(context);
        allFriends = repo.getAllFriends();
    }

    public void setFriendsList(LifecycleOwner owner) {
        allFriends.observe(owner, new Observer<List<Friends>>() {
            @Override
            public void onChanged(@Nullable List<Friends> friends) {
                view.showFriendsList(friends);
            }
        });
    }
}
