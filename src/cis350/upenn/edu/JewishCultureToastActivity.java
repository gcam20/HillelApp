package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class JewishCultureToastActivity extends Activity implements OnCheckedChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jewish_culture_toast);
		
		//Setup Switches
		Switch jb = (Switch)findViewById(R.id.jBagelSwitch);
		jb.setChecked(NotificationSignup.signedUpForChannel("JB", getApplicationContext()));
		jb.setOnCheckedChangeListener(this);
		Switch ps = (Switch) findViewById(R.id.shabbatonesSwitch);
		ps.setChecked(NotificationSignup.signedUpForChannel("PS", getApplicationContext()));
		ps.setOnCheckedChangeListener(this);
		Switch shc = (Switch) findViewById(R.id.shabbatSwitch);
		shc.setChecked(NotificationSignup.signedUpForChannel("ShC", getApplicationContext()));
		shc.setOnCheckedChangeListener(this);
		Switch pt = (Switch) findViewById(R.id.transfersSwitch);
		pt.setChecked(NotificationSignup.signedUpForChannel("PT", getApplicationContext()));
		pt.setOnCheckedChangeListener(this);
		Switch mc = (Switch) findViewById(R.id.marketingSwitch);
		mc.setChecked(NotificationSignup.signedUpForChannel("MC", getApplicationContext()));
		mc.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jewish_culture_toast, menu);
		return true;
	}
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView.getId() == R.id.jBagelSwitch){
			if(isChecked)NotificationSignup.addChannel("JB",getApplicationContext());
			else NotificationSignup.removeChannel("JB", getApplicationContext());
		}
		if(buttonView.getId() == R.id.shabbatonesSwitch){
			if(isChecked)NotificationSignup.addChannel("PS",getApplicationContext());
			else NotificationSignup.removeChannel("PS", getApplicationContext());
		}
		if(buttonView.getId() == R.id.shabbatSwitch){
			if(isChecked)NotificationSignup.addChannel("ShC",getApplicationContext());
			else NotificationSignup.removeChannel("ShC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.transfersSwitch){
			if(isChecked)NotificationSignup.addChannel("PT",getApplicationContext());
			else NotificationSignup.removeChannel("PT", getApplicationContext());
		}
		if(buttonView.getId() == R.id.marketingSwitch){
			if(isChecked)NotificationSignup.addChannel("MC",getApplicationContext());
			else NotificationSignup.removeChannel("MC", getApplicationContext());
		}
	}
}
