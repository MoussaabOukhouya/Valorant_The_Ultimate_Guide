package com.ProGuides.Valorant.weapons;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.ActivityNotFoundException;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;

        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.ProGuides.Valorant.R;
        import com.facebook.ads.AdSize;
        import com.facebook.ads.AdView;
        import com.facebook.ads.AudienceNetworkAds;
        import com.facebook.ads.InterstitialAd;
        import com.google.android.exoplayer2.ExoPlayerFactory;
        import com.google.android.exoplayer2.SimpleExoPlayer;
        import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
        import com.google.android.exoplayer2.extractor.ExtractorsFactory;
        import com.google.android.exoplayer2.source.ExtractorMediaSource;
        import com.google.android.exoplayer2.source.MediaSource;
        import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
        import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
        import com.google.android.exoplayer2.trackselection.TrackSelector;
        import com.google.android.exoplayer2.ui.PlayerView;
        import com.google.android.exoplayer2.upstream.BandwidthMeter;
        import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
        import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

        import java.util.ArrayList;


public class weaponDetails extends AppCompatActivity {

    SimpleExoPlayer simpleExoPlayer;
    PlayerView simpleExoPlayerView;

    private InterstitialAd interstitialAd;
    private InterstitialAd interstitialAd2;
    private AdView adView;


    weapon classic = new weapon("Classic", "Semi-Automatic", "6.75 rounds/sec", "Low", "78", "26", "22", "3-Round Burst spread increase", "2.22 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/classic/spray_footage/classic_primary2.mp4#t=0.1", "12");
    weapon shorty = new weapon("Shorty", "Semi-Automatic", "3.3 rounds/sec", "Low", "36", "12", "10", "_________", "_________", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/shorty/spray_footage/shorty_primary2.mp4#t=0.1", "2");
    weapon frenzy = new weapon("Frenzy", "Full-Automatic", "10 rounds/sec", "Low", "78", "26", "22", "_________", "_________", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/frenzy/spray_footage/frenzy_primary2.mp4#t=0.1", "13");
    weapon ghost = new weapon("Ghost", "Semi-Automatic", "6.75 rounds/sec", "Medium", "105", "30", "26", "_________", "_________", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/ghost/spray_footage/ghost_primary2.mp4#t=0.1", "15");
    weapon sheriff = new weapon("Sheriff", "Semi-Automatic", "4 rounds/sec", "High", "160", "55", "47", "_________", "_________", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/sheriff/spray_footage/sheriff_primary2.mp4#t=0.1", "6");
    weapon stinger = new weapon("Stinger", "Full-Automatic", "18 rounds/sec", "Low", "67", "27", "23", "Zoom mode (1.15x), 4-Round Burst, spread reduction", "4 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/stinger/spray_footage/stinger_primary3.mp4#t=0.1", "20");
    weapon spectre = new weapon("Spectre", "Full-Automatic", "13.33 rounds/sec", "Medium", "78", "26", "22", "Zoom mode (1.15x), slight spread reduction", "12 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/spectre/spray_footage/spectre_primary3.mp4#t=0.1", "30");
    weapon bucky = new weapon("Bucky", "Semi-Automatic", "1.1 rounds/sec", "Low", "44", "22", "19", "Semi-Automatic Air Burst (Extended primary fire shot)", "1.1 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/bucky/spray_footage/bucky_primary3.mp4#t=0.1", "5");
    weapon judge = new weapon("Judge", "Full-Automatic", "3.5 rounds/sec", "Medium", "34", "17", "14", "_________", "_________", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/judge/spray_footage/judge_primary3.mp4#t=0.1", "7");
    weapon bulldog = new weapon("Bulldog", "Full-Automatic", "9.15 rounds/sec", "Medium", "116", "35", "30", "Zoom (1.25x), 3-Round Burst", "3 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/bulldog/spray_footage/bulldog_primary3.mp4#t=0.1", "24");
    weapon guardian = new weapon("Guardian", "Semi-Automatic", "6.5 rounds/sec", "Medium", "195", "65", "49", "Zoom (1.5x), slight spread reduction", "6.5 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/guardian/spray_footage/guardian_primary2.mp4#t=0.1", "12");
    weapon phantom = new weapon("Phantom", "Full-Automatic", "11 rounds/sec", "Medium", "156", "39", "33", "Zoom (1.25x), slight spread reduction", "9.9 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/phantom/spray_footage/phantom_primary2.mp4#t=0.1", "30");
    weapon vandal = new weapon("Vandal", "Full-Automatic", "9.25 rounds/sec", "Medium", "156", "39", "33", "Zoom (1.25x), slight spread reduction", "8.32 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/vandal/spray_footage/vandal_primary3.mp4#t=0.1", "25");
    weapon marshal = new weapon("Marshal", "Semi-Automatic", "1.5 rounds/sec", "Medium", "202", "101", "85", "Dual-Zoom Mode (2.5x), significant spread reduction", "1.2 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/marshal/spray_footage/marshal_primary2.mp4#t=0.1", "5");
    weapon operator = new weapon("Operator", "Semi-Automatic", "0.75 rounds/sec", "High", "255", "150", "127", "Dual-Zoom Mode (2.5x, 5x), significant spread reduction", "0.75 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/operator/spray_footage/operator_primary2.mp4#t=0.1", "5");
    weapon ares = new weapon("Ares", "Full-Automatic", "10 -> 13 rounds/sec (increasing during fire)", "High", "72", "30", "25", "Zoom mode (1.25x), slight spread reduction", "10 -> 13 rounds/sec (increasing during fire)", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/ares/spray_footage/ares_primary2.mp4#t=0.1", "50");
    weapon odin = new weapon("Odin", "Full-Automatic", "12 -> 15.6 rounds/sec (increasing during fire)", "High", "95", "38", "32", "Zoom mode (1.25x), slight spread reduction", "15.6 rounds/sec", "https://blitz-cdn-videos.blitz.gg/valorant/weapons/odin/spray_footage/odin_primary2.mp4#t=0.1", "100");


    ArrayList<weapon> myarray = new ArrayList<weapon>();

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_details);

        adView = new AdView(getApplicationContext(),"725119301645228_725271884963303", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        interstitialAd = new InterstitialAd(this, "725119301645228_725272191629939");
        interstitialAd.loadAd();
        interstitialAd2 = new InterstitialAd(this, "725119301645228_725259951631163");
        interstitialAd2.loadAd();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String name = getIntent().getStringExtra("name");
        myarray.add(classic);
        myarray.add(shorty);
        myarray.add(frenzy);
        myarray.add(ghost);
        myarray.add(sheriff);
        myarray.add(stinger);
        myarray.add(spectre);
        myarray.add(bucky);
        myarray.add(judge);
        myarray.add(bulldog);
        myarray.add(guardian);
        myarray.add(phantom);
        myarray.add(vandal);
        myarray.add(marshal);
        myarray.add(operator);
        myarray.add(ares);
        myarray.add(odin);



        TextView P_firemode = findViewById(R.id.firemode_det);
        TextView P_ratefire = findViewById(R.id.rateoffire_det);
        TextView A_firemode = findViewById(R.id.a_firemode_det);
        TextView A_ratefire = findViewById(R.id.a_firerate_det);
        TextView capacity = findViewById(R.id.capacity);
        TextView fire_penet = findViewById(R.id.wallpentra);
        TextView head_dmg = findViewById(R.id.headdmg);
        TextView torso_dmg = findViewById(R.id.torsodmg);
        TextView leg_dmg = findViewById(R.id.legdmg);

        simpleExoPlayerView = (PlayerView) findViewById(R.id.videoView);


        for (i = 0; i < myarray.size(); i++) {
            if (name.equals(myarray.get(i).getName())) {

                getSupportActionBar().setTitle(myarray.get(i).getName());
                P_firemode.setText(myarray.get(i).getFiremode());
                P_ratefire.setText(myarray.get(i).getFirerate());
                A_firemode.setText(myarray.get(i).getAlt_firemode());
                A_ratefire.setText(myarray.get(i).getAlt_firerate());
                capacity.setText(myarray.get(i).getCapacity());
                fire_penet.setText(myarray.get(i).getWallpenetration());
                head_dmg.setText(myarray.get(i).getHead_dmg());
                torso_dmg.setText(myarray.get(i).getTorso_dmg());
                leg_dmg.setText(myarray.get(i).getLeg_dmg());
                Uri uri = Uri.parse(myarray.get(i).getVideo());
                try {
                    BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                    TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
                    simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
                    DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Exoplayer");
                    ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
                    MediaSource mediaSource = new ExtractorMediaSource(uri, dataSourceFactory, extractorsFactory, null, null);
                    simpleExoPlayerView.setPlayer(simpleExoPlayer);
                    simpleExoPlayer.prepare(mediaSource);
                    simpleExoPlayer.setPlayWhenReady(true);
                } catch (Exception e) {
                    Log.e("Exo player error", "exoplayer error" + e);
                }

            }

        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
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
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }
        if (adView != null) {
            adView.destroy();
        }
        if(simpleExoPlayer != null){
            simpleExoPlayer.stop();

        }

        super.onDestroy();
    }
}