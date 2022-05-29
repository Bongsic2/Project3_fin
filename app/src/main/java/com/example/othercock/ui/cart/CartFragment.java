package com.example.othercock.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.othercock.DTO.OrderMenu;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.example.othercock.Socket.Protocol;
import com.example.othercock.Socket.service_Socket;
import com.example.othercock.adapter.cartAdapter;

import java.util.ArrayList;


public class CartFragment extends Fragment {


    ArrayList<OrderMenu> menuList;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager1;
    TextView totalPrice;
    Button check;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        linearLayoutManager1 = new GridLayoutManager(root.getContext(), 1, GridLayoutManager.VERTICAL, false);
        totalPrice = (TextView)root.findViewById(R.id.orderTotalTextView);
        check = (Button)root.findViewById(R.id.placeOrderButton);

        recyclerView = (RecyclerView) root.findViewById(R.id.cartRecyclerView);
        menuList = ((MainActivity) getActivity()).getCartList();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), service_Socket.class);
                intent.putExtra("pw", Protocol.STORESELECT + "|" + ((MainActivity)getActivity()).user.getName() + "|" +((MainActivity)getActivity()).getCartList().toString());
                getActivity().startService(intent);

                ((MainActivity)getActivity()).fragmentMain();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        cartAdapter adapter = new cartAdapter(menuList, root.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager1);
        totalPrice.setText(String.valueOf(TotalPrice(menuList)));

        return root;
    }

    public int TotalPrice(ArrayList<OrderMenu> cart) {
        int total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getPrice();
        }

        return total;
    }
}



