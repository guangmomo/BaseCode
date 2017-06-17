package com.xuliwen.basecode.androidcode.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xuliwen.basecode.Constants;
import com.xuliwen.basecode.R;

public class IntentActivity1 extends AppCompatActivity {

    private static final String ACTIONActivity2="com.xuliwen.basecode.androidcode.intent.IntentActivity2";

    private static final String CATEGORY1="android.intent.category.CUSTOM1";
    private static final String CATEGORY2="android.intent.category.CUSTOM2";
    private static final String CATEGORY3="android.intent.category.CUSTOM3";

    private static final String ACTIONService1="com.xuliwen.basecode.androidcode.intent.IntentService1";

    private static final String ACTIONReceiver1="com.xuliwen.basecode.androidcode.intent.IntentReceiver1";


    private static final String ACTIONDATAActivity="com.xuliwen.basecode.androidcode.intent.DataActivity";

    private static final Uri URIDATAActivity=Uri.parse("activity://www.xuliwen.com:8888/index");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);
    }

    public void toIntentActivity2(View view) {
        Intent intent=new Intent("com.xuliwen.basecode.androidcode.intent.IntentActivityTwo");
       // intent.addCategory(CATEGORY1);
        intent.setPackage(Constants.PKG);

//        Intent intent=new Intent(this,IntentActivity2.class)
        startActivity(intent);
    }

    public void toIntentService1(View view) {
        Intent intent=new Intent();
        intent.addCategory(CATEGORY1);
        intent.addCategory(CATEGORY2);
        intent.addCategory(CATEGORY3);
        intent.setPackage(Constants.PKG);
        startService(intent);
    }

    public void toIntentReceiver1(View view) {
        Intent intent=new Intent();
        intent.addCategory(CATEGORY1);
        intent.setPackage(Constants.PKG);
        sendBroadcast(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void testData(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTIONDATAActivity);
         intent.setDataAndType(URIDATAActivity,"DataActivity/one");
        startActivity(intent);
    }

    public void toActionView(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }
}
