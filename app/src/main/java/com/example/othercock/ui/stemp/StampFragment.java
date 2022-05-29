package com.example.othercock.ui.stemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.adapter.Barcode;
import com.example.othercock.adapter.OnorderAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class StampFragment extends Fragment {
    View view;

    int imgIndex = 0;
    int img[] = {R.id.iceStamp1, R.id.iceStamp2, R.id.iceStamp3, R.id.iceStamp4,
            R.id.iceStamp5, R.id.iceStamp6, R.id.iceStamp7, R.id.iceStamp8, R.id.iceStamp9,
            R.id.iceStamp10};

    ArrayList<User> info;

    Button addStampBtn;
    Button couponChangBtn;
    int CouMax = 10;
    User user;

    ImageView img2[] = new ImageView[10];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.stampfragment, container, false);
        //   exOrderBtn = (Button) view.findViewById(R.id.exOrderBtn);
        addStampBtn = (Button) view.findViewById(R.id.addStampBtn);
        couponChangBtn = (Button) view.findViewById(R.id.couponChangBtn);

        user = ((MainActivity) getActivity()).settingUser(null);
        if (user != null) {
            user = ((MainActivity) getActivity()).settingUser(null);
        }

        System.out.println(user.getStamp());
        for (int i = 0; i < user.getStamp(); i++) {
            img2[i] = (ImageView) view.findViewById(img[i]);
            img2[i].setImageResource(R.drawable.stampcheck);
        }
        couponNumber(user.getStamp());

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.addStampBtn:
                        Intent intent = new Intent(getContext(), Barcode.class);
                        startActivity(intent);
                        break;
                    case R.id.couponChangBtn:
                        ((MainActivity) getActivity()).fragmentCoopne();
                        break;
                }
            }
        };

        addStampBtn.setOnClickListener(onClick);
        couponChangBtn.setOnClickListener(onClick);


        return view;
    }


    void couponNumber(int stamp) {
        int couNum = user.getCoupon();
        if (stamp == 10) {
            user.setCoupon(couNum + 1);
            user.setStamp(0);
        }
    }


//        } else if (user.getStamp() == 10) {
//            recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
//            OnorderAdapter adapter = new OnorderAdapter(list);
//            recyclerView.setAdapter(adapter);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.setLayoutManager(linearLayoutManager);
//        }
//        if (user.getStamp() != null) {
//            img2[user.getStamp()].setImageResource(R.drawable.stampcheck);
//            imgIndex++;
//        } else if (imgIndex == 9) {
//
//        } else {
//            imgIndex = 0;
//        }

}



