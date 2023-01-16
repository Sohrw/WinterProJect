package com.example.moacall.topElement;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class acceptFrag extends Fragment {

    ArrayList<AcceptData> acceptData;
    ListView acceptView;
    private AcceptAdapter acceptAdapter;
    ScrollView scrollView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {

        View rootView = inflater.inflate(R.layout.accept, container, false);
        this.InitializeData();


        acceptView = (ListView) rootView.findViewById(R.id.listView_accept);
        acceptAdapter = new AcceptAdapter(getContext(), acceptData);
        scrollView = (ScrollView) rootView.findViewById(R.id.scrollView_accept);




        acceptView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(adapterView.getContext(), "Clicked : " + position + " " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        acceptView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        int totalHeight = 0;
        for (int i = 0; i< acceptAdapter.getCount(); i++) {
            View listItem = acceptAdapter.getView(i, null, acceptView);
            listItem.measure(0,0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = acceptView.getLayoutParams();
        params.height = totalHeight + (acceptView.getDividerHeight() * (acceptAdapter.getCount() -1));
        acceptView.setLayoutParams(params);
        acceptView.setAdapter(acceptAdapter);



        return rootView;
    }

    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg, receiveMsg;


        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://192.168.0.4:8080/login");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg = "user_name="+strings[0]+"&pw="+strings[1];
                Log.d("sendMsg", sendMsg);
                osw.write(sendMsg);
                osw.flush();

                if(conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    StringBuffer buffer = new StringBuffer();
                    while ((str = reader.readLine()) != null) {
                        buffer.append(str);
                    }
                    receiveMsg = buffer.toString();
                } else{
                    Log.i("Connection Result ", conn.getResponseCode()+" ERROR");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e ) {
                e.printStackTrace();
            }
            return receiveMsg;
        }
    }

    public void InitializeData() {

        acceptData = new ArrayList<>();
        LocalDateTime startTime = LocalDateTime.now();
        Address foodAddress = new Address("조원동", "14132", "104동 1701호");
        acceptData.add(new AcceptData(1L, startTime, startTime, foodAddress, foodAddress, "sdads", 1111, 2222, DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(2L, startTime, startTime, foodAddress, foodAddress, "sdads", 1111, 2222, DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(3L, startTime, startTime, foodAddress, foodAddress, "sdads", 1111, 2222, DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(4L, startTime, startTime, foodAddress, foodAddress, "sdads", 1111, 2222, DeliveryStatus.WAIT_FOR_COOKING));
        acceptData.add(new AcceptData(5L, startTime, startTime, foodAddress, foodAddress, "sdads", 1111, 2222, DeliveryStatus.WAIT_FOR_COOKING));




    }


}
