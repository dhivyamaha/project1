package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class lastpage extends Activity {
	Button btn;
	EditText a,b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.lastpage);
	    a = (EditText) findViewById(R.id.editText1);
	    b = (EditText) findViewById(R.id.editText2);
	    btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(lastpage.this,MainActivity.class);
				startActivity(i);
				Toast.makeText(getApplicationContext(),"Payment successfully",Toast.LENGTH_LONG).show();
			}
		});
	    
}
}