package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

      Bagel onion = new Bagel("Onion");
      Bagel plain = new Bagel("Plain");
      Bagel everything = new Bagel("Everything");
      Bagel sesame = new Bagel("Sesame");

      Coffee black = new Coffee("Black");
      Coffee white = new Coffee("White");
      Coffee capuccino = new Coffee("Capuccino");
      Coffee latte = new Coffee("Latte");

      Filling bacon = new Filling("Bacon");
      Filling egg =  new Filling("Egg");
      Filling cheese = new Filling("Cheese");
      Filling creamCheese =new Filling("Cream Cheese");
      Filling salmon = new Filling("Smoked Salmon");
      Filling ham = new Filling("Ham");

    @Test
    public void emptyOrder(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Customer customer = new Customer(basket,inventory);

        Order order = customer.placeOrder();

        Assertions.assertEquals(0, order.getBagels().size());
        Assertions.assertEquals(0, order.getCoffees().size());
        Assertions.assertEquals(0, order.getTotalCost());
    }

    @Test
    public void coffeeAndBagelOrder(){
       List<Item> items = new ArrayList<>();
       items.add(black);
       items.add(plain);

       Order order = new Order(items);
       Assertions.assertEquals(1, order.getBagels().size());
       Assertions.assertEquals(1, order.getCoffees().size());
       Assertions.assertEquals(1.25F, order.getTotalCost());

       items.add(black);
       items.add(everything);
        Order order2 = new Order(items);
        Assertions.assertEquals(2.5F, order2.getTotalCost());
    }

    @Test
    public void coffeeAndBagelOrderExtraCoffee(){
        List<Item> items = new ArrayList<>();
        items.add(black);
        items.add(black);
        items.add(plain);

        Order order = new Order(items);
        Assertions.assertEquals(2.24F, order.getTotalCost());
    }

    @Test
    public void sixBagelsDiscount(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i<6;i++){
            items.add(plain);
        }

        Order order = new Order(items);

        Assertions.assertEquals(2.49F, order.getTotalCost());
    }

    @Test
    public void sevenBagels(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i<7;i++){
            items.add(everything);
        }

        Order order = new Order(items);
        Assertions.assertEquals(2.98F, order.getTotalCost());
    }

    @Test
    public void twelveBagelsDiscount(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i<12;i++){
            items.add(everything);
        }
        Order order = new Order(items);
        Assertions.assertEquals(3.99F, order.getTotalCost());
    }

    @Test
    public void sixteenBagels(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i<16;i++){
            items.add(plain);
        }
        Order order = new Order(items);
        Assertions.assertEquals(5.55F, order.getTotalCost(), 0.001);
    }

    @Test
    public void eighteenBagels(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i<18;i++){
            items.add(plain);
        }
        Order order = new Order(items);
        Assertions.assertEquals(6.48F, order.getTotalCost());
    }

    @Test
    public void testFillingNotDiscount(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i<5;i++){
            items.add(everything);
        }
        Bagel bagelWithFilling = new Bagel("sesame");
        bagelWithFilling.addFilling("egg");
        items.add(bagelWithFilling);

        Order order = new Order(items);
        Assertions.assertEquals(2.61F, order.getTotalCost());
    }

    @Test
    public void twentyBagels(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i < 20;i++){
            items.add(sesame);
        }
        Order order = new Order(items);
        Assertions.assertEquals(7.46F, order.getTotalCost(),0.001);
    }

    @Test
    public void twentyfourBagels(){
        List<Item> items = new ArrayList<>();
        for (int i =0; i < 24;i++){
            items.add(plain);
        }
        Order order = new Order(items);
        Assertions.assertEquals(7.98F, order.getTotalCost(),0.001);
    }
}