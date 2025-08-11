package com.booleanuk.core;

public class Manager extends PublicMember {

    public Manager(Basket basket, Inventory inventory) {
        super(basket, inventory);
    }

    public Boolean changeBasketCapacity(int capacity){
        return super.basket.setCapacity(capacity, this);
    }

}
