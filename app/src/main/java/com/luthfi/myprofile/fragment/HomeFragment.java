package com.luthfi.myprofile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.activity.LoginActivity;
import com.luthfi.myprofile.data.model.User;
import com.luthfi.myprofile.presenter.HomePresenter;
import com.luthfi.myprofile.view.HomeView;

import java.util.Objects;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class HomeFragment extends Fragment implements HomeView {

    HomePresenter presenter;
    TextView tvUser;
    Button btnSignOut;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void showUser(User user) {
        String username = user.getNane() + " (" + user.getUsername() +")";
        tvUser.setText(username);
    }

    @Override
    public void onSignOut() {
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
        Toast.makeText(getContext(), "Signed Out", Toast.LENGTH_SHORT).show();
        Objects.requireNonNull(getActivity()).finish();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvUser = view.findViewById(R.id.tvUser);
        btnSignOut = view.findViewById(R.id.btnSignOut);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new HomePresenter(getContext(), this);
        presenter.getUserData(this);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signOut();
            }
        });
    }
}
