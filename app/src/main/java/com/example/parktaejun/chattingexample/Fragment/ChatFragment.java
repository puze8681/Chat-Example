package com.example.parktaejun.chattingexample.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.parktaejun.chattingexample.Adapter.ChattingListAdapter;
import com.example.parktaejun.chattingexample.R;
import com.example.parktaejun.chattingexample.Datas.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class ChatFragment extends Fragment {

    private EditText chat_edit;
    private ListView chat_list;
    private ChattingListAdapter listAdapter;
    private List<User> items = new ArrayList<>();

    public ChatFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        chat_edit = (EditText) view.findViewById(R.id.chat_edit);
        chat_list = (ListView) view.findViewById(R.id.chat_list);

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
        items.add(new User("박태준"));
        items.add(new User("윤영채"));
        items.add(new User("박태준"));
        items.add(new User("윤영채"));

        listAdapter = new ChattingListAdapter(getContext(), items);
        chat_list.setAdapter(listAdapter);

        return view;
    }
}
