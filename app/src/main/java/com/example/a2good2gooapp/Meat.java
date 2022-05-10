package com.example.a2good2gooapp;

import android.content.Context;
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

public class Meat extends Fragment {
    private LinearLayout llMasterMeat;
    private String[] meatIngrentsArray ={"Andebryst","Andelår","Bacon","Skinke","Bresaola","Skinkeschnitzel","Tigerrejer","Torsk","Tykstegsbøffer","Pølser","Steak","Steg","Svinekød","Svinekoteletter","Svinemørbrad","Culotte","Cuvette","Flæskesteg","Hakket kalvekød","Hakket kylling","Hakket oksekød","hakket svinekød","Kalvekød","Entrecote","Hamburgerryg","kalkunbryst","Kyllingebryst","Laks","Rejer"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meat,container,false);
        llMasterMeat =(LinearLayout) view.findViewById(R.id.llMasterMeat);

        ((MainActivity)getActivity()).MakeTable(meatIngrentsArray, llMasterMeat, getActivity());

        return view;
    }
}