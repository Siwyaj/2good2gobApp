package com.example.a2good2gooapp;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;


import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.gridlayout.widget.GridLayout;
import androidx.viewpager.widget.ViewPager;


import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Locale;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CardView bottombar;
    private Button findOpskriftButton;
    ArrayList<String> ingredientsSelected = new ArrayList<String>();
    List<RecipesClass> recipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findOpskriftButton = findViewById(R.id.findOpskriftButton);
        findOpskriftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        recipes = MakeRecipeList();

        MakeCategoryToolBar();

    }

    public void MakeCategoryToolBar() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);

        PageAdapter VPAdapter = new PageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        VPAdapter.addFragment(new Veggies(),"");//just add something in the "" if you want text below icons
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
                case " ":
                    wordArray.set(wordArray.indexOf(c),"_");
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
    public void MakeTable(String[] Ingredientsarray, LinearLayout llmaster, Context context) {

        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Æ","Ø","Å"};//,'Æ','Ø','Å'

        for (String alpha: alphabet) {
            ArrayList<String> currentLetter = new ArrayList<String>();
            for (int i=0; i<Ingredientsarray.length-1;i++){
                if (Ingredientsarray[i].startsWith(alpha)){
                    currentLetter.add(Ingredientsarray[i]);
                }
            }
            if (!currentLetter.isEmpty()){
                TextView letter = new TextView(context);
                letter.setText(alpha);
                letter.setPadding(20,5,5,5);
                llmaster.addView(letter);
                GridLayout letterGrid = new GridLayout(context);
                for (String s : currentLetter) {
                    CardView cardView = new CardView(context);
                    ImageView ingredientPicture = new ImageView(context);
                    LinearLayout llIngredient = new LinearLayout(context);
                    TextView textView = new TextView(context);


                    int id = getResources().getIdentifier(replaceCharUsingCharArray(s).toLowerCase(Locale.ROOT), "drawable",context.getPackageName());
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
                            if (ingredientsSelected.contains(s.toLowerCase(Locale.ROOT))){
                                ingredientsSelected.remove(s.toLowerCase(Locale.ROOT));
                                border.setStroke(15,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
                            }
                            else{
                                ingredientsSelected.add(s.toLowerCase(Locale.ROOT));
                                border.setStroke(25,0xFFFEAD30);
                                ingredientPicture.setBackgroundDrawable(border);
                            }
                            if (ingredientsSelected.size()==0){
                            }
                            else{
                            }
                            SortRecipes();
                        }
                    });
                    cardView.setRadius(20);
                    cardView.setPadding(50, 50, 50, 50);

                    cardView.getCardBackgroundColor();
                    cardView.setLayoutParams(new RelativeLayout.LayoutParams(300, 300));
                    ingredientPicture.setPadding(30, 30, 30, 30);

                    textView.setPadding(20, 20, 20, 20);
                    textView.setGravity(11);
                    textView.setText(s);

                    llIngredient.setPadding(20, 20, 20, 20);


                    cardView.addView(ingredientPicture);
                    llIngredient.addView(cardView);
                    llIngredient.addView(textView);
                    if (letterGrid.getParent()!=null){
                        ((ViewGroup)letterGrid.getParent()).removeView(letterGrid);
                    }

                    letterGrid.setColumnCount(3);
                    letterGrid.addView(llIngredient);
                    llmaster.addView(letterGrid);
                    llmaster.setPadding(0,0,0,150);
                }
            }
        }

    }
    public void MakeRecipeTable(String recipeName, String recipeTime, String pictureURL, String link){
        LinearLayout bottombarLLMaster = findViewById(R.id.bottombarLLMaster);

        LinearLayout llMaster = new LinearLayout(this);
        //Structure for a card
        //make the layout
        CardView theCard = new CardView(this);
        TextView recipeNameTextview = new TextView(this);
        ImageView recipeImage = new ImageView(this);
        ImageView mortor = new ImageView(this);
        ImageView clock = new ImageView(this);
        TextView itemsUsed = new TextView(this);
        TextView time = new TextView(this);

        //change font of time and recipeNameTextView

        LinearLayout cardLayout = new LinearLayout(this);
        LinearLayout bottomOfBar = new LinearLayout(this);
        LinearLayout mortorAndItems = new LinearLayout(this);
        LinearLayout clockAndTime = new LinearLayout(this);
        GridLayout letterGrid = new GridLayout(this);

        //padding

        bottombarLLMaster.setPadding(0,0,0,0);
        recipeImage.setPadding(20,20,20,20);

        cardLayout.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT));

        //put information in
        time.setText(recipeTime);
        clock.setImageResource(R.drawable.clock);

        Glide.with(this).load(pictureURL).into(recipeImage);

        recipeNameTextview.setText(recipeName);

        //setup
        theCard.setRadius(20);
        recipeImage.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,500));
        recipeImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

        theCard.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT));

        clock.setLayoutParams(new RelativeLayout.LayoutParams(60,60));

        time.setGravity(Gravity.RIGHT);


        theCard.setPadding(0,100,0,100);
        mortorAndItems.setPadding(20,20,20,20);

        bottomOfBar.setPadding(20,20,20,20);
        cardLayout.addView(recipeImage);
        cardLayout.setOrientation(LinearLayout.VERTICAL);
        bottomOfBar.setOrientation(LinearLayout.VERTICAL);
        clockAndTime.setOrientation(LinearLayout.HORIZONTAL);
        clockAndTime.addView(clock);
        clockAndTime.addView(time);
        clockAndTime.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT));
        clockAndTime.setGravity(Gravity.RIGHT);
        bottomOfBar.addView(recipeNameTextview);
        //bottomOfBar.addView(mortorAndItems);
        bottomOfBar.addView(clockAndTime);

        cardLayout.addView(bottomOfBar);

        recipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);
            }
        });

        theCard.addView(cardLayout);
        //theCard.setPadding(20,20,20,20);
        bottombarLLMaster.addView(theCard);
        bottombarLLMaster.setPadding(0,0,0,200);

        //letterGrid.setColumnCount(1);
        //bottombarLLMaster.addView(letterGrid);

    }

    public void SortRecipes(){
        LinearLayout bottombarLLMaster = findViewById(R.id.bottombarLLMaster);
        int jchecker=0;
        bottombarLLMaster.removeAllViews();
        //LinearLayout masterLinearLayour = findViewById(R.id.bottombarLLMaster);
        //masterLinearLayour.removeAllViews();
        Log.i("MainActivity","method ran");
        //ArrayList<RecipesClass> recipeInclude = new ArrayList<RecipesClass>();
        for (int i = 0; i < recipes.size(); i++) {
            recipes.get(i).setScore(0);
            for(int ii = 0; ii < ingredientsSelected.size(); ii++) {
                if (recipes.get(i).ingrSort.contains(ingredientsSelected.get(ii))){
                    recipes.get(i).score++;
                }
            }
        }
        int[] included = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
        int count = 0;

        for (int j = ingredientsSelected.size(); j > 0 && count<20; j--){


            //
            int firstj;
            for (int i = 0; i < recipes.size()&& count<=20; i++) {
                if (recipes.get(i).score==j){
                    firstj = j;
                    if(firstj!=jchecker){
                        jchecker=firstj;

                        ImageView mortor = new ImageView(this);
                        TextView itemsUsed = new TextView(this);
                        LinearLayout mortorAndItems = new LinearLayout(this);
                        mortorAndItems.addView(mortor);
                        mortorAndItems.addView(itemsUsed);
                        itemsUsed.setText(""+j+" Ingredienser brugt");
                        mortor.setImageResource(R.drawable.ingre);

                        mortor.getLayoutParams().height = 60;
                        mortor.getLayoutParams().width = 60;

                        //mortor.setLayoutParams(new RelativeLayout.LayoutParams(80,80));

                        mortorAndItems.setPadding(20,20,20,20);



                        mortorAndItems.setOrientation(LinearLayout.HORIZONTAL);

                        bottombarLLMaster.addView(mortorAndItems);

                    }
                    count++;
                    //MakeRecipeXML(recipes.get(i).getName(),recipes.get(i).getTime(),recipes.get(i).getLink(),recipes.get(i).getImg());
                    MakeRecipeTable(recipes.get(i).getName(),recipes.get(i).getTime()+"min",recipes.get(i).img, recipes.get(i).getLink());
                    Log.i("data", "> Item " + i + "\n" + recipes.get(i));
                }
            }
            //MakeRecipeTable();
        }
    }

    public List<RecipesClass> MakeRecipeList(){
        String jsonFileString = JSONSorter.getJsonFromAssets(getApplicationContext(), "recipeData.json");
        //Log.i("data", jsonFileString);
        Gson gson = new Gson();
        Type listRecipeType = new TypeToken<List<RecipesClass>>() {}.getType();
        List<RecipesClass> recipeList = gson.fromJson(jsonFileString, listRecipeType);
        return recipeList;
    }
/*
    public void MakeRecipeXML(String recipeName, String time, String URL, String pictureURL){
        {
            LinearLayout bottombarLLMaster = findViewById(R.id.bottombarLLMaster);

            LinearLayout llMaster = new LinearLayout(this);
            //Structure for a card
            //make the layout
            CardView theCard = new CardView(this);
            TextView recipeNameText = new TextView(this);
            ImageView recipeImage = new ImageView(this);
            ImageView clock = new ImageView(this);
            TextView timeText = new TextView(this);
            LinearLayout cardLayout = new LinearLayout(this);
            LinearLayout bottomOfBar = new LinearLayout(this);
            LinearLayout clockAndTime = new LinearLayout(this);
            GridLayout letterGrid = new GridLayout(this);

            //padding

            bottombarLLMaster.setPadding(0,0,0,0);
            recipeImage.setPadding(20,20,20,20);

            cardLayout.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT));

            //put information in
            timeText.setText(time);

            clock.setImageResource(R.drawable.clock);
            recipeImage.setImageResource(R.drawable.aioli);
            recipeNameText.setText(recipeName);

            //setup


            theCard.setRadius(20);
            recipeImage.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,500));
            recipeImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

            theCard.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT));

            clock.setLayoutParams(new RelativeLayout.LayoutParams(60,60));


            //time.setGravity(Gravity.RIGHT);


            theCard.setPadding(0,100,0,100);


            bottomOfBar.setPadding(20,20,20,20);
            cardLayout.addView(recipeImage);
            cardLayout.setOrientation(LinearLayout.VERTICAL);
            bottomOfBar.setOrientation(LinearLayout.HORIZONTAL);
            clockAndTime.setOrientation(LinearLayout.HORIZONTAL);
            clockAndTime.addView(clock);
            clockAndTime.addView(timeText);
            bottomOfBar.addView(recipeNameText);
            //bottomOfBar.addView(mortorAndItems);
            bottomOfBar.addView(clockAndTime);

            cardLayout.addView(bottomOfBar);

            theCard.addView(cardLayout);
            //theCard.setPadding(20,20,20,20);
            bottombarLLMaster.addView(theCard);

            //letterGrid.setColumnCount(1);
            //bottombarLLMaster.addView(letterGrid);
            Log.i("MainActivity","made recepie card");
        }
    }*/
}
