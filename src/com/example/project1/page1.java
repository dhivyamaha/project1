package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class page1 extends Activity{
	Button btn1,btn2,btn3,btn4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page1);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button3);
		btn3=(Button)findViewById(R.id.button2);
		btn4=(Button)findViewById(R.id.button4);
	    btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(page1.this,page2.class);
				startActivity(i);
			}
		});
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(page1.this,page3.class);
				startActivity(i);
			}
		});
        btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(page1.this,page4.class);
				startActivity(i);
			}
		});
        btn4.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(page1.this,page5.class);
			startActivity(i);
		}
	});
	}
	

}
