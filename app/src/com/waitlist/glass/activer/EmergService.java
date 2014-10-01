package com.waitlist.glass.activer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
For the Manifest
<service
  android:name="EmergService"
  android:icon="@drawable/icon"
  android:label="@string/service_name"
  >
</service>
*/

public class EmergService extends Service {
	
	public EmergService() {
	}
	
	@Override
	public IBinder onBind(Intent intent){
		throw new UnsupportedOperationException("Not yet implemented");
	}
	Date emergDate = new Date();
	boolean emergFlag = false;
	long startTime = emergDate.getTime();
	@Override
	public void onCreate(){
		
		
		
	
	}
	
	public void onStartCommand(Intent intent, int startID){
		if (emergFlag == false)
			emergDate = new Date();
			long emergTime = emergDate.getTime();
			if (emergTime == startTime + 10000)
				Toast.makeText(this, "Male: Heart Attack ETA: 3 Mins", Toast.LENGTH_SHORT).show();
				emergFlag = true;
				
	}
	
	public void onDestroy(){
	}
}