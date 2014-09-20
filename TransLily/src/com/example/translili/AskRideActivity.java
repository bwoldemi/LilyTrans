package com.example.translili;

import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AskRideActivity extends ActionBarActivity {

	TextView userProfile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask_ride);
		
		userProfile=(TextView) findViewById(R.id.userProfile);
		
		String name= getIntent().getStringExtra("name");
		String from=getIntent().getStringExtra("from");
		String to=getIntent().getStringExtra("to");
		String phoneNumber=getIntent().getStringExtra("contact");
		String date= getIntent().getStringExtra("date");
		
		userProfile.setText(Html.fromHtml(name+"<br/>"+from+"<br/>"+to+"<br/>"+phoneNumber + date));
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ask_ride, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}