package com.example.othercock.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.R;
import com.example.othercock.items.StampItem;

import java.util.ArrayList;

public class StampAdapter extends RecyclerView.Adapter<StampAdapter.ViewHolder> {

    private ArrayList<StampItem> stampInfo;

    public StampAdapter(ArrayList<StampItem> stampInfo) {
        super();
        this.stampInfo = stampInfo;
    }

    public StampAdapter() {
    }

    @Override
    public int getItemCount() {
        return stampInfo.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.stamp_date.setText(stampInfo.get(position).getDate());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.fragment_show_stamp_list, null);
        return new ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView stamp_date;
    //    public TextView maketName;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            stamp_date = (TextView) itemLayoutView.findViewById(R.id.stamp_date);

        }
    }
}
