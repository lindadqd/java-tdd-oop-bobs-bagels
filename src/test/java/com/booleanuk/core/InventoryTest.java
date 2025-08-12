package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void inInventoryTrue(){
        Inventory inventory = new Inventory();
        Assertions.assertTrue(inventory.inInventory("onion"));
        Assertions.assertTrue(inventory.inInventory("plain"));
        Assertions.assertTrue(inventory.inInventory("bacon"));
        Assertions.assertTrue(inventory.inInventory("EGG"));
        Assertions.assertTrue(inventory.inInventory("BlAck"));
        Assertions.assertTrue(inventory.inInventory("Cream CHEESE"));
    }

    @Test
    public void inInventoryFalse(){
        Inventory inventory = new Inventory();
        Assertions.assertFalse(inventory.inInventory("eggy"));
        Assertions.assertFalse(inventory.inInventory(" "));
        Assertions.assertFalse(inventory.inInventory("LAtteee"));
        Assertions.assertFalse(inventory.inInventory("toast"));
        Assertions.assertFalse(inventory.inInventory("something"));
    }
}
