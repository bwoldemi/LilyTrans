package post;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.translili.R;

import data.Parser;
import data.ScheduleList;

public class MyPostedRides extends ActionBarActivity {
	private EditText phoneNumber;
	private Button date;
	private final static  String URL_FOR_SEARCHING_POST_RIDES="http://tutbereket.net/LiliTransport/posted_rides.php";
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_post_rides);
		date = (Button) findViewById(R.id.date_picker_my_post);
		phoneNumber = (EditText) findViewById(R.id.phone_number_my_post);
		listView= (ListView)findViewById(R.id.my_posted_list);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ScheduleList sd=(ScheduleList)parent.getItemAtPosition(position);
				
				Intent intent = new Intent(MyPostedRides.this, ReservedPostRides.class);
				
				intent.putExtra("serviceGroup",sd.getServiceGroup());
				intent.putExtra("id", sd.getTransportID());
				intent.putExtra("starting", sd.getStartingPoint());
				intent.putExtra("destination", sd.getDestinationPoint());
				intent.putExtra("date", sd.getDate());
				
				startActivity(intent);
			
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_post_rides, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void retivePostRides(View view) {
		String d = date.getText().toString();
		String phone = phoneNumber.getText().toString();
		new SearchMyPostAsynckTask().execute(phone,d);
	}

	public static class DatePickerFragment extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {
		private Button datePicker;

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

			datePicker = (Button) getActivity().findViewById(
					R.id.date_picker_my_post);
			String date = Integer.toString(arg3) + "-" + Integer.toString(arg2)
					+ "-" + Integer.toString(arg1);

			datePicker.setText(date);

		}
	}

	public void showDatePickerDialogMYPost(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "Date Picker");
	}
	// Search
	
	private class SearchMyPostAsynckTask extends AsyncTask<String, Void, String> {
		ProgressDialog progressDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog = ProgressDialog.show(MyPostedRides.this,
					"Saving", "Saving....");
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String content = null;
			try {

				System.out.println(params[0]);
				// get the first argument passed to the execute method

				List<NameValuePair> nameValuePaire = new ArrayList<NameValuePair>(
						2);

				nameValuePaire.add(new BasicNameValuePair("phonenumber", params[0]));
				nameValuePaire.add(new BasicNameValuePair("date", params[1]));
				

				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(URL_FOR_SEARCHING_POST_RIDES);
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePaire));

				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				InputStream inputStream = httpEntity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream, "iso-8859-1"), 8);
				StringBuffer stringBuffer = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					stringBuffer.append(line);
				}
				inputStream.close(); // free memory

				content = stringBuffer.toString();
				return content;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}

		}

		@Override
		protected void onPostExecute(String result) {
			progressDialog.setMessage(result);
			progressDialog.dismiss();
		
			System.out.println(result);
			try {
				Parser.parse(result);
				listView.setAdapter(new MyPostRideArrayAdapter(MyPostedRides.this, Parser.parse(result)));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 
	 */
	private class MyPostRideArrayAdapter extends ArrayAdapter<ScheduleList> {
		Vector<ScheduleList> bookedRides;
		Context context;

		public MyPostRideArrayAdapter(Context context,
				Vector<ScheduleList> resource) {
			super(context, R.layout.booked_rides, resource);
			this.bookedRides = resource;
			this.context = context;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflator = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if (convertView == null) {
				convertView = inflator.inflate(R.layout.booked_rides, parent,
						false);
			}

			TextView tvServiceGroup = (TextView) convertView
					.findViewById(R.id.tvBookedServiceGroup);
			TextView tvGroupId = (TextView) convertView
					.findViewById(R.id.tvBookedGroupID);
			TextView tvStartinpoint = (TextView) convertView
					.findViewById(R.id.tvBookedStartingPoint);
			TextView tvDestination = (TextView) convertView
					.findViewById(R.id.tvBookedDestination);
			TextView tvPickupTime = (TextView) convertView
					.findViewById(R.id.tvBookedPickUpTime);
			TextView tvPhoneNumber = (TextView) convertView
					.findViewById(R.id.tvBookedPhoneNumber);

			tvServiceGroup.setText(Html.fromHtml("<b>" + "Type: </b>"
					+ bookedRides.get(position).getServiceGroup()));
			tvGroupId.setText(Html.fromHtml("<b>" + "Id: </b>"
					+ bookedRides.get(position).getTaxiID()));
			tvStartinpoint.setText(Html.fromHtml("<b>" + "Starting Point: </b>"
					+ bookedRides.get(position).getStartingPoint()));
			tvDestination.setText(Html.fromHtml("<b>" + "Destination: </b>"
					+ bookedRides.get(position).getDestinationPoint()));
			tvPickupTime.setText(Html.fromHtml("<b>" + "Pick up Time : </b>"
					+ bookedRides.get(position).getPickUpTime()));
			tvPhoneNumber.setText(Html.fromHtml("<b>" + "Phone number : </b>"
					+ bookedRides.get(position).getPhonenumber()));

			return convertView;
		}
	}
	

}
