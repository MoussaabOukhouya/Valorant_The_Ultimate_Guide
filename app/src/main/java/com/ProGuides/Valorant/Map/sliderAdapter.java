package com.ProGuides.Valorant.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;

import com.ProGuides.Valorant.R;

public class sliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public sliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.havenico,
            R.drawable.splitico,
            R.drawable.blindico,
            R.drawable.ascentic
    };

    int headers[] = {
            R.string.haven,
            R.string.split,
            R.string.blind,
            R.string.ascent
    };

    int description[] = {
            R.string.havendes,
            R.string.splitdes,
            R.string.blinddes,
            R.string.ascentdes
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
        View view = layoutInflater.inflate(R.layout.sildes_layout,container,false);

        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView header = view.findViewById(R.id.slider_header);
        TextView desc = view.findViewById(R.id.slider_desc);

        imageView.setImageResource(images[position]);
        header.setText(headers[position]);
        desc.setText(description[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((NestedScrollView)object);
    }
}


