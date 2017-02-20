package com.ladse.greasepay.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.ladse.greasepay.R;
import com.ladse.greasepay.common.AlertManager;
import com.ladse.greasepay.faq.FAQData;
import com.ladse.greasepay.faq.FAQResponse;
import com.ladse.greasepay.utils.FAQAdapter;
import com.ladse.greasepay.webclient_retro.ServerCall;
import com.ladse.greasepay.webclient_retro.ServiceGenerator;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAQFragment extends Fragment {

    private ExpandableListView faqList;
    private FAQAdapter adapter;
    private List<String> mFaqQuestions;
    private List<String> mAnswers;
    private HashMap<String, String> listDataChild;
    private Context context;
    private ArrayList<FAQData> faqData;
    public FAQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_faq, container, false);
        faqList = (ExpandableListView) v.findViewById(R.id.faq_list_View);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        getFAQ();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void getFAQ() {
        ServerCall retrofitInterface = ServiceGenerator.getRestWebService();
        Call<FAQResponse> si = retrofitInterface.getFAQ();
        si.enqueue(new Callback<FAQResponse>() {
            @Override
            public void onResponse(Call<FAQResponse> call, Response<FAQResponse> response) {
                FAQResponse response1 = response.body();
                faqData = response1.getData();
                if(faqData.size()>0){
                    faqData = response1.getData();
                    prepareFaqList(faqData);
                }
                else{
                    AlertManager.showErrorDialog(context, "No FAQ.");
                }
            }

            @Override
            public void onFailure(Call<FAQResponse> call, Throwable t) {
                    AlertManager.showErrorDialog(context, "Network not reachable");
            }
        });

    }

    private void prepareFaqList(ArrayList<FAQData> dataList){
        mFaqQuestions = new ArrayList<>();
        listDataChild = new HashMap<>();
        int i = 0;
        while(i<dataList.size()){
          mFaqQuestions.add(dataList.get(i).getQuestion());
            listDataChild.put(dataList.get(i).getQuestion(), dataList.get(i).getAnswer());
            i++;
        }
        adapter = new FAQAdapter(getActivity(), mFaqQuestions, listDataChild);
        faqList.setAdapter(adapter);
        faqList.animate();
    }
    public void setContext(Context context){
        this.context = context;
    }

}
