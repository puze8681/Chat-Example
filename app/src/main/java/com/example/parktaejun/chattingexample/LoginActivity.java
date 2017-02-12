package com.example.parktaejun.chattingexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parktaejun.chattingexample.Datas.IDCard;
import com.example.parktaejun.chattingexample.Server.IDCardService;
import com.example.parktaejun.chattingexample.Server.Util;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by parktaejun on 2017. 2. 12..
 */

public class LoginActivity extends AppCompatActivity {
    private AlertDialog dialog;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, SplashActivity.class));
        setContentView(R.layout.activity_login);

        final EditText id = (EditText) findViewById(R.id.idText);
        final EditText pass = (EditText) findViewById(R.id.passText);
        loginbtn = (Button) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginAsynTask().execute(id.getText().toString(), pass.getText().toString());
            }
        });
    }

    public class LoginAsynTask extends AsyncTask<String, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog.Builder(getApplicationContext()).setTitle("로그인 중 입니당...").show();
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                Response<IDCard> res = new Util().retrofit.create(IDCardService.class).login(params[0], params[1]).execute();
                Log.d(Util.TAG, res.body().toString());

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dialog.dismiss();
    }

}
