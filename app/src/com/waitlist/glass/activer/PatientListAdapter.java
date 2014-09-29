package com.waitlist.glass.activer;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
			RelativeLayout itemLayout = (RelativeLayout) LayoutInflater
	        .from(mContext)
	        .inflate(R.layout.activity_start_activ_er, parent, false);
			// TODO: Fill layout with patient info.
			final TextView nameView = (TextView) itemLayout.findViewById(R.id.patientName);
			nameView.setText(patientItem.getName());
			
			return itemLayout;
		}
	}