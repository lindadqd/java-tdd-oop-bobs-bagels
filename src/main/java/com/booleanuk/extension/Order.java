package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Order {
    private List<Bagel> bagels;
    private List<Coffee> coffees;


    public Order(List<Item> itemsOrdered){
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();

        for (Item item : itemsOrdered){
            if (item instanceof Bagel){
                bagels.add((Bagel) item);
            } else if (item instanceof Coffee){
                coffees.add((Coffee) item);
            }
        }
    }


    public List<Bagel> getBagels() {
        return null;
    }

    public List<Coffee> getCoffees() {
        return null;
    }

    public float getTotalCost() {
        return 0;
    }
}
