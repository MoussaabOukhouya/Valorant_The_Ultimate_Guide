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
 * Use the {@link Rifles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Rifles extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Rifles() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Rifles.
     */
    // TODO: Rename and change types and number of parameters
    public static Rifles newInstance(String param1, String param2) {
        Rifles fragment = new Rifles();
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
    weapon bulldog= new weapon("Bulldog", "Cost: 2100", "Fire Mode: Full-Automatic", "Rate Of Fire: 9.15 Rounds/sec", R.drawable.bulldog);
    weapon guardian= new weapon("Guardian", "Cost: 2700", "Fire Mode: Semi-Automatic", "Rate Of Fire: 6.5 Rounds/sec", R.drawable.guardian);
    weapon phantom= new weapon("Phantom", "Cost: 2900", "Fire Mode: Full-Automatic", "Rate Of Fire: 11 Rounds/sec", R.drawable.phantom);
    weapon vandal= new weapon("Vandal", "Cost: 2900", "Fire Mode: Full-Automatic", "Rate Of Fire: 9.25 Rounds/sec", R.drawable.vandal);

    ListView lv;
    ArrayList<weapon> weapons = new ArrayList<weapon>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rifles,container,false);
        lv = rootView.findViewById(R.id.riflesview);
        weapons.add(bulldog);
        weapons.add(guardian);
        weapons.add(phantom);
        weapons.add(vandal);
        Adapter adapter = new Adapter(getContext(),R.id.myyyview,weapons);
        lv.setAdapter(adapter);
        return  rootView;
    }
}
