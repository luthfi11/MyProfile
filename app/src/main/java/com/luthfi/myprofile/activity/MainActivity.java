package com.luthfi.myprofile.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.fragment.AboutFragmentManager;
import com.luthfi.myprofile.fragment.ContactFragment;
import com.luthfi.myprofile.fragment.FriendsFragment;
import com.luthfi.myprofile.fragment.ProfileFragment;
import com.luthfi.myprofile.presenter.MainPresenter;
import com.luthfi.myprofile.view.MainView;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;
    FragmentManager fm = getSupportFragmentManager();
    final Fragment profil = new ProfileFragment();
    final Fragment contact = new ContactFragment();
    final Fragment friend = new FriendsFragment();
    final Fragment about = new AboutFragmentManager();
    Fragment active = profil;
    Fragment[] fragment = {about, friend, contact, profil};

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    presenter.changeView(profil);
                    return true;
                case R.id.navigation_contact:
                    presenter.changeView(contact);
                    return true;
                case R.id.navigation_friends:
                    presenter.changeView(friend);
                    return true;
                case R.id.navigation_about:
                    presenter.changeView(about);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.addView();
        presenter.changeView(profil);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void showView(Fragment fragment) {
        fm.beginTransaction().hide(active).show(fragment).commit();
        active = fragment;
    }

    @Override
    public void addView() {
        for (int i = 0; i<4; i++) {
            fm.beginTransaction().add(R.id.content, fragment[i]).hide(fragment[i]).commit();
        }
    }
}
