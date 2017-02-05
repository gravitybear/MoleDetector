package com.qhacks.moledetector;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import devlight.io.library.ArcProgressStackView;

public class SkinInformation extends AppCompatActivity {

    public static Bitmap data;
    public static PredictionResult result;

    public Dictionary<String, String> urls = new Hashtable<>();
    public Dictionary<String, ArrayList<String>> info = new Hashtable<>();


    // hardcoded yeeeee
    void populateDictionaries() {
        urls.put("Dermatology", "http://www.dermatology.ca/skin-hair-nails/skin/");
        urls.put("Wikipedia", "https://en.wikipedia.org/wiki/Skin_cancer");
        urls.put("WebMD", "http://www.webmd.com/melanoma-skin-cancer/");

        info.put("safe", new ArrayList<String>());

    }

    // fills textviews on first window you open after scanning
    void fillMainInfo() {
        String short_desc;
        String tip;
        String doctor1;
        String doctor2;
        int likelihood = (int) Math.round(result.getLikelihood() * 100);
        short_desc = "Since our results are not 100% accurate, we still recommend seeing a physician every year for a professional skin exam";
        tip = "Most skin related abnormalities are caused by exposure to ultra-violet sun rays";
        doctor1 = "If you really think you have an issue";
        doctor2 = "You should see your family doctor";
        TextView diagnosis_title = (TextView) findViewById(R.id.diagnosis_title);
        diagnosis_title.setText(Integer.toString(likelihood) + "%");
        TextView diag_desc = (TextView) findViewById(R.id.diag_desc);
        diag_desc.setText(short_desc);
        TextView diag_tip = (TextView) findViewById(R.id.diag_tip);
        diag_tip.setText(tip);
        TextView reason_who = (TextView) findViewById(R.id.reason_who);
        reason_who.setText(doctor1);
        TextView who_see= (TextView) findViewById(R.id.who_see);
        who_see.setText(doctor2);

        final ArrayList<ArcProgressStackView.Model> models = new ArrayList<>();
        models.add(new ArcProgressStackView.Model("Jagedness", (int)(result.getJagedness() * 100), R.array.medical_express, R.array.devlight));
        models.add(new ArcProgressStackView.Model("Asymmetry", (int)(result.getAsymmetry() * 100), R.array.medical_express, R.array.polluted_waves));
        models.add(new ArcProgressStackView.Model("Coloring", (int)(result.getColoring() * 100), R.array.medical_express, R.array.medical_express));

        final ArcProgressStackView arcProgressStackView = (ArcProgressStackView) findViewById(R.id.arc);
        arcProgressStackView.setModels(models);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_more);

        Intent intent = getIntent();

        fillMainInfo();

        ImageView img = (ImageView) findViewById(R.id.img_skin_final);
        img.setImageBitmap(data);

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
