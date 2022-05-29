package com.example.othercock.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.OrderMenu;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.items.Item;
import com.example.othercock.ui.cart.CartFragment;

import java.util.ArrayList;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.ViewHolder> {

    private ArrayList<OrderMenu> itemList;
    private Context context;
    public cartAdapter(ArrayList<OrderMenu> itemList, Context context) {
        super();
        this.itemList = itemList;
        this.context = context;
    }

    public cartAdapter() {
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.tvTitle.setText(itemList.get(position).getName());
        viewHolder.ivIcon.setImageResource(itemList.get(position).getResource());
        viewHolder.price.setText( String.valueOf(itemList.get(position).getPrice()));
        viewHolder.delete_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(itemList.size() > 0){
                    itemList.remove(itemList.get(position));
                    notifyItemRemoved(position);
                }
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.cart_row, null);
        return new ViewHolder(itemView);
    }





    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public ImageView ivIcon;
        public TextView price;
        public ImageButton delete_but;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvTitle = (TextView) itemLayoutView.findViewById(R.id.productNameTextView);
            ivIcon = (ImageView) itemLayoutView.findViewById(R.id.productImageView);
            price = (TextView) itemLayoutView.findViewById(R.id.productTotalPriceTextView);
            delete_but = (ImageButton) itemLayoutView.findViewById(R.id.deleteProductButton);
        }
    }
}