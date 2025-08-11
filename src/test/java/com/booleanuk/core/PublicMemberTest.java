package com.booleanuk.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PublicMemberTest {

    @Test
    public void addBagelToBasketOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        PublicMember member = new PublicMember(basket, inventory);

        Assertions.assertTrue(member.addBagelToBasket("Onion"));
        Assertions.assertTrue(member.addBagelToBasket("Plain"));
        Assertions.assertTrue(member.addBagelToBasket("everything"));
        Assertions.assertTrue(member.addBagelToBasket("Sesame"));
        Assertions.assertTrue(member.addBagelToBasket("OnIOn"));
    }

    @Test
    public void addBagelToBasketNotOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        PublicMember member = new PublicMember(basket, inventory);

        Assertions.assertFalse(member.addBagelToBasket(" "));
        Assertions.assertFalse(member.addBagelToBasket("Sesamee"));
        Assertions.assertFalse(member.addBagelToBasket("Cheeseee"));
        Assertions.assertFalse(member.addBagelToBasket("Eggy"));
    }

    @Test
    public void addBagelToBasketFULL(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        PublicMember member = new PublicMember(basket, inventory);

        Assertions.assertTrue(member.addBagelToBasket("Onion"));
        Assertions.assertTrue(member.addBagelToBasket("Plain"));
        Assertions.assertTrue(member.addBagelToBasket("everything"));
        Assertions.assertTrue(member.addBagelToBasket("Sesame"));
        Assertions.assertTrue(member.addBagelToBasket("OnIOn"));
        Assertions.assertFalse(member.addBagelToBasket("Onion"));
        Assertions.assertFalse(member.addBagelToBasket("Plain"));

    }

    @Test
    public void removeItemOK(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        PublicMember member = new PublicMember(basket, inventory);
        member.addBagelToBasket("Sesame");

        Assertions.assertTrue(member.removeItem("Sesame"));

    }

    @Test
    public void removeItemNotOk(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        PublicMember member = new PublicMember(basket, inventory);
        member.addBagelToBasket("Sesame");

        Assertions.assertFalse(member.removeItem("Onion"));

    }

    @Test
    public void isBasketFullTrue(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        PublicMember member = new PublicMember(basket, inventory);
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
        PublicMember member = new PublicMember(basket, inventory);
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");

        Assertions.assertEquals(false, member.isBasketFull());
    }


}
