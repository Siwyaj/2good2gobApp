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


public class Grain extends Fragment {
    private LinearLayout llMasterGrain;
    private String[] grainIngredientsArray= {"Brød","Bulgur","Burgerboller","Butterdej","Franskbrød","Hvedebrød","Perlebyg","perlespelt","Pinjekerner","Pitabrød","Pølsebrød","Sesamfrø","Toastbrød","Tortilla","Tortilla Chips","Peanuts"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grain, container, false);
        llMasterGrain =(LinearLayout) view.findViewById(R.id.llMasterGrain);

        ((MainActivity)getActivity()).MakeTable(grainIngredientsArray,llMasterGrain,getActivity());

        return view;
    }
}