package cis350.upenn.edu;

import cis350.upenn.edu.R;
//import cis350.upenn.edu.R.layout;
//import cis350.upenn.edu.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PeopleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_people);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.people, menu);
		return true;
	}

}
