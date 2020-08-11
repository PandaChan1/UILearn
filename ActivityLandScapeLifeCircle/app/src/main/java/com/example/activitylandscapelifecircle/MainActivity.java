package com.example.activitylandscapelifecircle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate...");
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
