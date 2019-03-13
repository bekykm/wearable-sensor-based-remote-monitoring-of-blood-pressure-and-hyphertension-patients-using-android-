package com.example.BPmonitor;

import com.example.diabetcontrol.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class help extends Activity {
EditText e;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
	e=(EditText)findViewById(R.id.txtAdminLoginUname);
/*	e.setText("This app is provides as a support for diabets "
			+ "patients so as the will be notified to the "
			+ "nearest doctors and immidiate support will "
			+ "be given them!\"\r\n");
	e.setTextColor(Color.WHITE); */
	}
}