package com.booleanuk.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class publicMemberTest {

    @Test
    public void addBagelToBasketOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        publicMember member = new publicMember(basket, inventory);

        Assertions.assertEquals(true, member.addBagelToBasket("Onion"));
        Assertions.assertEquals(true, member.addBagelToBasket("Plain"));
        Assertions.assertEquals(true, member.addBagelToBasket("everything"));
        Assertions.assertEquals(true, member.addBagelToBasket("Sesame"));
        Assertions.assertEquals(true,member.addBagelToBasket("OnIOn"));
    }

    @Test
    public void addBagelToBasketNotOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        publicMember member = new publicMember(basket, inventory);

        Assertions.assertEquals(false, member.addBagelToBasket(" "));
        Assertions.assertEquals(false, member.addBagelToBasket("Sesamee"));
        Assertions.assertEquals(false, member.addBagelToBasket("Cheeseee"));
        Assertions.assertEquals(false, member.addBagelToBasket("Eggy"));
    }

    @Test
    public void addBagelToBasketFULL(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        publicMember member = new publicMember(basket, inventory);

        Assertions.assertEquals(true, member.addBagelToBasket("Onion"));
        Assertions.assertEquals(true, member.addBagelToBasket("Plain"));
        Assertions.assertEquals(true, member.addBagelToBasket("everything"));
        Assertions.assertEquals(true, member.addBagelToBasket("Sesame"));
        Assertions.assertEquals(true,member.addBagelToBasket("OnIOn"));
        Assertions.assertEquals(false, member.addBagelToBasket("Onion"));
        Assertions.assertEquals(false, member.addBagelToBasket("Plain"));

    }

    @Test
    public void removeItemOK(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        publicMember member = new publicMember(basket, inventory);
        member.addBagelToBasket("Sesame");

        Assertions.assertEquals(true, member.removeItem("Sesame"));

    }

    @Test
    public void removeItemNotOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        publicMember member = new publicMember(basket, inventory);
        member.addBagelToBasket("Sesame");

        Assertions.assertEquals(false, member.removeItem("Onion"));

    }

    @Test
    public void isBasketFullTrue(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        publicMember member = new publicMember(basket, inventory);
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");


        Assertions.assertEquals(true, member.isBasketFull());
    }

    @Test
    public void isBasketFullFalse(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        publicMember member = new publicMember(basket, inventory);
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");

        Assertions.assertEquals(false, member.isBasketFull());
    }


}
