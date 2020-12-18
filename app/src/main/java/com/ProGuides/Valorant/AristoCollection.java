package com.ProGuides.Valorant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

public class AristoCollection extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    myskin Luxeknife= new myskin("Aristocrat Sheriff","1275 Valorant Points","","https://valorantskins.com/img/skins/sheriff/aristocrat-sheriff-skin.png");
    myskin Luxeghost= new myskin("Aristocrat Stinger","1275 Valorant Points","","https://valorantskins.com/img/skins/stinger/aristocrat-stinger-skin.png");
    myskin Luxevandal= new myskin("Aristocrat Vandal","1275 Valorant Points","","https://valorantskins.com/img/skins/vandal/aristocrat-vandal-skin.png");
    myskin Luxespectre= new myskin("Aristocrat Bulldog","1275 Valorant Points","","https://valorantskins.com/img/skins/bulldog/aristocrat-bulldog-skin.png");
    myskin Luxejudge= new myskin("Aristocrat Ares","1275 Valorant Points","","https://valorantskins.com/img/skins/ares/aristocrat-ares-skin.png");



    public AristoCollection(Context context) {
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
                view.getResources().getString(R.string.AristocratSheriff),
                view.getResources().getString(R.string.AristocratStinger),
                view.getResources().getString(R.string.AristocratVandal),
                view.getResources().getString(R.string.AristocratBulldog),
                view.getResources().getString(R.string.AristocratAres)
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
