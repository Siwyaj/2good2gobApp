package com.example.a2good2gooapp;

import java.util.List;

public class RecipesClass {
    int id;
    int score;
    String name;
    String link;
    String img;
    String time;
    List<String> ingrSort;

    public int getId() {
        return  id;
    }

    public int getScore() {
        return score;
    }

    public void setScore (int s) {
        this.score = s;
    }

    public String getTime() {
        return time;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id +
                ", score='" + score +
                ", name='" + name + '\'' +
                ", link='" + link +
                ", img='" + img  +
                ", time='" + time +
                ", ingrSort='" + ingrSort +
                '}';

    }
}
