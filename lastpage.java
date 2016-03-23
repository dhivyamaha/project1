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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class lastpage extends Activity {
	Button b;
    TextView name,type1,id1,vehicle,passtype,amount,status,p,q,r;
    String uname="",type="",id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.lastpage);
	    Intent i = getIntent();
	    uname = i.getStringExtra("uname");
		System.out.println(uname);
		type = i.getStringExtra("type");
		System.out.println(type);
		id = i.getStringExtra("id");
		System.out.println(id);
		name = (TextView)findViewById(R.id.textView10);
	    name.setText(uname);
	    type1 =  (TextView)findViewById(R.id.textView11);
	    type1.setText(type);
	    id1 =  (TextView)findViewById(R.id.textView9);
	    id1.setText(id);
	    p =  (TextView)findViewById(R.id.textView3);
	    q =  (TextView)findViewById(R.id.textView2);
	    r =  (TextView)findViewById(R.id.textView4);
	    vehicle =  (TextView)findViewById(R.id.textView12);
	    passtype =  (TextView)findViewById(R.id.textView13);
	    amount =  (TextView)findViewById(R.id.textView14);
	    status =  (TextView)findViewById(R.id.textView15);
	    
	    
	    
	    b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
	 
			public void onClick(View v) {
				
				try {
					uname = URLEncoder.encode(uname, "UTF-8");
					type = URLEncoder.encode(type, "UTF-8");
					id = URLEncoder.encode(id, "UTF-8");		
					String url = "http://10.100.9.232/last.php?uname=" + uname.trim()
							+ "&type=" + type.trim()
							+ "&id=" + id.trim();
					System.out.println(url);
					pass_value_to_db get = new pass_value_to_db();
					get.execute(new String[] { url });

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	private class pass_value_to_db extends AsyncTask<String, Void, String> {

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() { // TODO Auto-generated method stub
			dialog = new ProgressDialog(lastpage.this);
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

			if (result.equals("false")) {

				// *******************************************************

				Toast.makeText(getApplicationContext(),
						" Please try again later...", Toast.LENGTH_LONG).show();
			} else {
				System.out.println(result);
				String[] value = result.split("@@@@");
				for (int i = 0; i < value.length; i++) {
					System.out.println(value[i]);
				}
			    vehicle.setText(value[0]);
			    passtype.setText(value[1]);
				amount.setText(value[2]);
		   		status.setText(value[3]);

			}

			if (dialog != null)
				dialog.dismiss();

		}
	}

}
