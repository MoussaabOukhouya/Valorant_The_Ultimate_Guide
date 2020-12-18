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


public class Brimstone extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brimstone);


        adView = new AdView(getApplicationContext(),"725119301645228_725199604970531", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Brimston");
        final ImageButton aftershock = (ImageButton) findViewById(R.id.incendiary);
        final ImageButton flashpoint = (ImageButton) findViewById(R.id.stimbeacon);
        final ImageButton faultline = (ImageButton) findViewById(R.id.skysmoke);
        final ImageButton rolling = (ImageButton) findViewById(R.id.orbitalstrike);


        aftershock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), brimstoneAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "incendiary");
                startActivity(intent);

            }
        });

        flashpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), brimstoneAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "stimbeacon");
                startActivity(intent);

            }
        });

        faultline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), brimstoneAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "skysmoke");
                startActivity(intent);

            }
        });

        rolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), brimstoneAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "orbitalstrike");
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
