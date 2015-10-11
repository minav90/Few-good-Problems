package com.example.purvesh.hack_fb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import org.json.JSONArray;

/**
 * Created by Purvesh on 10/10/2015.
 */
public class FriendsActivity extends AppCompatActivity {

    public static final String FRIENDS_COUNT_KEY = "friends_count_key";
    public static final String FRIENDS_NAMES_KEY = "friends_names_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        setUpFriendsPage();
    }

    private void setUpFriendsPage() {
        Intent intent = getIntent();
        int numFriends = intent.getIntExtra(FRIENDS_COUNT_KEY,0);
        String[] friendNames = intent.getStringArrayExtra(FRIENDS_NAMES_KEY);
        GridView gv=(GridView) findViewById(R.id.friendsGrid);
        CustomAdapter customAdapter = new CustomAdapter(this, numFriends,friendNames);
        gv.setAdapter(customAdapter);
    }
}
