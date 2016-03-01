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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class credit extends Activity {
	Spinner spn1;
	String amount1, cardno1, cvv1, id1, type = "x";
	ImageButton btn;
	EditText card, cvv, date;
	TextView amount;
	int a,id;

	String selection = "";
	String pos;
	String[] bank = { "State Bank of India", "Indian Overseas Bank",
			"Canara Bank", "Axis Bank", "Karur Vysya Bank" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.credit);
		Intent i = getIntent();
		a = i.getIntExtra("amount", 0);
		id1 = i.getStringExtra("id");
		type = i.getStringExtra("type");
		System.out.println(type);

		btn = (ImageButton) findViewById(R.id.imageButton1);
		card = (EditText) findViewById(R.id.editText1);
		cvv = (EditText) findViewById(R.id.editText2);
		date = (EditText) findViewById(R.id.editText3);
		amount = (TextView) findViewById(R.id.textView3);
		amount.setText(a + "");
		spn1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, bank);

		spn1.setAdapter(adapter);
		spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				int position = spn1.getSelectedItemPosition();
				pos = bank[+position];
				Toast.makeText(getApplicationContext(),
						"You have selected " + bank[+position],
						Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				amount1 = amount.getText().toString();
				cardno1 = card.getText().toString();
				cvv1 = cvv.getText().toString();

				String url = "";
				try {

					amount1 = URLEncoder.encode(amount1, "UTF-8");
					cardno1 = URLEncoder.encode(cardno1, "UTF-8");
					cvv1 = URLEncoder.encode(cvv1, "UTF-8");
					id1 = URLEncoder.encode(id1, "UTF-8");
					type = URLEncoder.encode(type, "UTF-8");
					if (pos == "State Bank of India") {
						url = "http://10.100.9.232/test.php?cardno="
								+ cardno1.trim() + "&amount=" + amount1.trim()
								+ "&cvv=" + cvv1.trim() + "&id1=" + id1.trim()
								+ "&type=" + type.trim();
					} else if (pos == "Indian Overseas Bank") {
						url = "http://10.100.9.232/ind.php?cardno="
								+ cardno1.trim() + "&amount=" + amount1.trim()
								+ "&cvv=" + cvv1.trim() + "&id1=" + id1.trim()
								+ "&type=" + type.trim();
					} else if (pos == "Canara Bank") {
						url = "http://10.100.9.232/can.php?cardno="
								+ cardno1.trim() + "&amount=" + amount1.trim()
								+ "&cvv=" + cvv1.trim() + "&id1=" + id1.trim()
								+ "&type=" + type.trim();
					} else if (pos == "Axis Bank") {
						url = "http://10.100.9.232/axis.php?cardno="
								+ cardno1.trim() + "&amount=" + amount1.trim()
								+ "&cvv=" + cvv1.trim() + "&id1=" + id1.trim()
								+ "&type=" + type.trim();
					} else if (pos == "Karur Vysya Bank") {
						url = "http://10.100.9.232/karur.php?cardno="
								+ cardno1.trim() + "&amount=" + amount1.trim()
								+ "&cvv=" + cvv1.trim() + "&id1=" + id1.trim()
								+ "&type=" + type.trim();
					}

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
			dialog = new ProgressDialog(credit.this);
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
			// Toast.makeText(getApplicationContext(),
			// result,Toast.LENGTH_LONG).show();
			if (result.equals("false")) {

				// *******************************************************

				Toast.makeText(getApplicationContext(),
						" Please try again later...", Toast.LENGTH_LONG).show();
			} else {
				System.out.println(result);
				Intent i = new Intent(getApplicationContext(), credit.class);
				i.putExtra("amount", a);
				startActivity(i);
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

}
