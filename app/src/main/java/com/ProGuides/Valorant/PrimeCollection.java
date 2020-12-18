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

import com.squareup.picasso.Picasso;

public class PrimeCollection extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    myskin Luxeknife= new myskin("Prime Knife","3550 Valorant Points","","https://valorantskins.com/img/skins/knife/prime-axe-skin.png");
    myskin Luxeghost= new myskin("Prime Classic","1775 Valorant Points","","https://valorantskins.com/img/skins/classic/prime-classic-skin.png");
    myskin Luxevandal= new myskin("Prime Vandal","1775 Valorant Points","","https://valorantskins.com/img/skins/vandal/prime-vandal-skin.png");
    myskin Luxespectre= new myskin("Prime Spectre","1775 Valorant Points","","https://valorantskins.com/img/skins/spectre/prime-spectre-skin.png");
    myskin Luxejudge= new myskin("Prime Guardian","1775 Valorant Points","","https://valorantskins.com/img/skins/guardian/prime-guardian-skin.png");



    public PrimeCollection(Context context) {
        this.context = context;
    }

    String images[] = {
            Luxeknife.getImg(),
            Luxeghost.getImg(),
            Luxevandal.getImg(),
            Luxespectre.getImg(),
            Luxejudge.getImg(),

    };

    String headers[] = {
            Luxeknife.getName(),
            Luxeghost.getName(),
            Luxevandal.getName(),
            Luxespectre.getName(),
            Luxejudge.getName(),

    };

    String Prices[] = {
            Luxeknife.getPrice(),
            Luxeghost.getPrice(),
            Luxevandal.getPrice(),
            Luxespectre.getPrice(),
            Luxejudge.getPrice(),

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
                view.getResources().getString(R.string.PrimeKnife),
                view.getResources().getString(R.string.PrimeClassic),
                view.getResources().getString(R.string.PrimeVandal),
                view.getResources().getString(R.string.PrimeSpectre),
                view.getResources().getString(R.string.PrimeGuardian)
        };

        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView header = view.findViewById(R.id.slider_header);
        TextView price = view.findViewById(R.id.slider_price);
        TextView desc = view.findViewById(R.id.slider_desc);


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
