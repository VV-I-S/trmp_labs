package com.example.lab7_2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    private ImageView imageView;

    private float startX = -1, startY = -1, endX = -1, endY = -1;

    private Bitmap bitmap;
    private Canvas canvas;
    private Paint p = new Paint();
    Random r = new Random();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }

    private void onDrow(){
        if (bitmap == null){
            bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            p.setAntiAlias(true);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10);
        }
        canvas.drawLine(startX, startY -220, endX, endY -220, p);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            startX = event.getX();
            startY = event.getY();
            p.setColor(Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE){
            endX = event.getX();
            endY = event.getY();
            onDrow();
            startX = event.getX();
            startY = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP){
            endX = event.getX();
            endY = event.getY();
            onDrow();
        }
        return super.onTouchEvent(event);
    }
}
