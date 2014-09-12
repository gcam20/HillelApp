package cis350.upenn.edu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OrganizationsActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_organizations);
		
		//set up listeners
		Button israelBtn = (Button) findViewById(R.id.israel);
		israelBtn.setOnClickListener(this);
		Button socialJusticeBtn = (Button) findViewById(R.id.socialJustice);
		socialJusticeBtn.setOnClickListener(this);
		Button educationBtn = (Button) findViewById(R.id.education);
		educationBtn.setOnClickListener(this);
		Button jewishCultureBtn = (Button) findViewById(R.id.jewishCulture);
		jewishCultureBtn.setOnClickListener(this);
		Button religiousCommsBtn = (Button) findViewById(R.id.religiousCommunities);
		religiousCommsBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.organization, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int btn = v.getId();
		if (btn == R.id.israel) {
			Intent start = new Intent(getApplicationContext(), IsraelInfoActivity.class);
			startActivity(start);
		} else if (btn == R.id.socialJustice) {
			Intent start = new Intent(getApplicationContext(), SocialJusticeInfoActivity.class);
			startActivity(start);
		} else if (btn == R.id.education) {
			Intent start = new Intent(getApplicationContext(), EducationInfoActivity.class);
			startActivity(start);
		} else if (btn == R.id.jewishCulture) {
			Intent start = new Intent(getApplicationContext(), JewishCultureInfoActivity.class);
			startActivity(start);
		} else if (btn == R.id.religiousCommunities) {
			Intent start = new Intent(getApplicationContext(), ReligiousCommunitiesInfoActivity.class);
			startActivity(start);
		}
		
	}

}
