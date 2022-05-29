package com.example.othercock.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

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
import com.example.othercock.R;

import java.util.ArrayList;

public class FavoriteMenuFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<OrderMenu> favoriteList = new ArrayList<OrderMenu>();
    User user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorite_menu,container,false);

        user = ((MainActivity)getActivity()).settingUser(null);
        System.out.println(user);

        favoriteList = ((MainActivity)getActivity()).settingFavorite();
        recyclerView = (RecyclerView) root.findViewById(R.id.favoriteMenuRecy);
        linearLayoutManager = new LinearLayoutManager(root.getContext(), RecyclerView.VERTICAL, false);

        ArrayList<Item> list = new ArrayList<Item>();
        if(favoriteList != null){
            for (int i = 0; i < favoriteList.size(); i++) {
                list.add(new Item(favoriteList.get(i).getName(), getImage(favoriteList.get(i).getNumber()), favoriteList.get(i).getPrice()+"원"));
            }
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        FavoriteMenuAdapter adapter = new FavoriteMenuAdapter(list, root.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public int getImage(int number){
        int section = number/1000;
        int tail    = number%1000;
        return  ImageResource.IMAGE_RESOURCE[section-1][tail-1];
    }

}