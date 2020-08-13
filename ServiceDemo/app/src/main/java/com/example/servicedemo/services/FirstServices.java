package com.example.servicedemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FirstServices extends Service {
    private static final String TAG = FirstServices.class.getName();

    public class  InnerBinder extends Binder{
        public void callServiceInnerMethod(){
            syaHello();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind....");
        return new InnerBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate....");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand....");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy....");
    }
    
    private void syaHello(){
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }
}
