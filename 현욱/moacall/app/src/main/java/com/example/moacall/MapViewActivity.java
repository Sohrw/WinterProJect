package com.example.moacall;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapView;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MapViewActivity extends AppCompatActivity {

    private Address address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);
        Intent intent = getIntent();


        String latitude = intent.getStringExtra("latitude");
        String longitude = intent.getStringExtra("longitude");
        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey("l7xx740ca7e62b374e86b4634ff36d292130");
        LinearLayout linearLayoutTmap = (LinearLayout) findViewById(R.id.map_view);

        tMapView.setCenterPoint(  Double.parseDouble(longitude), Double.parseDouble(latitude));
        linearLayoutTmap.addView(tMapView);


    }
}
