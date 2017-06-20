package com.xuliwen.basecode.androidcode.startmode;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xuliwen.basecode.R;

public class SingleInstanceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
    }



    public void toSingleInstanceActivity(View view) {
        startActivity(new Intent(this,SingleInstanceActivity.class));
    }

    public void toSingleTaskActivity(View view) {
        startActivity(new Intent(this,SingleTaskActivity.class));
    }
}
