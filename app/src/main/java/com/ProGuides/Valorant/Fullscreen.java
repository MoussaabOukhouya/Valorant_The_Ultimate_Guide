package com.ProGuides.Valorant;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class Fullscreen extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1000 ;
    ImageView wall;
    ImageButton share;
    ImageButton set;
    ImageButton download;
    ImageButton home;
    ImageButton lock;
    String link;
    Bitmap bitmap = null;
    private  InterstitialAd interstitialAd;
    private InterstitialAd interstitialAd3;
    private InterstitialAd interstitialAd2;
    private InterstitialAd interstitialAd4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        interstitialAd = new InterstitialAd(this, "725119301645228_725290704961421");//download
        interstitialAd.loadAd();
        interstitialAd2 = new InterstitialAd(this, "725119301645228_725302441626914");//lockscreen
        interstitialAd2.loadAd();
        interstitialAd3 = new InterstitialAd(this, "725119301645228_725309361626222");//share
        interstitialAd3.loadAd();
        interstitialAd4 = new InterstitialAd(this, "725119301645228_725310611626097");//home
        interstitialAd4.loadAd();

        if (Build.VERSION.SDK_INT >= 4.4) {
            int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
            getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        }
        Intent intent = getIntent();
        link = getIntent().getStringExtra("link");


        share = findViewById(R.id.share);
        set = findViewById(R.id.set);
        download = findViewById(R.id.download);
        home =findViewById(R.id.homescreen);
        lock = findViewById(R.id.lock);









        share.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0D4D4D4, PorterDuff.Mode.OVERLAY);
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

        set.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0D4D4D4, PorterDuff.Mode.OVERLAY);
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

        download.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0D4D4D4, PorterDuff.Mode.OVERLAY);
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

        wall = findViewById(R.id.wallpaper);
        Picasso.get().load(link).into(wall);

        final Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        final Animation bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);



        download.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                    if (interstitialAd.isAdLoaded()) {
                        bitmap = ((BitmapDrawable) wall.getDrawable()).getBitmap();
                                String time = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
                                File dir = new File(Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DCIM + "/");
                                dir.mkdirs();
                                String name = time + ".jpg";
                                File file = new File(dir, name);
                                OutputStream out;
                                try {
                                    out = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG  , 100, out);
                                    out.flush();
                                    out.close();
                                    Toast.makeText(getApplicationContext(), "Image Saved in DCIM", Toast.LENGTH_SHORT).show();

                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG);
                                }
                        interstitialAd.show();
                    }
                }
                else{
                    ActivityCompat.requestPermissions(Fullscreen.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
                }
            }


        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(interstitialAd3.isAdLoaded()){
                    Activity activityContext = Fullscreen.this ;
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT, "Check this wallpaper of Valorant");
                            i.putExtra(Intent.EXTRA_TEXT, link);
                            startActivity(Intent.createChooser(i, "Wallpaper"));
                    interstitialAd3.show();
                }

            }



        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lock.isShown()){
                    set.setImageResource(R.drawable.set);
                    lock.setVisibility(View.GONE);
                    home.setVisibility(View.GONE);
                }
                else {

                    set.getBackground().setColorFilter(0xe0D4D4D4, PorterDuff.Mode.OVERLAY);
                    set.setImageResource(R.drawable.close);
                    lock.setVisibility(View.VISIBLE);
                    lock.startAnimation(bounce);
                    home.setVisibility(View.VISIBLE);
                    home.startAnimation(bounce);
                    ;
                }

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd4.isAdLoaded()) {
                    interstitialAd4.show();
                }
                Picasso.get().load(link).into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                        try {
                            wallpaperManager.setBitmap(bitmap);
                            set.getBackground().setColorFilter(getResources().getColor(R.color.trans), PorterDuff.Mode.OVERLAY);
                            set.setImageResource(R.drawable.set);
                            home.clearAnimation();
                            lock.setVisibility(View.GONE);
                            home.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Home Wallpaper Upadated Successfully",Toast.LENGTH_SHORT).show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {


                    }


                    @Override
                    public void onPrepareLoad(final Drawable placeHolderDrawable) {


                    }


                });


            }

        });

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd2.isAdLoaded()) {
                    interstitialAd2.show();
                }
                Picasso.get().load(link).into(new Target() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                        try {
                            wallpaperManager.setBitmap(bitmap,null,true,WallpaperManager.FLAG_LOCK);
                            set.getBackground().setColorFilter(getResources().getColor(R.color.trans), PorterDuff.Mode.OVERLAY);
                            set.setImageResource(R.drawable.set);
                            home.clearAnimation();
                            lock.setVisibility(View.GONE);
                            home.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"LockScreen Wallpaper Upadated Successfully",Toast.LENGTH_SHORT).show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {


                    }


                    @Override
                    public void onPrepareLoad(final Drawable placeHolderDrawable) {


                    }


                });

            }
        });


    }

    @Override
    protected void onDestroy() {
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        if (interstitialAd3 != null) {
            interstitialAd3.destroy();
        }
        if (interstitialAd4 != null) {
            interstitialAd4.destroy();
        }


        super.onDestroy();
    }


}







