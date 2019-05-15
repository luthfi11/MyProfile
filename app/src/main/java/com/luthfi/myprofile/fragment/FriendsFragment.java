package com.luthfi.myprofile.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.adapter.FriendsAdapter;
import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.presenter.FriendsPresenter;
import com.luthfi.myprofile.view.FriendsView;

import java.util.ArrayList;

import static com.luthfi.myprofile.model.FriendsData.getListData;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsFragment extends Fragment implements FriendsView {

    FriendsPresenter presenter;
    FriendsAdapter adapter;
    RecyclerView rvFriends;
    ArrayList<FriendsModel> friends;

    @Override
    public void showFriendsList() {
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);

        adapter.setData(getListData());
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
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        friends = new ArrayList<>();
        adapter = new FriendsAdapter(friends, getContext());

        presenter = new FriendsPresenter(this);
        presenter.setFriendsList();
    }
}
