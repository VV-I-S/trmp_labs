package com.example.lab3borisovaka;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton1 = findViewById(R.id.button);
        Button mButton5 = findViewById(R.id.button5);
        TextView mTextView = findViewById(R.id.textView);
        mTextView.setText((String)getIntent().getSerializableExtra("message"));
        mButton1.setOnClickListener(v->OnTwo(v));
        mButton5.setOnClickListener(v->OnThree(v));
    }

    public void OnTwo(View view) {
        EditText mEditText = findViewById(R.id.editText2);
        String message2 = mEditText.getText().toString();
        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
        intent.putExtra("message2",message2);
        startActivity(intent);
    }
    public void OnThree(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityThree.class);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            Intent intent = new Intent(getApplicationContext(), ActivityTwo.class);
            startActivity(intent);
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        Bundle e = data.getExtras();
        if (requestCode==2)
        {
            TextView mTextView = findViewById(R.id.textView);
            String s = e.getString("message");
            if (s != null)
                mTextView.setText(s);
        }
    }
}