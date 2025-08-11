package com.booleanuk.core;

public class Bagel extends Item{

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
}
