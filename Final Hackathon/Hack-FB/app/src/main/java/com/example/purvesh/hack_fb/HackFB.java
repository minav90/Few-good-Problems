package com.example.purvesh.hack_fb;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HackFB extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private JSONArray friendsJsonArr;
    private String m_userName;
    private String m_userId;

    public void onMapClicked() {
        Intent intent = new Intent(this,TrackFriends.class);
        intent.putExtra(TrackFriends.USER_NAME_KEY,m_userName);
        intent.putExtra(TrackFriends.USER_ID_KEY,m_userId);
        startActivity(intent);
    }

    public void onTrackerClicked() {

    }

    public void onFriendsClicked() {
        Intent intent = new Intent(this, FriendsActivity.class);
        intent.putExtra(FriendsActivity.FRIENDS_COUNT_KEY,friendsJsonArr.length());
        String[] names = new String[friendsJsonArr.length()];
        for(int i = 0; i < friendsJsonArr.length(); i++) {
            try {
                JSONObject friendInfo = friendsJsonArr.getJSONObject(i);
                names[i] = friendInfo.get("name").toString();
            } catch (JSONException jex) {
                System.out.print(false);
            }
        }
        intent.putExtra(FriendsActivity.FRIENDS_NAMES_KEY, names);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_hack_fb);
        findViewById(R.id.homepage).setVisibility(View.INVISIBLE);
        if(AccessToken.getCurrentAccessToken() == null) {
            setupFbLogin();
        } else {
            fetchUserInfo();
        }

    }

    private void setupFbLogin() {
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hack_fb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        fetchUserInfo();
    }

    private void fetchUserInfo() {
        GraphRequestBatch batchReq = new GraphRequestBatch(GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject jsonObject, GraphResponse response) {
                        try {
                            if(jsonObject != null) {
                                m_userName = jsonObject.get("name").toString();
                                m_userId = jsonObject.getString("id").toString();
                                setupHomePage();
                            }
                        } catch(JSONException jex) {
                            System.out.print("Parse error");
                        }
                    }}),
                GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(),
                        new GraphRequest.GraphJSONArrayCallback() {
                            @Override
                            public void onCompleted(JSONArray jsonArray, GraphResponse response) {
                                friendsJsonArr = jsonArray;

                            }
                        })
        );
        batchReq.addCallback(new GraphRequestBatch.Callback() {
            @Override
            public void onBatchCompleted(GraphRequestBatch batch) {
                System.out.print(true);
            }
        });
        batchReq.executeAsync();
    }

    private void setupHomePage() {
        TextView userName = (TextView)findViewById(R.id.user_name);
        userName.setText(m_userName);
        Button map = (Button)findViewById(R.id.mapBtn);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMapClicked();
            }
        });
        Button tracker = (Button)findViewById(R.id.tracker);
        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTrackerClicked();
            }
        });
        Button friends = (Button)findViewById(R.id.friends);
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFriendsClicked();
            }
        });
        findViewById(R.id.homepage).setVisibility(View.VISIBLE);
    }
}