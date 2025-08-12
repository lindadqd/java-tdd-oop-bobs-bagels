package com.booleanuk.extension;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Inventory {
    private Map<String, Item> inventory = new HashMap<>();

    public Inventory(){
        setDefaultInventory();
    }

    public boolean inInventory(String variant) {
        String item = variant.toUpperCase();
        for (String key : inventory.keySet()) {
            if (Objects.equals(key, item)) {
                return true;
            }
        } return false;
    }

    private void setDefaultInventory(){
        inventory.put("ONION", new Bagel("Onion"));
        inventory.put("PLAIN", new Bagel("Plain"));
        inventory.put("EVERYTHING", new Bagel("Everything"));
        inventory.put("SESAME", new Bagel("Sesame"));

        inventory.put("BLACK", new Coffee("Black"));
        inventory.put("WHITE", new Coffee("White"));
        inventory.put("CAPUCCINO", new Coffee("Capuccino"));
        inventory.put("LATTE", new Coffee("Latte"));

        inventory.put("BACON", new Filling("Bacon"));
        inventory.put("EGG", new Filling("Egg"));
        inventory.put("CHEESE", new Filling("Cheese"));
        inventory.put("CREAM CHEESE", new Filling("Cream Cheese"));
        inventory.put("SMOKED SALMON", new Filling("Smoked Salmon"));
        inventory.put("HAM", new Filling("Ham"));

    }

    public Item getItem(String variant){
        return inventory.get(variant.toUpperCase());
    }
}
