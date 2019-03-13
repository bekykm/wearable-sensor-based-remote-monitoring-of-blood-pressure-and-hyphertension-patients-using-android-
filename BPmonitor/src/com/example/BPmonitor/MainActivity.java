package com.example.BPmonitor;

import com.example.BPmonitor.*;
import com.example.diabetcontrol.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button doclogin,help,service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doclogin=(Button)findViewById(R.id.doclogin);
		doclogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(),DocLogin.class);
                  startActivity(intent);
			}
		});
		service=(Button)findViewById(R.id.btnservice);
		service.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	Toast toast=Toast.makeText(getApplicationContext(),"List of services provided by app..",Toast.LENGTH_SHORT);
	toast.setMargin(50,50);
	toast.show();	
			}
		});
		help=(Button)findViewById(R.id.btnbroker);
		help.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(getBaseContext(),help.class);
				
				//i.putExtra("check", message);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
