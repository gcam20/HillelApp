package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class JewishCultureInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jewish_culture_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jewish_culture_info, menu);
		return true;
	}

}
