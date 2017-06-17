package com.xuliwen.basecode.androidcode.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.utils.L;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        LogIntent();
    }

    private void LogIntent(){
        Intent intent=getIntent();
        L.l("DataActivity Data: "+intent.getDataString());
        L.l("DataActivity Type: "+ intent.getType());
    }
}
