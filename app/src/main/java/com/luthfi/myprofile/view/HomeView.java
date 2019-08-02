package com.luthfi.myprofile.view;

import com.luthfi.myprofile.data.model.User;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
