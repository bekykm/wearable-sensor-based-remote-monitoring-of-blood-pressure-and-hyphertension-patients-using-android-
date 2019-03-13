package com.example.BPmonitor;

import com.example.BPmonitor.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Afterlogin extends Activity {
	Button display,help,register,update;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.after_login);
	register=(Button)findViewById(R.id.add);
	register.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getBaseContext(),Patientreg.class);
              startActivity(intent);
		}
	});
	
}
}