package com.ProGuides.Valorant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;


public class showskins extends AppCompatActivity {

    ViewPager viewPager;
    ImageButton next;
    ImageButton previous;
    skinslider skinslider;
    PrimeCollection primeCollection;
    Prismcollection prismcollection;
    AristoCollection aristoCollection;
    ReaverCollection reaverCollection;
    TextView title;
    int currPosition;
    Toolbar toolbar;
     MediaPlayer mp;
    private InterstitialAd interstitialAd2;
    private InterstitialAd interstitialAd;
    private AdView adView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showskins);
        adView = new AdView(this,"725119301645228_725283531628805", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        interstitialAd2 = new InterstitialAd(this, "725119301645228_725259951631163");
        interstitialAd2.loadAd();
        interstitialAd = new InterstitialAd(this, "725119301645228_725279824962509");
        interstitialAd.loadAd();
        viewPager = findViewById(R.id.slider);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.title);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        mp = MediaPlayer.create(this, R.raw.tchic);




        Intent intent = getIntent();
        String name = getIntent().getStringExtra("collection");
        if (name.equals("Luxe")) {
            skinslider = new skinslider(this);
            viewPager.setAdapter(skinslider);
            title.setText("Luxe");
        } else if (name.equals("Prism")) {
            prismcollection = new Prismcollection(this);
            viewPager.setAdapter(prismcollection);
            title.setText("Prism");
        } else if (name.equals("Reaver")) {
            reaverCollection = new ReaverCollection(this);
            viewPager.setAdapter(reaverCollection);
            title.setText("Reaver");
        } else if (name.equals("Prime")) {
            primeCollection = new PrimeCollection(this);
            viewPager.setAdapter(primeCollection);
            title.setText("Prime");
        } else if (name.equals("Aristo")) {
            aristoCollection = new AristoCollection(this);
            viewPager.setAdapter(aristoCollection);
            title.setText("Aristocrat");
        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                currPosition = viewPager.getCurrentItem();
                viewPager.setCurrentItem(currPosition+1);



                }
            });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                currPosition = viewPager.getCurrentItem();
                int x = currPosition--;
                viewPager.setCurrentItem(currPosition--);
            }
        });

        next.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        previous.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(viewPager.getCurrentItem() == 0)
                    previous.setVisibility(View.GONE);
                else
                    previous.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageSelected(int position) {
                if(position+1==viewPager.getAdapter().getCount())
                    next.setVisibility(View.GONE);
                else
                    next.setVisibility(View.VISIBLE);


            }


            @Override
            public void onPageScrollStateChanged(int state) {


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
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        if (adView != null) {
            adView.destroy();
        }

        super.onDestroy();
    }
}







