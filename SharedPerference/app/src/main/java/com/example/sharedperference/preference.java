package com.example.sharedperference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class preference extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch mS;
    private SharedPreferences mPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        mS = this.findViewById(R.id.allow_unknown_app);
        mS.setOnCheckedChangeListener(this);
        mPreference = this.getSharedPreferences("setinfo", MODE_PRIVATE);
        boolean state = mPreference.getBoolean("state", false);
        mS.setChecked(state);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferences.Editor edit=mPreference.edit();
        edit.putBoolean("state",isChecked);
        edit.commit();
    }
}