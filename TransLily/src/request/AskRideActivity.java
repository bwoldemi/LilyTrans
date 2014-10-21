package request;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.example.translili.R;
import com.example.translili.Setting;

public class AskRideActivity extends ActionBarActivity {
	
	private EditText from;
	private EditText to;
	private Button datePicker;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask_ride);
		to = (EditText) findViewById(R.id.to);
		from = (EditText) findViewById(R.id.from);
		datePicker = (Button) findViewById(R.id.datePicker);
		
		
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
			Intent intent = new Intent(this, Setting.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	public void askForRide(View V) {
		if (!checkForms()) {
			Toast.makeText(this, " Please Complete Form", Toast.LENGTH_SHORT).show();
			
		} else {
			Intent intent = new Intent(this, SearchRideActivity.class);
			intent.putExtra("from", from.getText().toString());
			intent.putExtra("to", to.getText().toString());
			intent.putExtra("date", datePicker.getText());
			startActivity(intent);
		}
	}

	public boolean checkForms() {
		if (from.getText().toString().trim().equals("")) {
			return false;
		}
		if (to.getText().toString().trim().equals("")) {
			return false;
		}
		
		if (datePicker.getText().toString().trim()
				.equalsIgnoreCase("Pick date")) {
			return false;
		}

		return true;
	}

	
	public static class DatePickerFragment extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {
		Button datePicker;

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int currentYear = c.get(Calendar.YEAR);
			int currentMonth = c.get(Calendar.MONTH);
			int currentDay = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, currentYear,
					currentMonth, currentDay);
		}

		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			Log.d("arg0", arg0.toString());

			datePicker = (Button) getActivity().findViewById(R.id.datePicker);
			String date = Integer.toString(arg3) + "-" + Integer.toString(arg2)
					+ "-" + Integer.toString(arg1);

			datePicker.setText(date);

		}
	}

	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "Date Picker");
	}

}
