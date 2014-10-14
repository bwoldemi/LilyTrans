package menuActivities;

import lily.homecare.R;
import lily.homecare.R.id;
import lily.homecare.R.layout;
import lily.homecare.R.menu;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class History extends Activity {
	TextView textViewHistory;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		textViewHistory= (TextView)findViewById(R.id.textViewHistory);
		textViewHistory.setMovementMethod(new ScrollingMovementMethod());
		textViewHistory.setText(Html.fromHtml(getIntent().getExtras().getString("history", "No History")));
	}
}