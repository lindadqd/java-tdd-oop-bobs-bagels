package com.booleanuk.extension;

public class Customer extends PublicMember {

    public Customer(Basket basket, Inventory inventory) {
        super(basket, inventory);
    }


    public float getTotalCost() {
        return basket.getTotalCost();
    }

    public float getBagelPrice(String variant) {
        Item item = inventory.getItem(variant);
        if (item != null) {
            return item.getPrice();
        } return 0;
    }

    public boolean addFilling(String bagel, String filling) {
        if (!inventory.inInventory(bagel)) {
            System.out.println("We don't sell this bagel here!");
            return false;
        }

        if (!inventory.inInventory(filling)) {
            System.out.println("We don't sell this filling here!");
            return false;
        }

        return basket.addFillingToBagel(bagel, filling);
    }


    public float getFillingPrice(String variant) {
        Item item = inventory.getItem(variant);
        if (item != null) {
            return item.getPrice();
        } return 0;
    }

    public float getTotalBagelPrice(Bagel bagel) {
        return bagel.getPrice();
    }

    public Order placeOrder() {
        return basket.placeOrder();
    }
}
