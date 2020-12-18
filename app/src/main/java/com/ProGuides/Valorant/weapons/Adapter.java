package com.ProGuides.Valorant.weapons;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ProGuides.Valorant.R;


import java.util.List;


public class Adapter extends ArrayAdapter <weapon>{



    private  Context mContext;
    private List<weapon> weapons ;
    private  int mResource;
    LayoutInflater inflater;

    public Adapter(@NonNull Context context, int resource, @NonNull List<weapon> objects) {
        super(context, resource, objects);
        this.mContext = context ;
        this.mResource = resource ;
        this.weapons = objects ;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView=inflater.from(mContext).inflate(R.layout.row,parent,false);
        }
        TextView weapname = convertView.findViewById(R.id.weapname);
        TextView weapmode = convertView.findViewById(R.id.weapmode);
        TextView weaprate = convertView.findViewById(R.id.ratefire);
        TextView weapcost = convertView.findViewById(R.id.weapcost);
        ImageView weapimage = convertView.findViewById(R.id.img);

        weapname.setText(weapons.get(position).getName());
        weapmode.setText(weapons.get(position).getFiremode());
        weaprate.setText(weapons.get(position).getFirerate());
        weapcost.setText(weapons.get(position).getPrice());
        weapimage.setImageResource(weapons.get(position).getImg());




        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, weaponDetails.class);
                intent.putExtra("name", weapons.get(position).getName().toString());

                    mContext.startActivity(intent);

            }
        });
        return  convertView;
    }


}
