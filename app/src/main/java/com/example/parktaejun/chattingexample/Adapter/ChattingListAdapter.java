package com.example.parktaejun.chattingexample.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parktaejun.chattingexample.Datas.User;
import com.example.parktaejun.chattingexample.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by parktaejun on 2017. 2. 11..
 */

public class ChattingListAdapter extends BaseAdapter{

    private Context context;
    private List<User> items;
    private List<JSONObject> jsonItems;

    public ChattingListAdapter(Context context, List<User> items, List<JSONObject> jsonItems){
        this.context = context;
        this.items = items;
        this.jsonItems = jsonItems;
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

        JSONObject item = jsonItems.get(position);
        Drawable background = null;
        String msg = "";

        View view = LayoutInflater.from(context).inflate(R.layout.chat, null);
        LinearLayout container = (LinearLayout) view.findViewById(R.id.container);
        TextView chat_card = (TextView) view.findViewById(R.id.chat_box);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();

        try{
            if(jsonItems.getString("who").equals("me")){
                container.setGravity(Gravity.RIGHT);
                background = container.getResources().getDrawable(R.id.chat_box_me, context.getTheme());
            } else {
                background = container.getResources().getDrawable(R.id.chat_box_other, context.getTheme());
            }
            msg = item.getString("msg");
        } catch (JSONException e){
            e.printStackTrace();
        }
        chat_card.setBackground(background);
        chat_card.setText(msg);

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
