package com.luthfi.myprofile.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.luthfi.myprofile.preference.UserPreference;
import com.luthfi.myprofile.view.MainView;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
