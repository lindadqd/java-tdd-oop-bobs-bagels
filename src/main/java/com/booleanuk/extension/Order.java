package com.booleanuk.extension;


import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Bagel> bagels;
    private List<Coffee> coffees;

    public Order(List<Item> basketItems) {
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();

        for (Item item : basketItems) {
            if (item instanceof Bagel) {
                bagels.add((Bagel) item);
            } else if (item instanceof Coffee) {
                coffees.add((Coffee) item);
            }
        }
    }

    public float getTotalCost() {
        float total = 0;

        int blackCoffeeCount = 0;
        for (Coffee coffee : coffees) {
            if (coffee.getVariant().equals("BLACK")) {
                blackCoffeeCount++;
            }
        }

        int totalFillings = 0;
        for (Bagel bagel : bagels) {
            totalFillings += bagel.getFillings().size();
        }

        int combos = Math.min(blackCoffeeCount, bagels.size());
        int remainingBagels = bagels.size() - combos;
        int remainingBlackCoffees = blackCoffeeCount - combos;

        total += combos * 1.25f;
        total += applyBagelDiscounts(remainingBagels);
        total += remainingBlackCoffees * 0.99f;

        for (Coffee coffee : coffees) {
            if (!coffee.getVariant().equals("BLACK")) {
                total += coffee.getPrice();
            }
        }

        total += totalFillings * 0.12f;

        return total;
    }

    private float applyBagelDiscounts(int remainingBagels) {
        float total = 0;

        if (remainingBagels >= 12) {
            int twelvePacks = remainingBagels / 12;
            total += twelvePacks * 3.99f;
            remainingBagels -= twelvePacks * 12;
        }

        if (remainingBagels >= 6) {
            int sixPacks = remainingBagels / 6;
            total += sixPacks * 2.49f;
            remainingBagels -= sixPacks * 6;
        }

        int startIndex = bagels.size() - remainingBagels;
        for (int i = startIndex; i < bagels.size(); i++) {
            Bagel bagel = bagels.get(i);
            total += getBagelPrice(bagel);
        }

        return total;
    }

    private float getBagelPrice(Bagel bagel) {
        return bagel.getVariant().equals("PLAIN") ? 0.39f : 0.49f;
    }

    public List<Bagel> getBagels() {
        return bagels;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }
}
