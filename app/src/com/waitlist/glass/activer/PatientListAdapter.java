package com.waitlist.glass.activer;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.glass.widget.CardScrollAdapter;



	public class PatientListAdapter extends CardScrollAdapter {
		
		private final Context mContext;
		
		private final List<Patient> mPatients = new ArrayList<Patient>();
		
		public PatientListAdapter(Context context){
			
			mContext = context;
			
		}
		
		public void add(Patient item){
			mPatients.add(item);
		}
		
		@Override
		public int getPosition(Object item) {
			return mPatients.indexOf(item);
		}
 
		@Override
		public int getCount() {
			return mPatients.size();
		}
 
		@Override
		public Patient getItem(int position) {
			return mPatients.get(position);
		}


		@Override
		public int getItemViewType(int position){
			return 0;
		}
 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			final Patient patientItem = mPatients.get(position);
			// TODO: Change to a new layout.
			FrameLayout itemLayout = (FrameLayout) LayoutInflater
	        .from(mContext)
	        .inflate(R.layout.list_patient_layout, parent, false);
			// TODO: Fill layout with patient info.
			final TextView nameView = (TextView) itemLayout.findViewById(R.id.patient_name);
			nameView.setText(patientItem.getName());
			
			TextView triageView = (TextView) itemLayout.findViewById(R.id.triage_level);
			triageView.setText(patientItem.getTriage().toString());
			
			TextView issueView = (TextView) itemLayout.findViewById(R.id.patient_issue);
			issueView.setText(patientItem.getIssue());
			
			return itemLayout;
		}
	}