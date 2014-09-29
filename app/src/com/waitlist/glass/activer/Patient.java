package com.waitlist.glass.activer;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;

//Didn't make a constructor yet, as I'm not sure what type I want to 
//	make the dates, times and bloodpressures.
public class  Patient{

	public enum Triage {
			RED, YEL, GRN, WHT, BLK
			/*
			RED = Immediate - Cannot survive without immediate treatment, 
			have chance of survival
			YEL = Observation - Stable, treated immediately under normal
			circumstances
			GRN = 
			WHT 
			BLK
			*/
			
	};

	
	public final static String PATIENTNAME = "patientName";
	public final static String DOB = "dateofBirth";
	public final static String BLOODPRESSURE = "bloodPressure";
	public final static String TIMEADMITTED = "timeAdmitted";
	public final static String REASON = "visitReason";
	
	private String mName = new String();
	private Triage mTriage = Triage.GRN;
	private String mTimeAdmitted = new String();
	
	Patient(String name){
		mName = name;
	}
	
	Patient(Intent intent) {

		mName = intent.getStringExtra(Patient.PATIENTNAME);
		//mPriority = Priority.valueOf(intent.getStringExtra(ToDoItem.PRIORITY));
		//mStatus = Status.valueOf(intent.getStringExtra(ToDoItem.STATUS));

		/*try {
			mDate = ToDoItem.FORMAT.parse(intent.getStringExtra(ToDoItem.DATE));
		} catch (ParseException e) {
			mDate = new Date();
		}*/
	}
	
	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public Triage getTraige() {
		return mTriage;
	}

	public void setTriage(Triage triage) {
		mTriage = triage;
	}
	
}