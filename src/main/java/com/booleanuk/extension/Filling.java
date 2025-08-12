package com.booleanuk.extension;

public class Filling implements Item {
    private String variant;
    private String name;
    private String sku;
    private float price;

    public Filling (String variant) {
        this.variant = variant.toUpperCase();
        this.name = "Filling";
        this.price = 0.12F;
        setRest();
    }

    private void setRest(){
        switch(this.variant) {
            case "BACON" -> this.sku = "FILB";
            case "CHEESE" -> this.sku = "FILC";
            case "CREAM CHEESE" -> this.sku = "FILX";
            case "SMOKED SALMON" -> this.sku = "FILS";
            case "HAM" -> this.sku = "FILH";
            case "EGG" -> this.sku = "FILE";
        }
    }

    @Override
    public String getVariant() {
        return this.variant;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public String getSku() {
        return this.sku;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
