package com.example.broadcastdemoforcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mBatteryLevel;
    private BatteryLevelReceiver mBatteryLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        registerBatteryChangedLevel();

    }

    private void initView() {
        mBatteryLevel = findViewById(R.id.battery_level);
    }

    private void registerBatteryChangedLevel() {
        //第二步
        //我们要收听的频道是：电量变化
        IntentFilter intentFilter = new IntentFilter();

        //第三步
        //设置频道
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        //USB监听
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //第四步
        mBatteryLevelReceiver = new BatteryLevelReceiver();
        //第五步
        //注册广播，动态注册
        //还需要在Manifest中声明状态权限
        // This broadcast requires {@link android.Manifest.permission#BATTERY_STATS}
        this.registerReceiver(mBatteryLevelReceiver, intentFilter);
    }


    /**
     * 第一步，创建一个广播接收者，继承自BroadcastReceiver
     */
    public class BatteryLevelReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {

                Log.d(TAG, "收到了电量变化的广播 ：Activon is + " + action);
                int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                //获取当前电量信息
                Log.d(TAG, "当前电量：" + currentLevel);
                if (mBatteryLevel != null) {
                    mBatteryLevel.setText("当前电量：" + currentLevel);
                }
                int maxLevel = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                //拿到当前电量后，再除以最大值
                float percent = currentLevel * 1.0f / maxLevel * 100;
                Log.d(TAG, "当前电量百分比是：" + percent + "%");
            } else if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
                Log.d(TAG, "USB连接了....");
            } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
                Log.d(TAG, "USB断开了....");
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //onDestroy的时候要取消广播注册，否则会导致内存泄漏
        if (mBatteryLevelReceiver != null) {
            this.unregisterReceiver(mBatteryLevelReceiver);
        }
    }
}
