package com.example.parktaejun.chattingexample.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.parktaejun.chattingexample.LoginActivity;
import com.example.parktaejun.chattingexample.R;
import com.example.parktaejun.chattingexample.SplashActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

/**
 * Created by parktaejun on 2017. 2. 10..
 */

public class OptionFragment extends Fragment {

    private CallbackManager callbackManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState){
        View view = inflater.inflate(R.layout.fragment_option, container, false);
        LoginButton logOutButton = (LoginButton) view.findViewById(R.id.facebook_login_button);
        logOutButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        callbackManager = CallbackManager.Factory.create();
        logOutButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                LoginActivity.editor.clear();
                LoginActivity.editor.commit();

                Intent loginIntent = new Intent(getContext(), SplashActivity.class);
                startActivity(loginIntent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        return view;
    }
}
