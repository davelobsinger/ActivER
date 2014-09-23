package com.waitlist.glass.activer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;

public class StartActivERActivity extends Activity 
{
    private List<CardBuilder> mCards;
    private CardScrollView mCardScrollView;
    private MyCardScrollAdapter mAdapter;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		createCards();
		
        mCardScrollView = new CardScrollView(this);
        mAdapter = new MyCardScrollAdapter();
        mCardScrollView.setAdapter(mAdapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
	}
	
    private void createCards() {
        mCards = new ArrayList<CardBuilder>();

        mCards.add(new CardBuilder(this, CardBuilder.Layout.TEXT)
                .setText("This card has a footer.")
                .setFootnote("I'm the footer!"));

        mCards.add(new CardBuilder(this, CardBuilder.Layout.TEXT)
        .setText("This is card 2.")
        .setFootnote("I'm the footer!"));

        mCards.add(new CardBuilder(this, CardBuilder.Layout.TEXT)
        .setText("This is card 3.")
        .setFootnote("I'm the footer!"));
    }
	
	private class MyCardScrollAdapter extends CardScrollAdapter {
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
			return mCards.get(position).getItemViewType();
		}
 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return mCards.get(position).getView(convertView, parent);
		}
	}
}
