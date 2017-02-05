package com.qhacks.moledetector;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        startAnim();
    }

    void startAnim(){
        com.wang.avi.AVLoadingIndicatorView avi_outer = (com.wang.avi.AVLoadingIndicatorView) findViewById(R.id.avi_outer);
        com.wang.avi.AVLoadingIndicatorView avi_inner = (com.wang.avi.AVLoadingIndicatorView) findViewById(R.id.avi_inner);
        avi_outer.show();
        avi_inner.show();
    }

}
