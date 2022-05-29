package com.example.othercock.ui.other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.R;
import com.example.othercock.adapter.OnorderAdapter;
import com.example.othercock.items.OnOrderItem;

import java.util.ArrayList;


public class OrderHistoryFragment extends Fragment {
    LinearLayout layout;
    LinearLayout order_his;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    int[] items = { R.drawable.a1 ,R.drawable.a2, R.drawable.a3,R.drawable.a4,R.drawable.a5};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_order_history,container,false);

        recyclerView = (RecyclerView) root.findViewById(R.id.history_recycle);
        linearLayoutManager = new GridLayoutManager(root.getContext(),1,GridLayoutManager.VERTICAL,false);

        ArrayList<OnOrderItem> list = new ArrayList<OnOrderItem>();
        for (int i = 0; i <= 4; i++) {
            //list.add(new Item("설빙 메뉴 " + i, R.drawable.ic_launcher_foreground));
            list.add(new OnOrderItem( items[i], "이건메뉴이름", "2020.11.4 (화)"));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        OnorderAdapter adapter = new OnorderAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);

        return root;
    }
}
