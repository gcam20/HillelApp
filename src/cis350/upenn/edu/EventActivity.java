package cis350.upenn.edu;
import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class EventActivity extends Activity implements OnClickListener {

	private ArrayList<String> eventArr = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		new PopulateCalendarTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event, menu);
		return true;
	}
	public ArrayList<String> getEventArr(){
		return eventArr;
	}
	private void setUpCalendar(){
		final ListView lv = (ListView) findViewById(R.id.event_lv);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventArr);
		lv.setAdapter(adapter);
		((BaseAdapter) lv.getAdapter()).notifyDataSetChanged(); 
		lv.setOnItemClickListener(new ListView.OnItemClickListener() {
	        @Override
	        public void onItemClick(AdapterView<?> a, View v, int i, long l) {
	        	Log.d("DEBUGME", "Clicked on item at index=" + i);
	        	handleClick(i, lv);
	        }
	    });
	}
	
	
	@Override
	public void onClick(View v) {
		
	}
	public void handleClick(int i, ListView lv) {
		Object selection = lv.getItemAtPosition(i);
    	Log.d("DEBUGME", "Clicked on object=" + selection.toString());
	}
	private class PopulateCalendarTask extends AsyncTask<Void, Void, ArrayList<String>> {

	    	/**
	    	 * Calls on populator which calls on a scraper to populate the listview
	    	 */
			@Override
			protected ArrayList<String> doInBackground(Void... params) {
				// Event activity whose list is being populated
				ArrayList<String> options = getOptions();
				return options;
			}
			
			/**
			 * Takes in list of event options from the scraper to populate events list
			 */
			@Override
			protected void onPostExecute(ArrayList<String> options) {
				eventArr.addAll(options);
				setUpCalendar();
			}
			
			/**
			 * Helper method to call different populators and get results
			 * @return
			 */
			private ArrayList<String> getOptions() {
				ArrayList<String> list = new ArrayList<String>();
				try {
					Populator f = new CalendarPopulator();
					list = f.populate();
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	return list;
		    	
		    }
	    	
	    }
}
