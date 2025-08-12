package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bagel implements Item{
    private List<Filling> fillings = new ArrayList<>();
    private String variant;
    private String name;
    private String sku;
    private float price;

    public Bagel(String variant) {
        this.variant = variant.toUpperCase();
        this.name = "Bagel";
        this.price = 0.49F;
        setRest();
    }

    private void setRest(){
        switch (this.variant) {
            case "ONION" -> this.sku = "BGLO";
            case "PLAIN" -> {
                this.price = 0.39F;
                this.sku = "BGLP";
            }
            case "EVERYTHING" -> this.sku = "BGLE";
            case "SESAME" -> this.sku = "BGLS";
        }
    }

    @Override
    public String getVariant() {
        return this.variant;
    }

    @Override
    public float getPrice(){
        float totalPrice = this.price;

        if (!fillings.isEmpty()){
            for (Filling filling : fillings) {
                totalPrice += filling.getPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public String getSku() {
        return this.sku;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void addFilling(String filling){
        String addFilling = filling.toUpperCase();
        fillings.add(new Filling(addFilling));
    }


    public List<Filling>getFillings() {
        return null;
    }

    public boolean removeFilling(String filling) {
        return false;
    }
}
