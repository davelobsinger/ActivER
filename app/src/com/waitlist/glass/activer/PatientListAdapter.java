package com.waitlist.glass.activer;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.glass.widget.CardScrollAdapter;



	public class PatientListAdapter extends CardScrollAdapter {
		
		private final Context mContext;
		
		private final List<RelativeLayout> mViews = new ArrayList<RelativeLayout>();
		
		public PatientListAdapter(Context context){
			
			mContext = context;
			
		}
		
		public void add(){
			RelativeLayout card1 = new RelativeLayout(mContext);
			mViews.add(card1);
		}
		
		@Override
		public int getPosition(Object item) {
			return mViews.indexOf(item);
		}
 
		@Override
		public int getCount() {
			return mViews.size();
		}
 
		@Override
		public Object getItem(int position) {
			return mViews.get(position);
		}


		@Override
		public int getItemViewType(int position){
			return 0;
		}
 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			RelativeLayout itemLayout = (RelativeLayout) LayoutInflater
	        .from(mContext)
	        .inflate(R.layout.activity_start_activ_er, parent, false);
			
			return itemLayout;
		}
	}