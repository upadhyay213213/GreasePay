package com.ladse.greasepay.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ladse.greasepay.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Shrivats on 2/8/2017.
 */

public class FAQAdapter extends BaseExpandableListAdapter{

    private Context context;
    private List<String> faqQuestions;
    private HashMap<String, String> list_data_Child;

    public FAQAdapter(Context context, List<String> faqQuestions, HashMap<String, String>
            list_data_Child) {
        this.context = context;
        this.faqQuestions = faqQuestions;
        this.list_data_Child = list_data_Child;
    }

    @Override
    public int getGroupCount() {
        return this.faqQuestions.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return faqQuestions.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.list_data_Child.get(faqQuestions.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String mQuestions = (String) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context
                    .LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_heading, null);
        }
        TextView txtHeader = (TextView) convertView.findViewById(R.id.faq_heading);
        txtHeader.setText(mQuestions);
        ImageView sign = (ImageView) convertView.findViewById(R.id.faq_symbol);
        if(isExpanded){
            sign.setImageResource(R.drawable.minus);
        }
        else{
            sign.setImageResource(R.drawable.plus);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context
                    .LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_list_item, null);
        }
        TextView txtAnswers = (TextView) convertView.findViewById(R.id.faq_content);
        txtAnswers.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
