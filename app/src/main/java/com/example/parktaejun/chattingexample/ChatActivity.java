package com.example.parktaejun.chattingexample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.parktaejun.chattingexample.Adapter.ChattingListAdapter;
import com.example.parktaejun.chattingexample.Datas.User;
import com.github.nkzawa.socketio.client.IO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    static final String TAG = "log";

    private ListView chattingList;
    private List<JSONObject> items = new ArrayList<>();
    private ChattingListAdapter chat_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent getChatIntent = getIntent();
        String chatName = getChatIntent.getStringExtra("chatName");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setTitle(chatName);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        View toolbar_view = LayoutInflater.from(this).inflate(R.layout.toolbar, null);
        TextView title = (TextView) toolbar_view.findViewById(R.id.toolbar_title);
        title.setText(chatName);
        getSupportActionBar().setCustomView(toolbar_view);
        Log.d(TAG, chatName);

        toolbar_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "click");
                finish();
            }
        });

        chattingList = (ListView)findViewById(R.id.chat_list);
        chattingList.setFooterDividersEnabled(false);
        chattingList.setHeaderDividersEnabled(false);
        chattingList.setDividerHeight(0);
        chat_adapter = new ChattingListAdapter(this, items);
        chattingList.setAdapter(chat_adapter);

        mSocket.connect();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: finish(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addChat(JSONObject json){
        items.add(json);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                chat_adapter.notifyDataSetChanged();
            }
        });
    }

    private Socket mSocket;
    {
        try{
            mSocket = IO.socket("http://nh.applepi.kr");
        } catch (URISyntaxException e){}
    }
}
