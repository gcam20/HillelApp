package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class IsraelInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_israel_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.israel_info, menu);
		return true;
	}

}
