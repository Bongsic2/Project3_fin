package com.example.othercock.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.Manager;
import com.example.othercock.MainActivity;
import com.example.othercock.R;

import java.util.ArrayList;

public class StoreSelectAdapter extends RecyclerView.Adapter<StoreSelectAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView storename;
        public TextView storeaddr;
        public ImageView storepic;
        public Button detail;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            storename = (TextView) itemLayoutView.findViewById(R.id.storeinfo_name);
            storeaddr = (TextView) itemLayoutView.findViewById(R.id.storeinfo_addr);
            storepic = (ImageView) itemLayoutView.findViewById(R.id.storeinfo_pic);
            detail = (Button) itemLayoutView.findViewById(R.id.storeinfo_detail);
        }

    }
    private ArrayList<Manager> itemList;
    Context context;

    public StoreSelectAdapter(Context context, ArrayList<Manager> itemList) {
        super();
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.storename.setText(itemList.get(position).getMarket());
        viewHolder.storeaddr.setText(itemList.get(position).getAdress());
        int pos=position;
        viewHolder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), service_Socket.class);
//                intent.putExtra("pw", Protocol.STORESELECT + "|" + itemList.get(pos).getMarket());
//                context.getApplicationContext().startService(intent);
                System.out.println("카트로");
                ((MainActivity)context).fragmentCart();

            }

        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.fragment_storeselect_list, null);

        return new ViewHolder(itemView);
    }

    // 스토어 검색관련
    public void setItems(ArrayList<Manager> list){
        itemList=list;
        notifyDataSetChanged();
    }

}
