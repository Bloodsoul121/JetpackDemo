package com.blood.jetpackdemo.rtl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.blood.jetpackdemo.R;

public class RtlTextActivity extends AppCompatActivity {

    private TextView mTv1;
    private TextViewEx mTv2;
    private TextViewEx mTv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtl_text);
        mTv1 = findViewById(R.id.text1);
        mTv2 = findViewById(R.id.text2);
        mTv3 = findViewById(R.id.text3);

        String text = "هناك مشكلة في حسابك، قد غادرت التطبيق";

        mTv1.setText(text);
        mTv2.setText(text);
        mTv3.setText(text, true);
    }
}