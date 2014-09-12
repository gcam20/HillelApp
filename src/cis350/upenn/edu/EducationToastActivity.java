package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class EducationToastActivity extends Activity implements OnCheckedChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_education_toast);
		
		
		//Setup Switches
		Switch jlic = (Switch)findViewById(R.id.learningInitiativeSwitch);
		jlic.setChecked(NotificationSignup.signedUpForChannel("JLIC", getApplicationContext()));
		jlic.setOnCheckedChangeListener(this);
		Switch snl = (Switch) findViewById(R.id.sundayNightLearningSwitch);
		snl.setChecked(NotificationSignup.signedUpForChannel("SNL", getApplicationContext()));
		snl.setOnCheckedChangeListener(this);
		Switch hec = (Switch) findViewById(R.id.holocaustSwitch);
		hec.setChecked(NotificationSignup.signedUpForChannel("HEC", getApplicationContext()));
		hec.setOnCheckedChangeListener(this);
		Switch jssc = (Switch) findViewById(R.id.shortStorySwitch);
		jssc.setChecked(NotificationSignup.signedUpForChannel("JSSC", getApplicationContext()));
		jssc.setOnCheckedChangeListener(this);
		Switch dbh = (Switch) findViewById(R.id.divreiBeitSwitch);
		dbh.setChecked(NotificationSignup.signedUpForChannel("DBH", getApplicationContext()));
		dbh.setOnCheckedChangeListener(this);
		Switch tphp = (Switch) findViewById(R.id.hebrewProjectSwitch);
		tphp.setChecked(NotificationSignup.signedUpForChannel("TPHP", getApplicationContext()));
		tphp.setOnCheckedChangeListener(this);
		Switch j101 = (Switch) findViewById(R.id.judaism101Switch);
		j101.setChecked(NotificationSignup.signedUpForChannel("J101", getApplicationContext()));
		j101.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.education_toast, menu);
		return true;
	}
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView.getId() == R.id.learningInitiativeSwitch){
			if(isChecked)NotificationSignup.addChannel("JLIC",getApplicationContext());
			else NotificationSignup.removeChannel("JLIC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.sundayNightLearningSwitch){
			if(isChecked)NotificationSignup.addChannel("SNL",getApplicationContext());
			else NotificationSignup.removeChannel("SNL", getApplicationContext());
		}
		if(buttonView.getId() == R.id.holocaustSwitch){
			if(isChecked)NotificationSignup.addChannel("HEC",getApplicationContext());
			else NotificationSignup.removeChannel("HEC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.shortStorySwitch){
			if(isChecked)NotificationSignup.addChannel("JSSC",getApplicationContext());
			else NotificationSignup.removeChannel("JSSC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.divreiBeitSwitch){
			if(isChecked)NotificationSignup.addChannel("DBH",getApplicationContext());
			else NotificationSignup.removeChannel("DBH", getApplicationContext());
		}
		if(buttonView.getId() == R.id.hebrewProjectSwitch){
			if(isChecked)NotificationSignup.addChannel("TPHP",getApplicationContext());
			else NotificationSignup.removeChannel("TPHP", getApplicationContext());
		}
		if(buttonView.getId() == R.id.judaism101Switch){
			if(isChecked)NotificationSignup.addChannel("J101",getApplicationContext());
			else NotificationSignup.removeChannel("J101", getApplicationContext());
		}
	}

}
