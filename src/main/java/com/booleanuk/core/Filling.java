package com.booleanuk.core;

public class Filling extends Item {

    public Filling (String variant) {
        super.variant = variant.toUpperCase();
        super.name = "Filling";
        super.price = 0.12F;
        setRest();
    }

    private void setRest(){
        switch(super.variant) {
            case "BACON" -> super.sku = "FILB";
            case "CHEESE" -> super.sku = "FILC";
            case "CREAM CHEESE" -> super.sku = "FILX";
            case "SMOKED SALMON" -> super.sku = "FILS";
            case "HAM" -> super.sku = "FILH";
            case "EGG" -> super.sku = "FILE";
        }
    }
}
