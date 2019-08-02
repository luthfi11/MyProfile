package com.luthfi.myprofile.presenter;

import android.content.Context;
import android.widget.EditText;

import com.luthfi.myprofile.data.model.User;
import com.luthfi.myprofile.data.repo.UserRepository;
import com.luthfi.myprofile.view.SignUpView;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class SignUpPresenter {

    private SignUpView view;
    private UserRepository repo;

    public SignUpPresenter(Context context, SignUpView view) {
        this.view = view;
        repo = new UserRepository(context);
    }

    public void signUp(User user) {
        try {
            repo.insertUser(user);
            view.signUpSuccess();
        } catch (Exception ex) {
            view.signUpFailed();
        }
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Please fill this box !");
    }

    public void setPassError(EditText editText) {
        editText.requestFocus();
        editText.setError("Password length minimal 8 character !");
    }
}
