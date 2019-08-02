package com.luthfi.myprofile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.activity.AddEditEditFriendsActivity;
import com.luthfi.myprofile.adapter.FriendsAdapter;
import com.luthfi.myprofile.data.model.Friends;
import com.luthfi.myprofile.presenter.FriendsPresenter;
import com.luthfi.myprofile.view.FriendsView;

import java.util.ArrayList;
import java.util.List;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsFragment extends Fragment implements FriendsView, View.OnClickListener {

    FriendsAdapter adapter;
    ArrayList<Friends> friends;
    static FriendsPresenter presenter;
    RecyclerView rvFriends;
    FloatingActionButton fab;

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void showFriendsList(List<Friends> friends) {
        this.friends.clear();
        this.friends.addAll(friends);
        adapter.notifyDataSetChanged();
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
        adapter = new FriendsAdapter(friends, getActivity());
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);

        presenter = new FriendsPresenter(getContext(),this);
        presenter.setFriendsList(this);

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabAddFriends) {
            Intent i = new Intent(getContext(), AddEditEditFriendsActivity.class);
            i.putExtra("type", 0);
            startActivity(i);
        }
    }
}
