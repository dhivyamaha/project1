package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class page7 extends Activity{
	Button btn;
	EditText a,b,c,e;
	CheckBox s,d,m,w;
	Spinner spn1;
	String selection="";
	String[] vehicletype = {
			"Three Wheeler",
			"Car",
			"Bus",
			"Truck",
			"LCV"
			    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page7);
		a = (EditText) findViewById(R.id.editText1);
		b = (EditText) findViewById(R.id.editText3);
		c = (EditText) findViewById(R.id.editText2);
		e = (EditText) findViewById(R.id.editText4);
        s = (CheckBox) findViewById(R.id.checkBox1);
        d = (CheckBox) findViewById(R.id.checkBox2);
        w = (CheckBox) findViewById(R.id.checkBox3);
        m = (CheckBox) findViewById(R.id.checkBox4);
        spn1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, vehicletype);
 
        spn1.setAdapter(adapter);
        spn1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
 
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                            int arg2, long arg3) {
 
                        int position = spn1.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(),"You have selected "+vehicletype[+position],Toast.LENGTH_LONG).show();
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
				// TODO Auto-generated method stub
				if(s.isChecked()){
					selection="Single"+" ";
				}
				if(d.isChecked()){
					selection=selection+"Double"+" ";
				}
				if(w.isChecked()){
					selection=selection+"Weekly";
				}
				if(m.isChecked()){
					selection=selection+"Monthly";
				}
				Toast.makeText(getApplicationContext(), 
						"CheckBoxes "+selection+" are selected",Toast.LENGTH_LONG).show();
				selection="";


				Intent i1= new Intent(page7.this,page9.class);
				startActivity(i1);
			}
		});
    }
 
		
		
		
		
	}


