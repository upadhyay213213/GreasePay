package com.ladse.greasepay.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ladse.greasepay.R;

public class SignUpScreen extends AppCompatActivity implements View.OnClickListener {

    EditText mFname, mLname, mEmail, mPhone, mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        initializeUI();
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
                signUpAction();
                break;
        }
    }

    private void fbSignUpAction() {
    }

    private void googleSignUpAction() {
    }

    private void signUpAction() {
    }
}
