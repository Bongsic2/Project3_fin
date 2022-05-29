package com.example.othercock.ui.coopone;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.CouponDto;
import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.adapter.CouponAdapter;

import java.util.ArrayList;


public class CouponFrag extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.couponfragment, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.CouponRecycle);
        linearLayoutManager = new GridLayoutManager(root.getContext(), 1, GridLayoutManager.VERTICAL, false);


        user = ((MainActivity) getActivity()).settingUser(null);
        if (user != null) {
            user = ((MainActivity) getActivity()).settingUser(null);
        }

        ArrayList<CouponDto> couponList = new ArrayList<CouponDto>();
        for (int i = 0; i <= user.getCoupon(); i++) {
            //list.add(new Item("설빙 메뉴 " + i, R.drawable.ic_launcher_foreground));
            couponList.add(new CouponDto("몇일 남음!"));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        CouponAdapter adapter = new CouponAdapter(couponList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);

        return root;
    }
}
