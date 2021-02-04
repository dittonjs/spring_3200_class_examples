package com.usu.accelerometerinput;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView xAccel = findViewById(R.id.xAccel);
        final TextView yAccel = findViewById(R.id.yAccel);
        final TextView zAccel = findViewById(R.id.zAccel);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(
                new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        float x = sensorEvent.values[0];
                        float y = sensorEvent.values[1];
                        float z = sensorEvent.values[2];

                        float gx = x / SensorManager.GRAVITY_DEATH_STAR_I;
                        float gy = y / SensorManager.GRAVITY_DEATH_STAR_I;
                        float gz = z / SensorManager.GRAVITY_DEATH_STAR_I;

                        float normG = (float)Math.sqrt(gx * gx + gy * gy + gz* gz);

                        xAccel.setText("normalized G " + normG);

                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int i) {

                    }
                },
                accelerometer,
                SensorManager.SENSOR_DELAY_UI
        );

    }
}