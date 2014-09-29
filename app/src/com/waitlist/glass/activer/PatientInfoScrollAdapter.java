package com.waitlist.glass.activer;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.glass.widget.CardScrollAdapter;



	public class PatientInfoScrollAdapter extends CardScrollAdapter {
		public enum Card {
			MainInfo, Medications	
		};
		private final Context mContext;
		private LayoutInflater mInflater;
		
		
		// TODO: The patient should be created from an intent with packaged info.
		public Patient mPatient;
		
		private final List<Card> mCards = new ArrayList<Card>();
		
		
		public PatientInfoScrollAdapter(Context context, Patient patient){
			mContext = context;
			mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			mPatient = patient;
			
			mCards.add(Card.MainInfo);
			mCards.add(Card.Medications);
			
		}
		
		@Override
		public int getPosition(Object item) {
			return mCards.indexOf(item);
		}
 
		@Override
		public int getCount() {
			return mCards.size();
		}
 
		@Override
		public Object getItem(int position) {
			return mCards.get(position);
		}


		@Override
		public int getItemViewType(int position){
			return 0;
		}
 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			switch (mCards.get(position)) {
			case MainInfo: 
				convertView = mInflater.inflate(R.layout.patient_main_info, parent);
				TextView nameView = (TextView) convertView.findViewById(R.id.patient_name);
				nameView.setText(mPatient.getName());
				TextView dobView = (TextView) convertView.findViewById(R.id.date_of_birth);
				dobView.setText(Patient.FORMAT.format(mPatient.getDOB()));
				
				TextView allergyView = (TextView) convertView.findViewById(R.id.allergies_list);
				allergyView.setText(mPatient.getAllergies());
				// TODO: Add card info.
				break;
			
			case Medications: 
				convertView = mInflater.inflate(R.layout.medications_layout, parent);
				// TODO: Add card info.
				break;
			}
				
			
			//final Patient patientItem = mPatients.get(position);
			// TODO: Change to a new layout.
			//RelativeLayout itemLayout = (RelativeLayout) LayoutInflater
	        //.from(mContext)
	        //.inflate(R.layout.activity_start_activ_er, parent, false);
			// TODO: Fill layout with patient info.
			//final TextView nameView = (TextView) itemLayout.findViewById(R.id.patientName);
			//nameView.setText(patientItem.getName());
			
			return convertView;
		}
	}