package com.booleanuk.core;

public class Coffee extends Item {

    public Coffee(String variant) {
        super.variant = variant.toUpperCase();
        super.name = "Coffee";
        super.price = 1.29F;
        setRest();
    }

    private void setRest(){
        switch (super.variant) {
            case "BLACK" -> {
                super.price = 0.99F;
                super.sku = "COFB";
            }
            case "WHITE" -> {
                super.price = 1.19F;
                super.sku = "COFW";
            } case "CAPUCCINO" -> super.sku = "COFC";
            case "LATTE" -> super.sku = "COFL";
        }
    }
}
