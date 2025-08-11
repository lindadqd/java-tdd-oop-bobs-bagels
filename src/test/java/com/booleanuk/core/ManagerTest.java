package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void changeBasketCapacityOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Manager manager = new Manager(basket, inventory);

        Assertions.assertEquals(true, manager.changeBasketCapacity(10));
        Assertions.assertEquals(true, manager.changeBasketCapacity(100));
        Assertions.assertEquals(true, manager.changeBasketCapacity(50));

    }

    @Test
    public void changeBasketCapacityNotOk() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Manager manager = new Manager(basket, inventory);

        Assertions.assertEquals(false, manager.changeBasketCapacity(-10));
        Assertions.assertEquals(false, manager.changeBasketCapacity(-100));
        Assertions.assertEquals(false, manager.changeBasketCapacity(-1));
    }

}
