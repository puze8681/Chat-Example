package com.example.parktaejun.chattingexample.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.parktaejun.chattingexample.Adapter.FriendListAdapter;
import com.example.parktaejun.chattingexample.ChatActivity;
import com.example.parktaejun.chattingexample.LoginActivity;
import com.example.parktaejun.chattingexample.ProfileActivity;
import com.example.parktaejun.chattingexample.R;
import com.example.parktaejun.chattingexample.Datas.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class FriendFragment extends Fragment {

    private EditText friend_edit;
    private ListView friend_list;
    private FriendListAdapter listAdapter;
    private List<User> items = new ArrayList<>();

    public FriendFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        friend_edit = (EditText) view.findViewById(R.id.friend_edit);
        friend_list = (ListView) view.findViewById(R.id.friend_list);

        items.add(new User("search"));
        items.add(new User("myProfile"));
        items.add(new User(LoginActivity.userName));
        items.add(new User("myFriend"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));

        listAdapter = new FriendListAdapter(getContext(), items);
        friend_list.setAdapter(listAdapter);

        friend_list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String positionCheck = items.get(i).getName();
                        Log.d("asdf", String.valueOf(i)+ " : " + positionCheck);
                        if(!(positionCheck.equals("search") || positionCheck.equals("myProfile") || positionCheck.equals("myFriend"))){
                            Intent profileIntent = new Intent(getActivity(), ProfileActivity.class);
                            profileIntent.putExtra("chatName", items.get(i).getName());
                            startActivity(profileIntent);
                        }
                    }
                }
        );


        return view;
    }
}
