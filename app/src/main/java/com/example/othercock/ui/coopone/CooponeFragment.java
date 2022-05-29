package com.example.othercock.ui.coopone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.databinding.FragmentSlideshowBinding;

public class CooponeFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    TextView useBtn;
    FragmentManager fm;
    FragmentTransaction tran;
    CouponFrag frag;

    User user;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_coopone, container, false);

        useBtn = root.findViewById(R.id.useBtn);

        frag = new CouponFrag();

        setFrag(0);// 프래그먼트 교체


        user = ((MainActivity) getActivity()).settingUser(null);
        if (user != null) {
            user = ((MainActivity) getActivity()).settingUser(null);
        }


        Button.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.useBtn:
                        setFrag(0);
                        //  ((MainActivity) getActivity()).fragmentCouponFrag1();
                        break;

                }
            }
        };
        useBtn.setOnClickListener(onClickListener);


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setFrag(int num) {    //프래그먼트를 교체하는 작업을 하는 메소드를 만들었습니다
        fm = getChildFragmentManager();
        tran = fm.beginTransaction();
        switch (num) {
            case 0:
                tran.replace(R.id.cooponeFrag, frag);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();

                break;

        }
    }
}