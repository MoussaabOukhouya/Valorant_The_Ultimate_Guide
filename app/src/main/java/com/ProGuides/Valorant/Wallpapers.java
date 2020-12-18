package com.ProGuides.Valorant;


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
import android.widget.ImageView;

import android.widget.Toast;


import com.facebook.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;



import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class Wallpapers extends AppCompatActivity {
    ImageView wall1,wall2,wall3,wall4,wall5;
    ImageView wall6,wall7,wall8,wall9,wall10;
    ImageView wall11,wall12,wall13,wall14,wall15;
    ImageView wall16,wall17,wall18,wall19,wall20;
    private InterstitialAd interstitialAd2;

    Toolbar toolbar;
    FirebaseDatabase database ;
    String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        interstitialAd2 = new InterstitialAd(this, "725119301645228_725259951631163");
        interstitialAd2.loadAd();


        wall1 = findViewById(R.id.wallone);
        wall2 = findViewById(R.id.walltwo);
        wall3 = findViewById(R.id.wall3);
        wall4 = findViewById(R.id.wall4);
        wall5 = findViewById(R.id.wall5);
        wall6 = findViewById(R.id.wall6);
        wall7 = findViewById(R.id.wall7);
        wall8 = findViewById(R.id.wall8);
        wall9 = findViewById(R.id.wall9);
        wall10 = findViewById(R.id.wall10);
        wall11 = findViewById(R.id.wall11);
        wall12 = findViewById(R.id.wall12);
        wall13 = findViewById(R.id.wall13);
        wall14 = findViewById(R.id.wall14);
        wall15 = findViewById(R.id.wall15);
        wall16 = findViewById(R.id.wall16);
        wall17 = findViewById(R.id.wall17);
        wall18 = findViewById(R.id.wall18);
        wall19 = findViewById(R.id.wall19);
        wall20 = findViewById(R.id.wall20);

        database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("wall1");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall1);
                wall1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);


                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

         myRef = database.getReference("wall2");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall2);
                wall2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);


                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall3");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).resize(350,600).into(wall3);
                wall3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);


                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });


        myRef = database.getReference("wall4");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall4);
                wall4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);


                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall5");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall5);
                wall5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall6");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall6);
                wall6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall7");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall7);
                wall7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall8");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall8);
                wall8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall9");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall9);
                wall9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall10");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall10);
                wall10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall11");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall11);
                wall11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall12");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall12);
                wall12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall13");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall13);
                wall13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall14");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall14);
                wall14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall15");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall15);
                wall15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall16");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall16);
                wall16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall17");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall17);
                wall17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall18");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall18);
                wall18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);


                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall19");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall19);
                wall19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });

        myRef = database.getReference("wall20");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                url = dataSnapshot.getValue(String.class);
                final String link = url;
                Picasso.get().load(url).transform(new RoundedCornersTransformation(30,00)).resize(350,600).into(wall20);
                wall20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(),Fullscreen.class);
                        intent.putExtra("link",link);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError error) {


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
    protected void onDestroy() {
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }
        super.onDestroy();
    }
}
