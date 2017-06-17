package com.xuliwen.basecode.javacode.xuliehua.pacelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xuliwen.basecode.R;
import com.xuliwen.basecode.utils.L;

public class ReceiveParcelableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_parcelable);

        getParcelable();
    }

    private void getParcelable(){
        Intent intent=getIntent();
        Person person=intent.getParcelableExtra("person");
        L.l("ReceiveParcelableActivity接收到： "+person);
    }
}
