package com.example.othercock.ui.store;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.Manager;
import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.adapter.StoreInfoAdapter;
import com.example.othercock.adapter.StoreSelectAdapter;

import java.util.ArrayList;

public class StoreSelectFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    EditText editText;
    ArrayList<Manager> search_list = new ArrayList<>();
    User user;
    ArrayList<Manager> marketList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_storeselect,container,false);

        user = ((MainActivity)getActivity()).settingUser(null);
        if(user != null){
            marketList = ((MainActivity)getActivity()).settingMarket(null);
        }

        ArrayList<Manager> list = new ArrayList<Manager>();
        for (int i = 0; i <= marketList.size()-1; i++) {
            list.add(new Manager(marketList.get(i).getMarket(), marketList.get(i).getAdress(), marketList.get(i).getImageResource()));
        }


        recyclerView = (RecyclerView) root.findViewById(R.id.storeselect_recycle);
        linearLayoutManager = new GridLayoutManager(root.getContext(),1,GridLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        StoreSelectAdapter adapter = new StoreSelectAdapter(root.getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);

         editText = (EditText) root.findViewById(R.id.storeselect_search);
         //editText 리스터 작성
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = editText.getText().toString();
                search_list.clear();

                if(searchText.equals("")){
                    adapter.setItems(list);
                }
                else {
                    // 검색 단어를 포함하는지 확인
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getMarket().toLowerCase().contains(searchText.toLowerCase())) {
                            search_list.add(list.get(i));
                        }
                        //데이터베이스 받아오면 확인해봐야할듯!!!
                        adapter.setItems(search_list);
                    }
                }
            }
        });

        return root;
    }


}