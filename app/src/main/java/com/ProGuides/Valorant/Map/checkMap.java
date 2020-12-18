package com.ProGuides.Valorant.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ProGuides.Valorant.R;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.ads.InterstitialAd;


import java.util.ArrayList;

public class checkMap extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    SubsamplingScaleImageView mapimg;
    map haven = new map(0, "Haven", R.drawable.haven);
    map split = new map(1, "Split", R.drawable.split);
    map blind = new map(2, "Bind", R.drawable.bind);
    map ascent = new map(3, "Ascent", R.drawable.ascent);
    ArrayList<map> maps;
    TextView title;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_map);
        interstitialAd = new InterstitialAd(this, "725119301645228_725262921630866");
        interstitialAd.loadAd();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        mapimg = findViewById(R.id.mymapimg);
        title = findViewById(R.id.checkmaptitle);
        Intent intent = getIntent();
        int id = intent.getIntExtra("mapid", 0);
        maps = new ArrayList<>();
        maps.add(haven);
        maps.add(split);
        maps.add(blind);
        maps.add(ascent);


        for (int i = 0; i < maps.size(); i++) {
            if (id == maps.get(i).getId()) {
                mapimg.setImage(ImageSource.resource(maps.get(i).getImg()));
                title.setText(maps.get(i).getName());
            }
        }

    }

    @Override
    public void onBackPressed() {
        if (interstitialAd.isAdLoaded()) {
            interstitialAd.show();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();    }
}
