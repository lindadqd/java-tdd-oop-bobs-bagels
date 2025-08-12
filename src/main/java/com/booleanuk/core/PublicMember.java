package com.booleanuk.core;

public class PublicMember {
    protected Basket basket;
    protected Inventory inventory;

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

    public void addItemToBasket(Item bagel){
        if (!basket.isFull()){
            basket.addItemToBasket(bagel);
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
