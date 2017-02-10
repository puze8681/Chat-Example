package com.example.parktaejun.chattingexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class ChatFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState){
        return inflater.inflate(R.layout.chat_layout, container, false);
    }
}
