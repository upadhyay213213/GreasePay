package com.ladse.greasepay.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ladse.greasepay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendFeedbackFragment extends Fragment {
    private EditText mFeedback;
    private Button mSubmit;

    public SendFeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_send_feedback, container, false);
        mFeedback = (EditText) v.findViewById(R.id.fragment_feedback_edit_feedback);
        mSubmit = (Button) v.findViewById(R.id.fragment_feedback_button_submit);
        return v;
    }

}
