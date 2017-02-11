package com.example.parktaejun.chattingexample.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.parktaejun.chattingexample.Datas.User;
import com.example.parktaejun.chattingexample.R;

import java.util.List;

/**
 * Created by parktaejun on 2017. 2. 11..
 */

public class ChattingListAdapter extends BaseAdapter{

    private Context context;
    private List<User> items;

    public ChattingListAdapter(Context context, List<User> items){
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

        View view = null;
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
