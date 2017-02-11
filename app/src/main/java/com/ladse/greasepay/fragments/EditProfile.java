package com.ladse.greasepay.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.common.AppSharedPreference;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.profile.ProfileRequest;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfile extends Fragment {
    ImageButton mProfilePic;
    TextView mFirstName, mLastName, mNumber, mEmail;
    Button mSubmit;

    public EditProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        mProfilePic = (ImageButton) v.findViewById(R.id.fragment_edit_button_edit_pic);
        mFirstName = (TextView) v.findViewById(R.id.fragment_edit_profile_edit_firstName);
        mLastName = (TextView) v.findViewById(R.id.fragment_edit_profile_edit_lastName);
        mNumber = (TextView) v.findViewById(R.id.fragment_edit_profile_edit_number);
        mEmail = (TextView) v.findViewById(R.id.fragment_edit_profile_edit_email);
        mSubmit = (Button) v.findViewById(R.id.fragment_edit_profile_button_submit);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileRequest request = new ProfileRequest();
                request.setFirstName(mFirstName.getEditableText().toString());
                request.setLastName(mLastName.getEditableText().toString());
                request.setEmail(mEmail.getEditableText().toString());
                request.setPhoneNumber(mNumber.getEditableText().toString());
                editProfile(AppSharedPreference.getAuthToken(getActivity()), request);
            }
        });
        return v;
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void editProfile(String authToken, ProfileRequest profileRequest) {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<Model> si = retrofitInterface.editProfile(authToken,profileRequest);
        si.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                AlertManager.showErrorDialog(getActivity(), response.message());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

}
