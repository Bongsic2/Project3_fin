package com.example.othercock.ui.tier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;


public class TierFragment extends Fragment {
    TextView name;
    TextView exp;
    TextView tier;
    ImageView medal;

    User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tier,container,false);
        name = (TextView) root.findViewById(R.id.rank_Id);
        exp = (TextView) root.findViewById(R.id.tier_exp);
        tier = (TextView) root.findViewById(R.id.user_tier);
        medal = (ImageView) root.findViewById(R.id.medal_set);

        user = ((MainActivity)getActivity()).settingUser(null);

        name = root.findViewById(R.id.rank_Id);
        if(user != null){
            name.setText(user.getName());
            exp.setText(String.valueOf(user.getExp()));
            tier.setText(user.getTier());
            if(user.getTier().compareTo("SILVER")==0){
                medal.setImageResource(R.drawable.silver);
            }

        }

        return root;
    }
}
