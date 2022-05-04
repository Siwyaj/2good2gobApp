package com.example.a2good2gooapp;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.gridlayout.widget.GridLayout;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    int totalIngrediensSelected = 0;
    //ArrayList<String> vegetablesSorted=new ArrayList<String>(); not needed
    int newestListId=1;//if we at some point want to add list updating
    int currentListId=0;
    int n = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeCategoryToolBar();
        ViewPager viewpager = findViewById(R.id.viewPager);
        //MakeTable();


    }
/*
    public void MakeTable() {
    private ArrayList<String> vegetablesList = new ArrayList<String>();
    private ArrayList<String> ingredientsSelected = new ArrayList<String>();
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Æ","Ø","Å"};//,'Æ','Ø','Å'
        String[] grainArray = {"Gulderod","Bønner","Broccoli","Kartoffel","Pore","Tomat","Squash","Peberfrugt","Løg","Hvidløg", "Chili", "Champignon","Celleri", "Blomkål"};
        //androidx.gridlayout.widget.GridLayout gridMaster = findViewById(R.id.gridMaster);
        LinearLayout llMaster = findViewById(R.id.llMaster);

        for (String alpha: alphabet) {
            ArrayList<String> currentLetter = new ArrayList<String>();
            for (int i=0; i<grainArray.length-1;i++){
                if (grainArray[i].startsWith(alpha)){
                    currentLetter.add(grainArray[i]);
                }
            }
            if (!currentLetter.isEmpty()){
                TextView letter = new TextView(this);
                letter.setText(alpha);
                llMaster.addView(letter);
                GridLayout letterGrid = new GridLayout(this);
                for (String s : currentLetter) {

                    //all of the object creation
                    CardView cardView = new CardView(this);
                    ImageView ingredientPicture = new ImageView(this);
                    LinearLayout llIngredient = new LinearLayout(this);
                    TextView textView = new TextView(this);
                    //gridMaster.setPadding(50,50,50,50);

                    //imag
                    int id = getResources().getIdentifier(replaceCharUsingCharArray(s).toLowerCase(Locale.ROOT), "drawable", getPackageName());
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
                            Context context = getApplicationContext();
                            if (ingredientsSelected.contains(s)){
                                ingredientsSelected.remove(s);
                                totalIngrediensSelected--;
                                border.setStroke(15,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
                            }
                            else{
                                ingredientsSelected.add(s);
                                totalIngrediensSelected++;
                                border.setStroke(25,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
                            }
                            CharSequence selected = s;
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, selected, duration);
                            toast.show();
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
                    llMaster.addView(letterGrid);
                }
            }
        }
        //Integer[] picture = {R.drawable.blomkl,R.drawable.broccoli,R.drawable.celleri,R.drawable.chili,R.drawable.gulderod,R.drawable.hvidlg,R.drawable.kartoffel,R.drawable.lg,R.drawable.peberfrugt,R.drawable.pore,R.drawable.tomat};
    }*/
    public void MakeCategoryToolBar() {
        //tab creater start
        //FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        /*
        TabLayout.Tab veggieTab = tabLayout.newTab();
        TabLayout.Tab meatTab = tabLayout.newTab();
        TabLayout.Tab dairyTab = tabLayout.newTab();
        TabLayout.Tab grainTab = tabLayout.newTab();
        veggieTab.setIcon(R.drawable.veggie);
        meatTab.setIcon(R.drawable.steak);
        dairyTab.setIcon(R.drawable.milk);
        grainTab.setIcon(R.drawable.bread);
        tabLayout.addTab(veggieTab);
        tabLayout.addTab(meatTab);
        tabLayout.addTab(dairyTab);
        tabLayout.addTab(grainTab);*/
        //tab creater stop

        viewPager = findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);

        PageAdapter VPAdapter = new PageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        VPAdapter.addFragment(new Veggies(),"");//just add something in the "" if you want text belo icons
        VPAdapter.addFragment(new Meat(),"");
        VPAdapter.addFragment(new Dairy(),"");
        VPAdapter.addFragment(new Grain(),"");
        viewPager.setAdapter(VPAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.veggie);
        tabLayout.getTabAt(1).setIcon(R.drawable.steak);
        tabLayout.getTabAt(2).setIcon(R.drawable.milk);
        tabLayout.getTabAt(3).setIcon(R.drawable.bread);


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
