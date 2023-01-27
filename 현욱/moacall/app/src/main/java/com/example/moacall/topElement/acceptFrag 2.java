package com.example.moacall.topElement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.moacall.AcceptAdapter;
import com.example.moacall.AcceptData;
import com.example.moacall.Address;
import com.example.moacall.DeliveryStatus;
import com.example.moacall.R;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class acceptFrag extends Fragment {

    ArrayList<AcceptData> acceptData;
    ListView acceptView;
    private AcceptAdapter acceptAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {

        View rootView = inflater.inflate(R.layout.accept, container, false);

        this.InitializeData();

        acceptView = (ListView) rootView.findViewById(R.id.listView_accept);
        acceptAdapter = new AcceptAdapter(getContext(), acceptData);



        acceptView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(adapterView.getContext(), "Clicked : " + position + " " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
        acceptView.setAdapter(acceptAdapter);



        return rootView;
    }

    public void InitializeData() {

        acceptData = new ArrayList<>();
        Address clientAddress = new Address("a","b","c");
        Address foodAddress = new Address("a","b","c");

        acceptData.add(new AcceptData(1L, LocalDateTime.now().minusMinutes(20), LocalDateTime.now(), foodAddress, clientAddress, "ClientMemo", 10000, 6700,DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(2L, LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), foodAddress, clientAddress, "ClientMemo", 10000, 6700,DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(3L, LocalDateTime.now().minusMinutes(40), LocalDateTime.now(), foodAddress, clientAddress, "ClientMemo", 10000, 6700,DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(4L, LocalDateTime.now().minusMinutes(50), LocalDateTime.now(), foodAddress, clientAddress, "ClientMemo", 10000, 6700,DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(5L, LocalDateTime.now().minusMinutes(60), LocalDateTime.now(), foodAddress, clientAddress, "ClientMemo", 10000, 6700,DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(6L, LocalDateTime.now().minusMinutes(70), LocalDateTime.now(), foodAddress, clientAddress, "ClientMemo", 10000, 6700,DeliveryStatus.WAIT_FOR_COOKING));

    }


}
