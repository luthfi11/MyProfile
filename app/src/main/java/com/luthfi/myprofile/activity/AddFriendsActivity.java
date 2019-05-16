package com.luthfi.myprofile.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.presenter.AddFriendsPresenter;
import com.luthfi.myprofile.view.AddFriendsView;

import java.util.Objects;

// 16-05-2019 Luthfi Alfarisi 10116365 IF-8

public class AddFriendsActivity extends AppCompatActivity implements AddFriendsView {

    Toolbar toolbar;
    EditText etName, etNIM, etClass, etPhone, etEmail, etIG;
    AddFriendsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);

        presenter = new AddFriendsPresenter(this);

        toolbar = findViewById(R.id.toolbarAddFriends);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        etName = findViewById(R.id.etName);
        etNIM = findViewById(R.id.etNIM);
        etClass = findViewById(R.id.etClass);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etIG = findViewById(R.id.etIG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.nav_done:
                FriendsModel friends = new FriendsModel(
                        etName.getText().toString(),
                        etNIM.getText().toString(),
                        etClass.getText().toString(),
                        etPhone.getText().toString(),
                        etEmail.getText().toString(),
                        etIG.getText().toString()
                );
                presenter.addFriends(friends);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void saveData(FriendsModel friends) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("newFriend", friends);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }


}
