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
 * Use the {@link Shotguns#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Shotguns extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Shotguns() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Shotguns.
     */
    // TODO: Rename and change types and number of parameters
    public static Shotguns newInstance(String param1, String param2) {
        Shotguns fragment = new Shotguns();
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
    weapon Bucky = new weapon("Bucky", "Cost: 900", "Fire Mode: Semi-Automatic", "Rate Of Fire: 1.1 Rounds/sec", R.drawable.bucky);
    weapon Judge = new weapon("Judge", "Cost: 1500", "Fire Mode: Full-Automatic", "Rate Of Fire: 3.5 Rounds/sec", R.drawable.judge);

    ListView lv;
    ArrayList<weapon> weapons = new ArrayList<weapon>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shotguns,container,false);
        lv = rootView.findViewById(R.id.shotgunview);

        weapons.add(Bucky);
        weapons.add(Judge);

        Adapter adapter = new Adapter(getContext(),R.id.myyyview,weapons);
        lv.setAdapter(adapter);
        return  rootView;
    }
}
