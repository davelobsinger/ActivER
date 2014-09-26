package com.waitlist.glass.activer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;


import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollView;



public class PatientInfoActivity extends Activity 
{

	private CardScrollView mCardScrollView;
    private PatientListAdapter mAdapter;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
        mCardScrollView = new CardScrollView(this);
        
        mAdapter = new PatientListAdapter(getApplicationContext());
        // TODO: Create Patient objects to fill here.
        mAdapter.add();
        mAdapter.add();
        mAdapter.add();
        
        Log.d("PATIENT ACTIVITY","CardScrollAdapter Created");
        
        mCardScrollView.setAdapter(mAdapter);
        mCardScrollView.activate();
        setupClickListener();
        setContentView(mCardScrollView);
	}
	
    private void setupClickListener() {
        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.TAP);
            }
        });
    }	
	
}