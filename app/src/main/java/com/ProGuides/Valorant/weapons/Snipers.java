package com.ProGuides.Valorant.weapons;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ProGuides.Valorant.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Snipers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Snipers extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Snipers() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Snipers.
     */
    // TODO: Rename and change types and number of parameters
    public static Snipers newInstance(String param1, String param2) {
        Snipers fragment = new Snipers();
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

    weapon marshal = new weapon("Marshal", "Cost: 1100", "Fire Mode: Semi-Automatic", "Rate Of Fire: 1.5 Rounds/sec", R.drawable.marshal);
    weapon operator = new weapon("Operator", "Cost: 4500", "Fire Mode: Semi-Automatic", "Rate Of Fire: 0.75 Rounds/sec", R.drawable.operator);
    ListView lv;
    ArrayList<weapon> weapons = new ArrayList<weapon>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_snipers, container, false);
        lv = rootView.findViewById(R.id.sniperview);

        weapons.add(marshal);
        weapons.add(operator);
        Adapter adapter = new Adapter(getContext(), R.id.myyyview, weapons);
        lv.setAdapter(adapter);

        return rootView;
    }

}









