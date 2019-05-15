package com.luthfi.myprofile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.model.FriendsModel;

import java.util.ArrayList;

// 14-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder>  {

    private ArrayList<FriendsModel> friends;
    private Context context;

    public FriendsAdapter(ArrayList<FriendsModel> friends, Context context) {
        this.friends = friends;
        this.context = context;
    }

    public void setData(ArrayList<FriendsModel> items) {
        this.friends = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_friends, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(friends.get(i).getName());
        viewHolder.tvNIM.setText(friends.get(i).getNim());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAva;
        TextView tvName, tvNIM;

        ViewHolder(View itemView) {
            super(itemView);
            imgAva = itemView.findViewById(R.id.imgAva);
            tvName = itemView.findViewById(R.id.tvName);
            tvNIM = itemView.findViewById(R.id.tvNim);
        }
    }

}