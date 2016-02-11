package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class page10 extends Activity{
	Button btn;
	EditText a,b,c;
	Spinner spn1;
	String[] country = {
			"Africa",
			"Canada",
			"India",
			"Pakistan",
			"Russia"
			    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page10);
		a = (EditText) findViewById(R.id.editText1);
		b = (EditText) findViewById(R.id.editText2);
		c = (EditText) findViewById(R.id.editText3);
		
		 spn1 = (Spinner) findViewById(R.id.spinner1);
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
	                this, android.R.layout.simple_spinner_item, country);
	   
	        spn1.setAdapter(adapter);
	        spn1.setOnItemSelectedListener(
	                new AdapterView.OnItemSelectedListener() {
	 
	                    @Override
	                    public void onItemSelected(AdapterView<?> arg0, View arg1,
	                            int arg2, long arg3) {
	 
	                        int position = spn1.getSelectedItemPosition();
	                        Toast.makeText(getApplicationContext(),"You have selected "+country[+position],Toast.LENGTH_LONG).show();
	                        // TODO Auto-generated method stub
	                    }
	 
	                    @Override
	                    public void onNothingSelected(AdapterView<?> arg0) {
	                        // TODO Auto-generated method stub
	 
	                    }
	 
	                }
	            );
	        
	        btn=(Button)findViewById(R.id.button1);
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i1= new Intent(page10.this,lastpage.class);
					startActivity(i1);
					Toast.makeText(getApplicationContext(),"OTP send to your number",Toast.LENGTH_LONG).show();
				}
		
	});

}}
