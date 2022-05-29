package com.example.othercock.ui.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.OrderMenu;
import com.example.othercock.items.Item;
import com.example.othercock.MainActivity;
import com.example.othercock.R;

import java.util.ArrayList;

public class FavoriteMenuAdapter extends RecyclerView.Adapter<FavoriteMenuAdapter.ViewHolder> {
    private OCL ocl = new OCL();
    private ArrayList<Item> itemList;
    private Context context;
    ViewHolder viewHolder;
    public FavoriteMenuAdapter(ArrayList<Item> itemList, Context context) {
        super();
        this.itemList = itemList;
        this.context = context;
    }

    public FavoriteMenuAdapter() {
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        this.viewHolder = viewHolder;
        viewHolder.tvTitle.setText(itemList.get(position).getTitle());
        viewHolder.tvPrice.setText(String.valueOf(itemList.get(position).getPrice()));
        viewHolder.ivIcon.setImageResource(itemList.get(position).getIconResourceId());
        viewHolder.favorite.setOnClickListener(ocl);
        viewHolder.itemView.setOnClickListener(ocl);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.fragment_favorite_menu_list, null);
        return new ViewHolder(itemView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvPrice;
        public ImageView ivIcon;
        public LinearLayout favorite;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            favorite = (LinearLayout) itemLayoutView.findViewById(R.id.favorite_Linear);
            tvTitle = (TextView) itemLayoutView.findViewById(R.id.favorite_menu_name);
            tvPrice = (TextView) itemLayoutView.findViewById(R.id.favorite_menu_price);
            ivIcon = (ImageView) itemLayoutView.findViewById(R.id.favorite_menu_img);
        }
    }
    class OCL implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view.getId() == viewHolder.favorite.getId()){
                ((MainActivity)context).OrderDitailmenu(viewHolder.tvTitle.getText().toString());
            }
        }
    }
}