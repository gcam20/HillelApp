package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SocialJusticeToastActivity extends Activity implements OnCheckedChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social_justice_toast);
		
		//Setup Switches
		Switch bbbs = (Switch)findViewById(R.id.bigSwitch);
		bbbs.setChecked(NotificationSignup.signedUpForChannel("BBBS", getApplicationContext()));
		bbbs.setOnCheckedChangeListener(this);
		Switch ocpc = (Switch) findViewById(R.id.ocpChessedSwitch);
		ocpc.setChecked(NotificationSignup.signedUpForChannel("OCPC", getApplicationContext()));
		ocpc.setOnCheckedChangeListener(this);
		Switch sk = (Switch) findViewById(R.id.soupKitchenSwitch);
		sk.setChecked(NotificationSignup.signedUpForChannel("SK", getApplicationContext()));
		sk.setOnCheckedChangeListener(this);
		Switch atid = (Switch) findViewById(R.id.atidSwitch);
		atid.setChecked(NotificationSignup.signedUpForChannel("ATID", getApplicationContext()));
		atid.setOnCheckedChangeListener(this);
		Switch eco = (Switch) findViewById(R.id.ecoSwitch);
		eco.setChecked(NotificationSignup.signedUpForChannel("HE", getApplicationContext()));
		eco.setOnCheckedChangeListener(this);
		Switch prs = (Switch) findViewById(R.id.sunshineSwitch);
		prs.setChecked(NotificationSignup.signedUpForChannel("PrS", getApplicationContext()));
		prs.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.social_justice_toast, menu);
		return true;
	}
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView.getId() == R.id.bigSwitch){
			if(isChecked)NotificationSignup.addChannel("BBBS",getApplicationContext());
			else NotificationSignup.removeChannel("BBBS", getApplicationContext());
		}
		if(buttonView.getId() == R.id.ocpChessedSwitch){
			if(isChecked)NotificationSignup.addChannel("OCPC",getApplicationContext());
			else NotificationSignup.removeChannel("OCPC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.soupKitchenSwitch){
			if(isChecked)NotificationSignup.addChannel("SK",getApplicationContext());
			else NotificationSignup.removeChannel("SK", getApplicationContext());
		}
		if(buttonView.getId() == R.id.atidSwitch){
			if(isChecked)NotificationSignup.addChannel("ATID",getApplicationContext());
			else NotificationSignup.removeChannel("ATID", getApplicationContext());
		}
		if(buttonView.getId() == R.id.ecoSwitch){
			if(isChecked)NotificationSignup.addChannel("HE",getApplicationContext());
			else NotificationSignup.removeChannel("HE", getApplicationContext());
		}
		if(buttonView.getId() == R.id.sunshineSwitch){
			if(isChecked)NotificationSignup.addChannel("PrS",getApplicationContext());
			else NotificationSignup.removeChannel("PrS", getApplicationContext());
		}
	}
}
