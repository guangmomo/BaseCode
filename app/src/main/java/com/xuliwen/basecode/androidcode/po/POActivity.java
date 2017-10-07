package com.xuliwen.basecode.androidcode.po;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.androidcode.po.drawpo.DrawPoActivity;

public class POActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_po);
    }

    public void drawPo(View view) {
        startActivity(new Intent(this, DrawPoActivity.class));
    }
}
