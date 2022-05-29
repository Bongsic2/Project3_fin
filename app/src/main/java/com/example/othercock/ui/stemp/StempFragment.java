package com.example.othercock.ui.stemp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.othercock.R;

public class StempFragment extends Fragment {

    FragmentManager fm;
    FragmentTransaction tran;
    StampFragment stampFrag;
    StampHistory stampFrag2;
    //  ImageView backImage;
    TextView stampCardBText, showCardText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // View root = inflater.inflate(R.layout.fragment_stemp,container,false);
        View root = inflater.inflate(R.layout.fragment_stemp, container, false);


        stampCardBText = root.findViewById(R.id.stampCardBText);
        showCardText = root.findViewById(R.id.showCardText);


        stampFrag = new StampFragment();
        stampFrag2 = new StampHistory();
        setFrag(0);// 프래그먼트 교체


        TextView.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.stampCardBText:
                        setFrag(0);
                        Toast.makeText(getContext(), "프래그1", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.showCardText:
                        setFrag(1);
                        Toast.makeText(getContext(), "프래그2", Toast.LENGTH_LONG).show();

                        break;

                }
            }
        };
        stampCardBText.setOnClickListener(onClickListener);
        showCardText.setOnClickListener(onClickListener);


        return root;
    }


    public void setFrag(int num) {    //프래그먼트를 교체하는 작업을 하는 메소드를 만들었습니다
        // fm = getFragmentManager();
        fm = getChildFragmentManager();
        // tran = fm.beginTransaction();
        tran = fm.beginTransaction();
        switch (num) {
            case 0:
                tran.replace(R.id.stampFrag, stampFrag);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.stampFrag, stampFrag2);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
