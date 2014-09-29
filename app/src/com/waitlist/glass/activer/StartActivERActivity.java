package com.waitlist.glass.activer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import com.waitlist.glass.activer.Patient.Triage;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollView;


public class StartActivERActivity extends Activity 
{
    private CardScrollView mCardScrollView;
    private PatientListAdapter mAdapter;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        mCardScrollView = new CardScrollView(this);
        
        mAdapter = new PatientListAdapter(getApplicationContext());
        // TODO: Create Patient objects to fill here.
        Patient dave = new Patient("David Lobsinger");
        dave.setDOB("1991-10-08");
        dave.setBP("180/15");
        dave.setAllergies("Morphine");
        dave.setMeds("Concerta");
        dave.setTriage(Triage.YEL);
        dave.setIssue("Broken Heart");
        mAdapter.add(dave);
        
        Patient sarah = new Patient("Sarah Core");
        mAdapter.add(sarah);
        //mAdapter.add();
        //mAdapter.add();

        mCardScrollView.setAdapter(mAdapter);
        mCardScrollView.activate();
        setupClickListener();
        setContentView(mCardScrollView);
	}
	
    private void setupClickListener() {
        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	// TODO: Get the patient item, and pass it to the next activity.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                am.playSoundEffect(Sounds.TAP);
                showPatient();

            }
        });
    }
    
    private void showPatient(){
        Intent intent = new Intent(this, PatientInfoActivity.class);
        final Patient selectedPatient = mAdapter.getItem(mCardScrollView.getSelectedItemPosition());
        Patient.packageIntent(intent, selectedPatient.getName(), selectedPatient.getTriage()
        		, selectedPatient.getAllergies(), Patient.FORMAT.format(selectedPatient.getDOB()),selectedPatient.getBP());
        final String name = selectedPatient.getName();
        intent.putExtra("patientName", name);
        startActivity(intent);
    }
	
}
