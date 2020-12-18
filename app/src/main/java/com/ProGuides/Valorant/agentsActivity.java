package com.ProGuides.Valorant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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


import com.ProGuides.Valorant.Agents.Breach;
import com.ProGuides.Valorant.Agents.Brimstone;
import com.ProGuides.Valorant.Agents.Cypher;
import com.ProGuides.Valorant.Agents.Jett;
import com.ProGuides.Valorant.Agents.Omen;
import com.ProGuides.Valorant.Agents.Phoenix;
import com.ProGuides.Valorant.Agents.Raze;
import com.ProGuides.Valorant.Agents.Reyna;
import com.ProGuides.Valorant.Agents.killjoy;
import com.ProGuides.Valorant.Agents.Sage;
import com.ProGuides.Valorant.Agents.Sova;
import com.ProGuides.Valorant.Agents.Viper;
import com.ProGuides.Valorant.weapons.Weapons;
import com.ProGuides.Valorant.Map.Maps;
import com.ProGuides.Valorant.Ranked.Ranked;

import com.facebook.ads.InterstitialAd;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class agentsActivity extends AppCompatActivity {
    private InterstitialAd interstitialAd2;

    Toolbar toolbar;
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interstitialAd2 = new InterstitialAd(this, "725119301645228_725259951631163");
        interstitialAd2.loadAd();
        toolbar =(Toolbar) findViewById(R.id.toolbar);
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



        final BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.agents);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.agents:
                        return true;
                    case R.id.weapons:
                        startActivity(new Intent(getApplicationContext(), Weapons.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ranked:
                        startActivity(new Intent(getApplicationContext(), Ranked.class));
                        finish();
                        overridePendingTransition(0,0);
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





        Button button_breach = findViewById(R.id.butt_breach);
        Button button_jett = findViewById(R.id.butt_jett);
        Button button_sage = findViewById(R.id.butt_sage);
        Button button_sova = findViewById(R.id.butt_sova);
        Button button_omen = findViewById(R.id.butt_omen);
        Button button_viper = findViewById(R.id.butt_viper);
        Button button_brimstone = findViewById(R.id.butt_brimston);
        Button button_raze = findViewById(R.id.butt_raze);
        Button button_cypher = findViewById(R.id.butt_cypher);
        Button button_phoenix = findViewById(R.id.butt_phoenix);
        Button button_reyna = findViewById(R.id.butt_reyna);
        Button button_joy = findViewById(R.id.butt_killjoy);




        button_reyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Reyna.class));

            }
        });

        button_joy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), killjoy.class));

            }
        });

        button_breach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Breach.class));

            }
        });
        button_jett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Jett.class));

            }
        });
        button_sage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sage.class));

            }
        });
        button_sova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sova.class));

            }
        });
        button_omen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Omen.class));

            }
        });
        button_viper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Viper.class));

            }
        });
        button_brimstone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Brimstone.class));

            }
        });
        button_raze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Raze.class));

            }
        });
        button_cypher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cypher.class));

            }
        });
        button_phoenix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Phoenix.class));

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
                if (interstitialAd2.isAdLoaded()) {
                    interstitialAd2.show();
                    Toast.makeText(getApplicationContext(),"We really appreciate your support ?",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Ouuups! May be try again.. Thank you ?",Toast.LENGTH_SHORT).show();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onDestroy() {

        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }

        super.onDestroy();
    }

}
