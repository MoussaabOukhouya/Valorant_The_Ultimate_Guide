package com.ProGuides.Valorant;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;


public class skinslider extends PagerAdapter {



    Context context;
    LayoutInflater layoutInflater;
    myskin Luxeknife= new myskin("Luxe Knife","1750 Valorant Points","","https://valorantskins.com/img/skins/knife/luxe-knife-skin.png");
    myskin Luxeghost= new myskin("Luxe Ghost","875 Valorant Points","","https://valorantskins.com/img/skins/ghost/luxe-ghost-level-1-skin.png");
    myskin Luxevandal= new myskin("Luxe Vandal","875 Valorant Points","","https://valorantskins.com/img/skins/vandal/luxe-vandal-level-1-skin.png");
    myskin Luxespectre= new myskin("Luxe Spectre","875 Valorant Points","","https://valorantskins.com/img/skins/spectre/luxe-spectre-level-1-skin.png");
    myskin Luxejudge= new myskin("Luxe Judge","1750 Valorant Points","","https://valorantskins.com/img/skins/judge/luxe-judge-skin.png");
    myskin Luxeoperator= new myskin("Luxe Operator","875 Valorant Points","","https://valorantskins.com/img/skins/operator/luxe-operator-level-1-skin.png");


    public skinslider(Context context) {
        this.context = context;
    }

    String images[] = {
            Luxeknife.getImg(),
            Luxeghost.getImg(),
            Luxevandal.getImg(),
            Luxespectre.getImg(),
            Luxejudge.getImg(),
            Luxeoperator.getImg()
    };

    String headers[] = {
            Luxeknife.getName(),
            Luxeghost.getName(),
            Luxevandal.getName(),
            Luxespectre.getName(),
            Luxejudge.getName(),
            Luxeoperator.getName()
    };

    String Prices[] = {
            Luxeknife.getPrice(),
            Luxeghost.getPrice(),
            Luxevandal.getPrice(),
            Luxespectre.getPrice(),
            Luxejudge.getPrice(),
            Luxeoperator.getPrice()
    };



    @Override
    public int getCount() {
        return headers.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (NestedScrollView)object ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideskin,container,false);


        String description[] = {
                view.getResources().getString(R.string.luxeknife),
                view.getResources().getString(R.string.LuxeGhost),
                view.getResources().getString(R.string.LuxeVandal),
                view.getResources().getString(R.string.LuxeSpectre),
                view.getResources().getString(R.string.LuxeJudge),
                view.getResources().getString(R.string.LuxeOperator)
        };

        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView header = view.findViewById(R.id.slider_header);
        TextView price = view.findViewById(R.id.slider_price);
        TextView desc = view.findViewById(R.id.slider_desc);
        VideoView video = view.findViewById(R.id.videoView);

        Picasso.get().load(images[position]).into(imageView);
        header.setText(headers[position]);
        price.setText(Prices[position]);
        desc.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((NestedScrollView)object);
    }
}
