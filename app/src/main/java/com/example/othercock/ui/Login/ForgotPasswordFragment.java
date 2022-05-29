package com.example.othercock.ui.Login;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.othercock.R;

import org.jetbrains.annotations.NotNull;

public final class ForgotPasswordFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_forgot_password,container,false);

        Toolbar toolbar = (Toolbar)getView().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        toolbar.setNavigationOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {

//                ForgotPasswordActivity.super.onBackPressed();



            }
        }));


        return root;
    }

    public final void setStatusBarWhite(@NotNull AppCompatActivity activity) {

        if (VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            activity.getWindow().setStatusBarColor(Color.WHITE);
        }

    }
}
