package com.example.othercock.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.ui.other.PopuMenu;

import java.util.ArrayList;

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.ViewHolder> {

    private ArrayList<PopuMenu> popuMenuList;

    private Context context;
    public OtherAdapter(ArrayList<PopuMenu> popuMenuList, Context context){
        super();
        this.popuMenuList = popuMenuList;
        this.context = context;
    }

    public OtherAdapter(){

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View popuMenuView = View.inflate(parent.getContext(), R.layout.fragment_menu_list, null);
        return new ViewHolder(popuMenuView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {

        holder.tvTitle.setText(popuMenuList.get(position).getTitle());
        holder.ivIcon.setImageResource(popuMenuList.get(position).getIconResourceId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).OrderDitailmenu(holder.tvTitle.getText().toString() );
            }
        });
    }

    @Override
    public int getItemCount() {
        return popuMenuList.size();
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
