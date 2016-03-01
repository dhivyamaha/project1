package com.example.tollplaza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class page10 extends Activity {
	ImageButton img1, img2;
	int a; 
	String id,type="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page10);
		Intent i = getIntent();
		a = i.getIntExtra("amount", 0);
		id = i.getStringExtra("id");
		type=i.getStringExtra("type");
		//System.out.println(a + "----" + id);
		// Toast.makeText(getApplicationContext(),a, Toast.LENGTH_LONG).show();
		// Toast.makeText(getApplicationContext(),id, Toast.LENGTH_LONG).show();
		img1 = (ImageButton) findViewById(R.id.imageButton1);
		img2 = (ImageButton) findViewById(R.id.imageButton2);
		img1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), credit.class);
				i.putExtra("amount", a);
				i.putExtra("id", id);
				i.putExtra("type", type);
				startActivity(i);

			}

		});
		img2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), debit.class);
				i.putExtra("amount", a);
				i.putExtra("id", id);
				i.putExtra("type", type);

				startActivity(i);

			}

		});

	}

}
