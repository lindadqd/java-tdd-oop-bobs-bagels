package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ReceiptTest {

    Bagel plain = new Bagel("Plain");
    Bagel sesame = new Bagel("Sesame");
    Coffee black = new Coffee("Black");


    @Test
    public void createReceipt() {
        List<Item> items = new ArrayList<>();
        items.add(plain);
        Order order = new Order(items);
        Receipt receipt = new Receipt(order);
        receipt.printReceipt();

        Assertions.assertNotNull(receipt);
    }

    @Test
    public void checkPrintTop() {
        List<Item> items = new ArrayList<>();
        items.add(plain);
        Order order = new Order(items);
        Receipt receipt = new Receipt(order);

        String content = receipt.makeReceipt();

        Assertions.assertTrue(content.contains("~~~ Bob's Bagels ~~~"));
        Assertions.assertTrue(content.contains("----------------------------"));
    }

    @Test
    public void checkPrintBottom() {
        List<Item> items = new ArrayList<>();
        items.add(sesame);
        Order order = new Order(items);
        Receipt receipt = new Receipt(order);

        String content = receipt.makeReceipt();

        Assertions.assertTrue(content.contains("Thank you"));
        Assertions.assertTrue(content.contains("for your order!"));
    }

    @Test
    public void oneItemReceipt() {
        List<Item> items = new ArrayList<>();
        items.add(plain);
        Order order = new Order(items);
        Receipt receipt = new Receipt(order);

        String content = receipt.makeReceipt();

        Assertions.assertTrue(content.contains("PLAIN Bagel"));
        Assertions.assertTrue(content.contains("1"));
        Assertions.assertTrue(content.contains("£0.39"));
        Assertions.assertTrue(content.contains("Total"));
    }

    @Test
    public void totalSum() {
        List<Item> items = new ArrayList<>();
        items.add(plain);
        items.add(black);

        Order order = new Order(items);
        Receipt receipt = new Receipt(order);
        String content = receipt.makeReceipt();

        Assertions.assertTrue(content.contains("Total"));
        Assertions.assertTrue(content.contains("£1.25"));
    }
}