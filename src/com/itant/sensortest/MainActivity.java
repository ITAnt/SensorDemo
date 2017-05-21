package com.itant.sensortest;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_show;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv_show = (TextView) findViewById(R.id.tv_show); 
        //获得重力感应硬件控制器  
        SensorManager sm=(SensorManager) this.getSystemService(SENSOR_SERVICE); 
        Sensor sensor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); 
        //添加重力感应侦听，并实现其方法，  
        SensorEventListener sel = new SensorEventListener(){ 
            public void onSensorChanged(SensorEvent se) { 
	            float x=se.values[0]; 
	            float y=se.values[1]; 
	            float z=se.values[2]; 
	            tv_show.setText("x=" + (int)x + "   y=" + (int)y + "   z=" + (int)z); 
            } 
            public void onAccuracyChanged(Sensor arg0, int arg1) { } 
        }; 
        
        //注册Listener，SENSOR_DELAY_GAME为检测的精确度，  
        sm.registerListener(sel, sensor, SensorManager.SENSOR_DELAY_FASTEST);
	}
}
