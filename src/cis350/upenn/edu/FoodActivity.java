package cis350.upenn.edu;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
//import com.example.hillelapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FoodActivity extends Activity implements OnClickListener {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
      //set up listeners
  		Button menu = (Button) findViewById(R.id.menu);
  		menu.setOnClickListener(this);
  		Button shabbat = (Button) findViewById(R.id.shabbat);
  		shabbat.setOnClickListener(this);
  		new GetHoursTask().execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.food, menu);
        return true;
    }
    
    @Override
	public void onClick(View v) {
		//check which button is clicked
			if (v.getId() == R.id.menu){
				Intent start = new Intent(getApplicationContext(), MenuActivity.class);
				FoodActivity.this.startActivity(start);
			}
			if (v.getId() == R.id.shabbat){
				Intent start = new Intent(getApplicationContext(), ShabbatSignUpActivity.class);
				startActivity(start);
			}
	}
    
    private class GetHoursTask extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... arg0) {
			String url = "http://cms.business-services.upenn.edu/dining/hours-locations-a-menus/kosher-dining-at-falk.html";
			Scraper sc = new HoursScraper();
			Document doc = null;
			try {
				doc = sc.getParseable(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ArrayList<String> results = sc.parseSpecific(doc);
			String hours = "";
			for (String s : results) {
				if (hours == "") {
					hours = s;
				} else {
					hours = hours + ", " + s;
				}
			}
			return hours;
		}
		
		protected void onPostExecute(String hours) {
			TextView tv = (TextView) findViewById(R.id.diningHours);
			tv.setText(hours);
		}
    	
    }
}