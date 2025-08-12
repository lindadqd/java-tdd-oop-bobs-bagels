package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void getTotalCostWithItems(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);

        customer.addBagelToBasket("onion");
        customer.addBagelToBasket("onion");

        Assertions.assertEquals(0.98F, customer.getTotalCost());
    }


    @Test
    public void getTotalCostWithNoItems(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);

        Assertions.assertEquals(0.0, customer.getTotalCost());
    }

    @Test
    public void getBagelPrice(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);

        Assertions.assertEquals(0.49F, customer.getBagelPrice("Everything"));
        Assertions.assertEquals(0.49F, customer.getBagelPrice("Onion"));
        Assertions.assertEquals(0.39F, customer.getBagelPrice("Plain"));
        Assertions.assertEquals(0.49F, customer.getBagelPrice("Sesame"));
    }

    @Test
    public void addFillingOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);


        Assertions.assertEquals(true, customer.addFilling("onion", "egg"));
    }

    @Test
    public void addFillingNotOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);


        Assertions.assertEquals(false, customer.addFilling("everything", "eggy"));
    }

    @Test
    public void getTotalCostWithItemsWithFILLING(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);

        customer.addBagelToBasket("onion");
        customer.addFilling("onion", "cheese");
        customer.addBagelToBasket("plain");
        customer.addBagelToBasket("everything");

        Assertions.assertEquals(1.49F, customer.getTotalCost());
    }

    @Test
    public void getFillingPrice(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);

        Assertions.assertEquals(0.12F, customer.getFillingPrice("Cheese"));
        Assertions.assertEquals(0.12F, customer.getFillingPrice("Bacon"));
        Assertions.assertEquals(0.12F, customer.getFillingPrice("Egg"));
        Assertions.assertEquals(0.12F, customer.getFillingPrice("Cream cheese"));
        Assertions.assertEquals(0.12F, customer.getFillingPrice("smoked salmon"));
        Assertions.assertEquals(0.12F, customer.getFillingPrice("ham"));
    }

    @Test
    public void getTotalBagelPrice(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket, inventory);

        Bagel bagel = new Bagel("onion");
        customer.addBagelToBasket(bagel);
        customer.addFilling("onion","egg");

        Assertions.assertEquals(0.61F, customer.getTotalBagelPrice(bagel));
    }
}
