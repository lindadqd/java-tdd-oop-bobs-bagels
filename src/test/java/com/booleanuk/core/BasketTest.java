package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BasketTest {

    @Test
    public void getItems(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel("onion");
        basket.addItemToBasket(bagel);

        Assertions.assertTrue(basket.getItems().contains(bagel));

    }
    @Test
    public void getItemsEmptyBasket(){
        Basket basket = new Basket();

        Assertions.assertTrue(basket.getItems().isEmpty());
    }

    @Test
    public void removeItemOk(){
        Basket basket = new Basket();
        basket.addBagelToBasket("onion");

        Assertions.assertTrue(basket.removeItem("onion"));
    }

    @Test
    public void removeItemNotOk(){
        Basket basket = new Basket();
        Assertions.assertFalse(basket.removeItem("onion"));
    }

    @Test
    public void addItemToBasketOK(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel("plain");
        Coffee coffee = new Coffee("black");

        Assertions.assertTrue(basket.addItemToBasket(bagel));
        Assertions.assertTrue(basket.addItemToBasket(coffee));
    }

    @Test
    public void addItemToBasketNotOk(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel("plain");
        Bagel bagel2 = new Bagel("plain");
        Bagel bagel3 = new Bagel("plain");
        Bagel bagel4 = new Bagel("plain");
        Bagel bagel5 = new Bagel("plain");
        Coffee coffee = new Coffee("black");
        Filling filling = new Filling("egg");

        Assertions.assertFalse(basket.addItemToBasket(filling));

        basket.addItemToBasket(bagel);
        basket.addItemToBasket(bagel2);
        basket.addItemToBasket(bagel3);
        basket.addItemToBasket(bagel4);
        basket.addItemToBasket(bagel5);

        Assertions.assertFalse(basket.addItemToBasket(coffee));
    }

    @Test
    public void getCurrentCapacity(){
        Basket basket = new Basket();
        Assertions.assertEquals(5, basket.getCurrentCapacity());
    }

    @Test
    public void getTotalCost(){
        Basket basket = new Basket();
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        Assertions.assertEquals(0.98F, basket.getTotalCost());
    }

    @Test
    public void getTotalCostEmptyBasket(){
        Basket basket = new Basket();
        Assertions.assertEquals(0.0F, basket.getTotalCost());
    }

    @Test
    public void setCapacityOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Manager manager = new Manager(basket, inventory);

        Assertions.assertEquals(true,manager.changeBasketCapacity(10));
    }

    @Test
    public void isFull(){
        Basket basket = new Basket();
        Assertions.assertFalse(basket.isFull());
    }

    @Test
    public void isFullTrue(){
        Basket basket = new Basket();
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");


        Assertions.assertTrue(basket.isFull());
    }

    @Test
    public void getNumberOfItems(){
        Basket basket = new Basket();
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");
        basket.addBagelToBasket("onion");

        Assertions.assertEquals(5, basket.getNumberOfItems());
    }

}
