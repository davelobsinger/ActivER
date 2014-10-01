package com.waitlist.glass.activer;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollView;



public class PatientInfoActivity extends Activity 
{
	public final static String VOICENOTE = "voiceNote";

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
        
        mCardScrollView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                    int index, long arg3) {
            	AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            	handleVoice();
            	am.playSoundEffect(Sounds.SUCCESS);
                return true;
            }
        }); 
         
    }	
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patient_menu, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected (MenuItem item){
    	switch (item.getItemId()){
        case R.id.sch_xray:
        	Toast.makeText(getApplicationContext(), "Patient scheduled for X-Ray", Toast.LENGTH_SHORT).show();
        	return true;
        case R.id.sch_mri:
        	Toast.makeText(getApplicationContext(), "Patient scheduled for MRI", Toast.LENGTH_SHORT).show();
        	return true;
    	}
    	return false;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            if(spokenText == null) {
                spokenText = "";
            }
            Log.d("Text",spokenText);
            writeNote(spokenText);
            //contentView.setText(spokenText);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void writeNote(String text){
    	mAdapter.writeNote(text);
    }
    
    private void handleVoice()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        startActivityForResult(intent, 0);
    }
	
}