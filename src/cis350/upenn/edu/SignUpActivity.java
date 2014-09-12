package cis350.upenn.edu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends Activity implements OnClickListener {
	
	private String signUpUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		Button signUpBtn = (Button) findViewById(R.id.event_sign_up_btn);
		signUpBtn.setOnClickListener(this);
		loadInformation(name);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event, menu);
		return true;
	}
	
	private void loadInformation(String name) {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
		query.whereEqualTo("Name", name);
		final String fname = name;
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> eventList, ParseException e) {
		        if (e == null) {
		            Log.d("DEBUGME", "Retrieved " + eventList.size() + " event");
		            for (int i = 0; i < eventList.size(); i++) {
		            	ParseObject event = eventList.get(i);
		            	String description = event.getString("Description");
		            	String location = event.getString("Location");
		            	String contact_name = event.getString("ContactName");
		            	String contact_email = event.getString("ContactEmail");
		            	
		            	Date date = event.getDate("Date");
		            	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		            	dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		            	String date_format = dateFormat.format(date);
		            	
		            	signUpUrl = event.getString("URL");
		            	
		            	TextView name_tv = (TextView) findViewById (R.id.event_name); 
		                name_tv.setText(fname);
		                TextView description_tv = (TextView) findViewById (R.id.event_description); 
		                description_tv.setText(description);
		                TextView location_tv = (TextView) findViewById (R.id.event_location); 
		                location_tv.setText(location);
		                TextView date_tv = (TextView) findViewById (R.id.event_date); 
		                date_tv.setText(date_format);
		                TextView contact_name_tv = (TextView) findViewById (R.id.event_contact_name); 
		                contact_name_tv.setText(contact_name);
		                TextView contact_email_tv = (TextView) findViewById (R.id.event_contact_email); 
		                contact_email_tv.setText(contact_email);
		            }
		        } else {
		            Log.d("DEBUGME", "Error: " + e.getMessage());
		        }
		    }
		});
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.event_sign_up_btn){
			Intent start = new Intent(Intent.ACTION_VIEW, Uri.parse(signUpUrl));
			startActivity(start);
		}
	}

}
