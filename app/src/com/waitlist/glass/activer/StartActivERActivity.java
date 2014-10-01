package com.waitlist.glass.activer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
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
        
        createPatients();
        //Intent serviceIntent =new Intent(this, EmergService.class);
        //startService(serviceIntent);

        mCardScrollView.setAdapter(mAdapter);
        mCardScrollView.activate();
        setupClickListener();
        setContentView(mCardScrollView);
	}
	
	private void createPatients() {
		Patient p3 = new Patient("Johnathon Blouin");
        p3.setDOB("1953-06-08");
        p3.setBP("143/92");
        p3.setAllergies("");
        p3.setMeds("Procardia XL\nAvandia");
        p3.setTriage(Triage.RED);
        p3.setIssue("Chest pain, signs of cardiac arrest");
        p3.setHistory("Hypertension\nCoronary bypass");
        mAdapter.add(p3);
        
        Patient p2 = new Patient("Desmond Ebeling");
        p2.setDOB("1985-10-15");
        p2.setBP("131/78");
        p2.setAllergies("Penicillin");
        p2.setMeds("None");
        p2.setTriage(Triage.YEL);
        p2.setIssue("Dislocated shoulder, possible fracture");
        p2.setHistory("Strep Throat\nConcussion");
        mAdapter.add(p2);
        
        Patient p5 = new Patient("Krista Nyberg");
        p5.setDOB("1993-08-30");
        p5.setBP("118/79");
        p5.setAllergies("");
        p5.setMeds("Concerta\nYasmin");
        p5.setTriage(Triage.YEL);
        p5.setIssue("Severe abdonimal pain");
        p5.setHistory("Alcohol Poisoning\n");
        mAdapter.add(p5);
        
        Patient p6 = new Patient("Hunter Nyles");
        p6.setDOB("1989-12-23");
        p6.setBP("127/83");
        p6.setAllergies("");
        p6.setMeds("Possible opioid use");
        p6.setTriage(Triage.YEL);
        p6.setIssue("Nausea, decreased consciousness");
        p6.setHistory("Narcotics use\nHepatitis");
        mAdapter.add(p6);
        
        Patient p1 = new Patient("Jenna Borda");
        p1.setDOB("1976-02-01");
        p1.setBP("116/73");
        p1.setAllergies("");
        p1.setMeds("Celebrex");
        p1.setTriage(Triage.GRN);
        p1.setIssue("Sore throat, wheezing, shortness of breath");
        p1.setHistory("Angina\nAsthma");
        mAdapter.add(p1);
        
          
              
        Patient p4 = new Patient("Allison Swinton");
        p4.setDOB("1959-03-19");
        p4.setBP("122/83");
        p4.setAllergies("Insulin");
        p4.setMeds("Magnesium");
        p4.setTriage(Triage.GRN);
        p4.setIssue("Hives on lower back, skin irritation");
        p4.setHistory("Bladder infection");
        mAdapter.add(p4);
        
        
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
        
        Patient.packageIntent(intent, selectedPatient.getName(), selectedPatient.getTriage(), 
        		selectedPatient.getIssue(), selectedPatient.getAllergies(), Patient.FORMAT.format(selectedPatient.getDOB()),
        		selectedPatient.getBP(), selectedPatient.getMeds(), selectedPatient.getHistory(), selectedPatient.getNotes());
        
        startActivity(intent);
    }
	
}
