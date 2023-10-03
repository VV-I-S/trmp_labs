package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle ;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mButton0, mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9, mButtonPoint, mButtonAdd, mButtonSub, mButtonDiv, mButtonMul, mButtonEq, mButtonPer, mButtonM, mButtonMC;
    EditText mEditText;
    float mValueOne, mValueTwo;
    float mMValue = 0;
    boolean mAddition, mSubtract, mMultiplication, mDivision;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton0 = (Button) findViewById(R.id.button0);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton6 = (Button) findViewById(R.id.button6);
        mButton7 = (Button) findViewById(R.id.button7);
        mButton8 = (Button) findViewById(R.id.button8);
        mButton9 = (Button) findViewById(R.id.button9);
        mButtonPoint = (Button) findViewById(R.id.buttonPoint);
        mButtonAdd = (Button) findViewById(R.id.buttonAdd);
        mButtonSub = (Button) findViewById(R.id.buttonSub);
        mButtonMul = (Button) findViewById(R.id.buttonMul);
        mButtonDiv = (Button) findViewById(R.id.buttonDiv);
        mButtonPer = (Button) findViewById(R.id.buttonPer);
        mButtonM = (Button) findViewById(R.id.buttonM);
        mButtonMC = (Button) findViewById(R.id.buttonMC);
        mButtonEq = (Button) findViewById(R.id.buttonEq);
        mEditText = (EditText) findViewById(R.id.editText1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "1");
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "2");
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "3");
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "4");
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "5");
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "6");
            }
        });
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "7");
            }
        });
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "8");
            }
        });
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "9");
            }
        });
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "0");
            }
        });
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText == null) {
                    mEditText.setText("");
                } else {
                    try {
                        mValueOne = Float.parseFloat(mEditText.getText() + "");
                        mAddition = true;
                        mEditText.setText(null);
                    } catch (Exception e) {

                    }

                }
            }
        });
        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText == null) {
                    mEditText.setText("");
                } else {
                    try {
                        mValueOne = Float.parseFloat(mEditText.getText() + "");
                        mSubtract = true;
                        mEditText.setText(null);
                    } catch (Exception e) {

                    }

                }
            }
        });
        mButtonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText == null) {
                    mEditText.setText("");
                } else {
                    try {
                        mValueOne = Float.parseFloat(mEditText.getText() + "");
                        mMultiplication = true;
                        mEditText.setText(null);
                    } catch (Exception e) {

                    }
                }
            }
        });
        mButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText == null) {
                    mEditText.setText("");
                } else {
                    try {
                        mValueOne = Float.parseFloat(mEditText.getText() + "");
                        mDivision = true;
                        mEditText.setText(null);
                    } catch (Exception e) {

                    }
                }
            }
        });

        mButtonMC.setOnClickListener(v -> {
            mMValue = 0;
        });
        mButtonM.setOnClickListener(v -> {
            if (mEditText == null) {
                mEditText.setText("");
            } else {
                try {
                    if (mMValue == 0) {
                        mMValue = Float.parseFloat(mEditText.getText() + "");
                        mEditText.setText("");
                    } else {
                        mEditText.setText(mMValue + "");
                        mMValue = 0;
                    }
                } catch (Exception e) {

                }
            }
        });
        mButtonPer.setOnClickListener(v -> {
            if (mEditText == null) {
                mEditText.setText("");
            } else {
                try {
                    mEditText.setText((mValueOne * (Float.parseFloat(mEditText.getText() + "") / 100)) + "");
                } catch (Exception e) {

                }
            }
        });
        mButtonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mValueTwo = Float.parseFloat(mEditText.getText() + "");
                    if (mAddition == true ) {
                        mEditText.setText(mValueOne + mValueTwo + "");
                        mAddition = false;
                    }
                    if (mSubtract == true ) {
                        mEditText.setText(mValueOne - mValueTwo + "");
                        mSubtract = false;
                    }
                    if (mMultiplication == true ) {
                        mEditText.setText(mValueOne * mValueTwo + "");
                        mMultiplication = false;
                    }
                    if (mDivision == true ) {
                        mEditText.setText(mValueOne / mValueTwo + "");
                        mDivision = false;
                    }
                } catch (Exception e) {

                }

            }
        });
        mButtonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + ".");
            }
        });
    }
}