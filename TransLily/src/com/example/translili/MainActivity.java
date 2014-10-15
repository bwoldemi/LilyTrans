package com.example.translili;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * getFragmentManager().beginTransaction()
		 * .replace(android.R.id.content, new SettingFragment()) .commit();
		 * SharedPreferences sharedPref =
		 * PreferenceManager.getDefaultSharedPreferences(this);
		 */

	}

	public void requestRide(View view) {
		Intent intent = new Intent(this, AskRideActivity.class);
		startActivity(intent);
	}

	public void postRide(View view) {
		
		Intent intent = new Intent(this, PostRideActivity.class);
		startActivity(intent);
	}

	public void myRequestRides(View view) {
		Intent intent = new Intent(this, BookedRideActivity.class);
		startActivity(intent);

	}

	public void myPostRides(View view) {
		Intent intent = new Intent(this, AskRideActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Setting, about page
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// public class SettingFragment extends PreferenceFragment {
	// @Override
	// public void onCreate(Bundle savedInstanceState) {
	// // TODO Auto-generated method stub
	// super.onCreate(savedInstanceState);
	// addPreferencesFromResource(R.xml.preferences);
	//
	// }
	// }

}
