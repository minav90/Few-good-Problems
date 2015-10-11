package com.example.trackme;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

  private TextView textView;
  private BroadcastReceiver receiver = new BroadcastReceiver() {

    @Override
    public void onReceive(Context context, Intent intent) {
      Bundle bundle = intent.getExtras();
      if (bundle != null) {
        String string = bundle.getString(TrackService.FILEPATH);
        int resultCode = bundle.getInt(TrackService.RESULT);
        if (resultCode == RESULT_OK) {
          Toast.makeText(MainActivity.this,
              "Download complete. Download URI: " + string,
              Toast.LENGTH_LONG).show();
          
        } else {
          Toast.makeText(MainActivity.this, "Download failed",
              Toast.LENGTH_LONG).show();
          
        }
      }
    }
  };

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    

  }

  @Override
  protected void onResume() {
    super.onResume();
    registerReceiver(receiver, new IntentFilter(TrackService.NOTIFICATION));
  }
  @Override
  protected void onPause() {
    super.onPause();
    unregisterReceiver(receiver);
  }

  public void onClick(View view) {

    Intent intent = new Intent(this, TrackService.class);
    // add infos for the service which file to download and where to store
    intent.putExtra(TrackService.FILENAME, "index.html");
    intent.putExtra(TrackService.URL,
        "http://www.vogella.com/index.html");
    startService(intent);
   
  }
} 