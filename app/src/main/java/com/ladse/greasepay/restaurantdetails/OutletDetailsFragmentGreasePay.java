package com.ladse.greasepay.restaurantdetails;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.debitcard.CardDetailsActivity;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.promocode.checkpromocode.controler.CheckPromoCodePresenter;
import com.ladse.greasepay.promocode.checkpromocode.controler.CheckPromoCodePresenterImpl;
import com.ladse.greasepay.promocode.checkpromocode.controler.CheckPromoCodeView;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeData;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutletDetailsFragmentGreasePay extends Fragment implements CheckPromoCodeView{
    private TextView mLabelPricing;
    private TextView mLabelDate;
    private TextView mLabelPricingMen;
    private TextView mLabelPricingWomen;
    private TextView mLabelPricingPromo;
    private TextView mLabelPricingTax;
    private TextView mLabelPricingTotal;
    private EditText mPromoCode;
    private Button mPayBtn;
    private ImageView mCalender;
    private RestaurantData restaurantData;
    private TextView mLabelPricingMale;
    private TextView mLabelPricingFemale;
    private CheckPromoCodePresenter checkPromoCodePresenter;
    private boolean idEntryFree;
    private int totalmenPrice;
    private int totalwomenPrice;

    private ImageButton incrementMen, decrementMen, incrementWomen, decrementWomen;
    private TextView mNumberMen, mNumberWomen;
    public OutletDetailsFragmentGreasePay() {
        // Required empty public constructor
        checkPromoCodePresenter=new CheckPromoCodePresenterImpl(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.outlet_details_tab_greasepay, container, false);
        mLabelPricingMale = (TextView) v.findViewById(R.id.outlet_details_fragment_greasePay_pricing_male);
        mLabelPricingFemale = (TextView) v.findViewById(R.id.outlet_details_fragment_greasePay_pricing_female);
        mLabelDate = (TextView) v.findViewById(R.id.outlet_details_fragment_greasePay_date);
        mCalender = (ImageView) v.findViewById(R.id.outlet_details_fragment_greasePay_icon_calendar);
        incrementMen = (ImageButton) v.findViewById(R.id.outlet_details_fragment_greasePay_button_menIncrement);
        decrementMen = (ImageButton) v.findViewById(R.id.outlet_details_fragment_greasePay_button_menDecrement);
        incrementWomen = (ImageButton) v.findViewById(R.id.outlet_details_fragment_greasePay_button_womenIncrement);
        decrementWomen = (ImageButton) v.findViewById(R.id.outlet_details_fragment_greasePay_button_womenDecrement);
        mNumberMen = (TextView) v.findViewById(R.id.outlet_details_fragment_greasePay_no_of_men);
        mNumberWomen = (TextView) v.findViewById(R.id.outlet_details_fragment_greasePay_no_of_women);
        AppSharedPreference.setAuthToken("585d520a59a67", getContext());


        mCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {/*
                DatePickerDialog dialog = new DatePickerDialog(getActivity().getBaseContext());
                dialog.setTitle("Select Date");
                dialog.show();
                dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    }
                });*/
            }
        });
        incrementMen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int no = Integer.parseInt(mNumberMen.getText().toString()) + 1;
                mNumberMen.setText(no+"");
                totalwomenPrice=Integer.parseInt(restaurantData.getMalePersonPerFees())*no;
                mLabelPricingMen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees())*no));
                mLabelPricingTotal.setText(calculateTotalPrice());
            }
        });
        incrementWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(mNumberWomen.getText().toString()) + 1;
                mNumberWomen.setText(no+"");
                totalwomenPrice=Integer.parseInt(restaurantData.getFemalePersonPerFees())*no;
                mLabelPricingWomen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees())*no));
                mLabelPricingTotal.setText(calculateTotalPrice());
            }
        });
        decrementMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mNumberMen.getText().toString().equals("0")){
                    int no = Integer.parseInt(mNumberMen.getText().toString()) - 1;
                    mNumberMen.setText(no+"");
                    totalwomenPrice=Integer.parseInt(restaurantData.getMalePersonPerFees())*no;
                    mLabelPricingMen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees())*no));
                    mLabelPricingTotal.setText(calculateTotalPrice());
                }
            }
        });
        decrementWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mNumberWomen.getText().toString().equals("0")){
                    int no = Integer.parseInt(mNumberWomen.getText().toString()) - 1;
                    mNumberWomen.setText(no+"");
                    totalwomenPrice=Integer.parseInt(restaurantData.getFemalePersonPerFees())*no;
                    mLabelPricingWomen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees())*no));
                    mLabelPricingTotal.setText(calculateTotalPrice());
                }
            }
        });
        mPromoCode = (EditText) v.findViewById(R.id.outlet_details_fragment_greasepay_edit_promo);

        mLabelPricingMen = (TextView) v.findViewById(R.id.outlet_details_fragment_greasepay_label_pricingMen);
        mLabelPricingWomen = (TextView) v.findViewById(R.id.outlet_details_fragment_greasepay_label_pricingWomen);
        mLabelPricingPromo = (TextView) v.findViewById(R.id.outlet_details_fragment_greasepay_label_promoDiscount);
        mLabelPricingTax = (TextView) v.findViewById(R.id.outlet_details_fragment_greasepay_label_taxesFees);
        mLabelPricingTotal = (TextView) v.findViewById(R.id.outlet_details_fragment_greasepay_label_totalPayment);
        mPayBtn = (Button) v.findViewById(R.id.outlet_details_fragment_greasePay_button_submit);
        mPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), CardDetailsActivity.class);
                startActivity(intent);
            }
        });
        mPromoCode.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    checkPromoCodePresenter.checkPromocodevalidation(getActivity(),new CheckPromoCodeRequest(restaurantData.getRestaurantId(),mPromoCode.getText().toString()));
                }
                return false;

            }
        });

        return v;
    }

    private void setDate(int i, int i1, int i2) {
        mLabelDate.setText(i + "/" + i1 + "/" + i2);
    }

    @Override
    public void onStart() {
        super.onStart();
        setValues(restaurantData);
    }

    private void setValues(RestaurantData restaurantData) {
        //todo set values
        SimpleDateFormat sdf = new SimpleDateFormat("E, MMM d");
      mLabelDate.setText(sdf.format(new Date()));
        mLabelPricingMen.setText(restaurantData.getMalePersonPerFees());
        mLabelPricingWomen.setText(restaurantData.getFemalePersonPerFees());
        mLabelPricingTax.setText(restaurantData.getTaxFees());
        if(restaurantData.getFemaleEntryFree()&&restaurantData.getMaleEntryFree()){
            mLabelPricingMale.setText(getString(R.string.entry_free));
            mLabelPricingFemale.setVisibility(View.GONE);
            mLabelPricingTotal.setText("0");
            idEntryFree=true;
        }else{
            if(restaurantData.getMaleEntryFree()){
                mLabelPricingMale.setText(getString(R.string.entry_free_men));
                mLabelPricingFemale.setText(String.valueOf(restaurantData.getFemaleEntryFree())+" "+"for female entry");
            }
            else if(restaurantData.getFemaleEntryFree()){
                mLabelPricingMale.setText(getString(R.string.entry_free_women));
                mLabelPricingMale.setText(String.valueOf(restaurantData.getMaleEntryFree())+" "+"for male entry");
            }
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            restaurantData = (RestaurantData) bundle.getSerializable(AppConstatnts.CLUB_DATA);

        }

    }

    @Override
    public void onPromocodeValidate(CheckPromoCodeData data) {
        AlertManager.showErrorDialog(getActivity(),"Promo-code Applied");
        mLabelPricingPromo.setText(data.getDiscount());


    }

    @Override
    public void onPromocodeValidateError(String message) {
        AlertManager.showErrorDialog(getActivity(),message);
        mLabelPricingPromo.setText(mLabelPricingPromo.getText()+" 0");

    }

    @Override
    public void onPromocodeValidateServerError() {

    }

    private String calculateTotalPrice(){

        String tax=mLabelPricingTax.getText().toString();
        tax=tax.replace("%","");
        return String.valueOf((totalmenPrice+totalwomenPrice)-Double.parseDouble(tax));
    }
}
