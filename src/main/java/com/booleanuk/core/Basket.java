package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private static int capacity;
    private final int DEFAULT_CAPACITY = 5;
    List<Item> items;

    public Basket(){
        capacity = DEFAULT_CAPACITY;
        this.items = new ArrayList<>();
    }
    public void addBagelToBasket(String variant) {
        Bagel bagel = new Bagel(variant);
        items.add(bagel);
    }

    public void addBagelToBasket(Bagel variant) {
        items.add(variant);
    }

    public boolean isFull() {
        return items.size() >= capacity;
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
            capacity = newCapacity;
            return true;
        } else return false;
    }

    public float getTotalCost() {
        float sum = 0;
        for (Item item: items){
            sum += item.getPrice();
        }
        return sum;
    }

    public boolean addFillingToBagel(String bagel, String filling) {
        String bagelToUpper = bagel.toUpperCase();
        String fillingToUpper = filling.toUpperCase();
        for (Item item : items) {
            if (item instanceof Bagel && item.getVariant().toUpperCase().equals(bagelToUpper)) {
                ((Bagel) item).addFilling(filling);
                return true;
            }
        }

        if(isFull()){
            System.out.println("Cannot add new bagel. The basket is full.");
            return false;
        }

        Bagel newBagel = new Bagel(bagelToUpper);
        newBagel.addFilling(fillingToUpper);
        items.add(newBagel);
        return true;
    }
}
