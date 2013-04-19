package com.example.allinone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AllInOne extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_in_one);
		Button calc = (Button)findViewById(R.id.calc);
		calc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent calculator = new Intent(AllInOne.this, TipCalculator.class); 
				startActivity(calculator);
			}
		});
		
		Button exit = (Button)findViewById(R.id.exit);
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
		Button tap = (Button)findViewById(R.id.tap);
		tap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent Tap = new Intent(AllInOne.this, MainActivity.class);
				startActivity(Tap);
			}
		});
		
		Button t = (Button)findViewById(R.id.tourch);
		t.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent torch = new Intent(AllInOne.this, Torch.class);
				startActivity(torch);
			}
		});
	}
}
