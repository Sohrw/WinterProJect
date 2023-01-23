package com.example.moacall;

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

        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey("l7xx740ca7e62b374e86b4634ff36d292130");
        LinearLayout linearLayoutTmap = (LinearLayout) findViewById(R.id.map_view);

        linearLayoutTmap.addView(tMapView);


    }
}
