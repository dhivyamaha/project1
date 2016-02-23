package com.example.tollplaza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class page10 extends Activity{
	ImageButton img1,img2;
	int a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page10);
		Intent i = getIntent();
		a = i.getIntExtra("amount", 0);
		img1 = (ImageButton) findViewById(R.id.imageButton1);
		img2 = (ImageButton) findViewById(R.id.imageButton2);
		img1.setOnClickListener(new OnClickListener() {
			@Override 
			public void onClick(View arg0) {
				Intent i=new Intent(getApplicationContext(),credit.class);
				i.putExtra("amount", a);
				startActivity(i);
			   
			}
		 
		});
		img2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(getApplicationContext(),debit.class);
				i.putExtra("amount", a);
				startActivity(i);
			   
			}
		 
		});


	}

	
	


}
