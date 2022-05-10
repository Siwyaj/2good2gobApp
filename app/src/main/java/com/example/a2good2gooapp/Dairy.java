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

public class Dairy extends Fragment {
    LinearLayout llMasterDairy;
    String[] dairtIngredientArray = {"Cheddar","Creme fraiche","Emmentaler","Feta","Fløde","Flødeost","Gorgonzola","Grana padano","Græsk yoghurt","Halloumi","Hytteost","Kvark","Madlavningsfløde","Minimælk","Mozzarella","Mælk","Ost","Parmesan","Piskefløde","Ricotta","Skummemælk","Sødmælk","Yoghurt","Æg","Æggeblomme","Æggehvider"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dairy, container, false);
        llMasterDairy =(LinearLayout) view.findViewById(R.id.llMasterDairy);

        ((MainActivity)getActivity()).MakeTable(dairtIngredientArray, llMasterDairy, getActivity());


        return view;
    }
}