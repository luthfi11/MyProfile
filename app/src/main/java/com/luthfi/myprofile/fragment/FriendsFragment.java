package com.luthfi.myprofile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.activity.AddFriendsActivity;
import com.luthfi.myprofile.activity.MainActivity;
import com.luthfi.myprofile.adapter.FriendsAdapter;
import com.luthfi.myprofile.model.FriendsData;
import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.presenter.FriendsPresenter;
import com.luthfi.myprofile.view.FriendsView;

import java.util.ArrayList;

import static com.luthfi.myprofile.model.FriendsData.getListData;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsFragment extends Fragment implements FriendsView, View.OnClickListener {

    FriendsPresenter presenter;
    FriendsAdapter adapter;
    RecyclerView rvFriends;
    FloatingActionButton fab;
    ArrayList<FriendsModel> friends;

    @Override
    public void showFriendsList() {
        friends.addAll(getListData());
    }

    public FriendsFragment() {
        // Required empty public constructor
    }

    public static FriendsFragment newInstance() {
        return new FriendsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        rvFriends = view.findViewById(R.id.rvFriends);
        fab = view.findViewById(R.id.fabAddFriends);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        friends = new ArrayList<>();
        adapter = new FriendsAdapter(friends);
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);
        presenter = new FriendsPresenter(this);
        presenter.setFriendsList();

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getContext(), AddFriendsActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                FriendsModel fr = data.getParcelableExtra("newFriend");
                friends.add(fr);
                adapter.setData(friends);
            }
        }
    }
}
