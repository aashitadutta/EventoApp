package com.example.eventmanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class EventSuggestion extends BaseActivity {
    String subject = "test";
    String body = "";
    String to="aashitadutta@gmail.com";
	EditText editTextEventName,editTextDescription,editTextShortDescription,editTextDate,
	editTextVenue,editTextOrganizers,editTextPhone,editTextPrize;
	Button btnsubmit;
	CreateEvent createEvent;
	private DatePickerDialog datePicker;
	private SimpleDateFormat dateFormatter;
	 private String[] navMenuTitles;
		private TypedArray navMenuIcons;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_suggestion);
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items_users); // load
		// titles
		// from
		// strings.xml

	navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);// load icons from
	// strings.xml

	set(navMenuTitles, navMenuIcons);
		dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        editTextEventName=(EditText)findViewById(R.id.userTextEventName);
		editTextDescription=(EditText)findViewById(R.id.usereditDescription);
		editTextShortDescription=(EditText)findViewById(R.id.userTextShortDescription);
		editTextDate=(EditText) findViewById(R.id.userTextDate);
		editTextVenue=(EditText) findViewById(R.id.userTextVenue);
		editTextOrganizers=(EditText) findViewById(R.id.userTextOrganizer);
		editTextPhone=(EditText) findViewById(R.id.userTextContacts);
		editTextPrize=(EditText) findViewById(R.id.userTextPrize);
		btnsubmit=(Button)findViewById(R.id.buttonSubmitEvent);
		btnsubmit.setOnClickListener(new View.OnClickListener() {
			 
			public void onClick(View v) {
			String event_name=editTextEventName.getText().toString();
				String description=editTextDescription.getText().toString();
				String short_desc=editTextShortDescription.getText().toString();
				String contacts=editTextPhone.getText().toString();
				String date=editTextDate.getText().toString();
				String venue=editTextVenue.getText().toString();
				String prize=editTextPrize.getText().toString();
				String organizers=editTextOrganizers.getText().toString();
				body = "EVENTNAME = " + event_name + " " + "DESCRIPTION = " + description + " " + "SHORT_DESCRIPTION = " + short_desc
						+ " " + "DATE = " + date + " " + "VENUE = " + venue + " " + "PRIZE = " + prize + " " + "ORGANIZERS = " + organizers
						+ " " + "PHONE = " + contacts;
				if(event_name.equals("")||description.equals("")||short_desc.equals("")||date.equals("")||venue.equals("")||organizers.equals("")||contacts.equals("")||prize.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
						return;
				}
				else
				{	
					/*Intent sendIntent = new Intent(Intent.ACTION_SEND);
					sendIntent.setType("plain/text");
					sendIntent.setData(Uri.parse(to));
					sendIntent.setPackage("com.google.android.gm");
					//sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
					sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
					sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
					sendIntent.putExtra(Intent.EXTRA_TEXT, body);
					startActivity(sendIntent);*/
				            Intent email = new Intent(Intent.ACTION_SEND);  
				            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});  
				            email.putExtra(Intent.EXTRA_SUBJECT, subject);  
				            email.putExtra(Intent.EXTRA_TEXT, body);  
				 
				            //need this to prompts email client only  
				            email.setType("message/rfc822");  
				 
				            startActivity(Intent.createChooser(email, "Choose an Email client :")); 
					 
				    
				    Toast.makeText(getApplicationContext(), "Event Successfully Created ", Toast.LENGTH_LONG).show();
				    
				}
				
			}
			
		});
		//findViewsById();
		 //setDateTimeField();
		}
	/*private void findViewsById() {
		editTextDate=(EditText) findViewById(R.id.editTextDate);  
		editTextDate.setInputType(InputType.TYPE_NULL);
		
	}*/
	/*private void setDateTimeField() {
		editTextDate.setOnClickListener(this);
		Calendar newCalendar = Calendar.getInstance();
        datePicker = new DatePickerDialog(this, new OnDateSetListener() {
 
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editTextDate.setText(dateFormatter.format(newDate.getTime()));
            }
 
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
	}
	@Override
	public void onClick(View view) {
		 if(view == editTextDate) {
	            datePicker.show();
		
	}
		 
	}*/
				}

