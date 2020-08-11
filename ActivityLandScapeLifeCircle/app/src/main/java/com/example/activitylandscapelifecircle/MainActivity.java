package com.example.activitylandscapelifecircle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

/**
 * D/MainActivity: onCreate...
 * D/MainActivity: onStart...
 * D/MainActivity: onResume...
 * (切换成横屏)
 * D/MainActivity: onPause...
 * D/MainActivity: onStop...
 *                 onDestroy...
 * D/MainActivity: onCreate...
 * D/MainActivity: onStart...
 * D/MainActivity: onResume...
 * <p/>
 * 从上面可以看出，当我们切换成横屏时，Activity就会销毁，并且重新创建
 * 当我们从横屏切换到竖屏时，执行了一下生命周期方法：
 * D/MainActivity: onPause...
 * D/MainActivity: onStop...
 *                 onDestroy...
 * D/MainActivity: onCreate...
 * D/MainActivity: onStart...
 * D/MainActivity: onResume...
 * <p/>
 * 由上，可以得出结论：
 * 当我们横竖屏切换的时候，Activity就会销毁，并且重新创建
 *
 *
 * 实际开发中，可能会遇到的横竖屏切换场景
 * 1、游戏开发
 * 2、视频播放器
 * 3、其他场景
 *
 * 横竖屏切换，Activity生命周期发生变化，对我们开发有什么影响？
 *
 * 如何解决呢？
 * 1、禁止旋转，指定屏幕方向，在Manifest文件中设置Activity的screenOrientation属性
 *
 *
 * 2、对配置不敏感，Manifest文件中设置Activity的configChanges属性
 * 如 android:configChanges="keyboardHidden|screenSize|orientation"
 * 该属性中参数表示对这些配置不敏感，即这些配置的变化不会引起Activity生命周期的变化
 *
 *
 * 解决方法1，适用于只有一种屏幕状态的应用开发，，如横屏游戏开发
 * 解决方法2，适用于两种/多种屏幕状态的应用开发，如视频播放软件
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private SeekBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate...");
        initView();
    }

    private void initView() {
        mProgress = findViewById(R.id.progress_bar);
        //打印日志，发现横竖屏切换前后，mProgress是不同的两个对象
        //那么下面的代码就会重新执行一次
        //即若视频看到一半旋转屏幕时，seekBar就会重置为0
        Log.d(TAG,"mProgress=="+mProgress.toString());
        //设置初始化数据
        mProgress.setMax(100);
        mProgress.post(new Runnable() {
            @Override
            public void run() {
                mProgress.setProgress(0);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy...");
    }
}
