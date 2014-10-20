package post;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.translili.R;

import data.BookedSchedule;
import data.Parser;

public class ReservedPostRides extends Activity {
	final static String URL_RESERVED_RIDES = "";
	Vector<BookedSchedule> bookedSchedules;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reserved_post_rides);
		listView=(ListView)findViewById(R.id.listView_reserved_post);
		TextView tv = (TextView) findViewById(R.id.tv_ride_post_info);
		// int transportId= getIntent().getIntExtra("id", 0);
		String starting = getIntent().getStringExtra("starting");

		tv.setText(starting);
		 if(getIntent().getIntExtra("id", 0)!=0){
			 new SearchMyPostAsynckTask().execute(Integer.toString(39));
		 }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.reserved_post_rides, menu);
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

	private class SearchMyPostAsynckTask extends
			AsyncTask<String, Void, String> {
		ProgressDialog progressDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog = ProgressDialog.show(ReservedPostRides.this,
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
						1);

				nameValuePaire.add(new BasicNameValuePair("id", params[0]));

				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(URL_RESERVED_RIDES);
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
			try {
				bookedSchedules = Parser.parseBookedRides(result);
				listView.setAdapter(new ReservedPostRidesArrayAdapter(ReservedPostRides.this, bookedSchedules));
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(result);

		}

	}

	private class ReservedPostRidesArrayAdapter extends ArrayAdapter<BookedSchedule> {
		
		Vector<BookedSchedule> bookedRides;
		Context context;

		public ReservedPostRidesArrayAdapter(Context context,
				Vector<BookedSchedule> resource) {
			super(context, R.layout.list_user_books, resource);
			this.bookedRides = resource;
			this.context = context;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflator = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			if (convertView == null) {
				convertView = inflator.inflate(R.layout.list_user_books, parent,
						false);
			}
			
			TextView tvName= (TextView)findViewById(R.id.tv_name_rserved_post_rides);
			TextView tvPhoneNumber=(TextView)findViewById(R.id.tv_phonenuber_rserved_post_rides);
			TextView tvStatus=(TextView)findViewById(R.id.tv_status_rserved_post_rides);
//			Button approveButton= (Button)findViewById(R.id.button_approve_rserved_post_rides);
//			Button cancelButton=(Button)findViewById(R.id.button_cancel_rserved_post_rides);
			
			tvName.setText(bookedRides.get(position).getName());
			tvPhoneNumber.setText(bookedRides.get(position).getPhonenumber());
			tvStatus.setText(bookedRides.get(position).getStatus());
			
			return convertView;
		}
	}
}
