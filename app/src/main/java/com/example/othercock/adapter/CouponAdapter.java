package com.example.othercock.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.CouponDto;
import com.example.othercock.R;

import java.util.ArrayList;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.ViewHolder> {

    private ArrayList<CouponDto> couponList;

    public CouponAdapter(ArrayList<CouponDto> couponList) {
        super();
        this.couponList = couponList;
    }

    public CouponAdapter() {
    }

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.coupon_date.setText(couponList.get(position).getCoupon_date());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.shaved_ice_coupon, null);
        return new ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView coupon_date;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            coupon_date = (TextView) itemLayoutView.findViewById(R.id.coupon_date);

        }
    }
}
