package com.booleanuk.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class publicMemberTest {

    @Test
    public void addBagelToBasketOk(){
        Basket basket = new Basket();
        publicMember member = new publicMember(basket);

        Assertions.assertEquals(true, member.addBagelToBasket("Onion"));
        Assertions.assertEquals(true, member.addBagelToBasket("Plain"));
        Assertions.assertEquals(true, member.addBagelToBasket("Everything"));
        Assertions.assertEquals(true, member.addBagelToBasket("Sesame"));
        Assertions.assertEquals(true,member.addBagelToBasket("OnIOn"));
        Assertions.assertEquals(true,member.addBagelToBasket("SESAME"));
    }

    @Test
    public void addBagelToBasketNotOk(){
        Basket basket = new Basket();
        publicMember member = new publicMember(basket);

        Assertions.assertEquals(false, member.addBagelToBasket(" "));
        Assertions.assertEquals(false, member.addBagelToBasket("Sesamee"));
        Assertions.assertEquals(false, member.addBagelToBasket("Cheese"));
        Assertions.assertEquals(false, member.addBagelToBasket("Egg"));
    }

    @Test
    public void changeOrderOK(){
        Basket basket = new Basket();
        publicMember member = new publicMember(basket);
        member.addBagelToBasket("Sesame");

        Assertions.assertEquals(true, member.changeOrder("Sesame"));

    }

    @Test
    public void changeOrderNotOK(){
        Basket basket = new Basket();
        publicMember member = new publicMember(basket);
        member.addBagelToBasket("Sesame");

        Assertions.assertEquals(false, member.changeOrder("Onion"));

    }

    @Test
    public void isBasketFullTrue(){
        Basket basket = new Basket();
        publicMember member = new publicMember(basket);
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
        publicMember member = new publicMember(basket);
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");
        member.addBagelToBasket("Sesame");

        Assertions.assertEquals(false, member.isBasketFull());
    }


}
