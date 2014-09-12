package cis350.upenn.edu;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

public class SignUpListActivity extends Activity {

	private ArrayList<String> eventArr = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up_list);
		loadEvents();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_list, menu);
		return true;
	}
	
	private void loadEvents() {
		final ListView lv = (ListView) findViewById(R.id.event_lv);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, eventArr);
		lv.setAdapter(adapter);
		Log.d("DEBUGME", "Blank adapter set");
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> eventList, ParseException e) {
		        if (e == null) {
		            Log.d("DEBUGME", "Retrieved " + eventList.size() + " events");
		            for (int i = 0; i < eventList.size(); i++) {
		            	String n = eventList.get(i).getString("Name");
		            	eventArr.add(n);
		            }
		            Log.d("DEBUGME", "Built array: " + eventArr.toString());
		        } else {
		            Log.d("DEBUGME", "Error: " + e.getMessage());
		        }
		    }
		});
		
		Log.d("DEBUGME", "Notifying ListView...");
		((BaseAdapter) lv.getAdapter()).notifyDataSetChanged(); 
		Log.d("DEBUGME", "Notified of changes");
		
		lv.setOnItemClickListener(new ListView.OnItemClickListener() {
	        @Override
	        public void onItemClick(AdapterView<?> a, View v, int i, long l) {
	        	Log.d("DEBUGME", "Clicked on item at index=" + i);
	        	handleClick(i, lv);
	        }
	    });
		
	}
	
	public void handleClick(int i, ListView lv) {
		Object selection = lv.getItemAtPosition(i);
    	Log.d("DEBUGME", "Clicked on object=" + selection.toString());
    	Intent start = new Intent(getApplicationContext(), SignUpActivity.class);
    	start.putExtra("name", selection.toString());
		startActivity(start);
	}

}
