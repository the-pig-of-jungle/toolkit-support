package com.coder.zzq.toolkit.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.coder.zzq.toolkit.adapter.MsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mFirstList;

    private RecyclerView mSecondList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirstList = findViewById(R.id.first_list);
        mSecondList = findViewById(R.id.second_list);
        mFirstList.setLayoutManager(new LinearLayoutManager(this));
        mSecondList.setLayoutManager(new LinearLayoutManager(this));
        MsgAdapter msgAdapter = new MsgAdapter();
        List<String> list = new ArrayList<>(100);
        for (int i = 0;i < 100;i++){
            list.add("pos:" + i);
        }
        msgAdapter.setData(list);
        mFirstList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("test_state",newState + "");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e("test_distance",dx + "/" + dy);
            }
        });
        mFirstList.setAdapter(msgAdapter);

        MsgAdapter adapter = new MsgAdapter();
        adapter.setData(list);

        mSecondList.setAdapter(adapter);
    }
}
