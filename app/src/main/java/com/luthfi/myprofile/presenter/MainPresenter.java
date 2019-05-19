package com.luthfi.myprofile.presenter;

import android.support.v4.app.Fragment;

import com.luthfi.myprofile.view.MainView;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
