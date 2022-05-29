package com.example.othercock.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.othercock.DTO.OrderMenu;
import com.example.othercock.MainActivity;
import com.example.othercock.R;

public class Detail_MenuFragment extends Fragment {
    TextView name;
    TextView kcal;
    TextView allergy;
    ImageView img;

    OrderMenu menu;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_detail_menu,container,false); // 상세메뉴 켜기. (detail_menu.xml)실행

        menu = new OrderMenu();
        menu = ((MainActivity)getActivity()).getThisMenu();

        System.out.println("메뉴" +menu);

        img = (ImageView) root.findViewById(R.id.menu_img);
        img.setImageResource(menu.getResource());
        name = (TextView) root.findViewById(R.id.menu_name);
        name.setText(menu.getName());
        kcal = (TextView) root.findViewById(R.id.nutrition_info_detail);
        kcal.setText(String.valueOf(menu.getKcal())+"kcal");
        allergy = (TextView) root.findViewById(R.id.allergy_info_detail);
        allergy.setText(menu.getAllregy());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
