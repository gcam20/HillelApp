package cis350.upenn.edu;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Set up Parse
		Parse.initialize(this, "SLe1mHC9Oz7IrQi0zNbhD3ae6t9ldiOUEbMpp82b", "6TnW2hQAhmUOjrk44JZdc2yU9T0Z8GUEdxSLNf8G");
		PushService.setDefaultPushCallback(this, MainActivity.class);
		ParseInstallation.getCurrentInstallation().saveInBackground();
		//set up listeners
		ImageButton foodIcon = (ImageButton) findViewById(R.id.foodIcon);
		foodIcon.setOnClickListener(this);
		ImageButton settingsIcon = (ImageButton) findViewById(R.id.settingsIcon);
		settingsIcon.setOnClickListener(this);
		ImageButton aboutIcon = (ImageButton) findViewById(R.id.aboutIcon);
		aboutIcon.setOnClickListener(this);
		ImageButton organizationsIcon = (ImageButton) findViewById(R.id.organizationsIcon);
		organizationsIcon.setOnClickListener(this);
		ImageButton storeIcon = (ImageButton) findViewById(R.id.storeIcon);
		storeIcon.setOnClickListener(this);
		ImageButton donateIcon = (ImageButton) findViewById(R.id.donateIcon);
		donateIcon.setOnClickListener(this);
		ImageButton galleryIcon = (ImageButton) findViewById(R.id.galleryIcon);
		galleryIcon.setOnClickListener(this);
		ImageButton eventIcon = (ImageButton) findViewById(R.id.eventsIcon);
		eventIcon.setOnClickListener(this);
		ImageButton signUpIcon = (ImageButton) findViewById(R.id.signUpIcon);
		signUpIcon.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		//check which button is clicked
			if (v.getId() == R.id.foodIcon){
				Intent start = new Intent(getApplicationContext(), FoodActivity.class);
				startActivity(start);
			}else if (v.getId() == R.id.settingsIcon){
				Intent start = new Intent(getApplicationContext(), SettingsActivity.class);
				startActivity(start);
			}
			else if (v.getId() == R.id.aboutIcon){
				Intent start = new Intent(getApplicationContext(), PeopleActivity.class);
				startActivity(start);
			}
			else if (v.getId() == R.id.organizationsIcon) {
				Intent start = new Intent(getApplicationContext(), OrganizationsActivity.class);
				startActivity(start);
			}
			else if (v.getId() == R.id.storeIcon){
				Intent start = new Intent(Intent.ACTION_VIEW, 
						Uri.parse("https://fs19.formsite.com/pennhillel/formPENN_HILLEL_ESTORE/secure_index.html"));
				startActivity(start);

			}
			else if (v.getId() == R.id.donateIcon){
				Intent start = new Intent(Intent.ACTION_VIEW, 
						Uri.parse("https://fs19.formsite.com/pennhillel/donatetoPennHillel/secure_index.html"));
				startActivity(start);

			}
			else if (v.getId() == R.id.galleryIcon){
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100002021006721"));
					startActivity(intent);
				} catch(Exception e) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/penn.hillel.5/photos_all")));
				}
			}
			else if (v.getId() == R.id.eventsIcon){
				Intent start = new Intent(getApplicationContext(),EventActivity.class);
				startActivity(start);
			}
			else if (v.getId() == R.id.signUpIcon){
				Intent start = new Intent(getApplicationContext(), SignUpListActivity.class);
				startActivity(start);

			}
	}

}
