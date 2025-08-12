package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item{
    List<Filling> fillings = new ArrayList<>();

    public Bagel(String variant) {
        super.variant = variant.toUpperCase();
        super.name = "Bagel";
        super.price = 0.49F;
        setRest();
    }

    private void setRest(){
        switch (super.variant) {
            case "ONION" -> super.sku = "BGLO";
            case "PLAIN" -> {
                super.price = 0.39F;
                super.sku = "BGLP";
            }
            case "EVERYTHING" -> super.sku = "BGLE";
            case "SESAME" -> super.sku = "BGLS";
        }
    }

    @Override
    public float getPrice(){
        float totalPrice = super.price;

        System.out.println("variant: " + super.variant);
        System.out.println("Base: " + super.price);
        System.out.println("Number fillings: " + fillings.size());

        if (!fillings.isEmpty()){
            for (Filling filling : fillings) {
                totalPrice += filling.getPrice();
            }
        }
        return totalPrice;
    }

    public void addFilling(String filling){
        String addFilling = filling.toUpperCase();
        fillings.add(new Filling(addFilling));
    }


}
