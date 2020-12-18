package com.ProGuides.Valorant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;

import com.ProGuides.Valorant.R;
import com.ProGuides.Valorant.myskin;
import com.ProGuides.Valorant.weapons.Pageadapter;
import com.squareup.picasso.Picasso;

public class Prismcollection extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    myskin Luxeknife= new myskin("Prism Knife","2550 Valorant Points","","https://valorantskins.com/img/skins/knife/prism-knife-skin.png");
    myskin Luxeghost= new myskin("Prism Ghost","1275 Valorant Points","","https://valorantskins.com/img/skins/ghost/prism-ghost-skin.png");
    myskin Luxevandal= new myskin("Prism Phantom","1275 Valorant Points","","https://valorantskins.com/img/skins/phantom/prism-phantom-skin.png");
    myskin Luxespectre= new myskin("Prism Spectre","1275 Valorant Points","","https://valorantskins.com/img/skins/spectre/prism-spectre-skin.png");
    myskin Luxejudge= new myskin("Luxe Operator","1275 Valorant Points","","https://valorantskins.com/img/skins/operator/prism-operator-skin.png");
    myskin Luxeoperator= new myskin("Prism Ares","1275 Valorant Points","","https://valorantskins.com/img/skins/ares/prism-ares-skin.png");


    public Prismcollection(Context context) {
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
                view.getResources().getString(R.string.Prismknife),
                view.getResources().getString(R.string.PrismGhost),
                view.getResources().getString(R.string.PrismPhantom),
                view.getResources().getString(R.string.PrismSpectre),
                view.getResources().getString(R.string.PrismOperator),
                view.getResources().getString(R.string.PrismAres)
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
