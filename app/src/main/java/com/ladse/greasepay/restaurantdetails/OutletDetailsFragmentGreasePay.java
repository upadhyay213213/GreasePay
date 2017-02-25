package com.ladse.greasepay.restaurantdetails;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.booking.card_booking.BarBookingRequest;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.debitcard.CardDetailsActivity;
import com.ladse.greasepay.home.model.RestaurantData;
import com.ladse.greasepay.promocode.checkpromocode.controler.CheckPromoCodePresenter;
import com.ladse.greasepay.promocode.checkpromocode.controler.CheckPromoCodePresenterImpl;
import com.ladse.greasepay.promocode.checkpromocode.controler.CheckPromoCodeView;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeData;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutletDetailsFragmentGreasePay extends Fragment implements CheckPromoCodeView {
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
    private String mPromoDiscount = "";
    private Context context;
    private DatePickerDialog dialog;
    private String tax;
    public BarBookingRequest barBookingRequest;
    private String modifiedDate;

    public OutletDetailsFragmentGreasePay() {
        // Required empty public constructor
        checkPromoCodePresenter = new CheckPromoCodePresenterImpl(this);
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
        context = getContext();


        mCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new StartDatePicker();
                dialogFragment.show(getFragmentManager(), "start_date_picker");
            }
        });
        incrementMen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int no = Integer.parseInt(mNumberMen.getText().toString()) + 1;
                mNumberMen.setText(no + "");
                totalwomenPrice = Integer.parseInt(restaurantData.getMalePersonPerFees()) * no;
                mLabelPricingMen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees()) * no));
                mLabelPricingTotal.setText(calculateTotalPrice());
            }
        });
        incrementWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(mNumberWomen.getText().toString()) + 1;
                mNumberWomen.setText(no + "");
                totalwomenPrice = Integer.parseInt(restaurantData.getFemalePersonPerFees()) * no;
                mLabelPricingWomen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees()) * no));
                mLabelPricingTotal.setText(calculateTotalPrice());
            }
        });
        decrementMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mNumberMen.getText().toString().equals("0")) {
                    int no = Integer.parseInt(mNumberMen.getText().toString()) - 1;
                    mNumberMen.setText(no + "");
                    totalwomenPrice = Integer.parseInt(restaurantData.getMalePersonPerFees()) * no;
                    mLabelPricingMen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees()) * no));
                    mLabelPricingTotal.setText(calculateTotalPrice());
                }
            }
        });
        decrementWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mNumberWomen.getText().toString().equals("0")) {
                    int no = Integer.parseInt(mNumberWomen.getText().toString()) - 1;
                    mNumberWomen.setText(no + "");
                    totalwomenPrice = Integer.parseInt(restaurantData.getFemalePersonPerFees()) * no;
                    mLabelPricingWomen.setText(String.valueOf(Integer.parseInt(restaurantData.getFemalePersonPerFees()) * no));
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
                barBookingRequest = createBarBookingRequest();
                Intent intent = new Intent(getActivity(), CardDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(AppConstatnts.BAR_DATA, barBookingRequest);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mPromoCode.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    checkPromoCodePresenter.checkPromocodevalidation(getActivity(), new CheckPromoCodeRequest(restaurantData.getRestaurantId(), mPromoCode.getText().toString()));
                }
                return false;

            }
        });

        return v;
    }

    private void setDate(int i, int i1, int i2) {
        mLabelDate.setText(i + "/" + i1 + "/" + i2);
        if (dialog != null) {
            dialog.dismiss();
        }
       // barBookingRequest.setOrderDate(String.valueOf(modifiedDate));
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
        if (restaurantData.getFemaleEntryFree() && restaurantData.getMaleEntryFree()) {
            mLabelPricingMale.setText(getString(R.string.entry_free));
            mLabelPricingFemale.setVisibility(View.GONE);
            mLabelPricingTotal.setText("0");
            idEntryFree = true;
        } else {
            if (restaurantData.getMaleEntryFree()) {
                mLabelPricingMale.setText(getString(R.string.entry_free_men));
                mLabelPricingFemale.setText(String.valueOf(restaurantData.getFemaleEntryFree()) + " " + "for female entry");
            } else if (restaurantData.getFemaleEntryFree()) {
                mLabelPricingMale.setText(getString(R.string.entry_free_women));
                mLabelPricingMale.setText(String.valueOf(restaurantData.getMaleEntryFree()) + " " + "for male entry");
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
        AlertManager.showErrorDialog(getActivity(), "Promo-code Applied");
        mLabelPricingPromo.setText(data.getDiscount());
        mPromoDiscount = data.getDiscount();



    }

    @Override
    public void onPromocodeValidateError(String message) {
        AlertManager.showErrorDialog(getActivity(), message);
        mLabelPricingPromo.setText(mLabelPricingPromo.getText() + " 0");

    }

    @Override
    public void onPromocodeValidateServerError() {

    }

    private String calculateTotalPrice() {
        tax = mLabelPricingTax.getText().toString();
        tax = tax.replace("%", "");
        return String.valueOf((totalmenPrice + totalwomenPrice) - Double.parseDouble(tax));
    }

    Calendar c = Calendar.getInstance();
    int startYear = c.get(Calendar.YEAR);
    int startMonth = c.get(Calendar.MONTH);
    int startDay = c.get(Calendar.DAY_OF_MONTH);

    class StartDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            // Use the current date as the default date in the picker
            dialog = new DatePickerDialog(context, this, startYear, startMonth, startDay);
            dialog.getWindow().setBackgroundDrawableResource(R.color.colorEdittextBackground);
            return dialog;

        }

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            // Do something with the date chosen by the user
            startYear = year;
            startMonth = monthOfYear;
            startDay = dayOfMonth;
            Calendar myCalendar = Calendar.getInstance();
            myCalendar.set(year, monthOfYear, dayOfMonth);
            SimpleDateFormat outputFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            modifiedDate= outputFormat.format(myCalendar.getTime());

          //  modifiedDate= "2017-03-04 00:00:00";

            setDate(dayOfMonth, monthOfYear + 1, year);

        }

    }

    private  BarBookingRequest createBarBookingRequest(){

/*

        "stripe_token": "tok_19Zyx0GFeDGnC86FdfUiNsYY",
                "bar_id": "1",
                "male_person_per_fees": "50",
                "female_person_per_fees": "40",
                "order_date": "2017-01-03",
                "male_entry_free": "1",
                "female_entry_free": "0",
                "number_of_men": "2",
                "number_of_women": "2",
                "promo_code": "dics123",
                "price_for_men": "0",
                "price_for_women": "100",
                "promo_discount": "5",
                "tax_fees": "8.35",
                "total": "103.35",
                "advance_booking_fees": "20",
                "booking_type":"event", // booking_type should be “bar,event”
                "event_id":11// optional…. When order for event then add event_id


                 restaurantData.getRestaurantId(), "5", String.valueOf(modifiedDate), restaurantData.getMalePersonPerFees(),
                  restaurantData.getFemalePersonPerFees(),
                        mNumberWomen.getText().toString(), mNumberWomen.getText().toString(), tax, String.valueOf(totalmenPrice),
                        String.valueOf(totalwomenPrice), String.valueOf(mPromoDiscount),
                        mLabelPricingTax.getText().toString(), String.valueOf(mLabelPricingTotal.getText().toString()));
                String advanceBooking=restaurantData.getAdvanceBookingFees().replace("$"," ").trim();
*/

        BarBookingRequest barBookingRequest=new BarBookingRequest();
        barBookingRequest.setBarId(restaurantData.getRestaurantId());
        barBookingRequest.setMalePersonPerFees(restaurantData.getMalePersonPerFees());
        barBookingRequest.setFemalePersonPerFees(restaurantData.getFemalePersonPerFees());
        barBookingRequest.setOrderDate(modifiedDate);
        barBookingRequest.setMaleEntryFree(String.valueOf(restaurantData.getMaleEntryFree() == true ? 1: 0));
        barBookingRequest.setFemaleEntryFree(String.valueOf(restaurantData.getFemaleEntryFree() == true ? 1: 0));
        barBookingRequest.setNumberOfMen(mNumberWomen.getText().toString());
        barBookingRequest.setNumberOfWomen(mNumberWomen.getText().toString());
        barBookingRequest.setPromoCode(mPromoCode.getText().toString());
        barBookingRequest.setPriceForMen(mLabelPricingMen.getText().toString());
        barBookingRequest.setPriceForWomen(mLabelPricingWomen.getText().toString());
        barBookingRequest.setPromoDiscount(String.valueOf(mPromoDiscount.replace("%"," ").trim()));
        barBookingRequest.setTaxFees(mLabelPricingTax.getText().toString());
        barBookingRequest.setTotal(mLabelPricingTotal.getText().toString());
        String advanceBooking=restaurantData.getAdvanceBookingFees().replace("$"," ").trim();
        barBookingRequest.setAdvanceBookingFees(advanceBooking);
        barBookingRequest.setBookingType(restaurantData.getBarType());
        barBookingRequest.setEventId(0);//set if booking is for event
        return barBookingRequest;
    }

}
