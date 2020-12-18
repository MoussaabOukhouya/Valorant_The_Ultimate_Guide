package com.ProGuides.Valorant.Agents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.ProGuides.Valorant.R;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;


public class Sova extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sova);

        adView = new AdView(getApplicationContext(),"725119301645228_725194058304419", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sova");
        final ImageButton aftershock = (ImageButton) findViewById(R.id.shockbolt);
        final ImageButton flashpoint = (ImageButton) findViewById(R.id.owldrone);
        final ImageButton faultline = (ImageButton) findViewById(R.id.reconbolt);
        final ImageButton rolling = (ImageButton) findViewById(R.id.huntersfury);




        aftershock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sovaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "shockbolt");
                startActivity(intent);

            }
        });

        flashpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sovaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "owldrone");
                startActivity(intent);

            }
        });

        faultline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sovaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "reconbolt");
                startActivity(intent);

            }
        });

        rolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sovaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "huntersfury");
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
