package com.example.allinone;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	MediaPlayer mPlayer;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayer = MediaPlayer.create(MainActivity.this, R.raw.glass);
        ((Button) findViewById(R.id.button)).setOnClickListener(this);
    }
	public void onClick(View v) {
		if(v.getId()==R.id.button) {
			int i = Integer.parseInt(((Button) v).getText().toString());
			((Button) v).setText(Integer.toString(--i));
			Random gen = new Random();
			if((gen.nextInt(10) + 1 == 10) || (i<50)) {
				crack();
				((Button) v).setOnClickListener(null);
			}
		}
	}
	
	private void crack() {
		audibleFX();
		visualFX();
		touchFX();
	}
	
	private void audibleFX() {
		mPlayer.start();
	}
	
	private void touchFX() {
		Vibrator mv = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		mv.vibrate(new long[]{ 0, 500, 0}, -1);
	}
	
	private void visualFX() {
		findViewById(R.id.background).setBackgroundResource(R.drawable.cracked_screen);
		((TextView)findViewById(R.id.title)).setTextColor(0x6400ff00);
		((TextView)findViewById(R.id.blurb)).setTextColor(0x64ffffff);
		((Button)findViewById(R.id.button)).setBackgroundColor(0x64cdc9c9);
	}
	
	protected void onDestroy() {
		super.onDestroy();
		if(mPlayer!=null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
}

