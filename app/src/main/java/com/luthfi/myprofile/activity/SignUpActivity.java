package com.luthfi.myprofile.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.luthfi.myprofile.R;
import com.luthfi.myprofile.data.model.User;
import com.luthfi.myprofile.presenter.SignUpPresenter;
import com.luthfi.myprofile.view.SignUpView;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    SignUpPresenter presenter;
    EditText etUsername, etName, etPassword;
    TextView tvFailed;
    Button btnSignUp;

    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "Sign Up Success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void signUpFailed() {
        tvFailed.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();

        presenter = new SignUpPresenter(this, this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        tvFailed = findViewById(R.id.tvFailed);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void signUp() {
        String username = etUsername.getText().toString();
        String name = etName.getText().toString();
        String pass = etPassword.getText().toString();

        User user = new User(username, name, pass);

        if (!username.isEmpty()) {
            if (!name.isEmpty()) {
                if (pass.length() >= 8) {

                    presenter.signUp(user);

                } else presenter.setPassError(etPassword);
            } else presenter.setError(etName);
        } else presenter.setError(etUsername);
    }
}
