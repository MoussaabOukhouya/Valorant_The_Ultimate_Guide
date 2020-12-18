package com.ProGuides.Valorant.weapons;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ProGuides.Valorant.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sidearms#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sidearms extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Sidearms() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sidearms.
     */
    // TODO: Rename and change types and number of parameters
    public static Sidearms newInstance(String param1, String param2) {
        Sidearms fragment = new Sidearms();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    weapon classic = new weapon("Classic", "Free", "Fire Mode: Semi-Automatic", "Rate Of Fire: 6.75 Rounds/sec", R.drawable.classic);
    weapon shorty = new weapon("Shorty", "Cost: 200", "Fire Mode: Semi-Automatic", "Rate Of Fire: 3.3 Rounds/sec", R.drawable.shorty);
    weapon frenzy = new weapon("Frenzy", "Cost: 400", "Fire Mode: Full-Automatic", "Rate Of Fire: 10 Rounds/sec", R.drawable.frenzy);
    weapon ghost = new weapon("Ghost", "Cost: 500", "Fire Mode: Semi-Automatic", "Rate Of Fire: 6.75 Rounds/sec", R.drawable.ghost);
    weapon sheriff = new weapon("Sheriff", "Cost: 800", "Fire Mode: Semi-Automatic", "Rate Of Fire: 4 Rounds/sec", R.drawable.sheriff);
    ListView lv;
    ArrayList<weapon> weapons = new ArrayList<weapon>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sidearms,container,false);
            lv = rootView.findViewById(R.id.sidearmsview);
        weapons.add(classic);
        weapons.add(shorty);
        weapons.add(frenzy);
        weapons.add(ghost);
        weapons.add(sheriff);
            Adapter adapter = new Adapter(getContext(),R.id.myyyview,weapons);
            lv.setAdapter(adapter);
            return  rootView;

    }


    }


