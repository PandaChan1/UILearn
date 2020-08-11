package com.example.activitylifecircledemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.CDATASection;

/**
 * 模拟视频播放器在播放时接收到来电
 */

public class VideoPlayerActivity extends AppCompatActivity {
    private static final String TAG ="VideoPlayerActivity";
    private Button mPlayerControlBtn;
    private TextView mStateText;
    //isStopAtAmin表示是不是因为生命周期的变化主动停止了
    private boolean isStopAtAmin= false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        initView();
        initListener();
    }

    private boolean isPlayer=false;
    private void initListener() {
        mPlayerControlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayer){
                    //如果当前状态是播放的，那么我们就停止播放
                        stop();
                }else{
                    //如果当前状态是停止的，那么我们就开始播放
                    play();
                }
            }
        });
    }


    private void play(){
        Log.d(TAG,"播放电影");
        mStateText.setText("正在播放电影，声音很大！！！！");
        mPlayerControlBtn.setText("暂停");
        isPlayer=true;
    }

    private void stop(){
        Log.d(TAG,"停止播放电影");
        mStateText.setText("电影已经停止播放");
        mPlayerControlBtn.setText("播放");
        isPlayer=false;
    }
    private void initView() {
        mStateText = findViewById(R.id.current_play_state);
        mPlayerControlBtn = findViewById(R.id.player_control_btn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart.... ");
        if (isStopAtAmin&&!isPlayer) {
            play();
            isStopAtAmin=false;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop.... ");
        if (isPlayer) {
            //如果当前是播放的，那我们就需要把这个电影停止掉
            stop();
            isStopAtAmin=true;

        }
    }

}
