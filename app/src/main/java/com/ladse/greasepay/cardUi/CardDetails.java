package com.ladse.greasepay.cardUi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.ladse.greasepay.R;

import org.w3c.dom.Text;

public class CardDetails extends AppCompatActivity {
    private EditText mCardNumber, mCardExpiry, mCvv, mName, mZip;
    private CheckBox mDefaultCheck, mSaveCheck;
    private Button mProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Card Details");
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar(toolbar);
        initializeUI();
    }

    private void initializeUI() {
        mCardNumber = (EditText) findViewById(R.id.card_details_edit_cardNumber);
        mCardExpiry = (EditText) findViewById(R.id.card_details_edit_expiryDate);
        mCvv = (EditText) findViewById(R.id.card_details_edit_cvv);
        mName = (EditText) findViewById(R.id.card_details_edit_cardName);
        mZip = (EditText) findViewById(R.id.card_details_edit_zipCode);
        mDefaultCheck = (CheckBox) findViewById(R.id.card_details_check_defaultCard);
        mSaveCheck = (CheckBox) findViewById(R.id.card_details_check_saveCard);
        mProceed = (Button) findViewById(R.id.card_details_button_proceed);
        mProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
