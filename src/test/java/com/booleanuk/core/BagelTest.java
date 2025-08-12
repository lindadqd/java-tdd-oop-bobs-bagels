package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    @Test
    public void getFillings(){
        Bagel bagel = new Bagel("onion");
        Assertions.assertTrue(bagel.getFillings().isEmpty());

        bagel.addFilling("egg");
        Assertions.assertFalse(bagel.getFillings().isEmpty());
    }
    @Test
    public void addFillingOk(){
        Bagel bagel = new Bagel("onion");

        Assertions.assertTrue(bagel.addFilling("egg"));
        Assertions.assertTrue(bagel.addFilling("bacon"));
        Assertions.assertTrue(bagel.addFilling("cheese"));
        Assertions.assertTrue(bagel.addFilling("cReaAm cheese"));
        Assertions.assertTrue(bagel.addFilling("smoked SALMON"));
        Assertions.assertTrue(bagel.addFilling("hAM"));
    }

    @Test
    public void addFillingNotOk(){
        Bagel bagel = new Bagel("onion");

        Assertions.assertFalse(bagel.addFilling(" "));
        Assertions.assertFalse(bagel.addFilling("something "));
        Assertions.assertFalse(bagel.addFilling("everything"));
        Assertions.assertFalse(bagel.addFilling("white"));
    }

    @Test
    public void getTotalPrice(){
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
    public void removeFilling(){
        Bagel bagel = new Bagel("sesame");
        bagel.addFilling("egg");

        Assertions.assertTrue(bagel.removeFilling("egg"));
        Assertions.assertFalse(bagel.removeFilling("egg"));

    }
}
