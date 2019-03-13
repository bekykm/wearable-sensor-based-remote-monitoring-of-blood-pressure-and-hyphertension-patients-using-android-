package com.example.BPmonitor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Patientreg extends Activity {
	EditText fname,lname,phone,address,bemail,level,status;
	Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.patientreg);
	fname=(EditText)findViewById(R.id.fname);
    lname=(EditText)findViewById(R.id.lname);
    phone=(EditText)findViewById(R.id.pphone);
    address=(EditText)findViewById(R.id.padress);
    level=(EditText)findViewById(R.id.BPlevel);
    status=(EditText)findViewById(R.id.BPstatus);
}
	
	 public void reg(View v) {
		 String fn=fname.getText().toString();
	     String p=phone.getText().toString();

		 String ln=lname.getText().toString();
	     String add=address.getText().toString();
	     String l=level.getText().toString();
	     String s=status.getText().toString();;
	     
			
				if (fname.length()==0) {
					fname.setError("Enter your first name!");
				}
				else 
					if (lname.length()==0) {
						lname.setError("Enter your last name!");
					}else 
					if (!isValidPhone(p)) {
						phone.setError("Invalid Phone");
					}
					else 
						if (address.length()==0) {
							address.setError("Enter your address name!");
						}
	     else{
		Regbackground backwork=new Regbackground(this);
		backwork.execute(type,fn,ln,p,add,l,s);
		} 
	     }
	
		private boolean isValidPhone(String p) {
			if(!TextUtils.isEmpty(p)){
				return Patterns.PHONE.matcher(p).matches();
			}
			return false;
		}	 
	 
String type="register";
	     
	class Regbackground extends AsyncTask<String,Void,String> {
		Context context;
		AlertDialog al;
		ProgressDialog pdLoading;
		public Regbackground(Context ctx) {
			context=ctx;
		}
			protected String doInBackground(String... params) {
			String type=params[0];
			//String regurl="http://10.141.95.37/broker/regcustomer.php";
			String regurl="http://10.140.150.59/BPcontroller/regpatient.php";

		 if(type.equals("register")){
			try{
				URL url=new URL(regurl);
				HttpURLConnection con=(HttpURLConnection)url.openConnection();
			    con.setRequestMethod("POST");
			    con.setDoOutput(true);
			    con.setDoInput(true);
			    OutputStream o=con.getOutputStream();
			    BufferedWriter w=new BufferedWriter(new OutputStreamWriter(o,"UTF-8"));
			    Uri.Builder builder = new Uri.Builder().appendQueryParameter("fname", params[1])
			    		.appendQueryParameter("lname", params[2])
		                .appendQueryParameter("phone", params[3])
		                .appendQueryParameter("address", params[4]).appendQueryParameter("level", params[5]).appendQueryParameter("status", params[6]);
		       String query2 = builder.build().getEncodedQuery(); 
		        w.write(query2);
			      w.flush();
			      w.close();
			      o.close();
			      InputStream i=con.getInputStream();
			      BufferedReader r=new BufferedReader(new InputStreamReader(i,"UTF-8"));
			      String res="";
			      String line;
			      while((line=r.readLine())!=null){
			    	  res +=line;
			    	  
			      }
			      r.close();
			      i.close();
			      con.disconnect();
			      return res;
			}
			catch(MalformedURLException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}	
		}   
		return null;
	}
	 protected void onPreExecute(){
		al= new AlertDialog.Builder(context).create() ;
	    al.setTitle("Registration status!"); 
	    pdLoading=new ProgressDialog(context );
		pdLoading.setMessage("\tRegistering...");
	    pdLoading.setCancelable(true);
	    pdLoading.show();
	 }
	 protected void onPostExecute(String result) {
		al.setMessage(result);
		al.show();
	    pdLoading.dismiss();

		Toast.makeText(getBaseContext(),"Successfully registered!",Toast.LENGTH_LONG).show();
		SmsManager sms=SmsManager.getDefault();
		sms.sendTextMessage(phone.getText().toString(), null,"Hello Dear "+fname.getText().toString()+", your blood pressure level is: "+level.getText().toString()+", which is: "+status.getText().toString(), null, null);
	//	Toast.makeText(getApplicationContext(), " Blood pressure status !",Toast.LENGTH_LONG).show();

	/*	Intent i=new Intent(getApplicationContext(),CreateAccount2.class);
		   startActivity(i);
		   finish(); */
		}
	 protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}
}		
		
}

/*
register=(Button)findViewById(R.id.add); //require modification
	register.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getBaseContext(),Patientreg.class);
              startActivity(intent);
		}
	});
*/