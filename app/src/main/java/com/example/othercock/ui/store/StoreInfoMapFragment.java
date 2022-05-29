package com.example.othercock.ui.store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.othercock.DTO.Manager;
import com.example.othercock.DTO.User;
import com.example.othercock.MainActivity;
import com.example.othercock.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.Nullable;

public class StoreInfoMapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap Map;
    Manager market;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_storeinfo_map,container,false);
        market = ((MainActivity)getActivity()).getMarket();


        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Map = googleMap;
        String name = market.getMarket();
        float latitude = market.getX();
        float longitude = market.getY();

        LatLng Location = new LatLng(latitude,longitude);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(Location);
        markerOptions.title(name);
        Map.addMarker(markerOptions);
        //Map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        Map.moveCamera(CameraUpdateFactory.newLatLngZoom(Location,30));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}