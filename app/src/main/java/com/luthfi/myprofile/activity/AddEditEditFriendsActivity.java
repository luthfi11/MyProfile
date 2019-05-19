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
import com.luthfi.myprofile.fragment.FriendsFragment;
import com.luthfi.myprofile.model.FriendsModel;
import com.luthfi.myprofile.presenter.AddEditFriendsPresenter;
import com.luthfi.myprofile.view.AddEditFriendsView;

import java.util.Objects;

// 16-05-2019 Luthfi Alfarisi 10116365 IF-8

public class AddEditEditFriendsActivity extends AppCompatActivity implements AddEditFriendsView {

    Toolbar toolbar;
    EditText etName, etNIM, etClass, etPhone, etEmail, etIG;
    AddEditFriendsPresenter presenter;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_friends);

        presenter = new AddEditFriendsPresenter(this);

        toolbar = findViewById(R.id.toolbarAddFriends);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        etName = findViewById(R.id.etName);
        etNIM = findViewById(R.id.etNIM);
        etClass = findViewById(R.id.etClass);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etIG = findViewById(R.id.etIG);

        type = getIntent().getIntExtra("type", 0);

        presenter.isEdit(type);
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
                FriendsModel friend = new FriendsModel(
                        etName.getText().toString(),
                        etNIM.getText().toString(),
                        etClass.getText().toString(),
                        etPhone.getText().toString(),
                        etEmail.getText().toString(),
                        etIG.getText().toString()
                );

                if (!etName.getText().toString().isEmpty()) {
                    if (!etNIM.getText().toString().isEmpty()) {
                        if (!etClass.getText().toString().isEmpty()) {

                            if (type == 0) {
                                presenter.addFriend(friend);
                            } else {
                                int pos = getIntent().getIntExtra("pos", 99);
                                presenter.updateFriend(pos, friend);
                            }

                        } else {
                            presenter.setError(etClass);
                        }
                    } else {
                        presenter.setError(etNIM);
                    }
                } else {
                    presenter.setError(etName);
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showData() {
        FriendsModel f = getIntent().getParcelableExtra("friend");
        etName.setText(f.getName());
        etNIM.setText(f.getNim());
        etClass.setText(f.getClass_());
        etPhone.setText(f.getPhone());
        etEmail.setText(f.getEmail());
        etIG.setText(f.getIg());
    }

    @Override
    public void addData(FriendsModel friends) {
        FriendsFragment.add(friends);
        finish();
    }

    @Override
    public void updateData(int pos, FriendsModel fr) {
        FriendsFragment.update(pos, fr);
        Intent i = new Intent();
        i.putExtra("newData", fr);
        setResult(Activity.RESULT_OK, i);
        finish();
    }

    @Override
    public void showError(EditText et) {
        et.requestFocus();
        et.setError("Please Fill This Box !");
    }
}
