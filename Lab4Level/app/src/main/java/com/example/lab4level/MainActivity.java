package com.example.lab4level;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Context;
import android.hardware.Sensor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.WindowManager;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        private SensorManager sm;
        private Sensor s;
        private Sensor mLightSensor;
        private ImageView im;
        private TextView tv;
        private SensorEventListener sv;
        float mMaxValue;
        float mValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        im = (ImageView) findViewById(R.id.im);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLightSensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        mMaxValue = mLightSensor.getMaximumRange();
        if(sm != null)s = sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        sv = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                float[] rotationMatrix = new float[16];
                SensorManager.getRotationMatrixFromVector(rotationMatrix, sensorEvent.values);
                float[] remmapedRotationMatrix = new float[16];
                SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X, SensorManager.AXIS_Z, remmapedRotationMatrix);

                float[] orientations = new float[3];
                SensorManager.getOrientation(remmapedRotationMatrix, orientations);
                for (int i=0; i<3; i++){
                    orientations[i] = (float) (Math.toDegrees(orientations[i]));
                }

                tv.setText(String.valueOf((int) orientations[2]));
                im.setRotation(-orientations[2]);

//                if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
//                    tv.setText(Float.toString(sensorEvent.values[0]));
//                    mValue =sensorEvent.values[0];
//                    WindowManager.LayoutParams layout = getWindow().getAttributes();
//                    layout.screenBrightness = (int)(255f* mValue / mMaxValue);
//                    getWindow().setAttributes(layout);
//                }

            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(sv, s, SensorManager.SENSOR_DELAY_FASTEST);
        //sm.registerListener(sv, mLightSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(sv);
    }
}