package com.qhacks.moledetector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SkinInformation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_container);

        Button goCamera = (Button) findViewById(R.id.go_camera);
        goCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go back to homepage
                Intent intent = new Intent(SkinInformation.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        final Button showResults = (Button) findViewById(R.id.show_results);
        View line = findViewById(R.id.info_select2);
        line.setVisibility(View.VISIBLE);
        View line2 = findViewById(R.id.info_select3);
        line2.setVisibility(View.INVISIBLE);
        showResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View info = findViewById(R.id.incl_skin_info);
                View more = findViewById(R.id.incl_skin_more);
                if (info.getVisibility() == View.GONE) {
                    info.setVisibility(View.VISIBLE);
                    more.setVisibility(View.GONE);
                    View line = findViewById(R.id.info_select2);
                    line.setVisibility(View.VISIBLE);
                    View line2 = findViewById(R.id.info_select3);
                    line2.setVisibility(View.INVISIBLE);
                }
            }
        });

        final Button showInfo = (Button) findViewById(R.id.show_info);
        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View info = findViewById(R.id.incl_skin_info);
                View more = findViewById(R.id.incl_skin_more);
                if (more.getVisibility() == View.GONE) {
                    more.setVisibility(View.VISIBLE);
                    info.setVisibility(View.GONE);
                    View line = findViewById(R.id.info_select3);
                    line.setVisibility(View.VISIBLE);
                    View line2 = findViewById(R.id.info_select2);
                    line2.setVisibility(View.INVISIBLE);
                }

            }
        });

    }
}
