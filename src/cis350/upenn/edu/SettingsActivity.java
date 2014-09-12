package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class SettingsActivity extends Activity implements OnClickListener,OnCheckedChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		//set up Button listeners
		Button religious = (Button) findViewById(R.id.religiousCommunities);
		religious.setOnClickListener(this);
		Button israel = (Button) findViewById(R.id.israel);
		israel.setOnClickListener(this);
		Button socialJustice = (Button) findViewById(R.id.socialJustice);
		socialJustice.setOnClickListener(this);
		Button education = (Button) findViewById(R.id.education);
		education.setOnClickListener(this);
		Button jewishCulture = (Button) findViewById(R.id.jewishCulture);
		jewishCulture.setOnClickListener(this);
		
		//Set up Switch Listeners
		Switch religiousS = (Switch) findViewById(R.id.religiousCommunitiesSwitch);
		religiousS.setChecked(NotificationSignup.signedUpForAllRC(getApplicationContext()));
		religiousS.setOnCheckedChangeListener(this);
		Switch israelS = (Switch) findViewById(R.id.israelSwitch);
		israelS.setChecked(NotificationSignup.signedUpForAllIO(getApplicationContext()));
		israelS.setOnCheckedChangeListener(this);
		Switch socialJusticeS = (Switch) findViewById(R.id.socialJusticeSwitch);
		socialJusticeS.setOnCheckedChangeListener(this);
		socialJusticeS.setChecked(NotificationSignup.signedUpForAllSJ(getApplicationContext()));
		Switch educationS = (Switch) findViewById(R.id.educationSwitch);
		educationS.setChecked(NotificationSignup.signedUpForAllED(getApplicationContext()));
		educationS.setOnCheckedChangeListener(this);
		Switch jewishCultureS = (Switch)findViewById(R.id.jewishCultureSwitch);
		jewishCultureS.setChecked(NotificationSignup.signedUpForAllJC(getApplicationContext()));
		jewishCultureS.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		//check which button is clicked
		if (v.getId() == R.id.religiousCommunities){
			Intent start = new Intent(getApplicationContext(), 
					ReligiousCommunitiesToastActivity.class);
			startActivity(start);
		}
		if (v.getId() == R.id.israel){
			Intent start = new Intent(getApplicationContext(), 
					IsraelToastActivity.class);
			startActivity(start);
		}
		if (v.getId() == R.id.socialJustice){
			Intent start = new Intent(getApplicationContext(), 
					SocialJusticeToastActivity.class);
			startActivity(start);
		}
		if (v.getId() == R.id.education){
			Intent start = new Intent(getApplicationContext(), 
					EducationToastActivity.class);
			startActivity(start);
		}
		if (v.getId() == R.id.jewishCulture){
			Intent start = new Intent(getApplicationContext(), 
					JewishCultureToastActivity.class);
			startActivity(start);
		}

	}
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView.getId() == R.id.religiousCommunitiesSwitch){
			if(isChecked)NotificationSignup.signupAllRC(getApplicationContext());
		}
		if(buttonView.getId() == R.id.israelSwitch){
			if(isChecked)NotificationSignup.signupAllIO(getApplicationContext());
		}
		if(buttonView.getId() == R.id.socialJusticeSwitch){
			if(isChecked)NotificationSignup.signupAllSJ(getApplicationContext());
		}
		if(buttonView.getId() == R.id.educationSwitch){
			if(isChecked)NotificationSignup.signupAllED(getApplicationContext());
		}
		if(buttonView.getId() == R.id.jewishCultureSwitch){
			if(isChecked)NotificationSignup.signupAllJC(getApplicationContext());
		}
	}
}
