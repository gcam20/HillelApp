package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class IsraelToastActivity extends Activity implements OnCheckedChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_israel_toast);
		
		//Setup Switches
		Switch pipac = (Switch)findViewById(R.id.pipacSwitch);
		pipac.setChecked(NotificationSignup.signedUpForChannel("PIPAC", getApplicationContext()));
		pipac.setOnCheckedChangeListener(this);
		Switch js = (Switch) findViewById(R.id.jStreetSwitch);
		js.setChecked(NotificationSignup.signedUpForChannel("JS", getApplicationContext()));
		js.setOnCheckedChangeListener(this);
		Switch icc = (Switch) findViewById(R.id.iCultSwitch);
		icc.setChecked(NotificationSignup.signedUpForChannel("ICC", getApplicationContext()));
		icc.setOnCheckedChangeListener(this);
		Switch paviv = (Switch) findViewById(R.id.avivSwitch);
		paviv.setChecked(NotificationSignup.signedUpForChannel("PA", getApplicationContext()));
		paviv.setOnCheckedChangeListener(this);
		Switch pfoi = (Switch) findViewById(R.id.friendsSwitch);
		pfoi.setChecked(NotificationSignup.signedUpForChannel("PFOI", getApplicationContext()));
		pfoi.setOnCheckedChangeListener(this);
		Switch tamid = (Switch) findViewById(R.id.tamidSwitch);
		tamid.setChecked(NotificationSignup.signedUpForChannel("TAMID", getApplicationContext()));
		tamid.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.israel_toast, menu);
		return true;
	}
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView.getId() == R.id.pipacSwitch){
			if(isChecked)NotificationSignup.addChannel("PIPAC",getApplicationContext());
			else NotificationSignup.removeChannel("PIPAC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.jStreetSwitch){
			if(isChecked)NotificationSignup.addChannel("JS",getApplicationContext());
			else NotificationSignup.removeChannel("JS", getApplicationContext());
		}
		if(buttonView.getId() == R.id.iCultSwitch){
			if(isChecked)NotificationSignup.addChannel("ICC",getApplicationContext());
			else NotificationSignup.removeChannel("ICC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.avivSwitch){
			if(isChecked)NotificationSignup.addChannel("PA",getApplicationContext());
			else NotificationSignup.removeChannel("PA", getApplicationContext());
		}
		if(buttonView.getId() == R.id.friendsSwitch){
			if(isChecked)NotificationSignup.addChannel("PFOI",getApplicationContext());
			else NotificationSignup.removeChannel("PFOI", getApplicationContext());
		}
		if(buttonView.getId() == R.id.tamidSwitch){
			if(isChecked)NotificationSignup.addChannel("TAMID",getApplicationContext());
			else NotificationSignup.removeChannel("TAMID", getApplicationContext());
		}
	}

}
