package com.example.othercock.ui.menu;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.othercock.DTO.OrderMenu;
import com.example.othercock.DTO.User;
import com.example.othercock.ImageResource;
import com.example.othercock.MainActivity;
import com.example.othercock.items.Item;
import com.example.othercock.adapter.ItemAdapter;


import com.example.othercock.R;
import com.example.othercock.ui.other.PopuMenu;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    User user;
    ArrayList<OrderMenu> menuList;
    ArrayList<OrderMenu> menuArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu,container,false);
        user = ((MainActivity)getActivity()).settingUser(null);
        if( user !=null){
            menuArrayList = ((MainActivity)getActivity()).settingMenu(null);
        }
        System.out.println("메뉴어레이리스트");
        System.out.println(menuArrayList);
        System.out.println("메뉴어레이리스트");
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        linearLayoutManager = new GridLayoutManager(container.getContext(),2,GridLayoutManager.VERTICAL,false);

        ArrayList<Item> list = new ArrayList<Item>();
        for (int i = 0; i < menuArrayList.size(); i++) {
            list.add(new Item(menuArrayList.get(i).getName(), getImage(menuArrayList.get(i).getNumber())));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        ItemAdapter adapter = new ItemAdapter(list, root.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);

        Button fullmenubtn = (Button)root.findViewById(R.id.fullmenubtn);
        Button bingsubtn = (Button)root.findViewById(R.id.bingsubtn);
        Button dessertbtn = (Button)root.findViewById(R.id.dessertbtn);
        Button coffeebtn = (Button)root.findViewById(R.id.coffeebtn);
        Button Fruitbtn = (Button)root.findViewById(R.id.Fruitbtn);
        Button aidbtn = (Button)root.findViewById(R.id.aidbtn);

        fullmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Item> list = new ArrayList<Item>();
                for (int i = 0; i < menuArrayList.size(); i++) {
                    list.add(new Item(menuArrayList.get(i).getName(), getImage(menuArrayList.get(i).getNumber())));
                    recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
                    recyclerView.setAdapter(adapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setLayoutManager(linearLayoutManager);
                }
            }
        });

        bingsubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Item> list = new ArrayList<Item>();
                for (int i = 0; i < menuArrayList.size(); i++) {
                    if(menuArrayList.get(i).getIndex().contains("빙수")) {
                        list.add(new Item(menuArrayList.get(i).getName(), getImage(menuArrayList.get(i).getNumber())));
                        ItemAdapter adapter = new ItemAdapter(list, root.getContext());
                        RecyclerView recyclerView2 = (RecyclerView) root.findViewById(R.id.recyclerView);
                        recyclerView2.setAdapter(adapter);
                        recyclerView2.setItemAnimator(new DefaultItemAnimator());
                        recyclerView2.setLayoutManager(linearLayoutManager);

                    }
                }
            }
        });

        dessertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Item> list = new ArrayList<Item>();
                for (int i = 0; i < menuArrayList.size(); i++) {
                    if(menuArrayList.get(i).getIndex().contains("디저트")) {
                        list.add(new Item(menuArrayList.get(i).getName(), getImage(menuArrayList.get(i).getNumber())));
                        ItemAdapter adapter = new ItemAdapter(list, root.getContext());
                        RecyclerView recyclerView3 = (RecyclerView) root.findViewById(R.id.recyclerView);
                        recyclerView3.setAdapter(adapter);
                        recyclerView3.setItemAnimator(new DefaultItemAnimator());
                        recyclerView3.setLayoutManager(linearLayoutManager);

                    }
                }
            }
        });

        coffeebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Item> list = new ArrayList<Item>();
                for (int i = 0; i < menuArrayList.size(); i++) {
                    if(menuArrayList.get(i).getIndex().contains("커피")) {
                        list.add(new Item(menuArrayList.get(i).getName(), getImage(menuArrayList.get(i).getNumber())));
                        ItemAdapter adapter = new ItemAdapter(list, root.getContext());
                        RecyclerView recyclerView4 = (RecyclerView) root.findViewById(R.id.recyclerView);
                        recyclerView4.setAdapter(adapter);
                        recyclerView4.setItemAnimator(new DefaultItemAnimator());
                        recyclerView4.setLayoutManager(linearLayoutManager);

                    }
                }
            }
        });

        Fruitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Item> list = new ArrayList<Item>();
                for (int i = 0; i < menuArrayList.size(); i++) {
                    if(menuArrayList.get(i).getIndex().contains("열매한잔")) {
                        list.add(new Item(menuArrayList.get(i).getName(), getImage(menuArrayList.get(i).getNumber())));
                        ItemAdapter adapter = new ItemAdapter(list, root.getContext());
                        RecyclerView recyclerView5 = (RecyclerView) root.findViewById(R.id.recyclerView);
                        recyclerView5.setAdapter(adapter);
                        recyclerView5.setItemAnimator(new DefaultItemAnimator());
                        recyclerView5.setLayoutManager(linearLayoutManager);

                    }
                }
            }
        });

        aidbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Item> list = new ArrayList<Item>();
                for (int i = 0; i < menuArrayList.size(); i++) {
                    if(menuArrayList.get(i).getIndex().contains("스무디")) {
                        list.add(new Item(menuArrayList.get(i).getName(), getImage(menuArrayList.get(i).getNumber())));
                        ItemAdapter adapter = new ItemAdapter(list, root.getContext());
                        RecyclerView recyclerView6 = (RecyclerView) root.findViewById(R.id.recyclerView);
                        recyclerView6.setAdapter(adapter);
                        recyclerView6.setItemAnimator(new DefaultItemAnimator());
                        recyclerView6.setLayoutManager(linearLayoutManager);

                    }
                }
            }
        });

        return root;

    }


    public int getImage(int number){
        int section = number/1000;
        int tail    = number%1000;
        System.out.println(ImageResource.IMAGE_RESOURCE[section-1][tail-1]);
        return  ImageResource.IMAGE_RESOURCE[section-1][tail-1];
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}