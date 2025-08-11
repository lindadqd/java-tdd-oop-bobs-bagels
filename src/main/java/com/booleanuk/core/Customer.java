package com.booleanuk.core;

public class Customer extends PublicMember {

    public Customer(Basket basket, Inventory inventory) {
        super(basket, inventory);
    }


    public float getTotalCost() {
        return super.basket.getTotalCost();
    }

    public float getBagelPrice(String everything) {
        return 0;
    }

    public Boolean addFilling(String bagel, String filling) {
        return null;
    }

    public float getFillingPrice(String cheese) {
        return 100000;
    }

    public float getTotalBagelPrice() {
        return 1000000;
    }
}
