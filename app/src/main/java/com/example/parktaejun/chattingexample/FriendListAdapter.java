package com.example.parktaejun.chattingexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.CustomViewHolder> {

    private Context context;
    private List<User> items;

    public FriendListAdapter (Context context, List<User> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_profileview, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.name.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public CustomViewHolder(View itemview){
            super(itemview);
            name = (TextView) itemview.findViewById(R.id.profile_name);
        }
    }
}
