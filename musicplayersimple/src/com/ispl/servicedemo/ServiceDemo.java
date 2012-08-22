package com.ispl.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ServiceDemo extends Activity implements OnClickListener{
	 private static final String TAG = "ServicesDemo";
	 Button buttonStart, buttonStop,btnpause;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       // setContentView(R.layout.main);

        buttonStart = (Button) findViewById(R.id.startBtn);
        buttonStop = (Button) findViewById(R.id.stopBut);
        btnpause = (Button)findViewById(R.id.pauseBut);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        btnpause.setOnClickListener(this);
        
        
    }
	@Override
	public void onClick(View v) {
		 switch (v.getId()) {
		    case R.id.startBtn:
		      Log.d(TAG, "onClick: starting srvice");
		      startService(new Intent(this, MyService.class));
		      break;
		    case R.id.stopBut:
		      Log.d(TAG, "onClick: stopping srvice");
		      stopService(new Intent(this, MyService.class));
		      break;
		    case R.id.pauseBut:
		    	
		    	MediaPlayer player = new MediaPlayer();
		    	
		    	player.pause();/*
		    	if (player.isPlaying()) {
					if (player != null)
					{
						
					}
		    	}*/
			      break;
		    }
	}
}