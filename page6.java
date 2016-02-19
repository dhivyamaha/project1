package com.example.tollplaza;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class page6 extends Activity implements OnCheckedChangeListener{
	Button btn;
	EditText uname,vehnum,amount;
	int a;
	RadioGroup passtypegroup;
	RadioButton passtypebutton;
	String uname1,vehnum1,passtype1,amount1;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page6);
		 uname= (EditText) findViewById(R.id.editText1);
		 vehnum = (EditText) findViewById(R.id.editText2);
		 amount = (EditText) findViewById(R.id.editText3);
	     passtypegroup = (RadioGroup) findViewById(R.id.radioGroup1);
	     int selectedId = passtypegroup.getCheckedRadioButtonId();
         
         passtypebutton = (RadioButton) findViewById(selectedId);
	     passtypegroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

	         @Override
	         public void onCheckedChanged(RadioGroup group, int checkedId) {
	             switch (checkedId) {
	             case R.id.radio0:   
	                a = 40;
	                amount.setText(a+"");
	                 break;

	             case R.id.radio1:
	                 a = (40*7)-95;
	                 amount.setText(a+"");
	                 break;
	                 
	             case R.id.radio2:
	                 a = (40*30)-190;
	                 amount.setText(a+"");
	                 break;

	             }   

	         }
	     });
         btn = (Button) findViewById(R.id.button1);
         btn.setOnClickListener(new OnClickListener() {


            public void onClick(View v) {
            	
             
               
             
               Toast.makeText(page6.this,
        				passtypebutton.getText(),Toast.LENGTH_SHORT).show();
               uname1=uname.getText().toString();
			   vehnum1=vehnum.getText().toString();
			   amount1=amount.getText().toString();
			   passtype1= passtypebutton.getText().toString(); 
			   try
				{
					uname1=URLEncoder.encode(uname1,"UTF-8");
					vehnum1=URLEncoder.encode(vehnum1,"UTF-8");
					amount1=URLEncoder.encode(amount1,"UTF-8");
					passtype1=URLEncoder.encode(passtype1,"UTF-8");
					String url="http://10.100.9.232/bus.php?name="
							+ uname1.trim() + "&vehicleno="
							+ vehnum1.trim() + "&passtype=" + passtype1.trim() + "&amount=" + amount1.trim();
					System.out.println(url);
					pass_value_to_db get = new pass_value_to_db();
					get.execute(new String[] { url });
					Intent i=new Intent(page6.this,MainActivity.class);
					startActivity(i);

				}catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         
           }
        });
	}
	 private class pass_value_to_db extends AsyncTask<String, Void, String>{
	    	ProgressDialog dialog;


			@Override
			protected void onPreExecute() { //  TODO Auto-generated method stub
				dialog = new ProgressDialog(page6.this);
				dialog.setTitle("Processing...");
				dialog.setMessage("Please wait.");
				dialog.setCancelable(false);
				dialog.show();
			}

			@Override
			protected String doInBackground(String... urls) {
				String result = "";
				for (String url : urls) {
					InputStream is = null;
					try {

						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httppost = new HttpPost(url);
						HttpResponse response = httpclient.execute(httppost);
						int status = response.getStatusLine().getStatusCode();
						Log.d("KG", "status=" + status);

						if (status == 200) {
							HttpEntity entity = response.getEntity();
							is = entity.getContent();
							BufferedReader reader = new BufferedReader(
									new InputStreamReader(is, "iso-8859-1"), 8);
							String line = "";
							while ((line = reader.readLine()) != null) {
								result += line;
							}
							is.close();

							Log.v("KG", result);

						}
					} catch (Exception ex) {
						Log.e("Error", ex.toString());
					}
				}
				return result;
			}

			protected void onPostExecute(String result) {
				Log.v("KG", "output=" + result);
				result = result.trim(); //
				// Toast.makeText(getApplicationContext(), result, //
				// Toast.LENGTH_LONG).show();
				if (result.equals("false")) {

					// *******************************************************

					Toast.makeText(getApplicationContext(),
							" Please try again later...", Toast.LENGTH_LONG).show();
				} else {
					System.out.println(result);

				}

				if (dialog != null)
					dialog.dismiss();

			}
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}