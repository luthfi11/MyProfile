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
import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.presenter.FriendsPresenter;
import com.luthfi.myprofile.view.FriendsView;

import java.util.ArrayList;

import static com.luthfi.myprofile.model.FriendsData.getListData;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsFragment extends Fragment implements FriendsView, View.OnClickListener {

    FriendsAdapter adapter;
    ArrayList<FriendsModel> friends;
    static FriendsPresenter presenter;
    RecyclerView rvFriends;
    FloatingActionButton fab;

    @Override
    public void showFriendsList() {
        friends.addAll(getListData());
    }

    @Override
    public void addFriend(FriendsModel fr) {
        friends.add(0, fr);
        adapter.setData(friends);
    }

    @Override
    public void updateFriend(int pos, FriendsModel fr) {
        friends.remove(pos);
        friends.add(pos, fr);
        adapter.setData(friends);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void deleteFriend(int pos) {
        friends.remove(pos);
        adapter.notifyDataSetChanged();
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
        adapter = new FriendsAdapter(friends, getActivity());
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);
        presenter = new FriendsPresenter(this);
        presenter.setFriendsList();

        fab.setOnClickListener(this);
    }

    public static void add(FriendsModel fr) {
        presenter.add(fr);
    }

    public static void update(int pos, FriendsModel fr) {
        presenter.update(pos, fr);
    }

    public static void delete(int pos) {
        presenter.delete(pos);
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
