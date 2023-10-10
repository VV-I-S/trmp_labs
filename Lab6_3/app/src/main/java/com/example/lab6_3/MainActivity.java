package com.example.lab6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }
    class DrawView extends View {
        Paint p;
        Rect rect;
        StringBuilder sb;
        public DrawView(Context context) {
            super(context);
            p = new Paint();
            Paint paint = new Paint();
            rect = new Rect(100,200,200,300);
            sb = new StringBuilder();
        }

        @Override
        public void onDraw(Canvas canvas){
            canvas.drawARGB(80, 102, 204, 255);
            p.setColor(Color.RED);
            p.setStrokeWidth(15);
            p.setStyle(Paint.Style.STROKE);

            // Определяем объект Path и закрываем пентаграмму
            Path path1 = new Path();
            path1.moveTo(550, 550);
            path1.lineTo(950, 850);
            path1.lineTo(800, 1350);
            path1.lineTo(300, 1350);
            path1.lineTo(150, 850);
            path1.close();
            // Рисуем по Пути, рисуем пятиконечную звезду
            canvas.drawPath(path1, p);

            p.setStyle(Paint.Style.FILL);
            // Определяем объект Path и закрываем пентаграмму
            Path path2 = new Path();
            path2.moveTo(550, 550);
            path2.lineTo(300, 1350);
            path2.lineTo(950, 850);
            path2.lineTo(150, 850);
            path2.lineTo(800, 1350);
            path2.close();
            // Рисуем по Пути, рисуем пятиконечную звезду
            canvas.drawPath(path2, p);
        }
    }
}
