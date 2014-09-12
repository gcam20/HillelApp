package cis350.upenn.edu;
import java.util.*;

import cis350.upenn.edu.R.color;
//import com.example.hillelapp.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends Activity implements OnClickListener {

	ArrayList<String> options;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        View lunchHeader = findViewById(R.id.lunchHeader);
		lunchHeader.setOnClickListener(this);
		lunchHeader.setBackgroundColor(color.blue);
		Log.d("DEBUGME", "lunch: " + lunchHeader.getId());
		View dinnerHeader = findViewById(R.id.dinnerHeader);
		dinnerHeader.setBackgroundColor(color.lightBlue);
		dinnerHeader.setOnClickListener(this);
		
		new PopulateMenuTask().execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
	public void onClick(View v) {
    	View lunchList = findViewById(R.id.lunchList);
		View lunchHeader = findViewById(R.id.lunchHeader);
		View dinnerList = findViewById(R.id.dinnerList);
		View dinnerHeader = findViewById(R.id.dinnerHeader);
    	// Show lunch, hide dinner
    	if (v.getId() == R.id.lunchHeader){
			if (lunchList.getVisibility() == View.GONE) {
				lunchList.setVisibility(View.VISIBLE);
				dinnerList.setVisibility(View.GONE);
				lunchHeader.setBackgroundColor(color.blue);
				dinnerHeader.setBackgroundColor(color.lightBlue);
			}
			
		// Show dinner, hide lunch
		} else if (v.getId() == R.id.dinnerHeader){
			if (dinnerList.getVisibility() == View.GONE) {
				lunchList.setVisibility(View.GONE);
				dinnerList.setVisibility(View.VISIBLE);
				lunchHeader.setBackgroundColor(color.lightBlue);
				dinnerHeader.setBackgroundColor(color.blue);
			}
		}
	}
    
    private class PopulateMenuTask extends AsyncTask<Void, Void, ArrayList<String>> {

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
			ArrayList<String> lunchMenu = new ArrayList<String>();
			ArrayList<String> dinnerMenu = new ArrayList<String>();
			boolean dividerFound = false;
			for (String option : options) {
				if (option != "LUNCH_DINNER_DIVIDER" && !dividerFound) {
					lunchMenu.add(option);
				} else if (option != "LUNCH_DINNER_DIVIDER" && dividerFound) {
					dinnerMenu.add(option);
				} else { // option == LUNCH_DINNER_DIVIDER
					dividerFound = true;
				}
			}
			ListView luncList = (ListView) findViewById(R.id.lunchList);
			ListView dinnerList = (ListView) findViewById(R.id.dinnerList);
			ArrayAdapter<String> lunchAdapter = 
					new ArrayAdapter<String>(MenuActivity.this ,
							android.R.layout.simple_list_item_1, lunchMenu);
			ArrayAdapter<String> dinnerAdapter = 
					new ArrayAdapter<String>(MenuActivity.this ,
							android.R.layout.simple_list_item_1, dinnerMenu);
	    	luncList.setAdapter(lunchAdapter);
	    	dinnerList.setAdapter(dinnerAdapter);
		}
		
		/**
		 * Helper method to call different populators and get results
		 * @return
		 */
		private ArrayList<String> getOptions() {
			ArrayList<String> list = new ArrayList<String>();
			try {
				Populator f = new MenuPopulator();
				list = f.populate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return list;
	    	
	    }
    	
    }
}

