package com.ProGuides.Valorant.Agents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.ProGuides.Valorant.R;
import com.facebook.ads.AudienceNetworkAds;

import com.facebook.ads.*;

public class killjoy extends AppCompatActivity {
    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_killjoy);


        adView = new AdView(getApplicationContext(),"725119301645228_725210004969491",AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Killjoy");
        final ImageButton alarm = (ImageButton) findViewById(R.id.alarmbot);
        final ImageButton nano = (ImageButton) findViewById(R.id.nanoswarm);
        final ImageButton turret = (ImageButton) findViewById(R.id.turret);
        final ImageButton lock = (ImageButton) findViewById(R.id.lockdown);




        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), joyAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "alarmbot");
                startActivity(intent);

            }
        });

        nano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), joyAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "nanoswarm");
                startActivity(intent);

            }
        });

        turret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), joyAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "turret");
                startActivity(intent);

            }
        });

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), joyAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "lockdown");
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}