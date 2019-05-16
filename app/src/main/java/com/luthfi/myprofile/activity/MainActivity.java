package com.luthfi.myprofile.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.fragment.AboutFragment;
import com.luthfi.myprofile.fragment.ContactFragment;
import com.luthfi.myprofile.fragment.FriendsFragment;
import com.luthfi.myprofile.fragment.ProfileFragment;
import com.luthfi.myprofile.presenter.MainPresenter;
import com.luthfi.myprofile.view.MainView;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    presenter.changeView(ProfileFragment.newInstance());
                    return true;
                case R.id.navigation_contact:
                    presenter.changeView(ContactFragment.newInstance());
                    return true;
                case R.id.navigation_friends:
                    presenter.changeView(FriendsFragment.newInstance());
                    return true;
                case R.id.navigation_about:
                    presenter.changeView(AboutFragment.newInstance());
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        presenter.changeView(ProfileFragment.newInstance());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void showView(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }
}
