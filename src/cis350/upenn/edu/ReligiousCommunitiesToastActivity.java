package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ReligiousCommunitiesToastActivity extends Activity implements OnCheckedChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_religious_communities_toast);
		
		//Setup Switches
		Switch ocp = (Switch)findViewById(R.id.ocpSwitch);
		ocp.setChecked(NotificationSignup.signedUpForChannel("OCP", getApplicationContext()));
		ocp.setOnCheckedChangeListener(this);
		Switch cjc = (Switch) findViewById(R.id.cjcSwitch);
		cjc.setChecked(NotificationSignup.signedUpForChannel("CJC", getApplicationContext()));
		cjc.setOnCheckedChangeListener(this);
		Switch rjc = (Switch) findViewById(R.id.rjcSwitch);
		rjc.setChecked(NotificationSignup.signedUpForChannel("RJC", getApplicationContext()));
		rjc.setOnCheckedChangeListener(this);
		Switch shir = (Switch) findViewById(R.id.scSwitch);
		shir.setChecked(NotificationSignup.signedUpForChannel("SC", getApplicationContext()));
		shir.setOnCheckedChangeListener(this);
		Switch syq = (Switch) findViewById(R.id.syqSwitch);
		syq.setChecked(NotificationSignup.signedUpForChannel("SYQ", getApplicationContext()));
		syq.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.religious_communities_toast, menu);
		return true;
	}
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView.getId() == R.id.ocpSwitch){
			if(isChecked)NotificationSignup.addChannel("OCP",getApplicationContext());
			else NotificationSignup.removeChannel("OCP", getApplicationContext());
		}
		if(buttonView.getId() == R.id.cjcSwitch){
			if(isChecked)NotificationSignup.addChannel("CJC",getApplicationContext());
			else NotificationSignup.removeChannel("CJC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.rjcSwitch){
			if(isChecked)NotificationSignup.addChannel("RJC",getApplicationContext());
			else NotificationSignup.removeChannel("RJC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.scSwitch){
			if(isChecked)NotificationSignup.addChannel("SC",getApplicationContext());
			else NotificationSignup.removeChannel("SC", getApplicationContext());
		}
		if(buttonView.getId() == R.id.syqSwitch){
			if(isChecked)NotificationSignup.addChannel("SYQ",getApplicationContext());
			else NotificationSignup.removeChannel("SYQ", getApplicationContext());
		}
	}
}
