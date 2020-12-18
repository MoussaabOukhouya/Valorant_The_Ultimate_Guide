package com.ProGuides.Valorant.weapons;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Pageadapter extends FragmentStatePagerAdapter {

    private  int nbrtabs ;
    public Pageadapter(FragmentManager fm , int nbr){
        super(fm);
        this.nbrtabs = nbr;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
            switch (position){

                case  0:
                    return  new Sidearms();
                case  1:
                    return  new Smgs();
                case  2:
                    return  new Shotguns();
                case  3:
                    return  new Rifles();
                case  4:
                    return  new Snipers();
                case  5:
                    return  new Heavy();
                default:
                    return null;
            }

    }

    @Override
    public int getCount() {
        return nbrtabs;
    }


}





