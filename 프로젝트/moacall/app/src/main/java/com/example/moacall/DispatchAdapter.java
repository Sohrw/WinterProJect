package com.example.moacall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DispatchAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    Context dContext = null;
    LayoutInflater layoutInflater = null;
    ArrayList<AcceptData> acceptData;
    MainActivity activity;

    public DispatchAdapter(Context context, ArrayList<AcceptData> data) {
        dContext = context;
        acceptData = data;
        layoutInflater = LayoutInflater.from(dContext);
    }

    @Override
    public int getCount() {
        return acceptData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public AcceptData getItem(int position) { return acceptData.get(position); }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.listview_item, null);
        TextView startTimeText = (TextView) view.findViewById(R.id.startTimeText);
        TextView acceptText = (TextView) view.findViewById(R.id.acceptTime);
        TextView summaryAddressText = (TextView) view.findViewById(R.id.summaryAddress);
        TextView typeOfPaymentText = (TextView) view.findViewById(R.id.typeOfPaymentText);
        TextView priceText = (TextView) view.findViewById(R.id.priceText);
        TextView clientAddressText = (TextView) view.findViewById(R.id.clinetAddressText);
        TextView clientRefectorAddressText = (TextView) view.findViewById(R.id.clientRefectorAddressText);
        TextView memoText = (TextView) view.findViewById(R.id.memoText);
        Button pickupButton = (Button) view.findViewById(R.id.mapButton);
        pickupButton.setText("픽업");
        pickupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        String startTime = acceptData.get(position).getStartTime();
        LocalDateTime presentTime = LocalDateTime.now();
        startTimeText.setText(compareMinute(startTime, presentTime) + "분");

        summaryAddressText.setText(acceptData.get(position).getFoodAddress() + "/금방나옴/" + "9.99km");

        typeOfPaymentText.setText("선결제");
        priceText.setText(acceptData.get(position).getClientPrice() + "/" + acceptData.get(position).getDeliveryPrice());
        clientAddressText.setText(acceptData.get(position).getClientAddress());
        memoText.setText(acceptData.get(position).getClientMemo());

        return view;

    }

    public static long compareMinute(String date1, LocalDateTime date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

        LocalTime startDate = LocalDateTime.parse(date1, formatter).toLocalTime();
        LocalTime endDate = date2.toLocalTime();
        Duration diff = Duration.between(startDate, endDate);
        long diffMinute = diff.toMinutes();
        return diffMinute;

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
