package com.example.parktaejun.chattingexample.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parktaejun.chattingexample.R;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class OptionFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState){
        View view = inflater.inflate(R.layout.fragment_option, container, false);
        return view;
    }
}
