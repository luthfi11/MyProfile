package com.luthfi.myprofile.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.presenter.FriendsDetailPresenter;
import com.luthfi.myprofile.view.FriendsDetailView;

import java.util.Random;

// 15-05-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsDetailActivity extends AppCompatActivity implements FriendsDetailView, View.OnClickListener {

    ImageView imgAva;
    TextView tvName, tvNIM, tvClass, tvPhone, tvEmail, tvIg;
    FriendsDetailPresenter presenter;
    FriendsModel friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_detail);

        presenter = new FriendsDetailPresenter(this);

        imgAva = findViewById(R.id.imgFriendAva);
        tvName = findViewById(R.id.tvFriendName);
        tvNIM = findViewById(R.id.tvFriendNIM);
        tvClass = findViewById(R.id.tvFriendClass);
        tvPhone = findViewById(R.id.tvFriendPhone);
        tvEmail = findViewById(R.id.tvFriendEmail);
        tvIg = findViewById(R.id.tvFriendIg);

        presenter.getFriendsDetail();
    }

    @Override
    public void showDetail() {
        int[] ava = {R.drawable.ava1, R.drawable.ava2, R.drawable.ava3, R.drawable.ava4, R.drawable.ava5};
        Random ran = new Random();
        int i = ran.nextInt(ava.length);

        imgAva.setImageResource(ava[i]);

        friends = getIntent().getParcelableExtra("friend");

        tvName.setText(friends.getName());
        tvNIM.setText(friends.getNim());
        tvClass.setText(friends.getClass_());
        tvPhone.setText(friends.getPhone());
        tvEmail.setText(friends.getEmail());
        tvIg.setText(friends.getIg());
    }

    @Override
    public void actionCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", friends.getPhone(), null));
        startActivity(i);
    }

    @Override
    public void actionEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + friends.getEmail()));
        startActivity(i);
    }

    @Override
    public void actionInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/" + friends.getIg().replace("@", "")));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lytPhone:
                presenter.makeCall();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.openInstagram();
                break;
        }
    }
}
