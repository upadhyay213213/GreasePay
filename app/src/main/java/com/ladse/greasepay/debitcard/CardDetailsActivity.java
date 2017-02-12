package com.ladse.greasepay.debitcard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.ladse.greasepay.R;
import com.ladse.greasepay.booking.card_booking.BarBookingRequest;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.debitcard.model.CardRequest;
import com.ladse.greasepay.debitcard.model.CardResponse;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;
import com.stripe.android.Stripe;
import com.stripe.android.exception.StripeException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardDetailsActivity extends AppCompatActivity {
    private EditText mCardNumber, mCardExpiry, mCvv, mName, mZip;
    private CheckBox mDefaultCheck, mSaveCheck;
    private Button mProceed;
    private EditText mCardExpiryMonth;
    private EditText mCardExpiryYear;
    private String errorMessage;
    private BarBookingRequest barBookingRequest;

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
        mCardExpiryMonth = (EditText) findViewById(R.id.card_details_edit_expiryMonth);
        mCardExpiryYear = (EditText) findViewById(R.id.card_details_edit_expiryYear);
        mCvv = (EditText) findViewById(R.id.card_details_edit_cvv);
        mName = (EditText) findViewById(R.id.card_details_edit_cardName);
        mZip = (EditText) findViewById(R.id.card_details_edit_zipCode);
        mDefaultCheck = (CheckBox) findViewById(R.id.card_details_check_defaultCard);
        mSaveCheck = (CheckBox) findViewById(R.id.card_details_check_saveCard);
        mProceed = (Button) findViewById(R.id.card_details_button_proceed);

        Bundle bundle=getIntent().getExtras();
        barBookingRequest= (BarBookingRequest) bundle.getSerializable(AppConstatnts.BAR_DATA);
        mProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validateCardFromtripe();
                new GetStripeToken(mCardNumber.getText().toString(), Integer.parseInt(mCardExpiryMonth.getText().toString()), Integer.parseInt(mCardExpiryYear.getText().toString()), mCvv.getText().toString()).execute();

                // saveCardDetails(AppSharedPreference.getAuthToken(CardDetailsActivity.this), new CardRequest(mCardNumber.getText().toString(), mCardExpiry.getText().toString(), mCvv.getText().toString(), mDefaultCheck.getText().toString(), mName.getText().toString(), mZip.getText().toString()));
            }
        });
    }




    class GetStripeToken extends AsyncTask<Void,Void,Token>{

        String cardNo;
        int month;
        int year;
        String cvv;

        public GetStripeToken(String cardNo, int month, int year, String cvv) {
            this.cardNo = cardNo;
            this.month = month;
            this.year = year;
            this.cvv = cvv;
        }

        @Override
        protected Token doInBackground(Void... params) {
            Token token = null;
            String publishableKey = AppConstatnts.STRIPE_PUBLIC_KEY;
            Card card = new Card(cardNo, month, year, cvv);

            Stripe stripe = new Stripe();
            try {
               token = stripe.createTokenSynchronous(card, publishableKey);

            } catch (StripeException stripeEx) {
                errorMessage = stripeEx.getLocalizedMessage();
            }
            return token;
        }

        @Override
        protected void onPostExecute(Token token) {
            super.onPostExecute(token);
            if(token!=null) {
                //AlertManager.showErrorDialog(CardDetailsActivity.this,token.getId());
                 saveCardDetails(AppSharedPreference.getAuthToken(CardDetailsActivity.this), new CardRequest(mCardNumber.getText().toString(), mCardExpiry.getText().toString(), mCvv.getText().toString(), mDefaultCheck.getText().toString(), mName.getText().toString(), mZip.getText().toString()));

            }else{
                AlertManager.showErrorDialog(CardDetailsActivity.this, String.valueOf(errorMessage));
            }
        }


    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void saveCardDetails(String authToken, CardRequest cardRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<CardResponse> si = retrofitInterface.saveCardDatat(authToken, cardRequest);
        si.enqueue(new Callback<CardResponse>() {
            @Override
            public void onResponse(Call<CardResponse> call, Response<CardResponse> response) {

                AlertManager.showErrorDialog(CardDetailsActivity.this, response.message());
                if(barBookingRequest!=null){

                }


            }

            @Override
            public void onFailure(Call<CardResponse> call, Throwable t) {

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void makeBarBooking(BarBookingRequest barBookingRequest){
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.barBooking(AppSharedPreference.getAuthToken(CardDetailsActivity.this),barBookingRequest);
    }
}
