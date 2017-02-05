package com.qhacks.moledetector;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        CoordinatorLayout mainPage = (CoordinatorLayout) findViewById(R.id.activity_main);
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(R.layout.activity_camera_function);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent intent = new Intent(MainActivity.this, AndroidCameraApi.class);
                startActivity(intent);
            }
        });

        TextView title = (TextView)findViewById(R.id.appName);
        TextView fact = (TextView)findViewById(R.id.scrollingFacts);
        Typeface font_ubuntu_bold = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Bold.ttf");
        Typeface font_ubuntu = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Regular.ttf");
        
        title.setTypeface(font_ubuntu_bold);
        fact.setTypeface(font_ubuntu);

        TextView myText = (TextView) findViewById(R.id.continue_tap );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(50); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);
    }
}
