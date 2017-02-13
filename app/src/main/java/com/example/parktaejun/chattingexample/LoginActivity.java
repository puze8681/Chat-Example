package com.example.parktaejun.chattingexample;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parktaejun.chattingexample.Datas.IDCard;
import com.example.parktaejun.chattingexample.Server.IDCardService;
import com.example.parktaejun.chattingexample.Server.Util;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import retrofit2.Response;

/**
 * Created by parktaejun on 2017. 2. 12..
 */

public class LoginActivity extends AppCompatActivity {
    private AlertDialog dialog;
    public static String userID;
    public static String userToken;
    public static String userName;
    public static Boolean loginCheck = false;

    Button loginbtn;

    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, SplashActivity.class));
        setContentView(R.layout.activity_login);

        final SharedPreferences pref = getSharedPreferences("pref", 0);
        pref.getBoolean("loginCheck", loginCheck);
        pref.getString("userID", "");
        pref.getString("userPW", "");
        pref.getString("userName", "");

        if(pref.getBoolean("loginCheck", loginCheck)){
            userID = pref.getString("userID", "");
            userToken = pref.getString("userPW", "");
            userName = pref.getString("userName", "");

            Toast toast = Toast.makeText(LoginActivity.this, "자동 로그인 ...", Toast.LENGTH_SHORT );
            toast.show();

            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            mainIntent.putExtra("userID", userID);
            mainIntent.putExtra("userToken", userToken);
            mainIntent.putExtra("userName", userName);

            startActivity(mainIntent);
        }

        final EditText id = (EditText) findViewById(R.id.idText);
        final EditText pass = (EditText) findViewById(R.id.passText);
        loginbtn = (Button) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginAsynTask().execute(id.getText().toString(), pass.getText().toString());
            }
        });

        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.facebook_login_button);

        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.i("fuck", "User ID: " + loginResult.getAccessToken().getUserId());
                Log.i("fuck", "Auth Token: " + loginResult.getAccessToken().getToken());

                userID = loginResult.getAccessToken().getUserId();
                userToken = loginResult.getAccessToken().getToken();
                loginCheck = true;

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("LoginActivity", response.toString());

                                // Application code
                                try {
                                    userName = object.getString("name");
                                    Log.d("TAG", userName);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();

                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                mainIntent.putExtra("userID", userID);
                mainIntent.putExtra("userToken", userToken);
                mainIntent.putExtra("userName", userName);

                SharedPreferences.Editor editor = pref.edit();   //값을 입력, 삭제하기 위해 사용
                editor.putBoolean("loginCheck", loginCheck);
                editor.putString("userID", userID);
                editor.putString("userPW", userToken);
                editor.putString("userName", userName);
                editor.commit();      //값을 저장할때 호출

                startActivity(mainIntent);
            }

            @Override
            public void onCancel()
            {
                // App code
                Log.w("fuck", "Cancel");
            }

            @Override
            public void onError(FacebookException exception)
            {
                // App code
                Log.e("fuck", "Error", exception);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
