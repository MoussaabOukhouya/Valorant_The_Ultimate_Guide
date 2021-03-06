package com.ProGuides.Valorant.Agents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;


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



public class cypherAbilities extends AppCompatActivity {

    SimpleExoPlayer simpleExoPlayer;
    PlayerView simpleExoPlayerView;
    private AdView adView;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cypher_abilities);

        adView = new AdView(getApplicationContext(),"725119301645228_725230904967401", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        interstitialAd = new InterstitialAd(this, "725119301645228_725215674968924");
        interstitialAd.loadAd();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = (TextView)findViewById(R.id.about);
        simpleExoPlayerView =(PlayerView) findViewById(R.id.videoView);
        Intent intent = getIntent();
        String abilitie = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(abilitie.equals("trapwire")){
            Uri uri = Uri.parse("https://blitz-cdn-videos.blitz.gg/valorant/agents/cypher/abilities/Cypher_C.mp4#t=0.1");
            try{
                BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                TrackSelector trackSelector =  new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
                simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this,trackSelector);
                DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Exoplayer");
                ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
                MediaSource mediaSource = new ExtractorMediaSource(uri,dataSourceFactory,extractorsFactory,null,null);
                simpleExoPlayerView.setPlayer(simpleExoPlayer);
                simpleExoPlayer.prepare(mediaSource);
                simpleExoPlayer.setPlayWhenReady(true);
            }catch (Exception e){
                Log.e("Exo player error","exoplayer error"+e);
            }
            textView.setText(R.string.trapwire);
            getSupportActionBar().setTitle("Trapwire");
        }
        else if (abilitie.equals("cybercage")){
            Uri uri = Uri.parse("https://blitz-cdn-videos.blitz.gg/valorant/agents/cypher/abilities/Cypher_Q.mp4#t=0.1");
            try{
                BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                TrackSelector trackSelector =  new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
                simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this,trackSelector);
                DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Exoplayer");
                ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
                MediaSource mediaSource = new ExtractorMediaSource(uri,dataSourceFactory,extractorsFactory,null,null);
                simpleExoPlayerView.setPlayer(simpleExoPlayer);
                simpleExoPlayer.prepare(mediaSource);
                simpleExoPlayer.setPlayWhenReady(true);
            }catch (Exception e){
                Log.e("Exo player error","exoplayer error"+e);
            }
            textView.setText(R.string.cybercage);
            getSupportActionBar().setTitle("Cyber Cage");
        }
        else if (abilitie.equals("spycam")){
            Uri uri = Uri.parse("https://blitz-cdn-videos.blitz.gg/valorant/agents/cypher/abilities/Cypher_E.mp4#t=0.1");
            try{
                BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                TrackSelector trackSelector =  new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
                simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this,trackSelector);
                DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Exoplayer");
                ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
                MediaSource mediaSource = new ExtractorMediaSource(uri,dataSourceFactory,extractorsFactory,null,null);
                simpleExoPlayerView.setPlayer(simpleExoPlayer);
                simpleExoPlayer.prepare(mediaSource);
                simpleExoPlayer.setPlayWhenReady(true);
            }catch (Exception e){
                Log.e("Exo player error","exoplayer error"+e);
            }
            textView.setText(R.string.spycam);
            getSupportActionBar().setTitle("Spy Cam");
        }
        else if (abilitie.equals("neutraltheft")){
            Uri uri = Uri.parse("https://blitz-cdn-videos.blitz.gg/valorant/agents/cypher/abilities/Cypher_X.mp4#t=0.1");
            try{
                BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
                TrackSelector trackSelector =  new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
                simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this,trackSelector);
                DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Exoplayer");
                ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
                MediaSource mediaSource = new ExtractorMediaSource(uri,dataSourceFactory,extractorsFactory,null,null);
                simpleExoPlayerView.setPlayer(simpleExoPlayer);
                simpleExoPlayer.prepare(mediaSource);
                simpleExoPlayer.setPlayWhenReady(true);
            }catch (Exception e){
                Log.e("Exo player error","exoplayer error"+e);
            }
            textView.setText(R.string.neutraltheft);
            getSupportActionBar().setTitle("Neural Theft");
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
        if (adView != null) {
            adView.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}
