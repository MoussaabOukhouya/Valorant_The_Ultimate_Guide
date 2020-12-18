package com.ProGuides.Valorant.Ranked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ProGuides.Valorant.R;
import com.facebook.ads.InterstitialAd;


public class ranked_details extends AppCompatActivity {

    TextView tile;
    TextView answer;
    private InterstitialAd interstitialAd;
    private InterstitialAd interstitialAd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranked_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Details");
        interstitialAd = new InterstitialAd(this, "725119301645228_725259454964546");
        interstitialAd.loadAd();
        interstitialAd2 = new InterstitialAd(this, "725119301645228_725259951631163");
        interstitialAd2.loadAd();
        tile = findViewById(R.id.question_title);
        answer = findViewById(R.id.answer);



        Intent intent = getIntent();
        int id = intent.getIntExtra("Question_number", -1);

        if (id == 1) {
            tile.setText("How Does Ranked work?");
            answer.setText(R.string.one);
        } else if (id == 2) {
            tile.setText("How do I unlock ranked?");
            answer.setText(R.string.two);
        } else if (id == 3) {
            tile.setText("How do I rank up?");
            answer.setText(R.string.three);
        } else if (id == 4) {
            tile.setText("Is there a points system?");
            answer.setText(R.string.four);
        } else if (id == 5) {
            tile.setText("Can I queue up with friends?");
            answer.setText(R.string.five);
        } else if (id == 6) {
            tile.setText("What happens if I don’t play ranked for a while?");
            answer.setText(R.string.sex);
        } else if (id == 7) {
            tile.setText("What’s the future of ranked look like?");
            answer.setText(R.string.seven);
        }

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
        super.onDestroy();
    }
}
