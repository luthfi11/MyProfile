package com.luthfi.myprofile.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.fragment.ContactFragment;
import com.luthfi.myprofile.fragment.FriendsFragment;
import com.luthfi.myprofile.fragment.ProfileFragment;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class MainActivity extends AppCompatActivity {

    private void changeView(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    changeView(ProfileFragment.newInstance());
                    return true;
                case R.id.navigation_contact:
                    changeView(ContactFragment.newInstance());
                    return true;
                case R.id.navigation_friends:
                    changeView(FriendsFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeView(ProfileFragment.newInstance());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
