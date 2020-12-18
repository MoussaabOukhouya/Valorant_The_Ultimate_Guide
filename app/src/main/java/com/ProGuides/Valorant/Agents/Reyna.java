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


public class Reyna extends AppCompatActivity {

    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reyna);

        adView = new com.facebook.ads.AdView(getApplicationContext(),"725119301645228_725182171638941", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Reyna");
        final ImageButton leer = (ImageButton) findViewById(R.id.leer);
        final ImageButton devour = (ImageButton) findViewById(R.id.devour);
        final ImageButton dismiss = (ImageButton) findViewById(R.id.dismiss);
        final ImageButton empress = (ImageButton) findViewById(R.id.empress);





        leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), reynaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "c");
                startActivity(intent);

            }
        });

        devour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), reynaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "q");
                startActivity(intent);

            }
        });

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), reynaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "e");
                startActivity(intent);

            }
        });

        empress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), reynaAbilities.class);
                intent.putExtra(Intent.EXTRA_TEXT , "x");
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
