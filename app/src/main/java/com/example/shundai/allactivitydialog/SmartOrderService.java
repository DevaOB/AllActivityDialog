package com.example.shundai.allactivitydialog;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
/**
 * Created by win7 on 2017/8/30.
 */
public class SmartOrderService extends Service {

    public static final String TAG="SmartOrderServiceTest";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind:>>>>>>>>>>>>>>>>>>>> onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate:>>>>>>>>>>>>>>>>>>>> onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand:>>>>>>>>>>>>>>>>>>>> onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart:>>>>>>>>>>>>>>>>>>>> onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:>>>>>>>>>>>>>>>>>>>> onDestroy");
    }
}
