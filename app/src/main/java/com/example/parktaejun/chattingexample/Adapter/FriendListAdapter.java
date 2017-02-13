package com.example.parktaejun.chattingexample.Adapter;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parktaejun.chattingexample.Datas.User;
import com.example.parktaejun.chattingexample.LoginActivity;
import com.example.parktaejun.chattingexample.R;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class FriendListAdapter extends BaseAdapter {

    private Context context;
    private List<User> items;

    public FriendListAdapter(Context context, List<User> items){
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
            view = LayoutInflater.from(context).inflate(R.layout.search_friend, null);
        }else if(position == 1 || position == 3){
            view = LayoutInflater.from(context).inflate(R.layout.text, null);
            TextView text = (TextView)view.findViewById(R.id.text_text);

            String _text = position == 1 ? "내 프로필" : "친구";
            text.setText(_text);
        }else if(position == 2){
            view = LayoutInflater.from(context).inflate(R.layout.item_profileview, null);
            ImageView profileImage = (ImageView) view.findViewById(R.id.profile_image);
            TextView profileText = (TextView) view.findViewById(R.id.profile_text);
            String url = "http://graph.facebook.com/" + LoginActivity.userID + "/picture?type=large";
            Picasso.with(context)
                    .load(url)
                    .into(profileImage);
            profileText.setText(LoginActivity.userName);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.item_profileview, null);
            TextView name = (TextView) view.findViewById(R.id.profile_text);
            name.setText(items.get(position).getName());
        }

        return view;
    }
}
