package com.ladse.greasepay.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.InputSanitation;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {
    private EditText mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initializeUI();
    }

    private void initializeUI() {
        mUsername = (EditText) findViewById(R.id.login_edit_username);
        mPassword = (EditText) findViewById(R.id.login_edit_password);
        ImageButton mFbLoginButton = (ImageButton) findViewById(R.id.login_button_fbLogin);
        mFbLoginButton.setOnClickListener(this);
        ImageButton mGoogleLoginButton = (ImageButton) findViewById(R.id.login_button_googleLogin);
        mGoogleLoginButton.setOnClickListener(this);
        Button mLoginButton = (Button) findViewById(R.id.login_button_loginBtn);
        mLoginButton.setOnClickListener(this);
        Button mSignUpButton = (Button) findViewById(R.id.login_button_signUp);
        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.login_button_fbLogin:
                Toast.makeText(this, "fblogin", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_button_googleLogin:
                break;
            case R.id.login_button_loginBtn:
                loginAction();
                break;
            case R.id.login_button_signUp:
                startActivity(new Intent(this, SignUpScreen.class));
                finish();
        }
    }

    private void fbLoginAction() {
    }

    private void googleLoginAction() {
    }

    private void loginAction() {
        InputSanitation sanitate = new InputSanitation();
        if (sanitate.checkInput(mUsername.getText().toString(), mPassword.getText().toString())) {
            Toast.makeText(this, "Input ok", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, sanitate.getError(), Toast.LENGTH_SHORT).show();
        }
    }
}
