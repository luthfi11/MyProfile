package com.luthfi.myprofile.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.luthfi.myprofile.data.model.User;
import com.luthfi.myprofile.data.repo.UserRepository;
import com.luthfi.myprofile.preference.UserPreference;
import com.luthfi.myprofile.view.HomeView;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class HomePresenter {

    private HomeView view;
    private UserRepository repo;
    private UserPreference prefs;

    public HomePresenter(Context context, HomeView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new UserPreference(context);
    }

    public void getUserData(LifecycleOwner owner) {
        String username = prefs.userLogin();
        String password = prefs.passwordLogin();

        repo.selectUser(username, password).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                view.showUser(user);
            }
        });
    }

    public void signOut() {
        prefs.setIsLogin(null, null);
        view.onSignOut();
    }
}
