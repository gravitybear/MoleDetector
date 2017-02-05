package com.qhacks.moledetector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SkinInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_container);

        Button goCamera = (Button) findViewById(R.id.go_camera);
        goCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkinInformation.this, AndroidCameraApi.class);
                startActivity(intent);
            }
        });

        Button showResults = (Button) findViewById(R.id.show_results);
        showResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_results_container);
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.activity_skin_information, null);
                mainLayout.removeAllViews();
                mainLayout.addView(layout);
            }
        });

    }
}
