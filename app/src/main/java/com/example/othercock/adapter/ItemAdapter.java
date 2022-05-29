package com.example.othercock.adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.items.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Item> itemList;
    private Context context;
    public ItemAdapter(ArrayList<Item> itemList, Context context) {
        super();
        this.itemList = itemList;
        this.context = context;
    }

    public ItemAdapter() {
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.tvTitle.setText(itemList.get(position).getTitle());
        viewHolder.ivIcon.setImageResource(itemList.get(position).getIconResourceId());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).Ditailmenu(viewHolder.tvTitle.getText().toString() );
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.fragment_menu_list, null);
        return new ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public ImageView ivIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            ivIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }
}