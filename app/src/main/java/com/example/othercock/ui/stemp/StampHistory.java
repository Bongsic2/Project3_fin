package com.example.othercock.ui.stemp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.StampDto;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.adapter.StampAdapter;
import com.example.othercock.items.StampItem;

import java.util.ArrayList;


public class StampHistory extends Fragment {
    View root;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<StampDto> stampList = new ArrayList<StampDto>();
    ArrayList<StampItem> list = new ArrayList<StampItem>();

    StampItem item = new StampItem();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.stampfragment2, container, false);

        System.out.println("test");

        recyclerView = (RecyclerView) root.findViewById(R.id.stamp_recycle);
        linearLayoutManager = new GridLayoutManager(root.getContext(), 1, GridLayoutManager.VERTICAL, false);

//        stampDto = ((MainActivity) getActivity()).settingStamp(null);
//        if (stampDto != null) {
//            stampDto = ((MainActivity) getActivity()).settingStamp(null);
//        }
        list = new ArrayList<StampItem>();
        stampList = ((MainActivity) getActivity()).settingStamp(null);
        if (stampList != null) {
            for (int i = 0; i < stampList.size(); i++) {
                System.out.println("몇번실행되냐");
                list.add( new StampItem(stampList.get(i).getDate()));
            }
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        StampAdapter adapter = new StampAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);

        return root;
    }

}
