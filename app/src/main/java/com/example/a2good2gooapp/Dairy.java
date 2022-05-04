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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dairy, container, false);
        llMasterDairy =(LinearLayout) view.findViewById(R.id.llMasterDairy);
        MakeTable();


        return view;
    }
    public void MakeTable() {
        ArrayList<String> vegetablesList = new ArrayList<String>();
        ArrayList<String> ingredientsSelected = new ArrayList<String>();
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Æ","Ø","Å"};//,'Æ','Ø','Å'
        String[] dairtArray = {"Gulderod","Bønner","Broccoli","Kartoffel","Pore","Tomat","Squash","Peberfrugt","Løg","Hvidløg", "Chili", "Champignon","Celleri", "Blomkål"};
        //androidx.gridlayout.widget.GridLayout gridMaster = findViewById(R.id.gridMaster);


        for (String alpha: alphabet) {
            ArrayList<String> currentLetter = new ArrayList<String>();
            for (int i=0; i<dairtArray.length-1;i++){
                if (dairtArray[i].startsWith(alpha)){
                    currentLetter.add(dairtArray[i]);
                }
            }
            if (!currentLetter.isEmpty()){
                TextView letter = new TextView(getActivity());
                letter.setText(alpha);
                llMasterDairy.addView(letter);
                GridLayout letterGrid = new GridLayout(getActivity());
                for (String s : currentLetter) {

                    //all of the object creation
                    CardView cardView = new CardView(getActivity());
                    ImageView ingredientPicture = new ImageView(getActivity());
                    LinearLayout llIngredient = new LinearLayout(getActivity());
                    TextView textView = new TextView(getActivity());
                    //gridMaster.setPadding(50,50,50,50);

                    //imag
                    int id = getResources().getIdentifier(replaceCharUsingCharArray(s).toLowerCase(Locale.ROOT), "drawable",getActivity().getPackageName());
                    ingredientPicture.setImageResource(id);
                    GradientDrawable border = new GradientDrawable();
                    border.setColor(0xFFFFFFFF);
                    border.setStroke(15,0xFFFEAD30);
                    ingredientPicture.setBackgroundDrawable(border);


                    llIngredient.setHorizontalGravity(11);
                    llIngredient.setGravity(11);
                    llIngredient.setOrientation(LinearLayout.VERTICAL);

                    ingredientPicture.setClickable(true);
                    ingredientPicture.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (ingredientsSelected.contains(s)){
                                ingredientsSelected.remove(s);
                                border.setStroke(15,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
                            }
                            else{
                                ingredientsSelected.add(s);
                                border.setStroke(25,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
                            }
                            CharSequence selected = s;
                            int duration = Toast.LENGTH_SHORT;

                        }
                    });
                    //The card only containing the picture of the ingredient.
                    cardView.setRadius(20);
                    cardView.setPadding(50, 50, 50, 50);

                    cardView.getCardBackgroundColor();
                    cardView.setLayoutParams(new RelativeLayout.LayoutParams(300, 300));
                    ingredientPicture.setPadding(20, 20, 20, 20);

                    //ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    //layoutParams.width();
                    //imageView.setLayoutParams(layoutParams);

                    //The ingredient text
                    textView.setPadding(20, 20, 20, 20);
                    textView.setGravity(11);
                    textView.setText(s);
                    //textView.setLayoutParams(params);

                    llIngredient.setPadding(20, 20, 20, 20);

                    //putting everything together
                    cardView.addView(ingredientPicture);
                    llIngredient.addView(cardView);
                    llIngredient.addView(textView);
                    if (letterGrid.getParent()!=null){
                        ((ViewGroup)letterGrid.getParent()).removeView(letterGrid);
                    }

                    letterGrid.addView(llIngredient);
                    llMasterDairy.addView(letterGrid);
                }
            }
        }
        //Integer[] picture = {R.drawable.blomkl,R.drawable.broccoli,R.drawable.celleri,R.drawable.chili,R.drawable.gulderod,R.drawable.hvidlg,R.drawable.kartoffel,R.drawable.lg,R.drawable.peberfrugt,R.drawable.pore,R.drawable.tomat};
    }
    public String replaceCharUsingCharArray(String str) {//this method just makes it so, that when a string is put into it containing æ,ø,å, then it will return the same word, but wil ae,oe,aa
        char[] charWordArray = str.toCharArray();
        ArrayList<String> wordArray = new ArrayList<String>();
        for (int i=0;i<charWordArray.length;i++){
            wordArray.add(String.valueOf(charWordArray[i]));
        }
        for (String c : wordArray) {
            Log.d("MainActivity",""+c);
            switch (c){
                case "æ":
                    wordArray.set(wordArray.indexOf(c),"ae");
                    break;
                case "ø":
                    wordArray.set(wordArray.indexOf(c),"oe");
                    break;
                case "å":
                    wordArray.set(wordArray.indexOf(c),"aa");
                    break;
                default:
                    break;

            }
        }
        String word = "";
        for (String s:wordArray) {
            word+=s;
        }
        return word;
    }
}