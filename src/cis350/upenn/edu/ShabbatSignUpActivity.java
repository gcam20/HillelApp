package cis350.upenn.edu;

import com.parse.ParseInstallation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ShabbatSignUpActivity extends Activity implements OnClickListener{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shabbat_sign_up);
        Button submit = (Button)findViewById(R.id.submitshabbat);
        submit.setOnClickListener(this);
        RadioButton r1 = (RadioButton)findViewById(R.id.swipes);
        r1.setOnClickListener(this);
        RadioButton r2 = (RadioButton)findViewById(R.id.dollars);
        r2.setOnClickListener(this);
        setupFields();
    }
	public void setupFields(){
    	ParseInstallation installation = ParseInstallation.getCurrentInstallation();
    	String name = (String) installation.get("name");
    	String email = (String) installation.get("email");
    	String pennnum = (String) installation.get("pennnum");
    	if(name != null && name != ""){
        	EditText name1 = (EditText)findViewById(R.id.name);
        	name1.setText(name);
    	}
    	if(email != null && email != ""){
        	EditText email1 = (EditText)findViewById(R.id.email);
        	email1.setText(email);
    	}
    	if(pennnum != null && pennnum != ""){
        	EditText pennnum1 = (EditText)findViewById(R.id.pennnum);
        	pennnum1.setText(pennnum);
    	}
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_up, menu);
        return true;
    }
    @Override
	public void onClick(View v) {
    	if(v.getId() == R.id.submitshabbat){
        	Toast.makeText(this, "Form Submission Success!", Toast.LENGTH_LONG).show();
        	ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        	EditText name = (EditText)findViewById(R.id.name);
        	EditText email = (EditText)findViewById(R.id.email);
        	EditText pennnum = (EditText)findViewById(R.id.pennnum);
        	CheckBox checked = (CheckBox)findViewById(R.id.save);
        	if(checked.isChecked()){
        		installation.put("name", name.getText().toString());
        		installation.put("email", email.getText().toString());
        		installation.put("pennnum",pennnum.getText().toString());
        		installation.saveInBackground();
        	}
        	finish();
    	}
    	else{
    		onRadioButtonClicked(v);
    	}
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        
        switch(view.getId()) {
            case R.id.dollars:
                if (checked){
                	RadioButton other = (RadioButton)findViewById(R.id.swipes);
                	other.setChecked(false);
                }
                break;
            case R.id.swipes:
                if (checked)
                {
                	RadioButton other = (RadioButton)findViewById(R.id.dollars);
                	other.setChecked(false);
                }
                break;
        }
    }
}
