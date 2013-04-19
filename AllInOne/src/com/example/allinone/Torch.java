package com.example.allinone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Torch extends Activity {
	
	WindowManager.LayoutParams lp;
	float fb;
	float lb = 0;
	float hb = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.torch);
		lp = getWindow().getAttributes();
		fb = lp.screenBrightness;
		ImageButton torch = (ImageButton)findViewById(R.id.torch);
		torch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 if(lp.screenBrightness==fb) {
			            lp.screenBrightness=lb;
			            getWindow().setAttributes(lp);
			        }
			        if(lp.screenBrightness==lb){
			            lp.screenBrightness=hb;
			            getWindow().setAttributes(lp);
			        }
				
			}
		});
	}
}
