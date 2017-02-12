package com.example.parktaejun.chattingexample.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parktaejun.chattingexample.ChatActivity;
import com.example.parktaejun.chattingexample.Datas.User;
import com.example.parktaejun.chattingexample.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by parktaejun on 2017. 2. 11..
 */

public class ChatRoomListAdapter extends BaseAdapter{

    private Context context;
    private List<User> items;

    public ChatRoomListAdapter(Context context, List<User> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.chat, null);
        LinearLayout container = (LinearLayout) view.findViewById(R.id.container);

        if(position == 0){
            view = LayoutInflater.from(context).inflate(R.layout.search_chat, null);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.item_chattingview, null);
            TextView name = (TextView) view.findViewById(R.id.chatting_text);
            name.setText(items.get(position).getName());
        }

        return view;
    }


}
