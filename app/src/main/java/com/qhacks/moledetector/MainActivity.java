package com.qhacks.moledetector;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                setContentView(R.layout.activity_camera_function);
            }
        });

        TextView title = (TextView)findViewById(R.id.appName);
        TextView fact = (TextView)findViewById(R.id.scrollingFacts);
        Typeface font_ubuntu_bold = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Bold.ttf");
        Typeface font_ubuntu = Typeface.createFromAsset(getAssets(),  "fonts/Ubuntu-Regular.ttf");

        title.setTypeface(font_ubuntu_bold);
        fact.setTypeface(font_ubuntu);
    }
}
