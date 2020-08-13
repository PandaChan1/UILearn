package com.example.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.servicedemo.services.FirstServices;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private boolean mIsServiceBind;
    private FirstServices.InnerBinder mRemoteBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate....");
    }


    /**
     * 开启服务
     * @param view
     */
    public void startServiceClick(View view){
        Intent intent=new Intent();
        intent.setClass(this, FirstServices.class);
        startService(intent);
    }

    /**
     * 停止服务
     * @param view
     */
    public void stopServiceClick(View  view){
        Intent intent=new Intent();
        intent.setClass(this, FirstServices.class);
        stopService(intent);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy....");
    }

    public void callServiceMethod(View view){
        Log.d(TAG,"call service inner method");
        mRemoteBinder.callServiceInnerMethod();
    }

    /**
     * 绑定服务
     * @param view
     */
    public void bindServiceClick(View view){
        Intent intent=new Intent();
        intent.setClass(this, FirstServices.class);
        mIsServiceBind = bindService(intent, mConnection, BIND_AUTO_CREATE);
    }


    private ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG,"onServiceConnected");
            mRemoteBinder = (FirstServices.InnerBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG,"onServiceDisconnected");
            mRemoteBinder=null;
        }
    };


    /**
     * 绑定服务
     * @param view
     */
    public void unbindServiceClick(View view){
        if (mConnection != null&&mIsServiceBind) {
            unbindService(mConnection);
        }

    }
}
