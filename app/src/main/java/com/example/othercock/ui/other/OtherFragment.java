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

import com.example.othercock.DTO.OrderMenu;
import com.example.othercock.DTO.PopulList;
import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.adapter.OtherAdapter;
import com.example.othercock.ui.store.StoreInfoFragment;

import java.util.ArrayList;


public class OtherFragment extends Fragment {
    LinearLayout layout;
    LinearLayout order_his;

    LinearLayout star_menu;
    LinearLayout around;

    RecyclerView recyclerView1; // 인기메뉴
    RecyclerView recyclerView2; // 신메뉴
    LinearLayoutManager linearLayoutManager1;
    LinearLayoutManager linearLayoutManager2;

    User user;

    boolean check = false;
    ArrayList<PopulList> populLists;
    ArrayList<OrderMenu> menuList;
    ArrayList<OrderMenu> newMenu = new ArrayList<>();
    ArrayList<OrderMenu> popilMenu = new ArrayList<>();

    ArrayList<PopuMenu> list1 = new ArrayList<>();
    ArrayList<PopuMenu> list2 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_othermain, container, false);
        order_his = (LinearLayout) root.findViewById(R.id.ordermain_list_orderhistory);
        layout = (LinearLayout) root.findViewById(R.id.linear_menu);
        star_menu = (LinearLayout) root.findViewById(R.id.star_menu);
        around = (LinearLayout) root.findViewById(R.id.map_menu);

        order_his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainActivity)getActivity()).testFragment();

                ((MainActivity) getActivity()).fragmentOrderHistory();

            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).fragmentOrderMeunFragment();
            }
        });
        star_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).FavoriteMenu();
            }
        });
        around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).fragmentChange(new StoreInfoFragment());
            }
        });
        user = ((MainActivity)getActivity()).settingUser(null);
        if( user !=null){
            populLists = ((MainActivity)getActivity()).settingPopul(null);
            menuList = ((MainActivity)getActivity()).settingMenu(null);
            getPopulList();
            getNewMenu();
        }

        recyclerView1 = (RecyclerView) root.findViewById(R.id.popuMenu); // 인기메뉴
        recyclerView2 = (RecyclerView) root.findViewById(R.id.newMenu); // 신메뉴
        linearLayoutManager1 = new GridLayoutManager(root.getContext(),1,GridLayoutManager.HORIZONTAL,false);
        linearLayoutManager2 = new GridLayoutManager(root.getContext(),1,GridLayoutManager.HORIZONTAL,false);

        for (int i = 0; i < popilMenu.size(); i++) {
            if(check == false)
                list1.add(new PopuMenu(popilMenu.get(i).getName(), popilMenu.get(i).getResource()));
        }

        recyclerView1.setLayoutManager(new LinearLayoutManager(root.getContext()));
        OtherAdapter adapter = new OtherAdapter(list1, root.getContext());
        recyclerView1.setAdapter(adapter);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setLayoutManager(linearLayoutManager1);

        for (int i = 0; i < newMenu.size(); i++) {
            if(check == false)
                list2.add(new PopuMenu(newMenu.get(i).getName(), newMenu.get(i).getResource()));
        }

        recyclerView2.setLayoutManager(new LinearLayoutManager(root.getContext()));
        adapter = new OtherAdapter(list2, root.getContext());
        recyclerView2.setAdapter(adapter);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setLayoutManager(linearLayoutManager2);

        check = true;
        return root;
    }
    private void getPopulList(){
        for(int i=0;i<populLists.size();i++){
            if(populLists.get(i).getPopul()==1){
                for(int j=0;j<menuList.size();j++){
                    if(menuList.get(j).getNumber()==populLists.get(i).getNumber()){
                        OrderMenu orderMenu = menuList.get(i);
                        popilMenu.add(orderMenu);
                    }
                }
            }
        }
        System.out.println("이거실행됨" + popilMenu);
    }
    private void getNewMenu(){
        for(int i=0;i<populLists.size();i++){
            if(populLists.get(i).getNewmenu()==1){
                for(int j=0;j<menuList.size();j++){
                    if(menuList.get(j).getNumber()==populLists.get(i).getNumber()){
                        newMenu.add(menuList.get(i));
                    }
                }
            }
        }
    }

}


