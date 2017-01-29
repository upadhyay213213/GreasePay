package com.ladse.greasepay.OutletDetails;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutletDetailsFragmentGreasePay extends Fragment {
    private TextView mLabelPricing;
    private TextView mLabelDate;
    private TextView mLabelPricingMen;
    private TextView mLabelPricingWomen;
    private TextView mLabelPricingPromo;
    private TextView mLabelPricingTax;
    private TextView mLabelPricingTotal;
    private EditText mPromoCode, mNoOfMen, mNoOfWomen;
    private Button mPayBtn;
    private ImageView mCalender;

    public OutletDetailsFragmentGreasePay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.outlet_details_tab_greasepay, container, false);
        mLabelPricing = (TextView) v.findViewById(R.id.outlet_details_fragment_greasePay_pricing);
        mLabelDate = (TextView) v.findViewById(R.id.outlet_details_fragment_greasePay_date);
        mCalender = (ImageView) v.findViewById(R.id.outlet_details_fragment_greasePay_icon_calendar);

        mNoOfMen = (EditText) v.findViewById(R.id.outlet_details_fragment_greasePay_no_of_men);
        mNoOfWomen = (EditText) v.findViewById(R.id.outlet_details_fragment_greasePay_no_of_women);
        mNoOfMen.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //todo update no of men in below payment details as soon as focus is lost
                }
            }
        });
        mNoOfWomen.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //todo update no of women in below payment details as soon as focus is lost
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
                //todo payment submit process
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        setValues();
    }

    private void setValues() {
        //todo set values
        SimpleDateFormat sdf = new SimpleDateFormat("E, MMM d");
        mLabelDate.setText(sdf.format(new Date()));
    }
}
