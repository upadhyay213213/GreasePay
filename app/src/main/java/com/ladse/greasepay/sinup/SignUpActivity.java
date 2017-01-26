package com.ladse.greasepay.sinup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ladse.greasepay.R;
import com.ladse.greasepay.login.LoginActivity;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener,SinUpView {

    private EditText mFname, mLname, mEmail, mPhone, mPass;
    private SinUpPresenterImpl sinUpPresenter;
    private boolean isSocial=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        initializeUI();
        sinUpPresenter=new SinUpPresenterImpl(this);
    }

    private void initializeUI() {
        mFname = (EditText) findViewById(R.id.signUp_edit_fname);
        mLname = (EditText) findViewById(R.id.signUp_edit_lname);
        mEmail = (EditText) findViewById(R.id.signUp_edit_email);
        mPhone = (EditText) findViewById(R.id.signUp_edit_phone);
        mPass = (EditText) findViewById(R.id.signUp_edit_password);
        ImageButton mFbSignUp = (ImageButton) findViewById(R.id.signUp_button_fbSignUp);
        mFbSignUp.setOnClickListener(this);
        ImageButton mGoogleSignUp = (ImageButton) findViewById(R.id.signUp_button_googleSignUp);
        mGoogleSignUp.setOnClickListener(this);
        Button mSignUp = (Button) findViewById(R.id.signUp_button_signUp);
        mSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUp_button_fbSignUp:
                fbSignUpAction();
                break;
            case R.id.signUp_button_googleSignUp:
                googleSignUpAction();
                break;
            case R.id.signUp_button_signUp:
                sinUpPresenter.validateSignUpDate(mFname.getText().toString(),mLname.getText().toString(),mPhone.getText().toString(),mEmail.getText().toString(),mPass.getText().toString(),isSocial);
                //signUpAction(mFname.getText().toString(),mLname.getText().toString(),mEmail.getText().toString(),mPass.getText().toString());
                break;
        }
    }

    private void fbSignUpAction() {
    }

    private void googleSignUpAction() {
    }



    @Override
    public void setValidationError() {

    }

    @Override
    public void onSinUpSuccessFull(LoginSinUpResponse loginSinUpResponse) {
        Log.v("onSinUpSuccessFull",loginSinUpResponse.toString());
        startActivity(new Intent(this, LoginActivity.class));

    }

    @Override
    public void onSinUpError(LoginSinUpResponse loginSinUpResponse) {

    }


}
