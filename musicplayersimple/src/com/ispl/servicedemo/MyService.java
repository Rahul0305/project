package com.ispl.servicedemo;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
	private static final String TAG = "MyService";
	MediaPlayer player;
	
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
		
		player = MediaPlayer.create(this, R.raw.summer_of_69);
		player.setLooping(false); // Set looping
		player.start();
		
		/*//Uri myUri = ....; // initialize Uri here
		
		try {
			Uri data = Uri.parse("R.raw.summer_of_69"); 
			MediaPlayer mediaPlayer = new MediaPlayer();
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer.setDataSource(getApplicationContext(), data);
			mediaPlayer.prepare();
			mediaPlayer.start();
			Toast.makeText(this, "My Service started", Toast.LENGTH_LONG).show();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this,""+e, Toast.LENGTH_LONG).show();
			Toast.makeText(this, "My Service not started", Toast.LENGTH_LONG).show();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this,""+e, Toast.LENGTH_LONG).show();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this,""+e, Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this,""+e, Toast.LENGTH_LONG).show();
		}
		*/
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		player.stop();
	}
	 
	//@Override
	 protected void onPause() {
		Toast.makeText(this, "My Service Paused", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onPause");
		player.pause();
	}
	/*@Override
	public void onStart(Intent intent, int startid) {
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		player.start();
	}*/
}
