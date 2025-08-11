package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private int capacity;
    private final int DEFAULT_CAPACITY = 5;
    List<Item> items;

    public Basket(){
        this.capacity = DEFAULT_CAPACITY;
        this.items = new ArrayList<>();
    }
    public void addBagelToBasket(String variant) {
        Bagel bagel = new Bagel(variant);
        items.add(bagel);
    }

    public boolean isFull() {
        return items.size() == capacity;
    }

    public boolean removeItem(String itemToRemove){
        if (!items.isEmpty()) {
            for (Item item : items){
                if (Objects.equals(item.getVariant().toUpperCase(), itemToRemove)){
                    items.remove(item);
                    return true;
                }
            }
        } return false;
    }

    public boolean setCapacity(int newCapacity, Manager manager){
        if (manager == null) {
            throw new SecurityException("Only managers can change basket capacity");
        }
        if (newCapacity >= 0){
            this.capacity = newCapacity;
            return true;
        } else return false;
    }
}
