package com.booleanuk.core;

public class PublicMember {
    Basket basket;
    Inventory inventory;

    public PublicMember(Basket basket, Inventory inventory){
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

    public void addBagelToBasket(Bagel bagel){
        if (!basket.isFull()){
            basket.addBagelToBasket(bagel);
        }
    }

    public boolean removeItem(String item) {
        String itemUpperCase = item.toUpperCase();
        return basket.removeItem(itemUpperCase);
    }

    public Boolean isBasketFull() {
        return basket.isFull();
    }
}
