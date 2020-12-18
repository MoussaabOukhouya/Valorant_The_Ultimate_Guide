package com.ProGuides.Valorant.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ProGuides.Valorant.weapons.Weapons;
import com.ProGuides.Valorant.agentsActivity;
import com.ProGuides.Valorant.R;
import com.ProGuides.Valorant.Ranked.Ranked;
import com.facebook.ads.InterstitialAd;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Maps extends AppCompatActivity {

    ViewPager viewPager;

    LinearLayout dotsLayout;
    sliderAdapter sliderAdapter;
    TextView[] dots;
    Button check;
    ImageButton next;
    int currPosition;
    Toolbar toolbar;
    MediaPlayer mp;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        mp = MediaPlayer.create(this, R.raw.tchic);


        setTitle("Maps");
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.maps);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.agents:
                        startActivity(new Intent(getApplicationContext(), agentsActivity.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.weapons:
                        startActivity(new Intent(getApplicationContext(), Weapons.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.ranked:
                        startActivity(new Intent(getApplicationContext(), Ranked.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.maps:

                        return true;

                }
                return false;
            }
        });

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        check = findViewById(R.id.present_map);
        next = findViewById(R.id.next);

        sliderAdapter = new sliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        adddots(0);
        viewPager.addOnPageChangeListener(changeListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = currPosition+1;
                viewPager.setCurrentItem(currPosition+1);
                mp.start();
                if( x > viewPager.getCurrentItem()){
                    viewPager.setCurrentItem(0);
                    currPosition = 0 ;
                }
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



    }

    private void adddots(int position) {

        dotsLayout.removeAllViews();
        dots = new TextView[4];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }

            if (dots.length > 0) {
                dots[position].setTextColor(getResources().getColor(R.color.pink));
            }

    }



    public void checkthis(View view){
        Intent intent = new Intent(getBaseContext(), checkMap.class);
        intent.putExtra("mapid",currPosition);
        startActivity(intent);

    }




        ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(viewPager.getCurrentItem() == viewPager.getAdapter().getCount())
                    viewPager.setCurrentItem(0);
            }

            @Override
            public void onPageSelected(final int position) {
                adddots(position);
                currPosition = position ;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

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