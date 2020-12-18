package com.ProGuides.Valorant.Agents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;


import com.ProGuides.Valorant.R;


public class Breach extends AppCompatActivity {
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breach);

        adView = new AdView(getApplicationContext(),"725119301645228_725206424969849", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Breach");
        final ImageButton aftershock = (ImageButton) findViewById(R.id.aftershock);
        final ImageButton flashpoint = (ImageButton) findViewById(R.id.flashpoint);
        final ImageButton faultline = (ImageButton) findViewById(R.id.faultline);
        final ImageButton rolling = (ImageButton) findViewById(R.id.rollingthunder);
    
        



        aftershock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), breachAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "aftershock");
                startActivity(intent);

            }
        });

        flashpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), breachAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "flashpoint");
                startActivity(intent);

            }
        });

        faultline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), breachAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "faultline");
                startActivity(intent);

            }
        });

        rolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), breachAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "rolling");
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
