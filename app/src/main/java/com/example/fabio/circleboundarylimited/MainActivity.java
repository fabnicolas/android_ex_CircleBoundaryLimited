package com.example.fabio.circleboundarylimited;

import android.content.Context;
import android.content.res.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if(sensor!=null){
            mSensorManager.registerListener(this, sensor,	SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            // Failure! No magnetometer.
        }
    }

    public void handleButtonMovement(View v){
        MovableCircleWidget mcw = (MovableCircleWidget)findViewById(R.id.mcw);

        switch(v.getId()){
            case R.id.button_up: mcw.up(); break;
            case R.id.button_down: mcw.down(); break;
            case R.id.button_left: mcw.sx(); break;
            case R.id.button_right: mcw.dx(); break;
            case R.id.button_center: mcw.center(); break;

        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
