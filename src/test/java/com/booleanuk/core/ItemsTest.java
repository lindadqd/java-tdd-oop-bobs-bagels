package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemsTest {
    Bagel onion = new Bagel("onion");
    Bagel plain = new Bagel("plain");
    Bagel everything = new Bagel("Everything");
    Bagel sesame = new Bagel("sesame");

    Coffee black = new Coffee("black");
    Coffee white = new Coffee("white");
    Coffee capuccino = new Coffee("capuccino");
    Coffee latte = new Coffee("latte");

    Filling bacon = new Filling("bacon");
    Filling egg = new Filling("egg");
    Filling cheese = new Filling("cheese");
    Filling creamCheese = new Filling("cream Cheese");
    Filling smokedSalmon = new Filling("smoked salmon");
    Filling ham = new Filling("ham");

    @Test
    public void getPrice(){
        Assertions.assertEquals(0.49F, onion.getPrice());
        Assertions.assertEquals(0.39F, plain.getPrice());
        Assertions.assertEquals(0.49F, everything.getPrice());
        Assertions.assertEquals(0.49F, sesame.getPrice());

        Assertions.assertEquals(0.99F, black.getPrice());
        Assertions.assertEquals(1.19F, white.getPrice());
        Assertions.assertEquals(1.29F, capuccino.getPrice());
        Assertions.assertEquals(1.29F, latte.getPrice());

        Assertions.assertEquals(0.12F, bacon.getPrice());
        Assertions.assertEquals(0.12F, egg.getPrice());
        Assertions.assertEquals(0.12F, cheese.getPrice());
        Assertions.assertEquals(0.12F, creamCheese.getPrice());
        Assertions.assertEquals(0.12F, smokedSalmon.getPrice());
        Assertions.assertEquals(0.12F, ham.getPrice());
    }

    @Test
    public void getVariant(){
        Assertions.assertEquals("ONION", onion.getVariant());
        Assertions.assertEquals("PLAIN", plain.getVariant());
        Assertions.assertEquals("EVERYTHING", everything.getVariant());
        Assertions.assertEquals("SESAME",sesame.getVariant());

        Assertions.assertEquals("BLACK", black.getVariant());
        Assertions.assertEquals("WHITE", white.getVariant());
        Assertions.assertEquals("CAPUCCINO", capuccino.getVariant());
        Assertions.assertEquals("LATTE", latte.getVariant());

        Assertions.assertEquals("BACON", bacon.getVariant());
        Assertions.assertEquals("EGG", egg.getVariant());
        Assertions.assertEquals("CHEESE", cheese.getVariant());
        Assertions.assertEquals("CREAM CHEESE", creamCheese.getVariant());
        Assertions.assertEquals("SMOKED SALMON", smokedSalmon.getVariant());
        Assertions.assertEquals("HAM", ham.getVariant());
    }

    @Test
    public void getSKU(){
        Assertions.assertEquals("BGLO", onion.getSku());
        Assertions.assertEquals("BGLP", plain.getSku());
        Assertions.assertEquals("BGLE", everything.getSku());
        Assertions.assertEquals("BGLS",sesame.getSku());

        Assertions.assertEquals("COFB", black.getSku());
        Assertions.assertEquals("COFW", white.getSku());
        Assertions.assertEquals("COFC", capuccino.getSku());
        Assertions.assertEquals("COFL", latte.getSku());

        Assertions.assertEquals("FILB", bacon.getSku());
        Assertions.assertEquals("FILE", egg.getSku());
        Assertions.assertEquals("FILC", cheese.getSku());
        Assertions.assertEquals("FILX", creamCheese.getSku());
        Assertions.assertEquals("FILS", smokedSalmon.getSku());
        Assertions.assertEquals("FILH", ham.getSku());
    }

    @Test
    public void getName(){
        Assertions.assertEquals("Bagel", onion.getName());
        Assertions.assertEquals("Bagel", plain.getName());
        Assertions.assertEquals("Bagel", everything.getName());
        Assertions.assertEquals("Bagel",sesame.getName());

        Assertions.assertEquals("Coffee", black.getName());
        Assertions.assertEquals("Coffee", white.getName());
        Assertions.assertEquals("Coffee", capuccino.getName());
        Assertions.assertEquals("Coffee", latte.getName());

        Assertions.assertEquals("Filling", bacon.getName());
        Assertions.assertEquals("Filling", egg.getName());
        Assertions.assertEquals("Filling", cheese.getName());
        Assertions.assertEquals("Filling", creamCheese.getName());
        Assertions.assertEquals("Filling", smokedSalmon.getName());
        Assertions.assertEquals("Filling", ham.getName());
    }
}
