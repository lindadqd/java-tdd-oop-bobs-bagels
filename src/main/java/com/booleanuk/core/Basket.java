package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private static int capacity;
    private final int DEFAULT_CAPACITY = 5;
    private List<Item> items;

    public Basket(){
        capacity = DEFAULT_CAPACITY;
        this.items = new ArrayList<>();
    }
    public void addBagelToBasket(String variant) {
        if (!this.isFull()) {
            String item = variant.toUpperCase();
            Bagel bagel = new Bagel(item);
            items.add(bagel);
        }
    }

    public boolean addItemToBasket(Item variant) {
        if (!this.isFull() && !(variant instanceof Filling)){
            items.add(variant);
            return true;
        }return false;
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public boolean removeItem(String itemToRemove){
        if (!items.isEmpty()) {
            for (Item item : items){
                if (Objects.equals(item.getVariant().toUpperCase(), itemToRemove.toUpperCase())){
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

    public List<Item> getItems() {
        return items;
    }

    public int getCurrentCapacity() {
        return capacity;
    }

    public int getNumberOfItems() {
        return items.size();
    }
}
