package com.ladse.greasepay.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Shrivats on 1/25/2017.
 */

public class OutletListTouchListener implements RecyclerView.OnItemTouchListener {
    private OnOutletTouchListener mListener;
    private GestureDetector gD;

    public OutletListTouchListener(Context context, OnOutletTouchListener mListener) {
        this.mListener = mListener;
        gD = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && gD.onTouchEvent(e)) {
            mListener.onItemClick(childView, rv.getChildAdapterPosition(childView));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface OnOutletTouchListener {
        void onItemClick(View v, int position);
    }
}
