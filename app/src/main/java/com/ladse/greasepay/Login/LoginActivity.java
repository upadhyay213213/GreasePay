package com.ladse.greasepay.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.home.ui.HomeScreenActivity;
import com.ladse.greasepay.sinup.SignUpActivity;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginView {
    private EditText mUsername, mPassword;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initializeUI();
        loginPresenter=new LoginPresenterImpl(this);
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
                //loginAction();
                boolean isSocial = false;
                loginPresenter.validateUserCredentialsToLogin(mUsername.getText().toString(), mPassword.getText().toString(), isSocial);
                break;
            case R.id.login_button_signUp:
                startActivity(new Intent(this, SignUpActivity.class));
                finish();
        }
    }

    @Override
    public void setCredentialsError() {
        //show alert dialog validation credential fail
    }

    @Override
    public void setLoginSuccessFull(LoginSinUpResponse loginSinUpResponse) {
        //Start new activity
       // AppSharedPreference.setAuthToken(loginSinUpResponse.getData().getAuthToken(),this);
        startActivity(new Intent(this,HomeScreenActivity.class));
       // startActivity(new Intent(this,UpcomingEventsActivity.class));
//        startActivity(new Intent(this,BookingListActivity.class));
    }

    @Override
    public void setLoginFail(String message) {
        AlertManager.showErrorDialog(this,"Invalid username and password");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.toString();
    }
}
