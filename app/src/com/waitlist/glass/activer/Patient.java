package com.waitlist.glass.activer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Intent;
import android.net.ParseException;
import android.util.Log;

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
	public final static String TRIAGE = "triage";
	public final static String ALLERGIES = "allegies";
	public final static String MEDS = "meds";
	public final static String TIMEADMITTED = "timeAdmitted";
	public final static String REASON = "visitReason";
	public final static String HISTORY = "history";
	public final static String NOTES = "notes";
	
	public final static SimpleDateFormat FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd", Locale.US);
	
	private String mName = new String();
	private Date mDOB = new Date();
	private String mIssue = new String();
	private Triage mTriage = Triage.GRN;
	private String mBloodPressure= new String();
	private String mAllergies = new String();
	private String mMeds = new String();
	private String mHistory = new String();
	private String mNotes = new String();
	
	Patient(String name){
		mName = name;
	}
	
	Patient(Intent intent) {
		// TODO: Finish unpackaging intent and creating patient object.
		mName = intent.getStringExtra(Patient.PATIENTNAME);
		mTriage = Triage.valueOf(intent.getStringExtra(Patient.TRIAGE));
		mBloodPressure = intent.getStringExtra(Patient.BLOODPRESSURE);
		mIssue = intent.getStringExtra(Patient.REASON);
		mAllergies = intent.getStringExtra(Patient.ALLERGIES);
		mMeds = intent.getStringExtra(Patient.MEDS);
		mHistory = intent.getStringExtra(Patient.HISTORY);
		mNotes = intent.getStringExtra(Patient.NOTES);
		
		try{
			mDOB = FORMAT.parse(intent.getStringExtra(Patient.DOB));
		} catch (java.text.ParseException e) {
			mDOB = new Date();
		}
	}
	
	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}
	
	public void setDOB(String date){
		// 1991-10-07 as string
		try{
			Log.d("PATIENT","Trying to set date of birth: " + date);
			mDOB = FORMAT.parse(date);
		} catch (java.text.ParseException e) {
			Log.d("PATIENT","Parsing exception: " + date);
			mDOB = new Date();
		}
		
	}
	
	public Date getDOB(){
		return mDOB;
	}
	
	public void setIssue(String issue){
		mIssue = issue;
	}
	
	public String getIssue(){
		return mIssue;
	}
		
	public Triage getTriage() {
		return mTriage;
	}

	public void setTriage(Triage triage) {
		mTriage = triage;
	}
	
	public void setBP(String bp){
		mBloodPressure = bp;
	}
	
	public String getBP(){
		return mBloodPressure;
	}
	
	public void setAllergies(String allergies){
		mAllergies = allergies;
	}
	
	public String getAllergies(){
		return mAllergies;
	}
	
	public void setMeds(String meds){
		mMeds = meds;
	}
	
	public String getMeds(){
		return mMeds;
	}
	
	public void setHistory(String history){
		mHistory = history;
	}
	
	public String getHistory(){
		return mHistory;
	}
	
	public void setNotes(String note){
		mNotes = note;
	}
	
	public String getNotes(){
		return mNotes;
	}
	
	public static void packageIntent(Intent intent, String name,
			Triage triage, String issue, String allergies, String date, String bp, String meds, String history, String notes) {

		intent.putExtra(Patient.PATIENTNAME, name);
		intent.putExtra(Patient.TRIAGE, triage.toString());
		intent.putExtra(Patient.BLOODPRESSURE, bp);
		intent.putExtra(Patient.REASON, issue);
		intent.putExtra(Patient.ALLERGIES, allergies);
		intent.putExtra(Patient.MEDS, meds);
		intent.putExtra(Patient.DOB, date);
		intent.putExtra(Patient.HISTORY, history);
		intent.putExtra(Patient.NOTES, notes);
	
	}
	
	
	
}