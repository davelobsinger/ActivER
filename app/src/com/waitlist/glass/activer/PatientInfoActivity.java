package com.waitlist.glass.activer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;


import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollView;



public class PatientInfoActivity extends Activity 
{

	private CardScrollView mCardScrollView;
    private PatientInfoScrollAdapter mAdapter;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
        mCardScrollView = new CardScrollView(this);
        
        Patient mPatient = new Patient(getIntent());
        
        mAdapter = new PatientInfoScrollAdapter(getApplicationContext(), mPatient);
        
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
                openOptionsMenu();
                am.playSoundEffect(Sounds.TAP);
            }
        });
    }	
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patient_menu, menu);
        return true;
    }
	
}