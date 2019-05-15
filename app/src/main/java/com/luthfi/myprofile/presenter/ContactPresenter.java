package com.luthfi.myprofile.presenter;

import com.luthfi.myprofile.view.ContactView;

// 15-05-2019 Luthfi Alfarisi 10116365 IF-8

public class ContactPresenter {

    private ContactView view;

    public ContactPresenter(ContactView view) {
        this.view = view;
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

    public void openTwitter() {
        view.actionTwitter();
    }
}
