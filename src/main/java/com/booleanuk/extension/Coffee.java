package com.booleanuk.extension;

public class Coffee implements Item {
    private String variant;
    private String name;
    private String sku;
    private float price;

    public Coffee(String variant) {
        this.variant = variant.toUpperCase();
        this.name = "Coffee";
        this.price = 1.29F;
        setRest();
    }

    private void setRest(){
        switch (this.variant) {
            case "BLACK" -> {
                this.price = 0.99F;
                this.sku = "COFB";
            }
            case "WHITE" -> {
                this.price = 1.19F;
                this.sku = "COFW";
            } case "CAPUCCINO" -> this.sku = "COFC";
            case "LATTE" -> this.sku = "COFL";
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
