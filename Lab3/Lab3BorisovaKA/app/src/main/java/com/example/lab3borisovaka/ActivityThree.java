package com.example.lab3borisovaka;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ActivityThree extends AppCompatActivity {

    Button mButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_three);
        mButton3 = findViewById(R.id.button3);
        mButton3.setOnClickListener(v->back(v));
    }

    public void back(View view) {
        Intent intent = new Intent(ActivityThree.this, MainActivity.class);
        startActivity(intent);
//        setResult(3, intent);
//        finish();
    }
}

