package com.xuliwen.basecode.androidcode.intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.xuliwen.basecode.utils.L;

public class IntentReceiver1 extends BroadcastReceiver {
    public IntentReceiver1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        L.l("IntentReceiver1 onReceive");
    }
}
