package com.example.recyclertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            //ListView效果
            case R.id.list_view_horizontal_reverse:
                Log.d(TAG,"点击了ListView的水平反向");
                break;
            case R.id.list_view_horizontal_stander:
                Log.d(TAG,"点击了ListView的水平标准");
                break;
            case R.id.list_view_vertical_reverse:
                Log.d(TAG,"点击了ListView的垂直反向");
                break;
            case R.id.list_view_vertical_stander:
                Log.d(TAG,"点击了ListView的垂直标准");
                break;

                //GridView效果
            case R.id.grid_view_horizontal_reverse:
                break;
            case R.id.grid_view_horizontal_stander:
                break;
            case R.id.grid_view_vertical_reverse:
                break;
            case R.id.grid_view_vertical_stander:
                break;

                //StaggerViwe效果
            case R.id.stagger_view_horizontal_reverse:
                break;
            case R.id.stagger_view_horizontal_stander:
                break;
            case R.id.stagger_view_vertical_reverse:
                break;
            case R.id.stagger_view_vertical_stander:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
