package com.xuliwen.basecode.androidcode.startmode;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xuliwen.basecode.R;

public class StandardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
    }


    public void toStandardActivity(View view) {

        Log.e("StandardActivity", "toStandardActivity");
        startActivity(new Intent(this,StandardActivity.class));

    }


}
