package com.example.a2good2gooapp;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Veggies extends Fragment {

    private LinearLayout llMasterVeggies;
    private String[] veggieArray = {"Æble","Ærter","Ærteskud","Agurk","Ananas","Appelsin","Asparges","Aubergine","Avocado","Bælgede edamamebønner","Bagekartofler","Bananer","Blomkål","Bønnespirer","Broccoli","Champignon","Cherrytomater","Citron","Citrongræs","Citronsaft","Dåse majs","Enebær","Fennikel","Flåede tomater","Forårsløg","Frisk basilikum","Frisk chili","Frisk ingefær","Frisk koriander","Frisk oregano","Frisk rosmarin","Frisk salvie","Frisk spinat","Frisk timian","Glaskartofler","Granatæbler","Grønkål","Gulerod","Gurkemeje","Hakkede tomater","Hjertesalat","Hvidkål","Hvidløg","Iceberg salat","Jalapenos","Jordskokker","Kål","Kartofler","Kinakål","Knoldselleri","Lime","Limeblade","Limesaft","Linser","Løg","Majskolber","Mango","Oliven","Pære","Pastinak","Peberfrugt","Peberrod","Perleløg","Persille","Pickles","Porre","Portobellosvamp","Purløg","Radiser","Rødbeder","Rødløg","Rosenkål","Rosiner","Rucola","Selleri","Skalotteløg","Søde kartofler","Soltørrede tomater","Spidskål","Squash","Sukkerærter","Svesker","Syltede rødløg","Tofu","Tomat","Tranebær","Vindruer","Zittauerløg"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_veggies, container, false);
        llMasterVeggies =(LinearLayout) view.findViewById(R.id.llMasterVeggies);

                ((MainActivity)getActivity()).MakeTable(veggieArray, llMasterVeggies, getActivity());

        return view;
    }
}