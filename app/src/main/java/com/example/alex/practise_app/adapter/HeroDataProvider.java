package com.example.alex.practise_app.adapter;

/**
 * Created by Alex on 6/12/2017.
 */

public class HeroDataProvider  {

    private String hero_name,hero_power;

    public HeroDataProvider(String hero_name, String hero_power) {
        this.hero_name = hero_name;
        this.hero_power = hero_power;
    }

    public String getHero_name() {
        return hero_name;
    }

    public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public String getHero_power() {
        return hero_power;
    }

    public void setHero_power(String hero_power) {
        this.hero_power = hero_power;
    }
}
