package com.ProGuides.Valorant.Ranked;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ProGuides.Valorant.weapons.Weapons;
import com.ProGuides.Valorant.agentsActivity;
import com.ProGuides.Valorant.Map.Maps;
import com.ProGuides.Valorant.R;

import com.facebook.ads.InterstitialAd;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Ranked extends AppCompatActivity {


    Button one, two, three, four, five, sex, seven;
    Toolbar toolbar;
    private com.facebook.ads.InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranked);
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);

        interstitialAd = new InterstitialAd(this, "725119301645228_725259951631163");
        interstitialAd.loadAd();


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
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.ranked);

        one = findViewById(R.id.butt_one);
        two = findViewById(R.id.butt_two);
        three = findViewById(R.id.button_three);
        four = findViewById(R.id.butt_four);
        five = findViewById(R.id.butt_five);
        sex = findViewById(R.id.butt_sex);
        seven = findViewById(R.id.button_seven);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.agents:
                        startActivity(new Intent(getApplicationContext(), agentsActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.weapons:
                        startActivity(new Intent(getApplicationContext(), Weapons.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ranked:
                        return true;
                    case R.id.maps:
                        startActivity(new Intent(getApplicationContext(), Maps.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ranked_details.class);
                intent.putExtra("Question_number", 1);
                startActivity(intent);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ranked_details.class);
                intent.putExtra("Question_number", 2);
                startActivity(intent);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ranked_details.class);
                intent.putExtra("Question_number", 3);
                startActivity(intent);

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ranked_details.class);
                intent.putExtra("Question_number", 4);
                startActivity(intent);

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ranked_details.class);
                intent.putExtra("Question_number", 5);
                startActivity(intent);

            }
        });
        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ranked_details.class);
                intent.putExtra("Question_number", 6);
                startActivity(intent);

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ranked_details.class);
                intent.putExtra("Question_number", 7);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.rate:
                Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                }
                return true;
            case R.id.shareapp:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=com.ProGuides.Valorant";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "The best application of valorant!");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                return true;
            case R.id.ads:
                if (interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                    Toast.makeText(getApplicationContext(),"We really appreciate your support ♥",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Ouuups! May be try again.. Thank you ♥",Toast.LENGTH_SHORT).show();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}





