package com.example.BPmonitor;

import com.example.diabetcontrol.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class DocLogin extends Activity {
		// User name
	    EditText Username;
	    // Password
	    EditText Password;
	    // Sign In
	    Button LogIn;
	    // Message
	    TextView tv_Message;

	    @Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.doc_login);
	       
	        // Initialization
	        Username = (EditText) findViewById(R.id.txtAdminLoginUname);
	        Password = (EditText) findViewById(R.id.txtAdminLoginPassword);
	        LogIn = (Button) findViewById(R.id.btnLoginAdmin);
	       // tv_Message = (TextView) findViewById(R.id.tv_Message);
	       
			LogIn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
	                // Stores User name
	                String username = String.valueOf(Username.getText());
	                // Stores Password
	                String password = String.valueOf(Password.getText());
	               
	                // Validates the User name and Password for admin, admin
	                if (username.equals("doc") && password.equals("doc")) {
	              //  	Toast toast=Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT);
	             //  	toast.setMargin(50,50);
	            //    	toast.show();
	              Intent i=new Intent(getApplicationContext(),Afterlogin.class);
                  startActivity(i);
	                } else {
	                	Toast toast=Toast.makeText(getApplicationContext(),"Login UnSuccessful!",Toast.LENGTH_SHORT);
	                	toast.setMargin(50,50);
	                	toast.show();	                }
	            }
	        });
	    }

	}

