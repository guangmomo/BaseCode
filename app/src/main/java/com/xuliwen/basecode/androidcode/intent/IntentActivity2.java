package com.xuliwen.basecode.androidcode.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.utils.L;

public class IntentActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        LogIntent();
    }

    private void LogIntent(){
        Intent intent=getIntent();
        L.l("action: "+intent.getAction());
        if(intent.getCategories()!=null){
            for(String category : intent.getCategories()){
                L.l("category: "+category);
            }
        }

    }
}
