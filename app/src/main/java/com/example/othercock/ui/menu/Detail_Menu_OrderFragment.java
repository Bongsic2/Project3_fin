package com.example.othercock.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.othercock.DTO.OrderMenu;
import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.helloar.HelloArActivity;

public class Detail_Menu_OrderFragment extends Fragment {
    Button order, cart, ar;
    OCL click = new OCL();
    TextView name;
    TextView kcal;
    TextView allergy;
    ImageView img;
    ImageView star;
    User user = new User();
    OrderMenu menu = new OrderMenu();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_detail_menu_order,container,false); // 상세메뉴 켜기. (detail_menu.xml)실행
        user = ((MainActivity)getActivity()).settingUser(null);
        menu = ((MainActivity)getActivity()).getThisMenu();
        System.out.println("왓썹");

        //아이디가필요해 TextView ㅇㅇ

        cart = (Button) root.findViewById(R.id.detail_cartBtn);
        order = (Button) root.findViewById(R.id.detail_orderBtn);
        ar = (Button) root.findViewById(R.id.datail_ar_btn);
        star = (ImageView) root.findViewById(R.id.datail_stars);

        cart.setOnClickListener(click);
        order.setOnClickListener(click);
        star.setOnClickListener(click);
        ar.setOnClickListener(click);

        System.out.println("메뉴"+menu);

        img = (ImageView) root.findViewById(R.id.detail_order_img);

        img.setImageResource(menu.getResource());


        name = (TextView) root.findViewById(R.id.detail_order_name);
        name.setText(menu.getName());
        kcal = (TextView) root.findViewById(R.id.detail_order_nutrition_info_detail);
        kcal.setText(String.valueOf(menu.getKcal())+"kcal");
        allergy = (TextView) root.findViewById(R.id.detail_order_allergy_info_detail);
        allergy.setText(menu.getAllregy());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    class OCL implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.detail_cartBtn){

                ((MainActivity)getActivity()).AddCart(menu);
                    Toast myToast = Toast.makeText(getContext(),"추가 완료", Toast.LENGTH_SHORT);
                    myToast.show();

            } else if(view.getId()==R.id.detail_orderBtn){
                System.out.println("이건오더");
                ((MainActivity)getActivity()).fragmentStoreSelect();
            } else if(view.getId()==R.id.datail_ar_btn){
                Intent intent = new Intent(getContext(), HelloArActivity.class);
                ((MainActivity)getContext()).startActivity(intent);

            } else if(view.getId()==R.id.datail_stars){
                String test= user.getStar() + menu.getNumber() +"/";
                user.setStar(test);
                user = ((MainActivity)getActivity()).settingUser(user);
            }
        }
    }
}

