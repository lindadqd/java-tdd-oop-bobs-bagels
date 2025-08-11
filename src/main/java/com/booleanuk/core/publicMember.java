package com.booleanuk.core;

public class publicMember {
    Basket basket;
    Inventory inventory;

    public publicMember(Basket basket, Inventory inventory){
        this.basket = basket;
        this.inventory = inventory;
    }

    public boolean addBagelToBasket(String variant){
        String item = variant.toUpperCase();
        if (inventory.inInventory(item) && !basket.isFull()){
            basket.addBagelToBasket(item);
            return true;
        } else return false;
    }

    public boolean removeItem(String item) {
        String itemUpperCase = item.toUpperCase();
        return basket.removeItem(itemUpperCase);
    }

    public Boolean isBasketFull() {
        return basket.isFull();
    }
}
