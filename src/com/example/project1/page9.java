package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class page9 extends Activity {
	ImageButton img1,img2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page9);
		img1 = (ImageButton) findViewById(R.id.imageButton1);
		img2 = (ImageButton) findViewById(R.id.imageButton2);
		img1.setOnClickListener(new OnClickListener() {
			@Override 
			public void onClick(View arg0) {
				Intent i=new Intent(page9.this,page10.class);
				startActivity(i);
			   
			}
		 
		});
		img2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(page9.this,page10.class);
				startActivity(i);
			   
			}
		 
		});


	}

	
	

}
