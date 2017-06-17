package com.xuliwen.basecode.androidcode.intent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.xuliwen.basecode.utils.L;

public class IntentService1 extends Service {
    public IntentService1() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        L.l("IntentService1 onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        L.l("IntentService1 onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
